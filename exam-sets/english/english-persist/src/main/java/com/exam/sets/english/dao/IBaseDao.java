package com.exam.sets.english.dao;

import java.util.List;

public interface IBaseDao<M> {
    
	public String save(M model);

    public void saveOrUpdate(M model);
    
    public void update(M model);
    
    public void merge(M model);

    public void delete(String id);

    public void deleteObject(M model);

    public M get(String id);
    
    public int countAll();

    public List<M> listAll();

    public List<M> listAll(int pn, int pageSize);
    
    public List<M> pre(String id, int pn, int pageSize);
    
    public List<M> next(String pk, int pn, int pageSize);
    
    public boolean exists(String id);
    
    public void flush();
    
    public void clear();
}
