/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cas10.domain;

import java.util.List;
import java.util.Map;

/**
 *
 * @author kasten
 */
public interface CrudDAO<T> {
    T create(T entity);
    T retrieve(Long id);
    List<T> retrieveList(Map<String, Object> params, Integer offset, Integer limit);
    List<T> retrieveList(String namedQuery, Map<String, Object> params, Integer offset, Integer limit);
    T update(T entity);
    void delete(Long id);
    void delete(T entity);
}
