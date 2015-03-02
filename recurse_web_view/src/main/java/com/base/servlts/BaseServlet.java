package com.base.servlts;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import com.base.businessa.logica.ProductComponent;
import com.base.businessa.logica.ProductOfferings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductOfferings pdctpfr;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaseServlet() {
		super();
		pdctpfr = new ProductOfferings();
		List<ProductComponent> lst = new ArrayList<ProductComponent>();
		for (int i = 0; i < 3; i++) {
			ProductComponent smplchobject = new ProductComponent();
			smplchobject.setProductDisplayName("Product Number : " + i);
			smplchobject.setComplexChildBundles(null);
			ProductComponent pdct2 = new ProductComponent();
			pdct2.setProductDisplayName("Product Number : " + i+" : "+i);
			pdct2.setComplexChildBundles(null);
			pdct2.setSimpleBundle(null);
			List p = new ArrayList<ProductComponent>();
			p.add(pdct2);
			smplchobject.setSimpleBundle(p);
			lst.add(smplchobject);
		}
		pdctpfr.setSimpleChildBundle(lst);
		List<ProductComponent> lst2 = new ArrayList<ProductComponent>();

		List<ProductComponent> cmplexChild = new ArrayList<ProductComponent>();
		for (int i = 3; i < 7; i++) {
			ProductComponent smplchobject = new ProductComponent();
			smplchobject.setProductDisplayName("Child Product Number : " + i+" : "+i);
			lst2.add(smplchobject);
			ProductComponent cmpBundles = new ProductComponent();
			cmpBundles.setSimpleBundle(lst2);
			ProductComponent cmpBundles2 = new ProductComponent();
			cmpBundles2.setComplexChildBundles(null);
			cmpBundles2.setSimpleBundle(lst2);
			cmplexChild.add(cmpBundles);
			cmplexChild.add(cmpBundles2);
		}
		pdctpfr.setComplexChildBundle(cmplexChild);
		System.out.println("Done");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Base Servlet");
		GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        System.out.println(gson.toJson(pdctpfr));
		/*ObjectMapper mapper = new ObjectMapper();
		try {
			File f = new File("./mapped.json");
			String p =f.getAbsolutePath();
			if (!f.exists())
				f.createNewFile();
			mapper.writeValue(f, pdctpfr);
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}*/
		/* request.setAttribute("product", pdctpfr); */
		RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Base Servlet");
	}

}
