package com.bst.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.bst.entity.ReplyTow;
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
public interface ReplyTowDao {
	public Integer Insert(ReplyTow object);
	
	public Integer Update(ReplyTow object);
	
	public Integer Delete(ReplyTow object);
	
	public ReplyTow SelectID(long id);
	
	public List<ReplyTow> SelectPAGE(List<Criterion> criterion, Integer PAGENOW);
	
	public List<ReplyTow> SelectAll(List<Criterion> criterion);
	
	public Integer getCountPAGE(List<Criterion> criterion);
}
