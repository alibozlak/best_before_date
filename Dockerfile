
# Compiling Process :
FROM ghcr.io/graalvm/native-image-community:21 AS build

WORKDIR /build

COPY . .

RUN ./mvnw install:install-file \
    -Dfile=libs/core-1.0.2.jar \
    -DpomFile=libs/pom.xml \
    -DgroupId=dev.bozlak \
    -DartifactId=core \
    -Dversion=1.0.2 \
    -Dpackaging=jar

RUN ./mvnw -Pnative native:compile -DskipTests \
    -DSUPABASE_URL=jdbc:postgresql://localhost:5432/dummy \
    -DSUPABASE_USERNAME=dummy \
    -DSUPABASE_PASSWORD=dummy \
    -DJWT_SECRET_KEY=yeterince_uzun_ve_guvenli_bir_dummy_key_32_karakter


# Runtime Process :
FROM alpine:latest

RUN apk add --no-cache gcompat

WORKDIR /app

COPY --from=build /build/target/bbd .

EXPOSE 8080

ENTRYPOINT ["./bbd"]