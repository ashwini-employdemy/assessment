package com.employdemysolutions.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;




@Component(service = { Servlet.class })
@SlingServletPaths(
        value = {"/bin/createcustompages"}
)
public class secondServlet extends SlingAllMethodsServlet {
   
    @Reference
    ResourceResolverFactory resolverFactory;

    @Override
    protected void doGet(SlingHttpServletRequest req, SlingHttpServletResponse resp)
            throws ServletException, IOException {
   
                Page newPage;
                PageManager pagemanager;
                ResourceResolver resourceResolver;
                Resource resource;
                com.day.cq.wcm.api.Page page;
        try {
            String pagePath="/content/project/us/en";
            String templatePath="/conf/project/settings/wcm/templates/secondTemplate";
            String pageTitle="firstpage";
            String pageName ="firstpage";
            String pageTitle1="";
            String pageName1 ="";


            resourceResolver=ResolverUtil.getResourceResolver(resolverFactory);
            //resourceResolver=req.getResourceResolver();
           
            pagemanager=resourceResolver.adaptTo(PageManager.class);
            for(int i=0;i<6;i++){
                pageName1=pageName+i;
                pageTitle1=pageTitle+i;
            page=pagemanager.create(pagePath,pageName1,templatePath, pageTitle1);
            }
            resourceResolver.commit();
   
            resp.getWriter().write("======FORM SUBMITTED p========");  
        }catch (Exception e){
           
           
           e.printStackTrace();
        }
        resp.getWriter().write("======FORM SUBMITTED p========");

    }

}