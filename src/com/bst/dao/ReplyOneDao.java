package com.bst.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.bst.entity.ReplyOne;
/**
 * 类名：1级回复管理
 * @author By：
 * @param Insert 添加
 * @param Update 修改
 * @param Delete 删除
 * @param SelectID 查询ID
 * @param SelectPAGE 查询全部并分页
 * @param SelectAll 查询全部
 * @param getCountPAGE 查询总页数
 */
public interface ReplyOneDao {
	public Integer Insert(ReplyOne object);
	
	public Integer Update(ReplyOne object);
	
	public Integer Delete(ReplyOne object);
	
	public ReplyOne SelectID(long id);
	
	public List<ReplyOne> SelectPAGE(List<Criterion> criterion, Integer PAGENOW);
	
	public List<ReplyOne> SelectAll(List<Criterion> criterion);
	
	public Integer getCountPAGE(List<Criterion> criterion);
}
