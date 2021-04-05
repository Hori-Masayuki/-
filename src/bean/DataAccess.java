package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataAccess {

	// DataSourceを保持する変数
	private static DataSource ds = null;
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
			setId(rs.getInt("id"));
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

	// データを登録するメソッド
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

}
