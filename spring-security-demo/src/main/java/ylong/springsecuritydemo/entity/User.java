package ylong.springsecuritydemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author: cyl
 * @description: TODO 用户类
 * @date: 2024/3/14 19:47
 */
@Data
public class User {
    // 主键自增
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
}
