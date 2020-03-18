package com.javaniuniu.litemall.db.service;

import com.github.pagehelper.PageHelper;
import com.javaniuniu.litemall.db.dao.LitemallFeedbackMapper;
import com.javaniuniu.litemall.db.domain.LitemallFeedback;
import com.javaniuniu.litemall.db.domain.LitemallFeedbackExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 意见反馈
 *
 * @author Yogeek
 * @date 2018/8/27 11:39
 */

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/javaniuniu
 * @Date: 2020/3/18 10:26 PM
 */
@Service
public class LitemallFeedbackService {
    @Autowired
    private LitemallFeedbackMapper feedbackMapper;

    public Integer add(LitemallFeedback feedback) {
        feedback.setAddTime(LocalDateTime.now());
        feedback.setUpdateTime(LocalDateTime.now());
        return feedbackMapper.insertSelective(feedback);
    }

    public List<LitemallFeedback> querySelective(Integer userId, String username, Integer page, Integer limit, String sort, String order) {
        LitemallFeedbackExample example = new LitemallFeedbackExample();
        LitemallFeedbackExample.Criteria criteria = example.createCriteria();

        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return feedbackMapper.selectByExample(example);
    }
}
