package br.ada.americanas.jsf.helloworldjsf.weld;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class WeldListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //Chamado quando o deploy da aplicação termina dentro do servidor
        ServletContextListener.super.contextInitialized(sce);
        WeldInstance.INSTANCE.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //Chamdo quando a aplicação é encerrada dentro do servidor
        ServletContextListener.super.contextDestroyed(sce);
        WeldInstance.INSTANCE.shutdown();
    }

}
