package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DataAccess;

@WebServlet(urlPatterns = "/deleteStudent")
public class DeleteStudent extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 文字コードの設定
		req.setCharacterEncoding("utf-8");

		// student_idを取得
		String student_id = req.getParameter("student_id");
		String user_id = req.getParameter("user_id");

		try {

			// DataAccessオブジェクトを生成
			DataAccess da = new DataAccess();

			// DataAccessのdeleteStudentメソッドを実行
			da.deleteStudent(student_id);

			// welcome.jspに画面遷移
			req.setAttribute("message", "削除しました");
			req.setAttribute("user_id", user_id);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/welcome.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("message", "エラーが発生しました");
			req.setAttribute("user_id", user_id);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/welcome.jsp");
			rd.forward(req, resp);
		}
	}
}
