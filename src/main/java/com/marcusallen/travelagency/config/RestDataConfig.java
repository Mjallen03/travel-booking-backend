package com.marcusallen.travelagency.config;

import com.marcusallen.travelagency.entities.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestDataConfig implements RepositoryRestConfigurer {

    /**
     * This method exposes standard rest api end points for the following classes:
     * Country
     * Customer
     * Division
     * Excursion
     * Vacation
     * <p>
     * Set page configuration parameters
     *
     * @param config
     * @param cors
     */

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        // Expose entity IDs
        config.exposeIdsFor(
                Country.class,
                Customer.class,
                Division.class,
                Excursion.class,
                Vacation.class,
                Cart.class,
                CartItem.class
        );

        // Disable paging limits
        config.setDefaultPageSize(Integer.MAX_VALUE);
        config.setMaxPageSize(Integer.MAX_VALUE);

        // Enable CORS for Angular frontend
        cors.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
