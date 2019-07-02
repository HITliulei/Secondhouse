package com.ll.secondhouse.mapper;

import com.ll.secondhouse.bean.users;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface usersMapper {

    @Select("select * from users where u_username=#{username} and u_password=#{password}")
    public users logincheck(String username, String password);

    @Select("select * from users where u_username=#{username}")
    public users checkusernmae(String username);


    @Options(useGeneratedKeys = true,keyProperty = "u_id")
    @Insert("insert into users values (#{u_id},#{u_username},#{u_password},#{u_email},#{u_data},#{u_address})")
    public int registry(users users);

    @Update("update users set u_username=#{u_username} ,u_password = #{u_password},u_telephone=#{u_telephone},u_sex=#{u_sex},u_data=#{u_data} where u_id = #{u_id}")
    public int updateusers(users users);

    @Delete("delete from users where u_id = #{id}")
    public int deleteUsersById(int id);

    @Select("select * from users where u_id = #{id}")
    public users getusersbyId(int id);


    @Select("select * from users")
    public List<users> findallusers();
}
