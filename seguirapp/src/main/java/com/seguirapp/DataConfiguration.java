package com.seguirapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
public class DataConfiguration {
    //Criar dois Beans, um para conexão com o banco
    //o outro para configurar o hibernate

    @Bean
    public DataSource dataSource(){
        //Bean de conexao com o banco
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.255.128/DBIFS");
        dataSource.setUsername("felipe");
        dataSource.setPassword("mkfelipe123");
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        //Configurando o hibernate
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true); //Mostra as etapas de no console
        adapter.setGenerateDdl(false); //Permite que o hibernate crie as tabelas automaticamente
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        adapter.setPrepareConnection(true);
        return adapter;
    }

}
