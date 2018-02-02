//package com.teamtyphoon.im;
//
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
///**
// * Application Lifecycle Listener implementation class ServerStartListener
// *
// */
//@WebListener
//public class WebSocketConnector implements ServletContextListener {
//
//
//    /**
//     * @see ServletContextListener#contextInitialized(ServletContextEvent)
//     */
//    public void contextInitialized(ServletContextEvent arg0)  {
//        messageReader=new RedisMessageBufferStoreReader();
//        messageReader.setDaemon(true);
//        messageReader.start();
//    }
//
//    /**
//     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
//     */
//    public void contextDestroyed(ServletContextEvent arg0)  {
//        messageReader.stopMe();
//    }
//
//}
