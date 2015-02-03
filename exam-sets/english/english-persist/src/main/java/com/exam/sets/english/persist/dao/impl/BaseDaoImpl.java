package com.exam.sets.english.persist.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.exam.sets.english.dao.IBaseDao;

public class BaseDaoImpl<M> implements IBaseDao<M> {
	
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public Session getSession() {
        //事务必须是开启的(Required)，否则获取不到
        return sessionFactory.getCurrentSession();
    }


	public String save(M model) {
		return getSession().save(model);
	}

	public void saveOrUpdate(M model) {
		// TODO Auto-generated method stub
		
	}

	public void update(M model) {
		getSession().update(model);
	}

	public void merge(M model) {
		// TODO Auto-generated method stub
		
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteObject(M model) {
		// TODO Auto-generated method stub
		
	}

	public M get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<M> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<M> listAll(int pn, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<M> pre(String id, int pn, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<M> next(String pk, int pn, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public void flush() {
		// TODO Auto-generated method stub
		
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
