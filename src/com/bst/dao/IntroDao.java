package com.bst.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.bst.entity.Intro;
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
public interface IntroDao {
	public Integer Insert(Intro object);
	
	public Integer Update(Intro object);
	
	public Integer Delete(Intro object);
	
	public Intro SelectID(long id);
	
	public Intro SelectIntro(String mark);
	
	public List<Intro> SelectPAGE(List<Criterion> criterion, Integer PAGENOW);
	
	public List<Intro> SelectAll(List<Criterion> criterion);
	
	public Integer getCountPAGE(List<Criterion> criterion);

}
