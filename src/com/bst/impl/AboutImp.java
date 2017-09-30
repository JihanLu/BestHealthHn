package com.bst.impl;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bst.dao.AboutDao;
import com.bst.entity.About;
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
@Repository
@Transactional
public class AboutImp implements AboutDao {
	private List<About> list_About=null;
	private  About intro=null;
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public Integer Insert( About object) {
		try{
			this.getSession().merge(object);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public Integer Update( About object) {
		try{
			this.getSession().update(object);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public Integer Delete( About object) {
		try{
			this.getSession().delete(object);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public About SelectID(long id) {
		try{
			intro=(About) this.getSession().get( About.class, id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return intro;
	}
	@Override
	public About SelectAbout() {
		return (About) this.getSession().createQuery("from About").uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public List<About> SelectAll(List<Criterion> criterion) {
		try{
			Criteria criteria=getCriteria(criterion, this.getSession());
			criteria.addOrder(Order.desc("time"));
			list_About=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return list_About;
	}
	private Criteria getCriteria(List<Criterion>criterion,Session session){
		Criteria criteria=session.createCriteria(About.class);
		for(Criterion criterions:criterion){
			criteria.add(criterions);
		}
		return criteria;
	}
}
