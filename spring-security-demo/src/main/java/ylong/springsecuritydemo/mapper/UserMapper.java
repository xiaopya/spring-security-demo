package ylong.springsecuritydemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import ylong.springsecuritydemo.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
