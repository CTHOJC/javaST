package com.level.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.level.pojo.City;
import com.level.pojo.Province;
import com.level.service.CityService;
import com.level.service.ProvinceService;

public class CityAction extends BaseAction implements Serializable {

    /**
     * 序列化.
     */
    private static final long serialVersionUID = 1L;

    private City city;
    private CityService cityService;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public CityService getCityService() {
        return cityService;
    }

    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }




    /**
     * 根据ID获取City.
     */
    public void getCityByData() {
        HttpServletResponse response = getResponse();
        response.setContentType("text/json,charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Cache-Control", "no-cache");
        int id = Integer.parseInt(getRequest().getParameter("id"));
        try {
        JSONArray jsonArray = new JSONArray();
        List<City> cityList = cityService.getCityBySql(id);
        jsonArray = JSONArray.fromObject(cityList); 
            PrintWriter out = response.getWriter();
            out.print(jsonArray.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
