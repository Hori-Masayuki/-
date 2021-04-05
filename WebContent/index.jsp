<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生徒管理システム</title>
<link rel="stylesheet">
</head>
<body>
	<h1>生徒管理システム</h1>
	<p>${message }</p>
	<p>ログイン画面</p>
	<form action="login" method="POST">
		<p>お名前</p>
		<input type="text" name="name"><br>
		<p>パスワード</p>
		<input type="password" name="password">
		<input type="submit" value="ログイン">
	</form>
	<p>
		新規登録は<a href="regist.jsp">こちら</a>
	</p>
</body>
</html>