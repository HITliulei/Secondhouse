package com.ll.secondhouse.mapper;
import com.ll.secondhouse.bean.recommend;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface recommendMapper {

    @Insert("insert into recommend values(#{t_id},#{u_id},#{h_id},#{score})")
    public void insertData(recommend recommend);

    @Select("select * from recommend")
    public List<recommend> findallscore();

    @Update("update recommend set score=#{score} where u_id=#{u_id} and h_id=#{h_id}")
    public void updateScore(recommend recommend);

    /*检查是否有这个评分了*/
    @Select("select * from recommend where u_id=#{u_id} and h_id=#{h_id}")
    public recommend checkScore(int u_id,int h_id);
}
