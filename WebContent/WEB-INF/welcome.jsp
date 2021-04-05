<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<title>生徒管理システム</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/styles.css">
</head>
<body>
	<div class="bodyHome">
		<p>ようこそ${name }さん</p>
		<p>あなたのIDは${id }です</p>
		<form action="insertStudent" method="POST">
			<input type="hidden" name="id" value="${id }"> <input
				type="submit" value="新規生徒登録" class="btnLink">
		</form>
		<form action="selectStudent" method="POST">
			<input type="hidden" name="id" value="${id }"> <input
				type="submit" value="生徒一覧" class="btnLink">
		</form>
		<form action="insertResult" method="POST">
			<input type="hidden" name="id" value="${id }"> <input
				type="submit" value="新規成績入力" class="btnLink">
		</form>
		<form action="selectResult" method="POST">
			<input type="hidden" name="id" value="${id }"> <input
				type="submit" value="成績一覧" class="btnLink">
		</form>
	</div>
</body>
</html>