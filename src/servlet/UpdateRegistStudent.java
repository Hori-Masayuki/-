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

@WebServlet(urlPatterns = "/updateRegistStudent")
public class UpdateRegistStudent extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 文字コードの設定
		req.setCharacterEncoding("utf-8");

		// 入力された値を取得
		String user_id = req.getParameter("user_id");
		String student_id = req.getParameter("student_id");
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

		try {
//			DataAccessオブジェクトを生成
			DataAccess da = new DataAccess();

//			DataAccessのselectStudentメソッドを実行
			Student student = da.selectStudent(student_id);

			// 入力された値を確認
			if (date == null || date.length() < 1) {
				req.setAttribute("message", "登録日を入力してください");
				req.setAttribute("user_id", user_id);
				req.setAttribute("student", student);
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/updateStudent.jsp");
				rd.forward(req, resp);
				return;
			}
			if (name == null || name.length() < 1) {
				req.setAttribute("message", "名前を入力してください");
				req.setAttribute("user_id", user_id);
				req.setAttribute("student", student);
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/updateStudent.jsp");
				rd.forward(req, resp);
				return;
			}
			if (ruby == null || ruby.length() < 1) {
				req.setAttribute("message", "ふりがなを入力してください");
				req.setAttribute("user_id", user_id);
				req.setAttribute("student", student);
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/updateStudent.jsp");
				rd.forward(req, resp);
				return;
			}
			if (zip == null || zip.length() < 1) {
				zip = "0";
			}
			if (birthday == null || birthday.length() < 1) {
				birthday = "1990/04/01";
			}

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

			// DataAcceseのupdateStudentメソッドを実行
			da.updateStudent(student);

			// welcome.jspに画面遷移
			req.setAttribute("message", "更新が完了しました");
			req.setAttribute("user_id", user_id);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/welcome.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			// welcome.jspに画面遷移
			req.setAttribute("message", "エラーが発生しました");
			req.setAttribute("user_id", user_id);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/welcome.jsp");
			rd.forward(req, resp);
		}
	}
}
