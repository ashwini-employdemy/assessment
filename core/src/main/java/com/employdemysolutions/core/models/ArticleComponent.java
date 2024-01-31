package com.employdemysolutions.core.models;

import javax.annotation.Resource;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
@Model(adaptables ={SlingHttpServletRequest.class,Resource.class},
defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)

public class ArticleComponent {

    @ValueMapValue
    private String path;

    @ValueMapValue
    private int number;

    public String getPath() {
        return path;
    }

    public int getNumber() {
        return number;
    }

    

    
}
