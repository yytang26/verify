//package com.tyy.page.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//
//import com.github.pagehelper.PageHelper;
//
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//
//import org.mybatis.spring.annotation.MapperScan;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.DefaultResourceLoader;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
///**
// * @author:tyy
// * @date:2021/5/30
// */
//@Configuration
//@Primary
//public class DruidDataSourceConfig extends DataSourceProperties {
//
//    private Logger logger = LoggerFactory.getLogger(DruidDataSourceConfig.class);
//
//    static final String MYSQL_DRIVER_NAME = "com.mysql.jdbc.Driver";
//
//    static final String ORACLE_DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
//
//    @Value("${spring.datasource.url}")
//    private String dbUrl;
//    @Value("${spring.datasource.username}")
//    private String userName;
//    @Value("${spring.datasource.password}")
//    private String password;
//    @Value("${spring.datasource.driver-class-name}")
//    private String driverClassName;
//    @Value("${spring.datasource.initial-size}")
//    private int initialSize;
////    @Value("${spring.datasource.druid.poolPreparedStatements}")
////    private boolean poolPreparedStatements;
////    @Value("${spring.datasource.druid.connection-properties}")
////    private String connectionProperties;
//
//    @Bean
//    public DataSource dataSource(){
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(dbUrl);
//        dataSource.setUsername(userName);
//        dataSource.setPassword(password);
//
//        dataSource.setDriverClassName(driverClassName);
//
//
//        dataSource.setInitialSize(initialSize);
////        dataSource.setPoolPreparedStatements(poolPreparedStatements);
////        dataSource.setConnectionProperties(connectionProperties);
//        return dataSource;
//
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:*/mapper/**/*.xml"));
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        sqlSessionFactoryBean.setConfigLocation(new DefaultResourceLoader().getResource("classpath:mybatis-config.xml"));
//
//        sqlSessionFactoryBean.setTypeAliasesPackage("com.tyy.mapper");
//        return sqlSessionFactoryBean.getObject();
//
//    }
//
//    @Bean
//    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//    @Bean("onePageHelper")
//    public PageHelper onePageHelper(){
//        logger.info("=====MybatisConfiguration.pageHelper()=====");
//        PageHelper pageHelper = new PageHelper();
//        Properties p = new Properties();
//        String dialect = "";
//        logger.info(("====dataSource()===="+this.driverClassName));
//        if(ORACLE_DRIVER_NAME.equals(this.driverClassName)){
//            dialect = "oracle";
//        }else if(MYSQL_DRIVER_NAME.equals(this.driverClassName)){
//            dialect = "mysql";
//        }
//        p.setProperty("offsetAsPageNum","true");
//        p.setProperty("rowBoundsWithCount","true");
//        p.setProperty("reasonable","true");
//        p.setProperty("dialect",dialect);
//        logger.info("====dataSourcePluginproperties====");
//        pageHelper.setProperties(p);
//        return pageHelper;
//    }
//}
//
