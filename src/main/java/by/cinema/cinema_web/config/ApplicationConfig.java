package by.cinema.cinema_web.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import static by.cinema.cinema_web.utils.Constants.BASE_NAME;
import static by.cinema.cinema_web.utils.Constants.DEFAULT_ENCODING;

@Configuration
public class ApplicationConfig {

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(BASE_NAME);
        messageSource.setDefaultEncoding(DEFAULT_ENCODING);
        return messageSource;
    }
}
