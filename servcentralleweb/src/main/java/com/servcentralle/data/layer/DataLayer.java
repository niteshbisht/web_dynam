package com.servcentralle.data.layer;

import java.util.Map;

public interface DataLayer {
	public void placeParamsMysql(Map<String, Object> paramMap);
	public void placeParamsMongoDb(Map<String, Object> paramMap);
	public Map<Integer, Object> getData();
}
