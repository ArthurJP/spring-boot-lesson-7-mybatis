package com.jp.springbootlesson7.annotation;

import com.jp.springbootlesson7.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Results(id = "UserResultMap2", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "pass"),
            @Result(property = "age", column = "age")
    })
    @Select("select * from user where id = #{id}")
//    @ResultMap("UserResultMap2")
    User selectUser(int id);
}
