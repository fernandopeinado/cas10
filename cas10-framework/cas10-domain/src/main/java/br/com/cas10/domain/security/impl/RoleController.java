/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cas10.domain.security.impl;

import br.com.cas10.domain.security.Role;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kasten
 */
@RestController
@RequestMapping(path = "/security/roles")
public class RoleController {

    @Autowired
    private RoleDAO dao;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity retrive(@PathVariable Long id) {
        Role role = dao.retrieve(id);
        if (role == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(role);
    }

    @RequestMapping(path =  "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        dao.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Long create(@RequestBody Role role) {
        Role newRole = dao.create(role);
        return newRole.getId();
    }

    @RequestMapping(path =  "/{id}", method = RequestMethod.POST)
    public void update(@PathVariable Long id, @RequestBody Role role) {
        Role updatedRole = dao.update(role);
    }

    @RequestMapping(path =  "/query/{size}/{offset}", method = RequestMethod.GET)
    public List<Role> query(@PathVariable int size, @PathVariable int offset) {
        return dao.retrieveList(null, size, offset);
    }

    @RequestMapping(path =  "/query/{size}/{offset}", method = RequestMethod.POST)
    public List<Role> query(@PathVariable int size, @PathVariable int offset, @RequestBody Map<String, Object> params) {
        return dao.retrieveList(params, size, offset);
    }
}
