package com.level.pojo;

/**
 * 区.
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Administrator
 * 
 */
@Entity
@Table(name = "area")
public class Area implements Serializable {
    /**
     * 序列化.
     */
    private static final long serialVersionUID = 5497493280874781486L;
    /**
     *id.
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * areaId.
     */
    @Column
    private String areaID;
    /**
     * 市.
     */
    @Column
    private String parent;
    /**
     *区名.
     */
    @Column
    private String area;
    
    public String getAreaID() {
        return areaID;
    }
    public void setAreaID(String areaID) {
        this.areaID = areaID;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getParent() {
        return parent;
    }
    public void setParent(String parent) {
        this.parent = parent;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
}
