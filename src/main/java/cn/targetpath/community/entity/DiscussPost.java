package cn.targetpath.community.entity;

import lombok.Data;

import java.util.Date;

/**
 * 帖子
 *
 * @author DengBo_Zhong
 * @version V1.0
 * @date 2023/2/16 22:30
 */
@Data
public class DiscussPost {
    private int id;
    private int userId;
    private String title;
    private String content;
    private int type;
    private int status;
    private Date createTime;
    private int commentCount;
    private double score;

}
