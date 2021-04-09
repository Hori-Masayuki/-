<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<title>生徒管理システム</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/styles.css">
</head>
<body>
	<div class="welcome-body">
		<p>${message }</p>
		<form action="/insertStudent.jsp">
		<input type="submit" value="新規生徒登録" class="welcome-link">
		</form>
		<form action="selectStudent" method="POST">
			<input type="submit" value="生徒一覧" class="welcome-link">
		</form>
		<form action="insertResult" method="POST">
			<input type="submit" value="新規成績入力" class="welcome-link">
		</form>
		<form action="selectResult" method="POST">
			<input type="submit" value="成績一覧" class="welcome-link">
		</form>
	</div>
</body>
</html>