package com.bst.dao;

/**
 * Created by javon on 2017/9/17.
 */
import java.util.List;

import org.hibernate.criterion.Criterion;

import com.bst.entity.ForumInfo;

/**
 * 类名：论坛简介
 * @author By：
 * @param Insert 添加
 * @param Update 修改
 * @param Delete 删除
 * @param SelectID 查询ID
 * @param SelectPAGE 查询全部并分页
 * @param SelectAll 查询全部
 * @param getCountPAGE 查询总页数
 */
public interface ForumInfoDao {
    public Integer Insert(ForumInfo object);

    public Integer Update(ForumInfo object);

    public Integer Delete(ForumInfo object);

    public ForumInfo SelectID(long id);

    public ForumInfo SelectIntro(String mark);

    public List<ForumInfo> SelectPAGE(List<Criterion> criterion, Integer PAGENOW);

    public List<ForumInfo> SelectAll(List<Criterion> criterion);

    public Integer getCountPAGE(List<Criterion> criterion);
}
