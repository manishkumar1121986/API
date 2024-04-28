package com.api.util;

import javax.inject.Inject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;



@Component
public class AssetApplicationContextAware implements ApplicationContextAware{
	@Inject
	private ApplicationContext context;
	@Override
	public void setApplicationContext(ApplicationContext context)
			{
		this.context = context;
	}

    public ApplicationContext getApplicationContext() {
        return context;
    }
}
