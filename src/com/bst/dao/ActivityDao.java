package com.bst.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.bst.entity.Activity;
/**
 * 类名：活动安排
 * @author By：
 * @param Insert 添加
 * @param Update 修改
 * @param Delete 删除
 * @param SelectID 查询ID
 * @param SelectPAGE 查询全部并分页
 * @param SelectAll 查询全部
 * @param getCountPAGE 查询总页数
 */
public interface ActivityDao {
	public List<Activity> selectlist();
	
	public Integer Insert(Activity object);
	
	public Integer Update(Activity object);
	
	public Integer Delete(long id);
	
	public Activity SelectID(long id);
	
	public List<Activity> SelectPAGE(List<Criterion> criterion, Integer PAGENOW);
	
	public List<Activity> SelectAll(List<Criterion> criterion);
	
	public Integer getCountPAGE(List<Criterion> criterion);
}
