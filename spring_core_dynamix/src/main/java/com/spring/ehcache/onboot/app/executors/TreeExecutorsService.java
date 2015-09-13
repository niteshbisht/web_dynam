package com.spring.ehcache.onboot.app.executors;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.spring.ehcache.onboot.app.caches.AppQTCache;
import com.spring.ehcache.onboot.app.caches.JenkinsQTCache;
import com.spring.ehcache.onboot.app.caches.TravisQTCache;

public class TreeExecutorsService {
	private AppQTCache aq;
	private JenkinsQTCache jq;
	private TravisQTCache tq;
	private ExecutorTask[] et;
	private boolean initialized;

	/**
	 * @param aq
	 * @param jq
	 * @param tq
	 * @param et
	 * @param initialized
	 */
	public TreeExecutorsService(AppQTCache aq, JenkinsQTCache jq,
			TravisQTCache tq) {
		super();
		this.aq = aq;
		this.jq = jq;
		this.tq = tq;
		this.et = new ExecutorTask[3];
		this.initialized = false;
	}

	public void prepareExecutorTask() {
		for (int i = 0; i < et.length; i++) {
			switch (i) {
			case 0:
				et[i] = new ExecutorTask(aq);
				break;
			case 1:
				et[i] = new ExecutorTask(jq);
				break;
			case 2:
				et[i] = new ExecutorTask(tq);
				break;
			}
		}
		initialized = true;
	}

	public void executeExecutorTasks() {
		if (initialized) {
			ExecutorService ex = Executors.newFixedThreadPool(3);
			try {
				ex.invokeAll(Arrays.asList(et));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
