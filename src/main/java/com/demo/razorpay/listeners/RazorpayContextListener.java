package com.demo.razorpay.listeners;

import com.demo.razorpay.models.products.XiaomiMiA3;
import com.demo.razorpay.models.products.XiaomiMiPlay;
import com.demo.razorpay.models.products.XiaomiRedmi7;
import com.demo.razorpay.service.local.ProductLocalService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Logger;

public class RazorpayContextListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(RazorpayContextListener.class.getName());

    private XiaomiRedmi7 xiaomiRedmi7;

    private XiaomiMiA3 xiaomiMiA3;

    private XiaomiMiPlay xiaomiMiPlay;

    public RazorpayContextListener(){
        this.xiaomiMiA3 = new XiaomiMiA3();
        this.xiaomiMiPlay = new XiaomiMiPlay();
        this.xiaomiRedmi7 = new XiaomiRedmi7();
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("<<<<------- Razorpay Product Registration started... ------->>>>");

       /* ProductLocalService.registerProduct(this.xiaomiMiA3);
        ProductLocalService.registerProduct(this.xiaomiMiPlay);
        ProductLocalService.registerProduct(this.xiaomiRedmi7);*/

        LOGGER.info("<<<<------- Razorpay Product Registration completed. ------->>>>");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        /*ProductLocalService.deRegisterProduct(this.xiaomiMiA3);
        ProductLocalService.deRegisterProduct(this.xiaomiMiPlay);
        ProductLocalService.deRegisterProduct(this.xiaomiRedmi7);*/
    }
}
