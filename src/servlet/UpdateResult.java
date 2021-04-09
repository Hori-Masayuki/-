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
import bean.Result;

@WebServlet(urlPatterns = "/updateResult")
public class UpdateResult extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 文字コードの設定
		req.setCharacterEncoding("utf-8");

		// student_idの取得
		String student_id = req.getParameter("student_id");
		String student_name = req.getParameter("student_name");

		try {

			// DataAccessオブジェクトを生成
			DataAccess da = new DataAccess();

			// DataAccessのselectAllResultで成績データを取得
			ArrayList<Result> resultList = da.selectAllResult(student_id);

			// resultListをスコープに渡し、画面遷移
			req.setAttribute("resultList", resultList);
			req.setAttribute("student_name", student_name);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/updateResult.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("message", "エラーが発生しました");
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/welcome.jsp");
			rd.forward(req, resp);
		}
	}
}
