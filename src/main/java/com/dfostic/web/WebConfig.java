package com.dfostic.web;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import javax.inject.Inject;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.dfostic.web")
public class WebConfig extends WebMvcConfigurerAdapter {
    
    @Inject SpringValidatorAdapter springValidator;

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setCacheSeconds(1);
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        messageSource.setBasename("messages/validation");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() throws ClassNotFoundException {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setProviderClass(HibernateValidator.class);
        validator.setValidationMessageSource(this.messageSource());
        return validator;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(new Locale("en"));
        return resolver;
    }

    @Override
    public Validator getValidator() {
        return this.springValidator; 
    } 
    
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        // Add formatters and/or converters
//    }
//    @Bean
//    public FormattingConversionService conversionService() {
//        // Use the DefaultFormattingConversionService but do not register defaults
//        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);
//
//        // Ensure @NumberFormat is still supported
//        //conversionService.addFormatterForFieldAnnotation(new NumberFormatAnnotationFormatterFactory());
//        conversionService.addConverter(new WebConfig.StringToLocalDateConverter());
//        
//        // Register date conversion with a specific global format
//        DateFormatterRegistrar registrar = new DateFormatterRegistrar();
//        registrar.setFormatter(new DateFormatter("yyyy-MM-dd"));
//        registrar.registerFormatters(conversionService);
//
//        return conversionService;
//    }
//
//    private static class StringToLocalDateConverter implements Converter<String, LocalDate> {
//
//        public StringToLocalDateConverter() {
//        }
//
//        public LocalDate convert(String s) {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
//            return LocalDate.parse(s, formatter);
//        }
//    }
}
