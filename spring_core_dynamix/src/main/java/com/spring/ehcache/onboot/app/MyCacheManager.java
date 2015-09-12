package com.spring.ehcache.onboot.app;

import java.util.List;

import org.springframework.cache.ehcache.EhCacheCacheManager;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

public class MyCacheManager {
	private EhCacheCacheManager cacheMan;

	public EhCacheCacheManager getCacheMan() {
		return cacheMan;
	}

	public void setCacheMan(EhCacheCacheManager cacheMan) {
		this.cacheMan = cacheMan;
	}

	public void showDataFromCache(String cacheName){
		CacheManager b = cacheMan.getCacheManager();
		boolean q = b.cacheExists(cacheName);
		Cache info = b.getCache(cacheName);
		List keys = info.getKeys();
		for(int i = 0;i<keys.size();i++)
			System.out.println(keys.get(i));
		System.out.println(q);
	}
}
