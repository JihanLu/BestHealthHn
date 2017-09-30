package com.bst.impl;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bst.dao.ReplyOneDao;
import com.bst.entity.ReplyOne;
/**
 * 类名：1级回复管理
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
public class ReplyOneImp implements ReplyOneDao {
	private ReplyOne replyOne=null;
	private List<ReplyOne> list_ReplyOne=null;
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public Integer Insert(ReplyOne object) {
		try{
			this.getSession().merge(object);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public Integer Update(ReplyOne object) {
		try{
			this.getSession().update(object);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public Integer Delete(ReplyOne object) {
		try{
			this.getSession().delete(object);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public ReplyOne SelectID(long id) {
		try{
			replyOne=(ReplyOne) this.getSession().get(ReplyOne.class, id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return replyOne;
	}
	private Criteria getCriteria(List<Criterion>criterion,Session session){
		Criteria criteria=session.createCriteria(ReplyOne.class);
		for(Criterion criterions:criterion){
			criteria.add(criterions);
		}
		return criteria;
	}
	@SuppressWarnings("unchecked")
	public List<ReplyOne> SelectPAGE(List<Criterion> criterion, Integer PAGENOW) {
		Integer PAGESIZE=10;
		try{
			Criteria criteria=getCriteria(criterion, this.getSession());
			criteria.setFirstResult(PAGESIZE*(PAGENOW-1));
			criteria.setMaxResults(PAGESIZE);
			criteria.addOrder(Order.desc("replyTime"));
			list_ReplyOne=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return list_ReplyOne;
	}

	@SuppressWarnings("unchecked")
	public List<ReplyOne> SelectAll(List<Criterion> criterion) {
		try{
			Criteria criteria=getCriteria(criterion, this.getSession());
			criteria.addOrder(Order.asc("replyTime"));
			list_ReplyOne=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return list_ReplyOne;
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

}
