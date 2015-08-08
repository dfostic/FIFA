package com.dfostic.config;

import com.dfostic.config.RootConfig.WebPackage;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import java.util.regex.Pattern;

@Configuration
@ComponentScan(basePackages = "com.dfostic.factory",
        excludeFilters = {
            @Filter(type = FilterType.CUSTOM, value = WebPackage.class)
        })
public class RootConfig {

    public static class WebPackage extends RegexPatternTypeFilter {

        public WebPackage() {
            super(Pattern.compile("com\\.dfostic\\.web"));
        }
    }
}
