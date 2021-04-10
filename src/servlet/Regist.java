package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DataAccess;
import bean.User;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/regist")
public class Regist extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 文字コードの設定
		req.setCharacterEncoding("utf-8");

		try {

			// 入力された値を取得
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			// 入力された値をチェック
			if (name == null || name.length() < 1) {
				req.setAttribute("message", "名前を入力してください");
				RequestDispatcher rd = req.getRequestDispatcher("/regist.jsp");
				rd.forward(req, resp);
				return;
			}
			if (email == null || email.length() < 1) {
				req.setAttribute("message", "メールアドレスを入力してください");
				RequestDispatcher rd = req.getRequestDispatcher("/regist.jsp");
				rd.forward(req, resp);
				return;
			}
			if (password == null || password.length() < 8) {
				req.setAttribute("message", "8文字以上のパスワードを入力してください");
				RequestDispatcher rd = req.getRequestDispatcher("/regist.jsp");
				rd.forward(req, resp);
				return;
			}

			// Userオブジェクトを作成
			User user = new User();

			// ブラウザから取得した値をセットしていく
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);

			// DataAccessのインスタンスを生成
			DataAccess da = new DataAccess();

			// DataAccessのregistUserメソッドを実行
			da.registUser(user);

			// ログイン画面に遷移
			req.setAttribute("message", "登録が完了しました");
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			// 新規登録画面へ遷移
			req.setAttribute("message", "エラーが発生しました");
			req.getRequestDispatcher("/regist.jsp").forward(req, resp);
		}
	}
}
