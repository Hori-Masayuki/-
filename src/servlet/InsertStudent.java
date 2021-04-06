package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/insertStudent")
public class InsertStudent extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 文字コードの設定
		req.setCharacterEncoding("utf-8");

		// userIdの取得
		String user_id = req.getParameter("user_id");
		req.setAttribute("user_id", user_id);

		// insertStudent.jspに画面遷移
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/insertStudent.jsp");
		rd.forward(req, resp);
	}
}
