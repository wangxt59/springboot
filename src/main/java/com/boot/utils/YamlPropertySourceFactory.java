package com.boot.utils;

import org.springframework.boot.env.PropertySourcesLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.util.StringUtils;
 
import java.io.IOException;
 
public class YamlPropertySourceFactory implements PropertySourceFactory {
 
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource encodedResource) throws IOException {
        return name != null ? new PropertySourcesLoader().load(encodedResource.getResource(), name, null) : new PropertySourcesLoader().load(
                encodedResource.getResource(), getNameForResource(encodedResource.getResource()), null);
    }
 
    private static String getNameForResource(Resource resource) {
        String name = resource.getDescription();
        if (!StringUtils.hasText(name)) {
            name = resource.getClass().getSimpleName() + "@" + System.identityHashCode(resource);
        }
        return name;
    }
}