package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.DataAccess;
import bean.Student;

@WebServlet(urlPatterns = "/registStudent")
public class RegistStudent extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 文字コードの設定
		req.setCharacterEncoding("utf-8");

		// user_idの取得
		HttpSession session = req.getSession();
		String user_id = (String) session.getAttribute("user_id");

		try {
			// 入力された値を取得
			String date = req.getParameter("date");
			String name = req.getParameter("name");
			String ruby = req.getParameter("ruby");
			String birthday = req.getParameter("birthday");
			String sex = req.getParameter("sex");
			String zip = req.getParameter("zip");
			String address1 = req.getParameter("address1");
			String address2 = req.getParameter("address2");
			String tel = req.getParameter("tel");
			String email = req.getParameter("email");
			String school = req.getParameter("school");
			String grade = req.getParameter("grade");

			// 入力された値を確認
			if (date == null || date.length() < 1) {
				req.setAttribute("message", "登録日を入力してください");
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/insertStudent.jsp");
				rd.forward(req, resp);
				return;
			}
			if (name == null || name.length() < 1) {
				req.setAttribute("message", "名前を入力してください");
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/insertStudent.jsp");
				rd.forward(req, resp);
				return;
			}
			if (ruby == null || ruby.length() < 1) {
				req.setAttribute("message", "ふりがなを入力してください");
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/insertStudent.jsp");
				rd.forward(req, resp);
				return;
			}
			if (zip == null || zip.length() < 1) {
				zip = "0";
			}
			if (birthday == null || birthday.length() < 1) {
				birthday = "1990/04/01";
			}

			// studentオブジェクトを生成
			Student student = new Student();

			// ブラウザから取得した値をセットしていく
			student.setUser_id(Integer.parseInt(user_id));
			student.setRegist_date(date);
			student.setName(name);
			student.setRuby(ruby);
			student.setBirthday(birthday);
			student.setSex(sex);
			student.setZip(Integer.parseInt(zip));
			student.setAddress1(address1);
			student.setAddress2(address2);
			student.setTel(tel);
			student.setEmail(email);
			student.setSchool(school);
			student.setGrade(grade);

			// DataAccessのインスタンス生成
			DataAccess da = new DataAccess();

			// DataAcceseのregistStudentメソッドを実行
			da.registStudent(student);

			// welcome.jspに画面遷移
			req.setAttribute("message", "登録が完了しました");
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/welcome.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			// welcome.jspに画面遷移
			req.setAttribute("message", "エラーが発生しました");
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/welcome.jsp");
			rd.forward(req, resp);
		}

	}
}
