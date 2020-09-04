package com.example.demo.mapper;

import com.example.demo.model.Shuju;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShujuMapper {
    @Insert("insert into shuju (id,biaoti,leirong) values(#{id},#{biaoti},#{leirong})")
    void addshuju(Shuju shuju);

    @Select("select * from shuju where biaoti=#{biaoti}")
    Shuju getshuju(String biaoti);

    @Delete("delete from shuju where biaoti=#{biaoti}")
    void deleteshuju(String biaoti);

    @Update("update shuju set leirong=#{leirong} where biaoti=#{biaoti}")
    void updateshuju(String biaoti, String leirong);

    @Select("select leirong from shuju where biaoti = #{biaoti}")
    String getleirong(String biaoti);

//    @Select("select biaoti from shuju where id = #{id}")
 //   String getbt(int id);

//    @Select("select leirong from shuju where id = #{id}")
//    String getlr(int id);

//    @Select("select * from shuju ")
//    List<Shuju> display();

    @Select("select biaoti from shuju ")
    List<String> allbiaoti();

    @Select("select leirong from shuju ")
    List<String> allleirong();

//    @Select("select id from shuju where id = #{id}")
//    Shuju getid(int id);

}
