package mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.taoxiao.Message; 

@Mapper  
public interface messageMapper {  
	@Select("select * from message")  
    List<Message> select1();
    
    @Select("select * from message where receiveaccount = #{receiveaccount}")  
    List<Message> select2(String receiveaccount);
    
    @Select("select * from message where receiveaccount = #{receiveaccount} and situation = #{situation}")  
    List<Message> select3(@Param("receiveaccount") String receiveaccount, @Param("situation") int situation);
    
    @Insert("INSERT INTO message VALUES(#{function}, #{sendaccount}, #{receiveaccount}, #{type}, #{message}, #{mtime}, #{situation})")
    boolean insert(@Param("function") String function, @Param("sendaccount") String sendaccount, @Param("receiveaccount") String receiveaccount, 
    		@Param("type") String type, @Param("message") String message, @Param("mtime") Date mtime,@Param("situation") int situation);
    
    @Update("UPDATE message set situation=#{situation} where receiveaccount=#{receiveaccount}")
    boolean update(@Param("receiveaccount") String account, @Param("situation") int situation);
}  
