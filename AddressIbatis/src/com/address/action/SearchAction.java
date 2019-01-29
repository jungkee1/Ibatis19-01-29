package com.address.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.address.config.SqlMapCon;
import com.address.model.AddressVO;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * Servlet implementation class SearchAction
 */
@WebServlet("/address/searchAction")
public class SearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String field = req.getParameter("field"); //검색 분류
		String word = req.getParameter("word");	//검색어
		
		SqlMapClient sqlMap = SqlMapCon.getSqlMapInstacne();
		HashMap<String, String> map = new HashMap<>();
		map.put("field", field);
		map.put("word",word);
		try {
			List<AddressVO> sarr = sqlMap.queryForList("searchData", map);
			
			req.setAttribute("slists", sarr);
			req.setAttribute("count",sarr.size()); //배열의 갯수를 setAttribute 시켜서 보낼때 같이 보냄 
			RequestDispatcher rd = req.getRequestDispatcher("searchResult.jsp");
			rd.forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //arg1만 가기때문에 위에서 hashmap 만들어서 두개를 한개처럼 해서 보낸다
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
