package com.bst.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.bst.entity.Recommend;
/**
 * 类名：项目产品推荐
 * @author By：
 * @param Insert 添加
 * @param Update 修改
 * @param Delete 删除
 * @param SelectID 查询ID
 * @param SelectPAGE 查询全部并分页
 * @param SelectAll 查询全部
 * @param getCountPAGE 查询总页数
 */
public interface RecommendDao {
	public Integer Insert(Recommend object);
	
	public Integer Update(Recommend object);
	
	public Integer Delete(Recommend object);
	
	public Recommend SelectID(long id);
	
	public List<Recommend> SelectPAGE(List<Criterion> criterion, Integer PAGENOW);
	
	public List<Recommend> SelectPAGE1(List<Criterion> criterion, Integer PAGENOW);
	
	public List<Recommend> SelectAll(List<Criterion> criterion);
	
	public Integer getCountPAGE(List<Criterion> criterion);
	
	public List<Recommend> selectlist();
	
	public Integer Delete(long id);
}
