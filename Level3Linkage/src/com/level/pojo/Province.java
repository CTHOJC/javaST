package com.level.pojo;

/**
 * 省.
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Administrator.
 * 
 */
@Entity
@Table(name = "province")
public class Province implements Serializable {
    /**
     * 序列化.
     */
    private static final long serialVersionUID = 5318855726291540197L;
    /**
     *ID. 
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * privinceId.
     */
    @Column
    private String provinceID;
    /**
     *名. 
     */
    @Column
    private String province;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getProvinceID() {
        return provinceID;
    }
    public void setProvinceID(String provinceID) {
        this.provinceID = provinceID;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    
}
