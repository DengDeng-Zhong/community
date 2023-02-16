package cn.targetpath.community.dao.impl;

import cn.targetpath.community.dao.UserMapper;
import cn.targetpath.community.entity.User;

/**
 * @author DengBo_Zhong
 * @version V1.0
 * @date 2023/2/16 21:55
 */

public class UserMapperImpl implements UserMapper {
    @Override
    public User selectById(int id) {
        return null;
    }

    @Override
    public User selectByName(String name) {
        return null;
    }

    @Override
    public User selectByEmail(String email) {
        return null;
    }

    @Override
    public int insertUser(User user) {
        return 0;
    }

    @Override
    public int updateStatus(int id, int status) {
        return 0;
    }

    @Override
    public int updateHeader(int id, String headerUrl) {
        return 0;
    }

    @Override
    public int updatePassword(int id, String password) {
        return 0;
    }
}
