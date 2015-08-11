package com.dfostic.web;

import com.dfostic.config.FifaConfig;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.dfostic.web")
public class WebConfig extends WebMvcConfigurerAdapter {

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
