package com.lin.test.service;

import com.lin.test.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 啊聪
 * @since 2022-10-08
 */
public interface UserService extends IService<User> {
    List<User> getAllUser();
    User getUserByUserName(String username);
}
