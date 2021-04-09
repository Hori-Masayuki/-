package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DataAccess;
import bean.Student;

@WebServlet(urlPatterns = "/selectResult")
public class SelectResult extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 文字コードの設定
		req.setCharacterEncoding("utf-8");
		String user_id = req.getParameter("user_id");

		try {
			// DataAccessオブジェクトを生成
			DataAccess da = new DataAccess();

			// user_idでstudentListを生成
			ArrayList<Student> studentList = da.selectAllStudents(user_id);

			// user_idとstudentListをスクープに渡し、画面遷移
			req.setAttribute("user_id", user_id);
			req.setAttribute("studentList", studentList);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/selectResult.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("user_id", user_id);
			req.setAttribute("message", "エラーが発生しました");
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/welcome.jsp");
			rd.forward(req, resp);
		}
	}
}
