package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DataAccess;

@WebServlet(urlPatterns = "/deleteResult")
public class DeleteResult extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 文字コードの設定
		req.setCharacterEncoding("utf-8");

		// result_idを取得
		String user_id = req.getParameter("user_id");
		String result_id = req.getParameter("result_id");

		try {

			// DataAccessオブジェクトを生成
			DataAccess da = new DataAccess();

			// DataAccessのdeleteResultメソッドを実行
			da.deleteResult(result_id);

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
