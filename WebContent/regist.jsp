<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<title>生徒管理システム</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<div class="bodySignUp">
		<p>${message }</p>
		<h1 class="textSignUp">サインアップ</h1>
		<div class="screenSignUp">
			<form action="regist" method="POST">
				<p class="editInput">ユーザー名</p>
				<input type="text" name="name"><br>
				<p class="editInput">メールアドレス</p>
				<input type="text" name="email">
				<p class="editInput">パスワード</p>
				<input type="password" name="password"><br> <input
					type="submit" value="サインアップ" class="btnSignUp">
			</form>
		</div>
		<p>
			<a href="index.jsp" class="textSignIn">ログイン画面へ</a>
		</p>
	</div>
</body>
</html>