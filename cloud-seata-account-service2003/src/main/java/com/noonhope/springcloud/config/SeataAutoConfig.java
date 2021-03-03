package com.noonhope.springcloud.config;


import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactionScanner;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author onlystatic
 * @date 2020/11/12 13:47
 */
@Configuration
@Slf4j
public class SeataAutoConfig {

    @Autowired(required = true)
    private DataSourceProperties dataSourceProperties;
    private DataSourceProxy dataSourceProxy;

    /**
     * 声明其为Bean实例
     * 在同样的DataSource中，首先使用被标注的DataSource
     *
     * @return
     */
    @Bean(name = "dataSource")
    @Primary
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        log.info("dataSourceProperties.getUrl():{}", dataSourceProperties.getUrl());
        druidDataSource.setUrl(dataSourceProperties.getUrl());
        druidDataSource.setUsername(dataSourceProperties.getUsername());
        druidDataSource.setPassword(dataSourceProperties.getPassword());
        druidDataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        druidDataSource.setInitialSize(0);
        druidDataSource.setMaxActive(180);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setMinIdle(0);
        druidDataSource.setValidationQuery("Select 1 from DUAL");
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(25200000);
        druidDataSource.setRemoveAbandoned(true);
        druidDataSource.setRemoveAbandonedTimeout(1800);
        druidDataSource.setLogAbandoned(true);
        log.info("装载dataSource........");
        dataSourceProxy = new DataSourceProxy(druidDataSource);
        return dataSourceProxy;
    }

    /**
     * init datasource proxy
     *
     * @Param: druidDataSource datasource bean instance
     * @Return: DataSourceProxy datasource proxy
     */
    @Bean
    public DataSourceProxy dataSourceProxy() {
        log.info("代理dataSource........");
        return dataSourceProxy;
    }

    /**
     * init global transaction scanner
     *
     * @Return: GlobalTransactionScanner
     */
    @Bean
    public GlobalTransactionScanner globalTransactionScanner() {
        return new GlobalTransactionScanner("cloud-seata-account-service", "my_test_tx_group");
    }
}
