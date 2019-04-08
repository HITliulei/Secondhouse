package com.ll.secondhouse.mapper;
import com.ll.secondhouse.bean.appraise;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface appraiseMapper {

    @Options(useGeneratedKeys = true,keyProperty = "a_id")
    @Insert("insert into appraise values (#{a_id},#{a_content},#{a_userid},#{a_house},#{a_data})")
    public int addAppraise(appraise appraise);

    @Select("select * from appraise where a_house = #{id}")
    public List<appraise> seehouseappraise(int id);

    @Select("select * from appraise where a_userid=#{id}")
    public List<appraise> userappraise(int id);
}
