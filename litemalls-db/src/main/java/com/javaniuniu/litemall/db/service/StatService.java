package com.javaniuniu.litemall.db.service;

import com.javaniuniu.litemall.db.dao.StatMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/javaniuniu
 * @Date: 2020/3/18 10:26 PM
 */
@Service
public class StatService {
    @Resource
    private StatMapper statMapper;


    public List<Map> statUser() {
        return statMapper.statUser();
    }

    public List<Map> statOrder() {
        return statMapper.statOrder();
    }

    public List<Map> statGoods() {
        return statMapper.statGoods();
    }
}
