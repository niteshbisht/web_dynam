package com.servcentralle.base.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.servcentralle.data.layer.DataLayer;
import com.servcentralle.data.layer.DataRedirect;

@Component
@Controller
public class FrontController {

	// private static final long serialVersionUID = 1L;
	Logger lgr = LoggerFactory.getLogger("com.servcentralle.base.controller.FrontController");

	@RequestMapping(value = "/userform", method = RequestMethod.GET)
	public String handleIndex() {
		return "userentryform";
	}

	@RequestMapping(value = "/getData", method = RequestMethod.GET)
	public ModelAndView getDataFromDb() {
		DataLayer dl = new DataRedirect();
		Map<Integer, Object> datamap = dl.getData();
		ModelAndView mview = new ModelAndView("showusers");
		mview.addObject("datamems", datamap);
		return mview;
	}
	
	@RequestMapping(value = "/dynamScript", method = RequestMethod.GET)
	public String handleDynamScript(){
		lgr.info("Redirecting to dynmicscript.jsp page");
		return "dynamicscript";
	}
	
	@RequestMapping(value = "/jScriptTest", method = RequestMethod.GET)
	public String handleJScriptTest(){
		lgr.info("Redirecting to dynmicscript.jsp page");
		return "jscripttst";
	}
}