package com.level.service;

import java.io.Serializable;
import java.util.List;

import com.level.pojo.Area;

public class AreaService implements Serializable {

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
     *  根据ID获取Area.
     */
    public List<Area> getAreaBySql(int id){
        String sql = "From Area where parent = '"+ id +"'";
        List<Area> areaList = baseService.getSqlList(sql);
        return areaList;
    }
}
