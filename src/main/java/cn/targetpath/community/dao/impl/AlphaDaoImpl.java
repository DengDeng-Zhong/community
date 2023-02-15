package cn.targetpath.community.dao.impl;

import cn.targetpath.community.dao.AlphaDao;
import org.springframework.stereotype.Repository;

/**
 * @author DengBo_Zhong
 * @version V1.0
 * @date 2023/2/15 21:11
 */
@Repository
public class AlphaDaoImpl implements AlphaDao  {
    @Override
    public String select() {
        return "AlphaDaoImpl";
    }
}
