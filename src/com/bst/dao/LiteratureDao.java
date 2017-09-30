package com.bst.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.bst.entity.Literature;
/**
 * 类名：文献发布
 * @author By：
 * @param Insert 添加
 * @param Update 修改
 * @param Delete 删除
 * @param SelectID 查询ID
 * @param SelectPAGE 查询全部并分页
 * @param SelectAll 查询全部
 * @param getCountPAGE 查询总页数
 */
public interface LiteratureDao {
	public Integer Insert(Literature object);
	
	public Integer Update(Literature object);
	
	public Integer Delete(Literature object);
	
	public Literature SelectID(long id);
	
	public Integer Delete(long id);
	
	public List<Literature> selectlist();
	
	public List<Literature> SelectPAGE(List<Criterion> criterion, Integer PAGENOW);
	
	public List<Literature> SelectPAGE1(List<Criterion> criterion, Integer PAGENOW);
	
	public List<Literature> SelectAll(List<Criterion> criterion);
	
	public Integer getCountPAGE(List<Criterion> criterion);
}
