package com.employdemysolutions.core.servlets;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

public class ResolverUtil  {
     private static final String SYSTEM_SERVICE_USER = "chhatrapal";

   
    public static ResourceResolver  getResourceResolver(ResourceResolverFactory resourceResolverFactory) throws LoginException {

        Map<String, Object> param = new HashMap<>();
        param.put(resourceResolverFactory.SUBSERVICE, SYSTEM_SERVICE_USER);
        return resourceResolverFactory.getServiceResourceResolver(param);
    }
}
