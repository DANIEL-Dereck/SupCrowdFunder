package fr.imie.supcrowdfunder.listener;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FileLocationContextListener implements ServletContextListener {

    @Override
    public void contextInitialized( ServletContextEvent sce ) {
        String rootPath = System.getProperty( "catalina.home" );
        ServletContext ctx = sce.getServletContext();
        String relativePath = ctx.getInitParameter( "tempfile.dir" );
        File file = new File( rootPath + File.separator + relativePath );
        if ( !file.exists() )
            file.mkdirs();
        System.out.println( "File Directory created to be used for storing files" );
        ctx.setAttribute( "FILES_DIR_FILE", file );
        ctx.setAttribute( "FILES_DIR", rootPath + File.separator + relativePath );

    }

    @Override
    public void contextDestroyed( ServletContextEvent sce ) {
        // TODO Auto-generated method stub

    }

}
