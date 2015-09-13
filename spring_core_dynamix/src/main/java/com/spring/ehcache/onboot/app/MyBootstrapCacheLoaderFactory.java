package com.spring.ehcache.onboot.app;

import java.util.Properties;

import com.spring.ehcache.onboot.app.caches.AppQTCache;
import com.spring.ehcache.onboot.app.caches.JenkinsQTCache;
import com.spring.ehcache.onboot.app.caches.TravisQTCache;
import com.spring.ehcache.onboot.app.executors.TreeExecutorsService;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.bootstrap.BootstrapCacheLoader;
import net.sf.ehcache.bootstrap.BootstrapCacheLoaderFactory;

public class MyBootstrapCacheLoaderFactory extends BootstrapCacheLoaderFactory
		implements BootstrapCacheLoader {
	private AppQTCache aqt;
	private JenkinsQTCache jqt;
	private TravisQTCache tqt;
	
	@Override
	public boolean isAsynchronous() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void load(Ehcache arg0) throws CacheException {
		
		TreeExecutorsService ts = new TreeExecutorsService(aqt, jqt, tqt);
		ts.prepareExecutorTask();
		ts.executeExecutorTasks();
	}

	@Override
	public Object clone() {
		return null;
	}

	@Override
	public BootstrapCacheLoader createBootstrapCacheLoader(Properties arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public AppQTCache getAqt() {
		return aqt;
	}

	public JenkinsQTCache getJqt() {
		return jqt;
	}

	public TravisQTCache getTqt() {
		return tqt;
	}

	public void setAqt(AppQTCache aqt) {
		this.aqt = aqt;
	}

	public void setJqt(JenkinsQTCache jqt) {
		this.jqt = jqt;
	}

	public void setTqt(TravisQTCache tqt) {
		this.tqt = tqt;
	}

}
