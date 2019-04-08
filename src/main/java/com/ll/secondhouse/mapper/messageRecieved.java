package com.ll.secondhouse.mapper;

import com.ll.secondhouse.bean.messagerecieved;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface messageRecieved {

    @Options(useGeneratedKeys = true,keyProperty = "mr_id")
    @Insert("insert into messagerecieved values (#{mr_id},#{mr_sid},#{mr_recieveid},#{mr_content},#{mr_date})")
    public int recievedmessage(messagerecieved messagerecieved);

    @Select("select * from messagerecieved where mr_recieveid = #{id}")
    public List<messagerecieved> getsendermessgeByid(int id);

    @Delete("delete from messagerecieved where mr_id=#{id}")
    public void deletereciedByid(int id);

    @Delete("delete from messagerecieved where mr_recieveid=#{id}")
    public void cleanUpMessage(int id);
}
