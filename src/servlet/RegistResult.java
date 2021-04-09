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
import bean.Student;

@WebServlet(urlPatterns = "/registResult")
public class RegistResult extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 文字コードの設定
		req.setCharacterEncoding("utf-8");
		String user_id = req.getParameter("user_id");

		try {
			// 入力された値を取得
			String student_id = req.getParameter("student_id");
			String semester = req.getParameter("semester");
			String test_date = req.getParameter("test_date");
			String test_name = req.getParameter("test_name");
			String english = req.getParameter("english");
			String math = req.getParameter("math");
			String japanese = req.getParameter("japanese");
			String science = req.getParameter("science");
			String society = req.getParameter("society");
			String music = req.getParameter("music");
			String physical = req.getParameter("physical");
			String tech_home = req.getParameter("tech_home");
			String art = req.getParameter("art");

			// 入力された値を確認
			if (test_date == null || test_date.length() < 1 || test_name == null || test_name.length() < 1) {
				req.setAttribute("user_id", user_id);
				req.setAttribute("message", "テスト日、テスト名を入力してください");
				// user_idからstudentListを取得
				DataAccess da = new DataAccess();
				ArrayList<Student> studentList = da.selectAllStudents(user_id);
				req.setAttribute("studentList", studentList);
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/insertResult.jsp");
				rd.forward(req, resp);
				return;
			}
			// 入力がない点数は0を代入
			if (english == null || english.length() < 1) {
				english = "0";
			}
			if (math == null || math.length() < 1) {
				math = "0";
			}
			if (japanese == null || japanese.length() < 1) {
				japanese = "0";
			}
			if (science == null || science.length() < 1) {
				science = "0";
			}
			if (society == null || society.length() < 1) {
				society = "0";
			}
			if (music == null || music.length() < 1) {
				music = "0";
			}
			if (physical == null || physical.length() < 1) {
				physical = "0";
			}
			if (tech_home == null || tech_home.length() < 1) {
				tech_home = "0";
			}
			if (art == null || art.length() < 1) {
				art = "0";
			}

			// Resultオブジェクトを生成
			Result result = new Result();
			result.setStudent_id(Integer.parseInt(student_id));
			result.setSemester(semester);
			result.setTest_date(test_date);
			result.setTest_name(test_name);
			result.setEnglish(Integer.parseInt(english));
			result.setMath(Integer.parseInt(math));
			result.setJapanese(Integer.parseInt(japanese));
			result.setScience(Integer.parseInt(science));
			result.setSociety(Integer.parseInt(society));
			result.setMusic(Integer.parseInt(music));
			result.setPhysical(Integer.parseInt(physical));
			result.setTech_home(Integer.parseInt(tech_home));
			result.setArt(Integer.parseInt(art));

			// DataAccessオブジェクトを生成
			DataAccess da = new DataAccess();

			// DataAccessのinsertResultメソッドを実施
			da.insertResult(result);

			// welcome.jspに画面遷移
			req.setAttribute("user_id", user_id);
			req.setAttribute("message", "登録完了しました");
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/welcome.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("user_id", user_id);
			req.setAttribute("message", "エラーが発生しました");
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/welcome.jsp");
			rd.forward(req, resp);
		}
	}
}
