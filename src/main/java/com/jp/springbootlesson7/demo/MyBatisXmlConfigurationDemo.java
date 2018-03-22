package com.jp.springbootlesson7.demo;

import com.jp.springbootlesson7.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class MyBatisXmlConfigurationDemo {
    public static void main(String[] args) throws Exception {
        ResourceLoader resourceLoader=new DefaultResourceLoader(  );
        Resource resource = resourceLoader.getResource( "classpath:/mybatis/mybatis-config.xml" );
        EncodedResource encodedResource = new EncodedResource( resource, "UTF-8" );
        Reader reader = encodedResource.getReader();
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build( reader, "development", new Properties() );
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne( "com.jp.springbootlesson7.mapper.UserMapper.SelectOneUser", 2 );
        System.out.println( "user = " + user );
        sqlSession.close();
    }
}
