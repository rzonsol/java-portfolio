package org.elearning.portfolio.services;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CreateDataSourceForJdbcTemplate {

    private static final String driverClassName = "org.h2.Driver";
    private static final String url = "jdbc:h2:file:./target/portfolio-db";
    private static final String dbUsername = "sa";
    private static final String dbPassword = "sa";

    private static DataSource dataSource;

    public static DriverManagerDataSource getDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(driverClassName);

        dataSource.setUrl(url);

        dataSource.setUsername(dbUsername);

        dataSource.setPassword(dbPassword);

        return dataSource;
    }

}