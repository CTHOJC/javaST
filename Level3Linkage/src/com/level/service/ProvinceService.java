package com.level.service;

import java.io.Serializable;
import java.util.List;

import com.level.pojo.Province;

public class ProvinceService implements Serializable {

    /**
     * 序列化.
     */
    private static final long serialVersionUID = 1L;
    
    private BaseService baseService;
    
    public BaseService getBaseService() {
        return baseService;
    }
    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }
    

    /**
     * 获取province.
     */
    public List<Province> getProvinceBySql(){
        String sql = "From Province";
        List<Province> provinceList = baseService.getSqlList(sql);
        return provinceList;
    }
}
