package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DataAccess;
import bean.Student;

@WebServlet(urlPatterns = "/updateStudent")
public class UpdateStudent extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 文字コードの設定
		req.setCharacterEncoding("utf-8");

		// student_idを取得
		String student_id = req.getParameter("student_id");
		String user_id = req.getParameter("user_id");

		try {

			// DataAccessのオブジェクトを生成
			DataAccess da = new DataAccess();

			// DataAccessのselectStudentメソッドを実行し、student情報を取得する
			Student student = da.selectStudent(student_id);

			// student情報をスコープに渡し、updateStudent.jspに画面遷移
			req.setAttribute("student", student);
			req.setAttribute("user_id", user_id);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/updateStudent.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			req.setAttribute("message", "エラーが発生しました");
			req.setAttribute("user_id", user_id);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/welcome.jsp");
			rd.forward(req, resp);
		}
	}
}
