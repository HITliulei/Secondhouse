package com.ll.secondhouse.mapper;

import com.ll.secondhouse.bean.messagesend;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import java.util.List;
public interface messageSend {

    @Options(useGeneratedKeys = true,keyProperty = "ms_id")
    @Insert("insert into messagesend values (#{ms_id},#{ms_senderid},#{ms_rid},#{ms_content},#{ms_date})")
    public int sendmessage(messagesend messagesend);

    @Select("select * from messagesend where ms_senderid = #{id}")
    public List<messagesend> getsendermessgeByid(int id);

    @Delete("delete from messagesend where ms_id=#{id}")
    public void deletesendid(int id);

    @Delete("delete from messagesend where ms_senderid=#{id}")
    public void cleanUpMessage(int id);
}
