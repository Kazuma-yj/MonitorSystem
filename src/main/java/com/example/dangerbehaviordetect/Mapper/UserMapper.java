package com.example.dangerbehaviordetect.Mapper;

import com.example.dangerbehaviordetect.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from User where mail = #{mail} and password = #{password}")
    public User login(String mail, String password);

    @Select("select * from User where mail = #{mail}")
    public User getByMail(String mail);

    @Select("select * from User where uID = #{ID}")
    public User getByID(int ID);

    @Options(keyProperty = "uID", useGeneratedKeys = true)
    @Insert("insert into User(mail, password, uName, admin) values (#{mail}, #{password}, #{uName}, 0)")
    public void register(User user);
}
