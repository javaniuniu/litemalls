package com.javaniuniu.litemall.db.service;

import com.github.pagehelper.PageHelper;
import com.javaniuniu.litemall.db.dao.LitemallNoticeMapper;
import com.javaniuniu.litemall.db.domain.LitemallNotice;
import com.javaniuniu.litemall.db.domain.LitemallNoticeExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 通知管理员
 *
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/javaniuniu
 * @Date: 2020/3/18 10:26 PM
 */
@Service
public class LitemallNoticeService {
    @Resource
    private LitemallNoticeMapper noticeMapper;


    public List<LitemallNotice> querySelective(String title, String content, Integer page, Integer limit, String sort, String order) {
        LitemallNoticeExample example = new LitemallNoticeExample();
        LitemallNoticeExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        if (!StringUtils.isEmpty(content)) {
            criteria.andContentLike("%" + content + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return noticeMapper.selectByExample(example);
    }

    public int updateById(LitemallNotice notice) {
        notice.setUpdateTime(LocalDateTime.now());
        return noticeMapper.updateByPrimaryKeySelective(notice);
    }

    public void deleteById(Integer id) {
        noticeMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(LitemallNotice notice) {
        notice.setAddTime(LocalDateTime.now());
        notice.setUpdateTime(LocalDateTime.now());
        noticeMapper.insertSelective(notice);
    }

    public LitemallNotice findById(Integer id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    public void deleteByIds(List<Integer> ids) {
        LitemallNoticeExample example = new LitemallNoticeExample();
        example.or().andIdIn(ids).andDeletedEqualTo(false);
        LitemallNotice notice = new LitemallNotice();
        notice.setUpdateTime(LocalDateTime.now());
        notice.setDeleted(true);
        noticeMapper.updateByExampleSelective(notice, example);
    }
}
