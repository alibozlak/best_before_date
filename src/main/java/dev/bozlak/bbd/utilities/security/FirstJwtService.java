package dev.bozlak.bbd.utilities.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class FirstJwtService implements JwtService {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    @Override
    public String generateToken(UserDetails userDetails){
        return this.buildToken(new HashMap<>(), userDetails, 1000 * 60 * 60 * 24);
    }

    public String generateRefreshToken(UserDetails userDetails){
        return this.buildToken(new HashMap<>(), userDetails, (long)1000 * 60 * 60 * 24 * 30);
    }

    private String buildToken(Map<String,Object> extraClaims, UserDetails userDetails, long expiration){
        long currentTimeMillis = System.currentTimeMillis();

        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + expiration))
                .signWith(this.getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails){
        return !this.isTokenExpired(token) && userDetails.getUsername().equals(this.getUserName(token));
    }

    private Date extractExpiration(String token){
        return this.extractClaim(token, Claims::getExpiration);
    }

    @Override
    public String getUserName(String token){
        return this.extractClaim(token, Claims::getSubject);
    }

    private boolean isTokenExpired(String token){
        return this.extractExpiration(token).before(new Date());
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = this.extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(this.getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigningKey(){
        byte[] keyBytes = Decoders.BASE64.decode(this.SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
