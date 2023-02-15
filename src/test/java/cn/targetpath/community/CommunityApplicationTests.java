package cn.targetpath.community;

import cn.targetpath.community.dao.AlphaDao;
import cn.targetpath.community.service.AlphaService;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {CommunityApplication.class})
class CommunityApplicationTests implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 测试从容器中取出bean
     */
    @Test
    @Ignore
    void contextLoads() {
        System.out.println("applicationContext = " + applicationContext);
        AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
        System.out.println("alphaDao = " + alphaDao.select());
    }

    @Test
    public void testBeanManagement() {
        AlphaService bean = applicationContext.getBean(AlphaService.class);
        System.out.println("bean = " + bean);

        bean = applicationContext.getBean(AlphaService.class);
        System.out.println("bean = " + bean);
    }

}
