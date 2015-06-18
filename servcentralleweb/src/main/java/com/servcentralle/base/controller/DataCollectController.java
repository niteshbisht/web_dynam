package com.servcentralle.base.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.servcentralle.data.layer.DataLayer;
import com.servcentralle.data.layer.DataRedirect;

@Component
@Controller
public class DataCollectController {
	// private static final long serialVersionUID = 1L;
	Logger lgr = Logger
			.getLogger("com.servcentralle.base.controller.DataCollectController");

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String handleIndex(HttpServletRequest request) {
		DataLayer dl = new DataRedirect();
		String name = request.getParameter("Name");
		String location = request.getParameter("Location");
		String address = request.getParameter("Address");
		Integer pin = Integer.parseInt(request.getParameter("Pin"));
		String services = request.getParameter("Services");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("Name", name);
		paramMap.put("Location", location);
		paramMap.put("Address", address);
		paramMap.put("Pin", pin);
		paramMap.put("Services", services);
		dl.placeParamsMysql(paramMap);
		StringBuilder sb = new StringBuilder();
		sb.append("a");
		return "added";
	}
}
