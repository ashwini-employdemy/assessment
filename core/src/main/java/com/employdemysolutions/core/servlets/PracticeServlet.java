package com.employdemysolutions.core.servlets;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true,service = Servlet.class, property = {
        "sling.servlet.methods =" + HttpConstants.METHOD_GET,
        "sling.servlet.paths =" + "/bin/PracticeServlet",
         "sling.servlet.resourceTypes=" + "sling/servlet/default"
})
public class PracticeServlet extends SlingSafeMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(PracticeServlet.class);
    
    @Reference
    PracticeService PracticeService;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {

        
                response.setContentType("text/plain");
                response.getWriter().write("Hello " );
            
        
    }
}
