package com.example;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Many implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = -3868730111052741574L;
   
    private Long oneKey;
    @Id
    private Long manyKey;
    private String status;
    
    public Long getOneKey() {
        return oneKey;
    }
    public void setOneKey(Long oneKey) {
        this.oneKey = oneKey;
    }
    public Long getManyKey() {
        return manyKey;
    }
    public void setManyKey(Long manyKey) {
        this.manyKey = manyKey;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
