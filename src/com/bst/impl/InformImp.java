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

import com.bst.dao.InformDao;
import com.bst.entity.Inform;
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
public class InformImp implements InformDao {
	private Inform inform=null;
	private List<Inform> list_Inform=null;
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public Integer Insert(Inform object) {
		try{
			this.getSession().merge(object);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public Integer Update(Inform object) {
		try{
			this.getSession().update(object);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public Integer Delete(Inform object) {
		try{
			this.getSession().delete(object);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public Inform SelectID(long id) {
		try{
			inform=(Inform) this.getSession().get(Inform.class, id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return inform;
	}
	private Criteria getCriteria(List<Criterion>criterion,Session session){
		Criteria criteria=session.createCriteria(Inform.class);
		for(Criterion criterions:criterion){
			criteria.add(criterions);
		}
		return criteria;
	}
	@SuppressWarnings("unchecked")
	public List<Inform> SelectPAGE(List<Criterion> criterion, Integer PAGENOW) {
		Integer PAGESIZE=10;
		try{
			Criteria criteria=getCriteria(criterion, this.getSession());
			criteria.setFirstResult(PAGESIZE*(PAGENOW-1));
			criteria.setMaxResults(PAGESIZE);
			criteria.addOrder(Order.desc("time"));
			list_Inform=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return list_Inform;
	}

	@SuppressWarnings("unchecked")
	public List<Inform> SelectAll(List<Criterion> criterion) {
		try{
			Criteria criteria=getCriteria(criterion, this.getSession());
			criteria.addOrder(Order.desc("time"));
			list_Inform=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return list_Inform;
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
	public Integer Delete(long id) {
		try{
			this.getSession().delete(SelectID(id));
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Inform> selectlist() {
		Query query=this.getSession().createQuery("from Inform order by time desc");
		return query.list();
	}

}
