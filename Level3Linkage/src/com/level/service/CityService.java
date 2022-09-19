package com.level.service;

import java.io.Serializable;
import java.util.List;

import com.level.pojo.City;

public class CityService implements Serializable {

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
     *  根据ID获取City.
     */
    public List<City> getCityBySql(int id){
        String sql = "From City where parent = '"+ id +"'";
        List<City> cityList = baseService.getSqlList(sql);
        return cityList;
    }
}
