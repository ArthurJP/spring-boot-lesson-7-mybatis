package com.jp.springbootlesson7.demo;

import com.jp.springbootlesson7.annotation.UserMapper;
import com.jp.springbootlesson7.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class MyBatisAnnotationConfigurationDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = contextClassLoader.getResourceAsStream( "mybatis/mybatis-config.xml/" );
        Reader reader = new InputStreamReader( inputStream, "UTF-8" );
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build( reader, "development", new Properties() );
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper( UserMapper.class );
        User user = userMapper.selectUser( 1 );
        System.out.println( "user = " + user );
        sqlSession.close();
    }
}
