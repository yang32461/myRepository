package com.qst.Util;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class CountListener implements HttpSessionListener {
	 int num=0;

    
    public CountListener() {
        // TODO Auto-generated constructor stub
    }

    public void sessionCreated(HttpSessionEvent event)  { 
    	
    	 
       	HttpSession session=event.getSession();
        
           num++;
           session.getServletContext().setAttribute("num", num);
    }


    public void sessionDestroyed(HttpSessionEvent event)  { 
    	 HttpSession session=event.getSession();
         num--;
         session.getServletContext().setAttribute("num", num);
        
    }
	
}
