//package com.ibmz.watsonxLeave.dao;
//
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//import javax.sql.DataSource;
//
///**
// * jdbc配置类
// */
//@Configuration
//@PropertySource("classpath:/db.properties")//加载指定的property文件
//public class jdbcConfigration {
//
//    @Value("${jdbc.driverClassName}")
//    String driverClassName;
//    @Value("${jdbc.url}")
//    String url;
//    @Value("${jdbc.username}")
//    String username;
//    @Value("${jdbc.password}")
//    String password;
//
//    /**
//     * 实例化Druid
//     */
//    @Bean
//    public DataSource getDataSource(){
//        DruidDataSource source=new DruidDataSource();
//        source.setDriverClassName(this.driverClassName);
//        source.setUrl(this.url);
////        source.setUsername(this.username);
////        source.setPassword(this.password);
//        return source;
//    }
//}
