package com.servcentralle.data.layer;

import java.util.Map;
import com.servdao.base.DataAccessIface;
import com.servdao.implcls.DataPush;

public class DataRedirect implements DataLayer {

	@Override
	public void placeParamsMysql(Map<String, Object> paramMap) {
		DataAccessIface df = new DataPush();
		df.sendParams(paramMap);
	}

	@Override
	public void placeParamsMongoDb(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<Integer, Object> getData() {
		DataAccessIface df = new DataPush();
		return df.getData();
	}

}
