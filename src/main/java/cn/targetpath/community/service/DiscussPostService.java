package cn.targetpath.community.service;

import cn.targetpath.community.dao.DiscussPostMapper;
import cn.targetpath.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DengBo_Zhong
 * @version V1.0
 * @date 2023/2/16 22:54
 */
@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return discussPostMapper.selectDiscussPosts(userId, offset, limit);
    }

    public int findDiscussPostCount(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}

