package com.level.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


public class BaseAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    /**
     * @author Administrator.
     * @return ServletActionContext.
     * */
    protected HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    /**
     *@return ServletActionContext.
     */
    protected HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }

    /**
     *@return Request.
     */
    protected HttpSession getSession() {
        return getRequest().getSession();
    }
}
