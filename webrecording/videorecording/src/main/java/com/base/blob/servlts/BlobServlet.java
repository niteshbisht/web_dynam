package com.base.blob.servlts;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class BlobServlet
 */
//@WebServlet("/BlobServlet")
public class BlobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			byte[] buffer = new byte[16 * 1024];
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			String user = "root";
			String password = "welcome";
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/videoservice", user, password);
			String sql = "select * from videos order by date_created desc";
			Random r = new Random();
			int i = r.nextInt();
			Statement createStatement = con.createStatement();
			ResultSet rs = createStatement.executeQuery(sql);
			List<Blob> blist = new ArrayList<Blob>();
			while(rs.next()){
				Blob blob = rs.getBlob("video_content");
				blist.add(blob);
			}
			Blob blob = blist.get(0);
			response.setHeader("Content-Type", "blob");
			response.setContentType("blob");
			ServletOutputStream outputStream = response.getOutputStream();
			int bytesRead=0;
			InputStream binaryStream = blob.getBinaryStream();
			while ((bytesRead = binaryStream.read(buffer)) != -1){
				 System.out.println(bytesRead); 
				 outputStream.write(buffer, 0, bytesRead); 
			}
			outputStream.flush();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// output.close();
		// input.close();
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		byte[] buffer = new byte[16 * 1024];

		InputStream input = request.getInputStream();
		FileOutputStream output = new FileOutputStream(new File(
				"F:\\eclipseprojects\\Servers\\vid1.webm"));
		int bytesRead;
		/*
		 * while ((bytesRead = input.read(buffer)) != -1){
		 * System.out.println(bytesRead); output.write(buffer, 0, bytesRead); }
		 */
		// output.flush();
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			String user = "root";
			String password = "welcome";
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/videoservice", user, password);
			String sql = "insert into videos(video_name,video_content,date_created) values(?,?,?)";
			Random r = new Random();
			int i = r.nextInt();
			PreparedStatement prepareStatement = con.prepareStatement(sql);
			prepareStatement.setString(1, "firstvideo==>" + i);
			prepareStatement.setBlob(2, input);
			prepareStatement.setDate(3, new Date(System.currentTimeMillis()));
			prepareStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// output.close();
		// input.close();
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
