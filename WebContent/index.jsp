<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<title>生徒管理システム</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<div class="bodySignIn">
		<p>${message }</p>
		<h1 class="textSignIn">サインイン</h1>
		<div class="screenSignIn">
			<form action="login" method="POST">
				<p class="editInput">ユーザー名</p>
				<input type="text" name="name">
				<p class="editInput">パスワード</p>
				<input type="password" name="password"><br> <input
					type="submit" value="サインイン" class="btnSignIn">
			</form>
		</div>
		<p>
			<a href="regist.jsp" class="textSignUp">アカウントを作成</a>
		</p>
	</div>
</body>
</html>