<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<title>生徒管理システム</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/styles.css">
</head>
<body>
	<div class="insertStudent-body">
		<h1 class="insertStudent-title">新規生徒登録</h1>
		<p><c:out value="${message }"></c:out></p>
		<form action="registStudent" method="POST">
			<input type="hidden" name="user_id" value="${user_id }">

			<div class="insertStudent-date">
				<p class="insertStudent-text">登録日</p>
				<input type="date" name="date" class="insertStudent-input" placeholder="2020/04/01">
			</div>

			<div class="insertStudent-name">
				<p class="insertStudent-text">氏名</p>
				<input type="text" name="name" class="insertStudent-input">
			</div>

			<div class="insertStudent-ruby">
				<p class="insertStudent-text">ふりがな</p>
				<input type="text" name="ruby" class="insertStudent-input">
			</div>

			<div class="insertStudent-birthday">
				<p class="insertStudent-text">生年月日</p>
				<input type="date" name="birthday" class="insertStudent-input" placeholder="1990/04/01">
			</div>

			<div class="insertStudent-sex">
				<p class="insertStudent-text">性別</p>
				<select name="sex" class="insertStudent-input">
					<option value="男">男</option>
					<option value="女">女</option>
					<option value="無回答">無回答</option>
				</select>
			</div>

			<div class="insertStudent-zipAddress">
				<p class="insertStudent-text">住所</p>
				<div>
					<input type="text" name="zip" class="insertStudent-inInput"
						placeholder="1234567"><br>
					<input type="text"
						name="address1" class="insertStudent-inInput" placeholder="address1"><br>
					<input type="text" name="address2" class="insertStudent-inInput"
						placeholder="address2">
				</div>
			</div>

			<div class="insertStudent-tel">
				<p class="insertStudent-text">連絡先</p>
				<input type="tel" name="tel" class="insertStudent-input" placeholder="090-1234-5678">
			</div>

			<div class="insertStudent-email">
				<p class="insertStudent-text">e-mail</p>
				<input type="email" name="email" class="insertStudent-input">
			</div>

			<div class="insertStudent-school">
				<p class="insertStudent-text">学校名</p>
				<input type="text" name="school" class="insertStudent-input">
			</div>

			<div class="insertStudent-grade">
				<p class="insertStudent-text">学年</p>
				<select name="grade"class="insertStudent-input">
					<option value="小1">小1</option>
					<option value="小2">小2</option>
					<option value="小3">小3</option>
					<option value="小4">小4</option>
					<option value="小5">小5</option>
					<option value="小6">小6</option>
					<option value="中1">中1</option>
					<option value="中2">中2</option>
					<option value="中3">中3</option>
					<option value="高1">高1</option>
					<option value="高2">高2</option>
					<option value="高3">高3</option>
				</select>
			</div>

				<input type="submit" value="保存" class="insertStudent-submit">
		</form>
	</div>
</body>
</html>