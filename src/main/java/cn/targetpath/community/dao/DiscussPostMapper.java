package cn.targetpath.community.dao;

import cn.targetpath.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author DengBo_Zhong
 * @version V1.0
 * @date 2023/2/16 22:32
 */
@Mapper
public interface DiscussPostMapper {
    /**
     * 查询帖子
     * @param userId 如果userid为0 表示查询所有的数据
     * @param offset
     * @param limit
     * @return
     */
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    /**
     *
     * param 注解用于给参数取别名
     * 如果只有一个参数.并且在if里使用,则必须加别名
     * @param userId
     * @return
     */
    int selectDiscussPostRows(@Param("userId") int userId);
}
