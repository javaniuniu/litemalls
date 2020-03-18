package org.javaniuniu.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.javaniuniu.litemall.db.domain.LitemallAd;
import org.javaniuniu.litemall.db.domain.LitemallAdExample;

public interface LitemallAdMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_ad
     *
     * @mbg.generated
     */
    long countByExample(LitemallAdExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_ad
     *
     * @mbg.generated
     */
    int deleteByExample(LitemallAdExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_ad
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_ad
     *
     * @mbg.generated
     */
    int insert(LitemallAd record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_ad
     *
     * @mbg.generated
     */
    int insertSelective(LitemallAd record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_ad
     *
     * @mbg.generated
     */
    LitemallAd selectOneByExample(LitemallAdExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_ad
     *
     * @mbg.generated
     */
    LitemallAd selectOneByExampleSelective(@Param("example") LitemallAdExample example, @Param("selective") LitemallAd.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_ad
     *
     * @mbg.generated
     */
    List<LitemallAd> selectByExampleSelective(@Param("example") LitemallAdExample example, @Param("selective") LitemallAd.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_ad
     *
     * @mbg.generated
     */
    List<LitemallAd> selectByExample(LitemallAdExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_ad
     *
     * @mbg.generated
     */
    LitemallAd selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallAd.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_ad
     *
     * @mbg.generated
     */
    LitemallAd selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_ad
     *
     * @mbg.generated
     */
    LitemallAd selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_ad
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LitemallAd record, @Param("example") LitemallAdExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_ad
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LitemallAd record, @Param("example") LitemallAdExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_ad
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LitemallAd record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_ad
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LitemallAd record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_ad
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LitemallAdExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_ad
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}