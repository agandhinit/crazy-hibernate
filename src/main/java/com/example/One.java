package com.example;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

@Entity
public class One implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 4925692605792436248L;
    @Id
    @GeneratedValue
    private Long oneKey;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumns({@JoinColumn(name = "oneKey", referencedColumnName = "oneKey", insertable = false, updatable = false) })
    @Where(clause = "status = 'NEW'")
    private Set<Many> many;

    public Long getOneKey() {
        return oneKey;
    }

    public void setOneKey(Long oneKey) {
        this.oneKey = oneKey;
    }

    public Set<Many> getMany() {
        return many;
    }

    public void setMany(Set<Many> many) {
        this.many = many;
    }
    
}
