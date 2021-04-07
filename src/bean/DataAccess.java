package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataAccess {

	// DataSourceを保持する変数
	private static DataSource ds = null;
	private Integer user_id;

	// getter,setterメソッド
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	// lookupで使用するJNDI参照名
	private static final String JNDI_NAME = "java:comp/env/jdbc/system";

	// DataSourceを取得するメソッド
	private static DataSource getDataSource() throws NamingException {

		// dsがnullの時だけlookupを実行
		if (ds == null) {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup(JNDI_NAME);
		}
		return ds;
	}

	// ログイン可能か確認するメソッド
	public boolean userCheck(String name, String password) throws SQLException {

		// Connection,PreparedStatement,ResultSet型変数の宣言
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// データ取得用SQL文
			String sql = "SELECT id,name , password FROM user WHERE name=?;";

			// DataSourceの取得
			conn = getDataSource().getConnection();

			// PreparedStatementオブジェクトの生成
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);

			// SQL文の実行
			rs = ps.executeQuery();

			// 検索結果の取得
			if (rs.next()) {
				String selectedPassword = rs.getString("password");

				// 入力されたパスワードとDBから取得したパスワードが一致しているか確認
				if (!password.equals(selectedPassword)) {

					// 一致しなかった場合falseを返す
					return false;
				}
			} else {
				// 検索結果が無かった場合はfalseを返す
				return false;
			}
			// パスワードと検索結果が一致した場合trueを返し、setIdメソッドを呼び出す
			setUser_id(rs.getInt("id"));
			return true;

		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			// クローズ処理
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	// ユーザーデータを登録するメソッド
	public void registUser(User user) throws SQLException {

		// Connection,PreparedStatement,ResultSet型変数の宣言
		Connection conn = null;
		PreparedStatement insertPs = null;
		PreparedStatement selectPs = null;
		ResultSet rs = null;

		try {
			// データ登録用のSQL文
			String insertSQL = "INSERT INTO user (name,email,password) VALUES(?,?,?);";

			// 二重登録確認用のSQL文
			String selectSQL = "SELECT name,password FROM user WHERE name=?;";

			// Connectionオブジェクトの取得
			conn = getDataSource().getConnection();

			// 二重登録確認用のPreparedStatementオブジェクトの取得
			selectPs = conn.prepareStatement(selectSQL);

			// 二重登録確認用のパラメータ設定
			selectPs.setString(1, user.getName());

			// ResultSetのオブジェクト取得
			rs = selectPs.executeQuery();

			// 名前とパスワードがすでに登録されている場合エラー処理
			if (rs.next() && rs.getString("password").equals(user.getPassword())) {
				throw new SQLException();
			}
			// データ登録用のPreparedStatementオブジェクトの取得
			insertPs = conn.prepareStatement(insertSQL);

			// データ登録用のパラメータ設定
			insertPs.setString(1, user.getName());
			insertPs.setString(2, user.getEmail());
			insertPs.setString(3, user.getPassword());

			// データ登録用のSQL文の実行
			insertPs.executeUpdate();
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			// クローズ処理
			if (conn != null) {
				conn.close();
			}
			if (insertPs != null) {
				insertPs.close();
			}
			if (selectPs != null) {
				selectPs.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
	}

	// 生徒データを登録するメソッド
	public void registStudent(Student student) throws SQLException {

		// Connection,PreparedStatement,ResultSet型変数の宣言
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// 生徒データ登録用のSQL文
			String sql = "INSERT INTO student (user_id,regist_date,name,ruby,birthday,sex,zip,address1,address2,tel,email,school,grade) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";

			// Connectionオブジェクトの取得
			conn = getDataSource().getConnection();

			// PreparedStatementオブジェクトの取得
			ps = conn.prepareStatement(sql);

			// パラメータ設定
			ps.setInt(1, student.getUser_id());
			ps.setString(2, student.getRegist_date());
			ps.setString(3, student.getName());
			ps.setString(4, student.getRuby());
			ps.setString(5, student.getBirthday());
			ps.setString(6, student.getSex());
			ps.setInt(7, student.getZip());
			ps.setString(8, student.getAddress1());
			ps.setString(9, student.getAddress2());
			ps.setString(10, student.getTel());
			ps.setString(11, student.getEmail());
			ps.setString(12, student.getSchool());
			ps.setString(13, student.getGrade());

			// データ登録用のSQL文の実行
			ps.executeUpdate();

		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			// クローズ処理
			if (conn != null) {
				conn.close();
			}
			if (ps != null) {
				ps.close();
			}
		}
	}

	// user_idから生徒一覧を取得できるメソッド
	public ArrayList<Student> selectAllStudents(String user_id) throws SQLException {

		// Connection,PreparedStatement,ResultSet型変数の宣言
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 返す用のArryaListを生成
		ArrayList<Student> studentList = new ArrayList<Student>();

		try {
			// データ取得用SQL文
			String sql = "SELECT id,name,grade FROM student WHERE user_id=? ORDER BY grade;";

			// DataSourceの取得
			conn = getDataSource().getConnection();

			// PreparedStatementオブジェクトの生成
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(user_id));

			// SQL文の実行
			rs = ps.executeQuery();

			// 検索結果からstudentを取得
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setGrade(rs.getString("grade"));

				studentList.add(student);
			}
			return studentList;

		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			// クローズ処理
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	// student_idからstudent情報を取得するメソッド
	public Student selectStudent(String student_id) throws SQLException {

		// Connection,PreparedStatement,ResultSet型変数の宣言
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 返す用のStudentを生成
		Student student = new Student();

		try {
			// データ取得用SQL文
			String sql = "SELECT * FROM student WHERE id=?;";

			// DataSourceの取得
			conn = getDataSource().getConnection();

			// PreparedStatementオブジェクトの生成
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(student_id));

			// SQL文の実行
			rs = ps.executeQuery();

			// 検索結果からstudentを取得
			if (rs.next()) {
				student.setId(rs.getInt("id"));
				student.setUser_id(rs.getInt("user_id"));
				student.setZip(rs.getInt("zip"));
				student.setRegist_date(rs.getString("regist_date"));
				student.setName(rs.getString("name"));
				student.setRuby(rs.getString("ruby"));
				student.setBirthday(rs.getString("birthday"));
				student.setSex(rs.getString("sex"));
				student.setAddress1(rs.getString("address1"));
				student.setAddress2(rs.getString("address2"));
				student.setTel(rs.getString("tel"));
				student.setEmail(rs.getString("email"));
				student.setSchool(rs.getString("school"));
				student.setGrade(rs.getString("grade"));
			}
			return student;

		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			// クローズ処理
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	// student_idからstudent情報を削除するメソッド
	public void deleteStudent(String student_id) throws SQLException {

		// Connection,PreparedStatement,ResultSet型変数の宣言
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// 生徒データ削除用のSQL文
			String sql = "DELETE FROM student WHERE id=?;";

			// Connectionオブジェクトの取得
			conn = getDataSource().getConnection();

			// PreparedStatementオブジェクトの取得
			ps = conn.prepareStatement(sql);

			// パラメータ設定
			ps.setInt(1, Integer.parseInt(student_id));

			// データ削除用のSQL文の実行
			ps.executeUpdate();

		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			// クローズ処理
			if (conn != null) {
				conn.close();
			}
			if (ps != null) {
				ps.close();
			}
		}
	}

	// student_idからstudent情報を更新するメソッド
	public void updateStudent(Student student) throws SQLException {

		// Connection,PreparedStatement,ResultSet型変数の宣言
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// 生徒データ登録用のSQL文
			String sql = "UPDATE student SET user_id=?,regist_date=?,name=?,ruby=?,birthday=?,sex=?,zip=?,address1=?,address2=?,tel=?,email=?,school=?,grade=? WHERE id=?;";

			// Connectionオブジェクトの取得
			conn = getDataSource().getConnection();

			// PreparedStatementオブジェクトの取得
			ps = conn.prepareStatement(sql);

			// パラメータ設定
			ps.setInt(1, student.getUser_id());
			ps.setString(2, student.getRegist_date());
			ps.setString(3, student.getName());
			ps.setString(4, student.getRuby());
			ps.setString(5, student.getBirthday());
			ps.setString(6, student.getSex());
			ps.setInt(7, student.getZip());
			ps.setString(8, student.getAddress1());
			ps.setString(9, student.getAddress2());
			ps.setString(10, student.getTel());
			ps.setString(11, student.getEmail());
			ps.setString(12, student.getSchool());
			ps.setString(13, student.getGrade());
			ps.setInt(14, student.getId());

			// データ登録用のSQL文の実行
			ps.executeUpdate();

		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			// クローズ処理
			if (conn != null) {
				conn.close();
			}
			if (ps != null) {
				ps.close();
			}
		}
	}
}
