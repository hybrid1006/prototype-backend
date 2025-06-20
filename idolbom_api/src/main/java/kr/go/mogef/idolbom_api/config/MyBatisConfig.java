package kr.go.mogef.idolbom_api.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("kr.go.mogef.idolbom_api.sample.mapper")
public class MyBatisConfig {
    
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        // SqlSessionTemplate: MyBatis 쿼리문을 수행해주는 역할
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}