package com.ll.secondhouse.mapper;

import com.ll.secondhouse.bean.orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ordersMapper {

    @Select("select * from orders where u_id=#{id}")
    public List<orders> seemyorders(int id);

    @Options(useGeneratedKeys = true,keyProperty = "o_id")
    @Insert({"insert into orders values(#{o_id},#{u_id},#{h_id},#{date},#{o_state},#{h_money})"})
    public int addorder(orders orders);

    @Select("select * from orders where o_id = #{id}")
    public orders lookorders(int id);

    @Select("select * from orders where h_id = #{id}")
    public orders findordersbyhouse(int id);


    @Update("update orders set o_state=#{o_state} where o_id=#{o_id}")
    public void update(orders orders);

    @Delete("delete from orders where o_id=#{o_id} ")
    public  void deleteorders(int id);
}
