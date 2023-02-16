package cn.targetpath.community.dao;

import cn.targetpath.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户接口
 *
 * @author DengBo_Zhong
 * @version V1.0
 * @date 2023/2/16 21:51
 */
@Mapper
public interface UserMapper {

    User selectById(int id);

    User selectByName(String name);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);

}
