package com.address.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.address.config.SqlMapCon;
import com.address.model.ZipcodeVO;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * Servlet implementation class ZipSearchAction
 */
@WebServlet("/address/zipSearch")
public class ZipSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZipSearchAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String dong = req.getParameter("dong");
		SqlMapClient sqlMap = SqlMapCon.getSqlMapInstacne();
		try {
			List<ZipcodeVO> arrZIP = sqlMap.queryForList("zipData", dong);
			//위에 이제 리턴 되는 arrZIP 을 가지고
			JSONArray jarr = new JSONArray();
			for(ZipcodeVO vo : arrZIP ) {
				JSONObject obj = new JSONObject();
				obj.put("zipcode", vo.getZipcode());
				obj.put("sido", vo.getSido());
				obj.put("gugun", vo.getGugun());
				obj.put("dong", vo.getDong());
				obj.put("bunji", vo.getBunji());
				obj.put("seq", vo.getSeq());
				jarr.add(obj);
			}
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println(jarr.toString());;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
