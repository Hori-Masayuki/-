package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DataAccess;
import bean.Student;

@WebServlet(urlPatterns = "/selectStudent")
public class SelectStudent extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 文字コードの設定
		req.setCharacterEncoding("utf-8");

		// user_idの取得
		String user_id = req.getParameter("user_id");
		try {

			// DataAccessオブジェクトを生成
			DataAccess da = new DataAccess();

			// DataAccessのselectAllStudentsメソッドを実行し、studentListを作成
			ArrayList<Student> studentList = da.selectAllStudents(user_id);

			// user_idとstudentListをスコープに渡し、selectStudent.jspに画面遷移
			req.setAttribute("studentList", studentList);
			req.setAttribute("user_id", user_id);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/selectStudent.jsp");
			rd.forward(req, resp);
		} catch (SQLException e) {
//			エラー処理
			req.setAttribute("message", "エラーが発生しました");
			req.setAttribute("user_id", user_id);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/welcome.jsp");
			rd.forward(req, resp);
		}
	}
}
