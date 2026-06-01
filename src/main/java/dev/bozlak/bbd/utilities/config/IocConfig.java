package dev.bozlak.bbd.utilities.config;

import dev.bozlak.bbd.repository.baseabstracts.*;
import dev.bozlak.bbd.repository.implementations.jpa.activitytype.JpaActivityTypeAdapter;
import dev.bozlak.bbd.repository.implementations.jpa.activitytype.JpaActivityTypeRepository;
import dev.bozlak.bbd.repository.implementations.jpa.adminstoreactivity.JpaAdminStoreActivityRepository;
import dev.bozlak.bbd.repository.implementations.jpa.adminstoreactivity.JpaAdminStoreActivityRepositoryAdapter;
import dev.bozlak.bbd.repository.implementations.jpa.bbdrecord.JpaBbdRecordRepository;
import dev.bozlak.bbd.repository.implementations.jpa.bbdrecord.JpaBbdRecordRepositoryAdapter;
import dev.bozlak.bbd.repository.implementations.jpa.bbdtracker.JpaBbdTrackerRepository;
import dev.bozlak.bbd.repository.implementations.jpa.bbdtracker.JpaBbdTrackerRepositoryAdapter;
import dev.bozlak.bbd.repository.implementations.jpa.homepage.JpaHomePageRepository;
import dev.bozlak.bbd.repository.implementations.jpa.homepage.JpaHomePageRepositoryAdapter;
import dev.bozlak.bbd.repository.implementations.jpa.mappers.*;
import dev.bozlak.bbd.repository.implementations.jpa.product.JpaProductAdapter;
import dev.bozlak.bbd.repository.implementations.jpa.product.JpaProductRepository;
import dev.bozlak.bbd.repository.implementations.jpa.productlog.JpaProductLogRepository;
import dev.bozlak.bbd.repository.implementations.jpa.productlog.JpaProductLogRepositoryAdapter;
import dev.bozlak.bbd.repository.implementations.jpa.store.JpaStoreAdapter;
import dev.bozlak.bbd.repository.implementations.jpa.store.JpaStoreRepository;
import dev.bozlak.bbd.repository.implementations.jpa.user.JpaUserAdapter;
import dev.bozlak.bbd.repository.implementations.jpa.user.JpaUserRepository;
import dev.bozlak.bbd.repository.implementations.jpa.useractivity.JpaUserActivityRepository;
import dev.bozlak.bbd.repository.implementations.jpa.useractivity.JpaUserActivityRepositoryAdapter;
import dev.bozlak.bbd.repository.implementations.jpa.userhimselfactivity.JpaUserHimselfActivityAdapter;
import dev.bozlak.bbd.repository.implementations.jpa.userhimselfactivity.JpaUserHimselfActivityRepository;
import dev.bozlak.bbd.service.abstracts.*;
import dev.bozlak.bbd.service.concretes.activitytype.ActivityTypeManager;
import dev.bozlak.bbd.service.concretes.adminstoreactivity.AdminStoreActivityManager;
import dev.bozlak.bbd.service.concretes.bbdrecord.BbdRecordManager;
import dev.bozlak.bbd.service.concretes.homepage.HomePageServiceImpl;
import dev.bozlak.bbd.service.concretes.product.ProductManager;
import dev.bozlak.bbd.service.concretes.productlog.ProductLogManager;
import dev.bozlak.bbd.service.concretes.store.StoreManager;
import dev.bozlak.bbd.service.concretes.user.UserManager;
import dev.bozlak.bbd.service.concretes.useractivity.UserActivityManager;
import dev.bozlak.bbd.service.concretes.userhimselfactivity.UserHimselfActivityManager;
import dev.bozlak.bbd.utilities.mappers.ProductLogMapperForServiceLayer;
import dev.bozlak.bbd.utilities.mappers.StoreMapper;
import dev.bozlak.bbd.utilities.mappers.UserActivityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class IocConfig {

    private final JpaUserRepository jpaUserRepository;
    private final UserMapperForJpa userMapperForJpa;
    private final dev.bozlak.bbd.utilities.mappers.UserMapper userMapper;

    private final JpaActivityTypeRepository jpaActivityTypeRepository;
    private final ActivityTypeMapperForJpa activityTypeMapperForJpa;

    private final JpaStoreRepository jpaStoreRepository;
    private final StoreMapperForJpa storeMapperForJpa;

    private final JpaProductRepository jpaProductRepository;
    private final ProductMapperForJpa productMapperForJpa;

    private final JpaBbdRecordRepository jpaBbdRecordRepository;
    private final BbdRecordMapperForJpa bbdRecordMapperForJpa;
    private final dev.bozlak.bbd.utilities.mappers.BbdRecordMapper bbdRecordMapperForCoreEntity;
    private final UserActivityMapper userActivityMapper;

    private final JpaUserActivityRepository jpaUserActivityRepository;
    private final UserActivityMapperForJpa userActivityMapperForJpa;

    private final JpaHomePageRepository jpaHomePageRepository;

    private final JpaUserHimselfActivityRepository jpaUserHimselfActivityRepository;
    private final UserHimselfActivityMapperForJpa userHimselfActivityMapperForJpa;

    private final JpaProductLogRepository jpaProductLogRepository;
    private final ProductLogMapperForJpa productLogMapperForJpa;
    private final ProductLogMapperForServiceLayer productLogMapperForServiceLayer;

    private final JpaBbdTrackerRepository jpaBbdTrackerRepository;

    private final JpaAdminStoreActivityRepository jpaAdminStoreActivityRepository;
    private final AdminStoreActivityMapperForJpa adminStoreActivityMapperForJpa;

    private final StoreMapper storeMapper;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    //---------------- Repository Layer Beans : --------------------

    @Bean
    public UserRepository userRepository(){
        return new JpaUserAdapter(
                this.jpaUserRepository, this.userMapperForJpa, this.bbdTrackerRepository()
        );
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
        return new JpaProductAdapter(
                this.jpaProductRepository,
                this.productMapperForJpa
        );
    }

    @Bean
    public BbdRecordRepository bbdRecordRepository(){
        return new JpaBbdRecordRepositoryAdapter(this.jpaBbdRecordRepository, this.bbdRecordMapperForJpa);
    }

    @Bean
    public UserActivityRepository userActivityRepository(){
        return new JpaUserActivityRepositoryAdapter(this.jpaUserActivityRepository, this.userActivityMapperForJpa);
    }

    @Bean
    public HomePageRepository homePageRepository(){
        return new JpaHomePageRepositoryAdapter(this.jpaHomePageRepository);
    }

    @Bean
    public UserHimselfActivityRepository userHimselfActivityRepository(){
        return new JpaUserHimselfActivityAdapter(
                this.jpaUserHimselfActivityRepository, this.userHimselfActivityMapperForJpa
        );
    }

    @Bean
    public ProductLogRepository productLogRepository(){
        return new JpaProductLogRepositoryAdapter(
                this.jpaProductLogRepository,
                this.productLogMapperForJpa,
                this.userRepository(),
                this.userMapperForJpa,
                this.activityTypeRepository(),
                this.activityTypeMapperForJpa
        );
    }

    @Bean
    public BbdTrackerRepository bbdTrackerRepository(){
        return new JpaBbdTrackerRepositoryAdapter(this.jpaBbdTrackerRepository);
    }

    @Bean
    public AdminStoreActivityRepository adminStoreActivityRepository(){
        return new JpaAdminStoreActivityRepositoryAdapter(
                this.jpaAdminStoreActivityRepository, this.adminStoreActivityMapperForJpa
        );
    }


    //---------------- Service Layer Beans : --------------------

    @Bean
    public UserService userService(){
        return new UserManager(
                this.userRepository(),
                this.userMapper,
                this.passwordEncoder(),
                this.userHimselfActivityService()
        );
    }

    @Bean
    public ActivityTypeService activityTypeService(){
        return new ActivityTypeManager(this.activityTypeRepository());
    }

    @Bean
    public StoreService storeService(){
        return new StoreManager(
                this.storeRepository(),
                this.storeMapper,
                this.adminStoreActivityService()
        );
    }

    @Bean
    public ProductService productService(){
        return new ProductManager(
                this.productRepository(), this.productLogService(), this.productLogMapperForServiceLayer
        );
    }

    @Bean
    public BbdRecordService bbdRecordService(){
        return new BbdRecordManager(
                this.bbdRecordRepository(),
                this.bbdRecordMapperForCoreEntity,
                this.userActivityMapper,
                this.userService(),
                this.productService(),
                this.userActivityService()
        );
    }

    @Bean
    public UserActivityService userActivityService() {
        return new UserActivityManager(this.userActivityRepository());
    }

    @Bean
    public HomePageService homePageService(){
        return new HomePageServiceImpl(this.homePageRepository(), this.userService());
    }

    @Bean
    public UserHimselfActivityService userHimselfActivityService(){
        return new UserHimselfActivityManager(this.userHimselfActivityRepository());
    }

    @Bean
    public ProductLogService productLogService(){
        return new ProductLogManager(this.productLogRepository());
    }

    @Bean
    public AdminStoreActivityService adminStoreActivityService(){
        return new AdminStoreActivityManager(this.adminStoreActivityRepository());
    }
}
