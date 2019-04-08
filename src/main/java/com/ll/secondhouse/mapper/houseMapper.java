package com.ll.secondhouse.mapper;

import com.ll.secondhouse.bean.house;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface houseMapper {

    //注册新房子
    @Options(useGeneratedKeys = true,keyProperty = "h_id")
    @Insert("insert into house values(#{h_id},#{h_name},#{h_address},#{h_produce},#{h_date},#{h_state},#{h_price},#{h_user_id},#{h_buyer_id})")
    public int addhouse(house house);

    //待审核的house
    @Select("select * from house where h_state=1 ")
    public List<house> noreview();

    //过审核的house
    @Select("select * from house where h_state=2")
    public List<house> reviewhouse();

    //user 公布的房子
    @Select("select * from house where h_user_id=#{id}")
    public List<house> userhouse(int id);

    //user 购买的house
    @Select("select * from house where h_buyer_id=#{id}")
    public List<house> buyerhouse(int id);

    @Select("select * from house where h_id=#{id}")
    public house findhouseById(int id);

    @Update("update house set h_name=#{h_name},h_address=#{h_address},h_produce=#{h_produce},h_date=#{h_date},h_state=#{h_state},h_price=#{h_price},h_buyer_id=#{h_buyer_id} where h_id=#{h_id}")
    public void updatehouse(house house);


    @Delete("delete from house where h_id=#{h_id}")
    public void deletehouse(int h_id);

    @Select("select * from house where h_name like  CONCAT('%',#{string},'%')")
    public List<house> getlikelyhouse(String string);
}
