package com.spring.ehcache.onboot.app.executors;

import java.util.concurrent.Callable;

import com.base.mysql.tree.traversal.TreeStructure;
import com.spring.ehcache.onboot.app.caches.IfaceCommonsCache;

public class ExecutorTask implements Callable<TreeStructure>{
	private IfaceCommonsCache iCache;

	/**
	 * @param iCache
	 */
	public ExecutorTask(IfaceCommonsCache iCache) {
		super();
		this.iCache = iCache;
	}

	@Override
	public TreeStructure call() throws Exception {
		TreeStructure ts = iCache.getTreeStructureIface();
		return ts;
	}
}
