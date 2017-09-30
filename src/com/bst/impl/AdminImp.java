package com.bst.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bst.dao.AdminDao;
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
@Repository
@Transactional
public class AdminImp implements AdminDao {
	private Admin admin=null;
	private List<Admin> list_Admin=null;
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public Integer Insert(Admin object) {
		try{
			this.getSession().merge(object);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public Integer Update(Admin object) {
		try{
			this.getSession().update(object);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public Integer Delete(Admin object) {
		try{
			this.getSession().delete(object);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public Admin SelectID(long id) {
		try{
			admin=(Admin) this.getSession().get(Admin.class, id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return admin;
	}
	private Criteria getCriteria(List<Criterion>criterion,Session session){
		Criteria criteria=session.createCriteria(Admin.class);
		for(Criterion criterions:criterion){
			criteria.add(criterions);
		}
		return criteria;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> SelectPAGE(List<Criterion> criterion, Integer PAGENOW) {
		Integer PAGESIZE=10;
		try{
			Criteria criteria=getCriteria(criterion, this.getSession());
			criteria.setFirstResult(PAGESIZE*(PAGENOW-1));
			criteria.setMaxResults(PAGESIZE);
			criteria.addOrder(Order.desc("time"));
			list_Admin=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return list_Admin;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> SelectAll(List<Criterion> criterion) {
		try{
			Criteria criteria=getCriteria(criterion, this.getSession());
			criteria.addOrder(Order.desc("time"));
			list_Admin=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return list_Admin;
	}

	@Override
	public Integer getCountPAGE(List<Criterion> criterion) {
		int RowCount=0;
		try{
			Criteria criteria=getCriteria(criterion, this.getSession());
			Number PageNumber=(Number) criteria.setProjection(Projections.rowCount()).uniqueResult();
			RowCount=PageNumber.intValue();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return RowCount;
	}

	@Override
	public Admin SelectUID(List<Criterion> criterion) {
		Criteria criteria=getCriteria(criterion, this.getSession());
		return (Admin) criteria.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> selecilist() {
		Query query=this.getSession().createQuery("from Admin order by time desc");
		return query.list();
	}

}