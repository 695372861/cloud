package com.myatomikos.lsxatomikos.datasource;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;

@ConfigurationProperties(prefix = "mysql.datasource.test1")
@Configuration
@MapperScan(basePackages = "com.myatomikos.lsxatomikos.user1.dao",sqlSessionTemplateRef = "user1SqlSessionTemplate")
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef="entityManagerFactorySecondary",
//        transactionManagerRef="transactionManagerSecondary",
//        basePackages= { "com.myatomikos.lsxatomikos.user1.dao" }) //设置Repository所在位置
//@EnableJpaRepositories(
//        basePackages= { "com.myatomikos.lsxatomikos.user1.dao" }) //设置Repository所在位置
public class DBConfig1 {
    private String url;
    private String username;
    private String password;
    private int minPoolSize;
    private int maxPoolSize;
    private int maxLifetime;
    private int borrowConnectionTimeout;
    private int loginTimeout;
    private int maintenanceInterval;
    private int maxIdleTime;
    private String testQuery;


//    @Primary
    @Bean(name ="user1DataSource")
    public DataSource user1DataSource()throws SQLException {
        MysqlXADataSource mysqlXADataSource=new MysqlXADataSource();
        mysqlXADataSource.setUrl(getUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword(getPassword());
        mysqlXADataSource.setUser(getUsername());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);


        AtomikosDataSourceBean xaDataSource=new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXADataSource);
        xaDataSource.setUniqueResourceName("user1DataSource");

        xaDataSource.setMinPoolSize(getMinPoolSize());
        xaDataSource.setMaxPoolSize(getMaxPoolSize());
        xaDataSource.setMaxLifetime(getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(getLoginTimeout());
        xaDataSource.setMaintenanceInterval(getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(getMaxIdleTime());
        xaDataSource.setTestQuery(getTestQuery());

        return   xaDataSource;
    }

//    @Primary
    @Bean (name="user1SqlSessionFactory")
    public SqlSessionFactory user1SqlSessionTemplate(@Qualifier("user1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
//    @Primary
    @Bean(name = "user1SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("user1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    @Override
    public String toString() {
        return "DBConfig1{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", minPoolSize=" + minPoolSize +
                ", maxPoolSize=" + maxPoolSize +
                ", maxLifetime=" + maxLifetime +
                ", borrowConnectionTimeout=" + borrowConnectionTimeout +
                ", loginTimeout=" + loginTimeout +
                ", maintenanceInterval=" + maintenanceInterval +
                ", maxIdleTime=" + maxIdleTime +
                ", testQuery='" + testQuery + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMinPoolSize() {
        return minPoolSize;
    }

    public void setMinPoolSize(int minPoolSize) {
        this.minPoolSize = minPoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public int getMaxLifetime() {
        return maxLifetime;
    }

    public void setMaxLifetime(int maxLifetime) {
        this.maxLifetime = maxLifetime;
    }

    public int getBorrowConnectionTimeout() {
        return borrowConnectionTimeout;
    }

    public void setBorrowConnectionTimeout(int borrowConnectionTimeout) {
        this.borrowConnectionTimeout = borrowConnectionTimeout;
    }

    public int getLoginTimeout() {
        return loginTimeout;
    }

    public void setLoginTimeout(int loginTimeout) {
        this.loginTimeout = loginTimeout;
    }

    public int getMaintenanceInterval() {
        return maintenanceInterval;
    }

    public void setMaintenanceInterval(int maintenanceInterval) {
        this.maintenanceInterval = maintenanceInterval;
    }

    public int getMaxIdleTime() {
        return maxIdleTime;
    }

    public void setMaxIdleTime(int maxIdleTime) {
        this.maxIdleTime = maxIdleTime;
    }

    public String getTestQuery() {
        return testQuery;
    }

    public void setTestQuery(String testQuery) {
        this.testQuery = testQuery;
    }

}
