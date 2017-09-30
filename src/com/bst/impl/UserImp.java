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

import com.bst.dao.UserDao;
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
@Repository
@Transactional
public class UserImp implements UserDao {
	private User user=null;
	private List<User> list_User=null;
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public long Insert(User object) {
		long i=0;
		try{
			i=(long) this.getSession().save(object);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return i;
	}

	public Integer Update(User object) {
		try{
			this.getSession().update(object);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public Integer Delete(User object) {
		try{
			this.getSession().delete(object);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public User SelectID(long id) {
		try{
			user=(User) this.getSession().get(User.class, id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return user;
	}
	private Criteria getCriteria(List<Criterion>criterion,Session session){
		Criteria criteria=session.createCriteria(User.class);
		for(Criterion criterions:criterion){
			criteria.add(criterions);
		}
		return criteria;
	}
	@SuppressWarnings("unchecked")
	public List<User> SelectPAGE(List<Criterion> criterion, Integer PAGENOW) {
		Integer PAGESIZE=10;
		try{
			Criteria criteria=getCriteria(criterion, this.getSession());
			criteria.setFirstResult(PAGESIZE*(PAGENOW-1));
			criteria.setMaxResults(PAGESIZE);
			criteria.addOrder(Order.desc("time"));
			list_User=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return list_User;
	}

	@SuppressWarnings("unchecked")
	public List<User> SelectAll(List<Criterion> criterion) {
		try{
			Criteria criteria=getCriteria(criterion, this.getSession());
			criteria.addOrder(Order.desc("time"));
			list_User=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return list_User;
	}

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
	public User SelectUID(List<Criterion> criterion) {
		Criteria criteria=getCriteria(criterion, this.getSession());
		return (User) criteria.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectlist() {
		Query query=this.getSession().createQuery("from User order by time desc");
		return query.list();
	}
}
