package com.bst.impl;

import com.bst.dao.ForumInfoDao;
import com.bst.entity.ForumInfo;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by javon on 2017/9/17.
 */
@Repository
@Transactional
public class ForumInfoImp implements ForumInfoDao {
    private ForumInfo intro=null;
    private List<ForumInfo> list_Intro=null;
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    public Integer Insert(ForumInfo object) {
        try{
            this.getSession().merge(object);
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public Integer Update(ForumInfo object) {
        try{
            this.getSession().update(object);
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public Integer Delete(ForumInfo object) {
        try{
            this.getSession().delete(object);
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public ForumInfo SelectID(long id) {
        try{
            intro=(ForumInfo) this.getSession().get(ForumInfo.class, id);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return intro;
    }
    private Criteria getCriteria(List<Criterion>criterion, Session session){
        Criteria criteria=session.createCriteria(ForumInfo.class);
        for(Criterion criterions:criterion){
            criteria.add(criterions);
        }
        return criteria;
    }
    @SuppressWarnings("unchecked")
    public List<ForumInfo> SelectPAGE(List<Criterion> criterion, Integer PAGENOW) {
        Integer PAGESIZE=10;
        try{
            Criteria criteria=getCriteria(criterion, this.getSession());
            criteria.setFirstResult(PAGESIZE*(PAGENOW-1));
            criteria.setMaxResults(PAGESIZE);
            criteria.addOrder(Order.desc("time"));
            list_Intro=criteria.list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return list_Intro;
    }

    @SuppressWarnings("unchecked")
    public List<ForumInfo> SelectAll(List<Criterion> criterion) {
        try{
            Criteria criteria=getCriteria(criterion, this.getSession());
            criteria.addOrder(Order.desc("time"));
            list_Intro=criteria.list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return list_Intro;
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
    public ForumInfo SelectIntro(String mark) {
        return (ForumInfo) this.getSession().createQuery("from Intro where mark="+mark+"").uniqueResult();
    }
}
