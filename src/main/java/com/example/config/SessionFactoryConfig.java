package com.example.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * Created by Chenjie on 2017/6/12.
 */
public class SessionFactoryConfig implements TransactionManagementConfigurer {
    @Autowired
    private DataSource dataSource;

    /** * mybatis 配置路径 */
    private static String MYBATIS_CONFIG = "mybatis-config.xml";

    private String typeAliasPackage = "com.example";

    /**
     *创建sqlSessionFactoryBean 实例
     * 并且设置configtion 如驼峰命名.等等
     * 设置mapper 映射路径
     * 设置datasource数据源
     * @return
     * @throws Exception
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
/** 设置mybatis configuration 扫描路径 */
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(MYBATIS_CONFIG));
/** 设置datasource */
        sqlSessionFactoryBean.setDataSource(dataSource);
/** 设置typeAlias 包扫描路径 */
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasPackage);
        return sqlSessionFactoryBean;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
