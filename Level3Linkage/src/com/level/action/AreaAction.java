package com.level.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.level.pojo.Area;
import com.level.service.AreaService;

public class AreaAction extends BaseAction implements Serializable {

    /**
     * 序列化.
     */
    private static final long serialVersionUID = 1L;

    private Area area;
    private AreaService areaService;

    
    public Area getArea() {
        return area;
    }


    public void setArea(Area area) {
        this.area = area;
    }


    public AreaService getAreaService() {
        return areaService;
    }


    public void setAreaService(AreaService areaService) {
        this.areaService = areaService;
    }


    /**
     * 根据ID获取Area.
     */
    public void getAreaByData() {
        HttpServletResponse response = getResponse();
        response.setContentType("text/json,charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Cache-Control", "no-cache");
        int id = Integer.parseInt(getRequest().getParameter("id"));
        try {
        JSONArray jsonArray = new JSONArray();
        List<Area> cityList = areaService.getAreaBySql(id);
        jsonArray = JSONArray.fromObject(cityList); 
            PrintWriter out = response.getWriter();
            out.print(jsonArray.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
