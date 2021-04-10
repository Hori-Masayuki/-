<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<title>生徒管理システム</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/styles.css">
</head>
<body>
	<div class="regist-body">
		<p>${message }</p>
		<h1 class="regist-signUp">サインアップ</h1>
		<div class="regist-signUp-screen">
			<form action="regist" method="POST">
				<p class="regist-text">ユーザー名</p>
				<input type="text" name="name" class="regist-input">
				<p class="regist-text">メールアドレス</p>
				<input type="email" name="email" class="regist-input">
				<p class="regist-text">パスワード</p>
				<input type="password" name="password" class="regist-input" placeholder="8文字以上">
				<input type="submit" value="サインアップ" class="regist-btn">
			</form>
		</div>
		<p>
			<a href="index.jsp" class="regist-signIn">ログイン画面へ</a>
		</p>
	</div>
</body>
</html>