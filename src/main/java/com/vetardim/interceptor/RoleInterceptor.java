package com.vetardim.interceptor;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.vetardim.DAO.RoleDao;
import com.vetardim.DAO.UserDao;
import com.vetardim.model.Role;
import com.vetardim.model.User;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class RoleInterceptor extends AbstractInterceptor {
    private List<String> allowedRoles = new ArrayList<String>();
    private List<String> disallowedRoles = new ArrayList<String>();

    public void setAllowedRoles(String roles) {
        this.allowedRoles = stringToList(roles);
    }

    public void setDisallowedRoles(String roles) {
        this.disallowedRoles = stringToList(roles);
    }

    public String intercept(ActionInvocation invocation) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String result = null;
        if (!isAllowed(request, invocation.getAction())) {
            response.sendRedirect("/");
            //result = handleRejection(invocation, response);
        } else {
            result = invocation.invoke();
        }
        return result;
    }

    protected List<String> stringToList(String val) {
        if (val != null) {
            String[] list = val.split("[ ]*,[ ]*");
            return Arrays.asList(list);
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    protected boolean isAllowed(HttpServletRequest request, Object action) throws Exception {
        HttpSession session=request.getSession(false);
        boolean result = false;
        boolean accept =false;
        String loginRole = null;
        if (session.getAttribute("login")!=null) {
            String Username = (String) session.getAttribute("login");
            for (User listElement : UserDao.getUsersList()) {
                if (Username.equals(listElement.getNickname())) {
                    for (Role role : RoleDao.getRolesList()) {
                        if (listElement.getRoleId() == role.getId()) {
                            accept = true;
                            session.setAttribute("role", role.getName());
                        }
                    }

                }

            }
            if (!accept) {
                session.invalidate();
                return false;
            }
        }
        if(session!=null){
            loginRole=(String)session.getAttribute("role");
        }

        if (allowedRoles.size() > 0) {
            if(session==null || loginRole==null){
                return result;
            }
            for (String role : allowedRoles) {
                if (role.equalsIgnoreCase(loginRole)) {
                    result = true;
                }
            }
            return result;
        } else if (disallowedRoles.size() > 0) {
            if(session!=null || loginRole!=null){
                for (String role : disallowedRoles) {
                    if (role.equalsIgnoreCase(loginRole)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    protected String handleRejection(ActionInvocation invocation,
                                     HttpServletResponse response) throws Exception {
        response.sendRedirect("/");
        return "invalidAdminAccess";
    }

}