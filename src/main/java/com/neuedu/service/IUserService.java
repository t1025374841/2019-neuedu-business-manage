package com.neuedu.service;

import com.neuedu.exception.MyException;
import com.neuedu.pojo.UserInfo;

import java.util.List;

/**
 * Created by tao on 2019/8/6.
 */
public interface IUserService {

    public UserInfo login(UserInfo userInfo) throws MyException;

    public List<UserInfo> findAll() throws MyException;

    public int register(UserInfo userInfo) throws MyException;

    public UserInfo findById(int useId) throws MyException;

    public int update(UserInfo userInfo) throws MyException;

    public int delete(int userId) throws MyException;

}
