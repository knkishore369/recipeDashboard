package com.org.capg.recipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RecipesDashboardApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        System.out.println("::: Recipes Dashboard Application :::");
        SpringApplication.run(RecipesDashboardApplication.class, args);

    }

}
