/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;

/**
 *
 * @author Vincent Laude
 */
public class Main {
     public static void main(String[] args) throws Exception{
        Server server = new Server(8080);
        ContextHandler context = new ContextHandler();
        context.setContextPath("/hello");
        //context.setHandler(new HelloHandler());
        server.setHandler(context);
        server.start();
        server.join();
    }
}
