package cn.targetpath.community.service;

import cn.targetpath.community.dao.UserMapper;
import cn.targetpath.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DengBo_Zhong
 * @version V1.0
 * @date 2023/2/16 23:00
 */
@Service
public class UserService  {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id){
        return userMapper.selectById(id);
    }
}
