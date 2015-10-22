/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cas10.domain.security.impl;

import br.com.cas10.domain.BaseCrudDAO;
import br.com.cas10.domain.security.Role;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kasten
 */
@Component
@Transactional
public class RoleDAO extends BaseCrudDAO<Role> {

    public RoleDAO() {
        super(Role.class);
    }

    @PersistenceContext
    @Override
    public void setEm(EntityManager em) {
        super.setEm(em);
    }

}
