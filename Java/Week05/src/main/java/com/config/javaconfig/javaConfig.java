package com.config.javaconfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import com.pojo.CityInfo;
import com.pojo.Klass;
import com.pojo.Student;
import com.service.ISchool;
import com.service.impl.School;
import com.zaxxer.hikari.HikariDataSource;
import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan(basePackages = "com")
//@ConfigurationProperties
@PropertySource(value = {"classpath:database.properties"}, encoding = "UTF-8")
@Import(value = {LoadBeanFromJavaConfig.class})
public class javaConfig {


    @Value("${mysql.user}")
    private String mysqlUser;

    @Value("${mysql.password}")
    private String mysqlPassword;

    @Value("${mysql.url}")
    private String mysqlUrl;

    @Bean(name = "cityHangzhou")
    public CityInfo getInstance(){
        CityInfo cityInfo = new CityInfo();
        cityInfo.setCityName("HangZhou");
        cityInfo.setCitySize(1500);
        return cityInfo;
    }

    @Bean
    public JdbcConnectionPool ConnectH2DataBaseINfo(){
        JdbcDataSource h2DataBaseInfo = new JdbcDataSource();
        h2DataBaseInfo.setPassword("sa");
        h2DataBaseInfo.setUser("sa");
        h2DataBaseInfo.setURL("jdbc:h2:mem:test");
        JdbcConnectionPool jdbcConnectionPool = JdbcConnectionPool.create(h2DataBaseInfo);
        return jdbcConnectionPool;
    }

    @Bean
    public Connection getOriginJDBC() throws SQLException {
        Connection connection = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPassword);
        connection.setAutoCommit(false);
        return connection;
    }

    @Bean
    public HikariDataSource getMysqlDataSourceFromHikari() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(mysqlUrl);
        dataSource.setUsername(mysqlUser);
        dataSource.setPassword(mysqlPassword);
        return dataSource;
    }

    @Bean
    public Student getStudentInstance(){
        return new Student();
    }

    @Bean
    public Klass getKlassInstance(){
        return new Klass();
    }

    @Bean
    public ISchool getSchoolInstance(){
        return new School();
    }
}
