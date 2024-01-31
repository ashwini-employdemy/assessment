package com.employdemysolutions.core.servlets;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.SearchResult;

public class PracticeServiceimpl {
    @Reference
    private QueryBuilder queryBuilder;

    @Reference
    private ResourceResolverFactory resolverFactory;
     @Override
    public void getMessage() {
      ResourceResolver resourceResolver = resolverFactory.getResourceResolver();
      QueryBuilder queryBuilder = resourceResolver.adaptTo(QueryBuilder.class);
      Session session = resourceResolver.adaptTo(Session.class);
       Map<String, String> map = new HashMap<String, String>();
       map.put("path", "/content/project/us/en");
       map.put("type", "cq:Page");
       map.put("1_property", "jcr:content/cq:template");
       map.put("1_property.value", "/conf/project/settings/wcm/templates/secondTemplate");
       Query query = queryBuilder.createQuery(PredicateGroup.create(map), resourceResolver.adaptTo(null));
        SearchResult result = query.getResult();
        if (!result.isEmpty()) {
            pagePath.add(page.getPath());
        }
  
    }
    
}
