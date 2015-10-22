/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cas10.domain.security;

import br.com.cas10.domain.Identified;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author kasten
 */
@Entity
@Table(name = "c10_role")
public class Role implements Identified {
    @Id
    @GeneratedValue(generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "c10_security_seq", allocationSize = 1)
    private Long id;
    @Column(length = 200)
    private String name;
    @Column(name = "rolegroup", length = 200)
    private String group;
    @Column(length = 1000)
    private String description;
    @Column(length = 2000)
    private String help;

    public Role() {
    }

    public Role(String name, String group, String description, String help) {
        this.name = name;
        this.group = group;
        this.description = description;
        this.help = help;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Role other = (Role) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.description;
    }
    
}
