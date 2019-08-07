package com.neuedu.service.Impl;

import com.neuedu.dao.UserInfoMapper;
import com.neuedu.exception.MyException;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tao on 2019/8/6.
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo login(UserInfo userInfo) throws MyException {

        //参数的非空校验
        if(userInfo==null){
            throw new MyException("参数不能为空");
        }
        if(userInfo.getUsername()==null||userInfo.getUsername().equals("")){
            throw new MyException("用户名不能为空");
        }
        if(userInfo.getPassword()==null||userInfo.getPassword().equals("")){
            throw new MyException("密码不能为空");
        }

        //判断用户名是否存在

        int username_result = userInfoMapper.exsitsUsername(userInfo.getUsername());

        if(username_result==0){
            throw new MyException("用户名不存在");
        }


        //根据用户名和密码登录

        UserInfo userinfo_result = userInfoMapper.findByUsernameAndPassword(userInfo);
        if(userinfo_result==null){
            throw new MyException("密码错误");
        }

        //判断权限

        if(userinfo_result.getRole()!=0){
            throw new MyException("没有权限访问");
        }


        return userinfo_result;
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public int register(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }

    @Override
    public UserInfo findById(int useId) {
        return userInfoMapper.selectByPrimaryKey(useId);
    }

    @Override
    public int update(UserInfo userInfo) {
        return userInfoMapper.updateByPrimaryKey(userInfo);
    }

    @Override
    public int delete(int userId) {
        return userInfoMapper.deleteByPrimaryKey(userId);
    }
}
