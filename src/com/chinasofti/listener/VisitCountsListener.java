package com.chinasofti.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.chinasofti.dao.CounterDao;
import com.chinasofti.service.CounterService;
public class VisitCountsListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("-------监听器关闭-------");
		Integer attribute = (Integer) arg0.getServletContext().getAttribute("counts");
		if (new CounterService().update(attribute) == 1) {
			new CounterDao().upadate(attribute);
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("---------监听器启动----------");
		Integer select = new CounterService().select();
		if (select==1) {
			arg0.getServletContext().setAttribute("counts", new CounterDao().select());
		}
	}


    
	
}
