package com.level.service;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author Administrator
 * 
 */
public class BaseService implements Serializable{
    /**.
     * 序列化.
     */
    private static final long serialVersionUID = 6564597827875093927L;
  
    private SessionFactory factory = null;

    /**
     * @return factory
     */
    public SessionFactory getFactory() {
        return factory;
    }

    /**
     * @param factory
     *            factory
     */
    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    /**
     * 保存.
     * 
     * @param object
     *            object
     */
    public void save(Object object) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    /**
     * 编辑.
     * 
     * @param object
     *            object
     * @return object
     */
    public Object merge(Object object) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.merge(object);
        session.getTransaction().commit();
        return object;
    }

    /**
     * 查询.
     * 
     * @param sql
     *            sql
     * @return list
     */
    public List getSqlList(String sql) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Object> list = null;
        list = session.createQuery(sql).list();
        session.getTransaction().commit();
        return list;
    }

    /**
     * 根据id获取一个Object.
     * 
     * @param clazz
     *            clazz
     * @param id
     *            id
     * @return Object
     */
    public Object get(Class<Object> clazz, Serializable id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Object obj = session.get(clazz, id);
        session.getTransaction().commit();
        return obj;
    }

    /**
     * 删除Object.
     * 
     * @param obj
     *            obj
     */
    public void remove(Object obj) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.delete(obj);
        session.getTransaction().commit();

    }

    /**
     * 执行sql.
     * 
     * @param sql
     *            sql
     * @return int
     */
    public int executeUpdate(String sql) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        int rs = session.createQuery(sql).executeUpdate();
        session.getTransaction().commit();
        return rs;
    }
}
