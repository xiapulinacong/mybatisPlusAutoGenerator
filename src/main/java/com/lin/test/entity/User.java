package com.lin.test.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 啊聪
 * @since 2022-10-08
 */
@Getter
@Setter
@TableName("t_user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("id")
    private Integer id;
    @ApiModelProperty(value = "用户名")// 对属性进行简要说明
    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("deleted")
    @TableLogic
    private Integer deleted;


}
