package com.address.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.address.config.SqlMapCon;
import com.address.model.AddressVO;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * Servlet implementation class InsertAction
 */
@WebServlet("/address/insertAction")
public class InsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		AddressVO vo = new AddressVO();
		vo.setAddr(req.getParameter("addr")); //getParameter�� ���ÿ� set���ѹ��� 
		vo.setName(req.getParameter("name"));
		vo.setTel(req.getParameter("tel"));
		vo.setZipcode(req.getParameter("zipcode"));
		
		SqlMapClient sqlMap = SqlMapCon.getSqlMapInstacne();
		try {
			sqlMap.insert("insertData",vo);  //SQL�� ���� id insertData ���� ���� //.insert ���� (select �� ���� ������ �ٸ�)
			resp.sendRedirect("listAction");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
