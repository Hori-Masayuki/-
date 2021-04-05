<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生徒管理システム</title>
<link rel="stylesheet">
</head>
<body>
	<h1>新規登録</h1>
	<p>${message }</p>
	<form action="regist" method="POST">
		<p>お名前</p>
		<input type="text" name="name"><br>
		<p>メールアドレス</p>
		<input type="text" name="email"><br>
		<p>パスワード</p>
		<input type="password" name="password"> <input type="submit"
			value="登録">
	</form>
</body>
</html>