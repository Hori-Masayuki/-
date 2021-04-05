package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DataAccess;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/login")
public class Welcome extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 文字コードの設定
		req.setCharacterEncoding("utf-8");

		// 入力された名前とパスワードを取得
		String name = req.getParameter("name");
		String password = req.getParameter("password");

		// DataAccessのインスタンスを生成
		DataAccess da = new DataAccess();

		// userCheckメソッドを実行し、画面遷移
		try {
			if(da.userCheck(name, password)){
				req.setAttribute("name", name);
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/welcome.jsp");
				rd.forward(req, resp);
			}else{
				req.setAttribute("message", "ユーザー名またはパスワードが違います");
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.forward(req, resp);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
