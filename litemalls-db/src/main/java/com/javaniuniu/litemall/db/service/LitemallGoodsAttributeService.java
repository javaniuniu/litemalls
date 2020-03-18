package com.javaniuniu.litemall.db.service;

import com.javaniuniu.litemall.db.dao.LitemallGoodsAttributeMapper;
import com.javaniuniu.litemall.db.domain.LitemallGoodsAttribute;
import com.javaniuniu.litemall.db.domain.LitemallGoodsAttributeExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 商品参数
 *
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/javaniuniu
 * @Date: 2020/3/18 10:26 PM
 */
@Service
public class LitemallGoodsAttributeService {
    @Resource
    private LitemallGoodsAttributeMapper goodsAttributeMapper;

    public List<LitemallGoodsAttribute> queryByGid(Integer goodsId) {
        LitemallGoodsAttributeExample example = new LitemallGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return goodsAttributeMapper.selectByExample(example);
    }

    public void add(LitemallGoodsAttribute goodsAttribute) {
        goodsAttribute.setAddTime(LocalDateTime.now());
        goodsAttribute.setUpdateTime(LocalDateTime.now());
        goodsAttributeMapper.insertSelective(goodsAttribute);
    }

    public LitemallGoodsAttribute findById(Integer id) {
        return goodsAttributeMapper.selectByPrimaryKey(id);
    }

    public void deleteByGid(Integer gid) {
        LitemallGoodsAttributeExample example = new LitemallGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(gid);
        goodsAttributeMapper.logicalDeleteByExample(example);
    }

    public void deleteById(Integer id) {
        goodsAttributeMapper.logicalDeleteByPrimaryKey(id);
    }

    public void updateById(LitemallGoodsAttribute attribute) {
        attribute.setUpdateTime(LocalDateTime.now());
        goodsAttributeMapper.updateByPrimaryKeySelective(attribute);
    }
}
