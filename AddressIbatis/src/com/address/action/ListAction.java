package com.address.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.address.config.SqlMapCon;
import com.address.model.AddressVO;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * Servlet implementation class ListAction
 */
@WebServlet("/address/listAction")
public class ListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		SqlMapClient sqlMap = SqlMapCon.getSqlMapInstacne();
		try {
			int count = (Integer) sqlMap.queryForObject("countData"); //��ü�� int�� ��ȯ �ȵǱ⶧���� ����ؼ� �ٲپ������
			req.setAttribute("count", count);
			
			List<AddressVO> arr = sqlMap.queryForList("listData"); //������ �������϶� queryForList �Ѱ��϶� queryForObject  //queryForList = select �� ������
			req.setAttribute("lists", arr);
			RequestDispatcher rd = req.getRequestDispatcher("addrList.jsp");
			rd.forward(req, resp);
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
