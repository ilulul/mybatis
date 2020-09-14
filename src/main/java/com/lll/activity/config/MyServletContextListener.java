package com.lll.activity.config;


import com.mysql.jdbc.AbandonedConnectionCleanupThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**f
 *
 *
 * .由于以上问题出现在Tomcat关闭的时候，也就是Web应用结束的时候，所以我们可以利用Web的监听器在Web应用关闭的时候注销这两个资源，同样，实现的监听器MyServletContextListener 实现ServletContextListener接口并重写contextDestroyed()方法
 */
//修复DBCP的BUG，https://issues.apache.org/jira/browse/DBCP-332
public class MyServletContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //这里如果Web应用拥有多个数据库的连接，可以一并关闭
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        Driver driver = null;
        while (drivers.hasMoreElements()) {
            try {
                driver = drivers.nextElement();
                DriverManager.deregisterDriver(driver);
            } catch (SQLException ex) {
            }
        }
        AbandonedConnectionCleanupThread.checkedShutdown();
    }
}


