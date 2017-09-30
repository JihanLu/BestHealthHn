package com.bst.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.bst.entity.News;
/**
 * 类名：资讯新闻
 * @author By：
 * @param Insert 添加
 * @param Update 修改
 * @param Delete 删除
 * @param SelectID 查询ID
 * @param SelectPAGE 查询全部并分页
 * @param SelectAll 查询全部
 * @param getCountPAGE 查询总页数
 */
public interface NewsDao {
	public Integer Insert(News object);
	
	public Integer Update(News object);
	
	public Integer Delete(News object);
	
	public News SelectID(long id);
	
	public List<News> SelectPAGE(List<Criterion> criterion, Integer PAGENOW);
	
	public List<News> SelectAll(List<Criterion> criterion);
	
	public Integer getCountPAGE(List<Criterion> criterion);
	
	public Integer Delete(long id);
	
	public List<News> selectlist();
}
