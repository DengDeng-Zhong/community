package cn.targetpath.community.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户
 *
 * @author DengBo_Zhong
 * @version V1.0
 * @date 2023/2/16 21:49
 */
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private int type;
    private int status;
    private String activationCode;
    private String headerUrl;
    private Date createTime;
}
