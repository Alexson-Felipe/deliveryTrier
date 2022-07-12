package br.com.alexson.delivery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguracao {

    @Bean
    public DataSource dataSource(){
        //Trier
        //String url = "jdbc:postgresql://localhost:5434/delivery"; //porta da esquerda no container docker 5434:5432

        //Em casa
        String url = "jdbc:postgresql://localhost:5432/delivery"; //porta da esquerda no container docker 5434:5432

        String usuario = "postgres";
        String senha = "postgres";

        return new DriverManagerDataSource(url, usuario, senha);
    }
}
