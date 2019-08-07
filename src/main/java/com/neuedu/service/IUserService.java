package com.neuedu.service;

import com.neuedu.exception.MyException;
import com.neuedu.pojo.UserInfo;

import java.util.List;

/**
 * Created by tao on 2019/8/6.
 */
public interface IUserService {

    public UserInfo login(UserInfo userInfo) throws MyException;

    public List<UserInfo> findAll();

    public int register(UserInfo userInfo);

    public UserInfo findById(int useId);

    public int update(UserInfo userInfo);

    public int delete(int userId);

}
