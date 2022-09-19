package com.level.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.level.pojo.Province;
import com.level.service.ProvinceService;

public class ProvinceAction extends BaseAction implements Serializable {

    /**
     * 序列化.
     */
    private static final long serialVersionUID = 1L;

    private Province province;
    private ProvinceService provinceService;

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public ProvinceService getProvinceService() {
        return provinceService;
    }

    public void setProvinceService(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    /**
     * 获取province.
     */
    public void getProvinceByData() {
        HttpServletResponse response = getResponse();
        response.setContentType("text/json,charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Cache-Control", "no-cache");
        try {
        JSONArray jsonArray = new JSONArray();
        List<Province> provinceList = provinceService.getProvinceBySql();
        jsonArray = JSONArray.fromObject(provinceList); 
            PrintWriter out = response.getWriter();
            out.print(jsonArray.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
