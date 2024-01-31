package com.employdemysolutions.core.servlets;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(immediate = true,service = Servlet.class, property = {
        "sling.servlet.methods =" + HttpConstants.METHOD_GET,
        "sling.servlet.paths =" + "/bin/demoproject",
         "sling.servlet.resourceTypes=" + "sling/servlet/default"
})
public class PageServlet extends SlingSafeMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(PageServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {

        try {
            String path = "/content/project/us/en";
            String template_path = "/conf/project/settings/wcm/templates/secondTemplate";
            ResourceResolver resourceResolver = request.getResourceResolver();
            PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
            
            for (int i = 1; i <= 6; i++) {
                String pageName = "Page" + i;
                String title = "Page" + i;
             
               
                Page createdPage = pageManager.create(path, pageName, template_path, title, true);
                resourceResolver.commit();
                response.setContentType("text/plain");
                response.getWriter().write(" " + createdPage);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
