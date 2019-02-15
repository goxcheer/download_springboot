package com.qgx.download.dao;

import com.qgx.download.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.Date;
import java.util.Map;

/**
 *@Author: Goxcheer
 *@Date:16:08 2019/1/11
 *@Email:604721660@qq.com
 *@decription: 用户Dao接口
 */
@Mapper
public interface UserDao {

    /**
     * 根据账号查询用户
     * @param account
     * @return
     */
    @Select("select * from t_user where account = #{account}")
    @Results(id="userMap", value = {@Result(column = "id", property = "id", javaType = Integer.class),
            @Result(column = "account", property = "account", javaType = String.class),
            @Result(column = "password", property = "password", javaType = String.class),
            @Result(column = "nick_name", property = "nickName", javaType = String.class),
            @Result(column = "email", property = "email", javaType = String.class),
            @Result(column = "points", property = "points", javaType = Integer.class),
            @Result(column = "is_vip", property = "isVip", javaType = String.class),
            @Result(column = "is_off", property = "isOff", javaType = String.class),
            @Result(column = "role_name", property = "" +
                    "" +
                    "" +
                    "", javaType = String.class),
            @Result(column = "register_date", property = "registerDate", javaType = Date.class)})
    User getUserByAccount(String account);

    @Select("select * from t_user where id = #{id}")
    @ResultMap("userMap")
    User getUserById(Integer id);

    /**
     * 根据邮箱查询用户
     * @param email
     * @return
     */
    @Select("select * from t_user where email = #{email}")
    @ResultMap("userMap")
    User getUserByEmail(String email);

    @Insert("insert into t_user (account,password,nick_name,email,is_vip,is_off,role_name,register_date) values (#{account},#{password}," +
            "#{nickName},#{email},#{isVip},#{isOff},#{roleName},#{registerDate})")
    Integer saveUser(User user);

    @UpdateProvider(type=UserDaoProvider.class, method = "updateUser")
    Integer updateUser(Map<String,Object> updateMap);

    class UserDaoProvider{
        public String updateUser(Map<String,Object>map){
            return new SQL(){{
                UPDATE("t_user");
                if (map.get("newPassword") != null) {
                    SET("password = #{newPassword}");
                }
                if (map.get("points") != null) {
                    SET("points = points + #{points}");
                }
                if (map.get("account") != null) {
                    WHERE("account = #{account}");
                }
                if (map.get("userId") != null) {
                    WHERE("id = #{userId}");
                }
            }}.toString();
        }
    }
}
