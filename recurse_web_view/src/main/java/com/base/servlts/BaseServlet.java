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

import com.base.businessa.logica.ComplexChildBundles;
import com.base.businessa.logica.ProductOfferings;
import com.base.businessa.logica.SimpleChildBundle;

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
		List<SimpleChildBundle> lst = new ArrayList<SimpleChildBundle>();
		for (int i = 0; i < 3; i++) {
			SimpleChildBundle smplchobject = new SimpleChildBundle();
			smplchobject.setProductName("Product Number : " + i);
			lst.add(smplchobject);
		}
		pdctpfr.setSimpleChildBundle(lst);

		List<SimpleChildBundle> lst2 = new ArrayList<SimpleChildBundle>();

		List<ComplexChildBundles> cmplexChild = new ArrayList<ComplexChildBundles>();
		for (int i = 3; i < 7; i++) {
			SimpleChildBundle smplchobject = new SimpleChildBundle();
			smplchobject.setProductName("Child Product Complex Number : " + i);
			lst2.add(smplchobject);
			ComplexChildBundles cmpBundles = new ComplexChildBundles();
			cmpBundles.setChildInsideComplexChildBundle(lst2);
			ComplexChildBundles cmpBundles2 = new ComplexChildBundles();
			cmpBundles2.setComplexChildBundles(null);
			cmpBundles2.setChildInsideComplexChildBundle(lst2);
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
		ObjectMapper mapper = new ObjectMapper();
		try {
			File f = new File("./mapped.json");
			String p =f.getAbsolutePath();
			if (!f.exists())
				f.createNewFile();
			mapper.writeValue(f, pdctpfr);
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
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
