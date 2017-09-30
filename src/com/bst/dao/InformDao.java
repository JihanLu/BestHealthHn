package com.bst.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.bst.entity.Inform;
/**
 * 类名：研究院简介
 * @author By：
 * @param Insert 添加
 * @param Update 修改
 * @param Delete 删除
 * @param SelectID 查询ID
 * @param SelectPAGE 查询全部并分页
 * @param SelectAll 查询全部
 * @param getCountPAGE 查询总页数
 */
public interface InformDao {
	public Integer Insert(Inform object);
	
	public Integer Update(Inform object);
	
	public Integer Delete(Inform object);
	
	public Inform SelectID(long id);
	
	public Integer Delete(long id);
	
	public List<Inform> SelectPAGE(List<Criterion> criterion, Integer PAGENOW);
	
	public List<Inform> SelectAll(List<Criterion> criterion);
	
	public Integer getCountPAGE(List<Criterion> criterion);
	
	public List<Inform> selectlist();

}
