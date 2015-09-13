package com.base.mysql.tree.traversal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TreeStructure {
	private int levelIndex;
	private String levelName;
	private Map<String, List<TreeStructure>> childNodes = new LinkedHashMap<String, List<TreeStructure>>();

	public Map<String, List<TreeStructure>> getChildNodes() {
		return childNodes;
	}

	public int getLevelIndex() {
		return levelIndex;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setChildNodes(Map<String, List<TreeStructure>> childNodes) {
		this.childNodes = childNodes;
	}

	public void setLevelIndex(int levelIndex) {
		this.levelIndex = levelIndex;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

}
