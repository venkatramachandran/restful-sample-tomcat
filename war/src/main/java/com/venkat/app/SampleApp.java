package com.venkat.app;

import org.glassfish.jersey.server.ResourceConfig;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.JacksonFeature;

import com.venkat.dao.SampleDao;

public class SampleApp extends ResourceConfig {
    public SampleApp() {
        register(new AbstractBinder(){
		    @Override
		    protected void configure() {
		        bind(SampleDao.class).to(SampleDao.class);
		    }
        });
        packages(true, "com.venkat.api, com.venkat.filters");
        register(JacksonFeature.class);
    }
}