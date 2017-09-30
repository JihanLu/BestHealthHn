package com.bst.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.bst.entity.Admin;
/**
 * 类名：管理员
 * @author By：
 * @param Insert 添加
 * @param Update 修改
 * @param Delete 删除
 * @param SelectID 查询ID
 * @param SelectPAGE 查询全部并分页
 * @param SelectAll 查询全部
 * @param getCountPAGE 查询总页数
 * @param SelectUID 管理员登陆查询
 */
public interface AdminDao {
	public Integer Insert(Admin object);
	
	public Integer Update(Admin object);
	
	public Integer Delete(Admin object);
	
	public Admin SelectID(long id);
	
	public List<Admin> SelectPAGE(List<Criterion> criterion, Integer PAGENOW);
	
	public List<Admin> SelectAll(List<Criterion> criterion);
	
	public Integer getCountPAGE(List<Criterion> criterion);
	
	public Admin SelectUID(List<Criterion> criterion);
	
	public List<Admin> selecilist();
}
