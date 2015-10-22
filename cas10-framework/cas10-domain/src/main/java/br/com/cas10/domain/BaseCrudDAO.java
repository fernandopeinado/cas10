/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cas10.domain;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author kasten
 */
public abstract class BaseCrudDAO<T> implements CrudDAO<T> {

    protected Class<T> clazz;
    protected EntityManager em;

    public BaseCrudDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public T create(T entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public T retrieve(Long id) {
        return em.find(clazz, id);
    }

    @Override
    public List<T> retrieveList(Map<String, Object> params, Integer offset, Integer limit) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(clazz);
        Root<T> entity = criteria.from(clazz);
        criteria.select(entity);
        if (params != null) {
            for (Entry<String, Object> param : params.entrySet()) {
                if (!param.getKey().startsWith("@")) {
                    //TODO:
                }
            }
        }
        TypedQuery<T> query = em.createQuery(criteria);
        if (limit != null) {
            query.setMaxResults(limit);
        }
        if (offset != null) {
            query.setFirstResult(offset);
        }
        return query.getResultList();
    }

    @Override
    public List<T> retrieveList(String namedQuery, Map<String, Object> params, Integer offset, Integer limit) {
        TypedQuery<T> query = em.createNamedQuery(namedQuery, clazz);
        if (params != null) {
            for (Map.Entry<String, Object> param : params.entrySet()) {
                query.setParameter(param.getKey(), param.getValue());
            }
        }
        if (limit != null) {
            query.setMaxResults(limit);
        }
        if (offset != null) {
            query.setFirstResult(offset);
        }
        return query.getResultList();
    }

    @Override
    public T update(T entity) {
        return em.merge(entity);
    }

    @Override
    public void delete(Long id) {
        T entity = em.find(clazz, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    @Override
    public void delete(T entity) {
        em.remove(entity);
    }

}
