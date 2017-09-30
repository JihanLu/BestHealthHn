package com.bst.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.bst.entity.User;
/**
 * 类名：用户
 * @author By：
 * @param Insert 添加
 * @param Update 修改
 * @param Delete 删除
 * @param SelectID 查询ID
 * @param SelectPAGE 查询全部并分页
 * @param SelectAll 查询全部
 * @param getCountPAGE 查询总页数
 * @param SelectUID 用户登陆查询
 */
public interface UserDao {
	public long Insert(User object);
	
	public Integer Update(User object);
	
	public Integer Delete(User object);
	
	public User SelectID(long id);
	
	public List<User> SelectPAGE(List<Criterion> criterion, Integer PAGENOW);
	
	public List<User> SelectAll(List<Criterion> criterion);
	
	public Integer getCountPAGE(List<Criterion> criterion);
	
	public User SelectUID(List<Criterion> criterion);
	
	public List<User> selectlist();
}
