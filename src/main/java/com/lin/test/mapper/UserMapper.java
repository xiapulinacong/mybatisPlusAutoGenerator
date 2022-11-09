package com.lin.test.mapper;

import com.lin.test.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 啊聪
 * @since 2022-10-08
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> getAllUser();
    User getUserByUserName(@Param("username") String username);
}
