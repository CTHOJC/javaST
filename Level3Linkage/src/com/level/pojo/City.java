package com.level.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 市.
 */
@Entity
@Table(name = "city")
public class City implements Serializable {
    /**
     * 序列化.
     */
    private static final long serialVersionUID = -2305897463846946655L;

    /**
     * id.
     */
    @Id
    @GeneratedValue
    private Integer id;
    
    /**
     * CityId.
     */
    @Column
    private String cityID;
    /**
     * 省.
     */
    @Column
    private String parent;

    /**
     *名. 
     */
    @Column
    private String city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
  
}
