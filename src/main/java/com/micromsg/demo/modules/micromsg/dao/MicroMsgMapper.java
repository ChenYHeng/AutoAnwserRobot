package com.micromsg.demo.modules.micromsg.dao;

import com.micromsg.demo.modules.micromsg.entity.MicroMsg;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MicroMsgMapper {
    @Select("select id, command, result\n" +
            "from msg_list")
    @Results(id = "listMap", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "command", property = "command"),
            @Result(column = "result", property = "result")
    })
    List<MicroMsg> getMsgList();

    @Insert("insert into msg_list(command, result)\n" +
            "values (#{command}, #{result})")
    void addRecord(String command, String result);

    @Update("update msg_list\n" +
            "set command=#{command}, result=#{result}\n" +
            "where id=#{id}")
    void updateRecord(int id, String command, String result);

    @Delete("delete from msg_list\n" +
            "where id = #{id}")
    void delRecord(int id);

    @Delete("<script>" +
            "delete from msg_list " +
            "where id in " +
            "<foreach collection='list' open='(' item='item' separator=',' close=')'>" +
            "   #{item}" +
            "</foreach>" +
            "</script>")
    void multiDel(List<Integer> id);

    @Select("select result\n" +
            "from msg_list\n" +
            "where command = #{command}")
    List<String> getResult(String command);

    @Select("<script>" +
            "   select id, command, result " +
            "   from msg_list" +
            "   where 1=1 " +
            "   <if test='command!=null and command!=\"\"'>" +
            "       and command like #{command}" +
            "   </if>" +
            "   <if test='result!=null and result!=\"\"'>" +
            "       and result like concat('%', #{result}, '%')" +
            "   </if>" +
            "</script>")
    @ResultMap(value = "listMap")
    List<MicroMsg> search(String command, String result);
}
