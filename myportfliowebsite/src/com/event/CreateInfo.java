package com.event;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.dao.Create;

@WebListener
public class CreateInfo implements ServletContextListener {

    public CreateInfo() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
         Create.distroy();
    }


    public void contextInitialized(ServletContextEvent sce)  { 
       boolean createDatabase = Create.createDatabase();
       System.out.println(createDatabase+"&&&&&&");
       if (createDatabase==false) {
		System.out.println("database created");
		boolean createTable = Create.createTable();
		if (createTable==false) {
			System.out.println("Table Created");
		}
       }
    
    
    }
	
}
