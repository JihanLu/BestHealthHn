package com.bst.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.bst.entity.Topic;
/**
 * 类名：帖子管理
 * @author By：
 * @param Insert 添加
 * @param Update 修改
 * @param Delete 删除
 * @param SelectID 查询ID
 * @param SelectPAGE 查询全部并分页
 * @param SelectAll 查询全部
 * @param getCountPAGE 查询总页数
 */
public interface TopicDao {
	public Integer Insert(Topic object);
	
	public Integer Update(Topic object);
	
	public Integer Delete(Topic object);
	
	public Topic SelectID(long id);
	
	public List<Topic> SelectPAGE(List<Criterion> criterion, Integer PAGENOW);
	
	public List<Topic> SelectAll(List<Criterion> criterion);
	
	public Integer getCountPAGE(List<Criterion> criterion);
}
