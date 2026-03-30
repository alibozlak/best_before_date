package dev.bozlak.bbd.utilities.config;

import dev.bozlak.bbd.repository.baseabstracts.ActivityTypeRepository;
import dev.bozlak.bbd.repository.baseabstracts.ProductRepository;
import dev.bozlak.bbd.repository.baseabstracts.StoreRepository;
import dev.bozlak.bbd.repository.baseabstracts.UserRepository;
import dev.bozlak.bbd.repository.implementations.jpa.activitytype.JpaActivityTypeAdapter;
import dev.bozlak.bbd.repository.implementations.jpa.activitytype.JpaActivityTypeRepository;
import dev.bozlak.bbd.repository.implementations.jpa.mappers.ActivityTypeMapper;
import dev.bozlak.bbd.repository.implementations.jpa.mappers.ProductMapper;
import dev.bozlak.bbd.repository.implementations.jpa.mappers.StoreMapper;
import dev.bozlak.bbd.repository.implementations.jpa.product.JpaProductAdapter;
import dev.bozlak.bbd.repository.implementations.jpa.product.JpaProductRepository;
import dev.bozlak.bbd.repository.implementations.jpa.store.JpaStoreAdapter;
import dev.bozlak.bbd.repository.implementations.jpa.store.JpaStoreRepository;
import dev.bozlak.bbd.repository.implementations.jpa.user.JpaUserAdapter;
import dev.bozlak.bbd.repository.implementations.jpa.user.JpaUserRepository;
import dev.bozlak.bbd.service.abstracts.ActivityTypeService;
import dev.bozlak.bbd.service.abstracts.ProductService;
import dev.bozlak.bbd.service.abstracts.StoreService;
import dev.bozlak.bbd.service.abstracts.UserService;
import dev.bozlak.bbd.service.concretes.activitytype.ActivityTypeManager;
import dev.bozlak.bbd.service.concretes.product.ProductManager;
import dev.bozlak.bbd.service.concretes.store.StoreManager;
import dev.bozlak.bbd.service.concretes.user.UserManager;
import dev.bozlak.bbd.repository.implementations.jpa.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class IocConfig {

    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapperForJpa;
    private final dev.bozlak.bbd.utilities.mappers.UserMapper userMapper;

    private final JpaActivityTypeRepository jpaActivityTypeRepository;
    private final ActivityTypeMapper activityTypeMapperForJpa;

    private final JpaStoreRepository jpaStoreRepository;
    private final StoreMapper storeMapperForJpa;

    private final JpaProductRepository jpaProductRepository;
    private final ProductMapper productMapperForJpa;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //---------------- Repository Layer Beans : --------------------

    @Bean
    public UserRepository userRepository(){
        return new JpaUserAdapter(this.jpaUserRepository, this.userMapperForJpa);
    }

    @Bean
    public ActivityTypeRepository activityTypeRepository(){
        return new JpaActivityTypeAdapter(this.jpaActivityTypeRepository, this.activityTypeMapperForJpa);
    }

    @Bean
    public StoreRepository storeRepository(){
        return new JpaStoreAdapter(this.jpaStoreRepository, this.storeMapperForJpa);
    }

    @Bean
    public ProductRepository productRepository(){
        return new JpaProductAdapter(this.jpaProductRepository, this.productMapperForJpa);
    }

    //---------------- Service Layer Beans : --------------------

    @Bean
    public UserService userService(){
        return new UserManager(this.userRepository(), this.userMapper, this.passwordEncoder());
    }

    @Bean
    public ActivityTypeService activityTypeService(){
        return new ActivityTypeManager(this.activityTypeRepository());
    }

    @Bean
    public StoreService storeService(){
        return new StoreManager(this.storeRepository());
    }

    @Bean
    public ProductService productService(){
        return new ProductManager(this.productRepository());
    }
}
