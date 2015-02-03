package com.exam.sets.english.persist.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.exam.sets.english.persist.dao.IBaseDao;

@Repository
public class BaseDaoImpl<M> implements IBaseDao<M> {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;
    
	public Session getSession() {
        //事务必须是开启的(Required)，否则获取不到
        return sessionFactory.getCurrentSession();
    }
    
	public Serializable save(M model) {
		return getSession().save(model);
	}

	public void saveOrUpdate(M model) {
		getSession().saveOrUpdate(model);
	}

	public void update(M model) {
		getSession().update(model);
	}

	public void merge(M model) {
		getSession().merge(model);
	}

	public void delete(Serializable id) {
		getSession().delete(id);
	}

	public void deleteObject(M model) {
		getSession().delete(model);
	}

	public M get(Serializable id) {
		//return getSession().get(clazz, id);
		return null;
	}

	public int countAll() {
		return 0;
	}

	public List<M> listAll() {
		return null;
	}

	public List<M> listAll(int pn, int pageSize) {
		return null;
	}

	public List<M> pre(Serializable pk, int pn, int pageSize) {
		return null;
	}

	public List<M> next(Serializable pk, int pn, int pageSize) {
		return null;
	}

	public boolean exists(Serializable id) {
		return false;
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

}
