package cn.targetpath.community;

import cn.targetpath.community.dao.UserMapper;
import cn.targetpath.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author DengBo_Zhong
 * @version V1.0
 * @date 2023/2/16 22:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {CommunityApplication.class})
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectById(){
        User user = userMapper.selectById(101);
        System.out.println("user = " + user);
    }

}
