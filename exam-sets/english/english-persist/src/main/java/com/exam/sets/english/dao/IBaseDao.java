package com.exam.sets.english.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<M> {
    
	public Serializable save(M model);

    public void saveOrUpdate(M model);
    
    public void update(M model);
    
    public void merge(M model);

    public void delete(Serializable id);

    public void deleteObject(M model);

    public M get(Serializable id);
    
    public int countAll();

    public List<M> listAll();

    public List<M> listAll(int pn, int pageSize);
    
    public List<M> pre(Serializable id, int pn, int pageSize);
    
    public List<M> next(Serializable id, int pn, int pageSize);
    
    public boolean exists(Serializable id);
    
    public void flush();
    
    public void clear();
}
