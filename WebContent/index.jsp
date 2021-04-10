<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<title>生徒管理システム</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/styles.css">
</head>
<body>
	<div class="index-body">
		<p>${message }</p>
		<h1 class="index-signIn">サインイン</h1>
		<div class="index-signIn-screen">
			<form action="login" method="POST">
				<p class="index-text">ユーザー名</p>
				<input type="text" name="name" class="index-input">
				<p class="index-text">パスワード</p>
				<input type="password" name="password" class="index-input">
				<input type="submit" value="サインイン" class="index-btn">
			</form>
		</div>
		<p>
			<a href="regist.jsp" class="index-signUp">アカウントを作成</a>
		</p>
	</div>
</body>
</html>