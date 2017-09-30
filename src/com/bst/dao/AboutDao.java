package com.bst.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.bst.entity.About;
/**
 * 类名：关于我们
 * @author By：
 * @param Insert 添加
 * @param Update 修改
 * @param Delete 删除
 * @param SelectID 查询ID
 * @param SelectPAGE 查询全部并分页
 * @param SelectAll 查询全部
 * @param getCountPAGE 查询总页数
 */
public interface AboutDao {
	public Integer Insert(About object);
	
	public Integer Update(About object);
	
	public  About SelectID(long id);
	
	public  About SelectAbout();
	
	public List<About> SelectAll(List<Criterion> criterion);

}
