<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<title>生徒管理システム</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/styles.css">
</head>
<body>
	<div class="updateStudent-body">
		<h1 class="updateStudent-title">生徒情報更新</h1>
		<p>
			<c:out value="${message }"></c:out>
		</p>
		<form action="updateRegistStudent" method="POST">
			<input type="hidden" name="user_id" value="${user_id }"> <input
				type="hidden" name="student_id" value="${student.id }">

			<div class="updateStudent-date">
				<p class="updateStudent-text">登録日</p>
				<input type="date" name="date"
					value="<c:out value="${student.regist_date }"/>"
					class="updateStudent-input">
			</div>

			<div class="updateStudent-name">
				<p class="updateStudent-text">氏名</p>
				<input type="text" name="name"
					value="<c:out value="${student.name }"/>"
					class="updateStudent-input">
			</div>

			<div class="updateStudent-ruby">
				<p class="updateStudent-text">ふりがな</p>
				<input type="text" name="ruby"
					value="<c:out value="${student.ruby }"/>"
					class="updateStudent-input">
			</div>

			<div class="updateStudent-birthday">
				<p class="updateStudent-text">生年月日</p>
				<input type="date" name="birthday"
					value="<c:out value="${student.birthday }"/>"
					class="updateStudent-input">
			</div>

			<div class="updateStudent-sex">
				<p class="updateStudent-text">性別</p>
				<input type="text" name="sex"
					value="<c:out value="${student.sex }"/>"
					class="updateStudent-input">
			</div>

			<div class="updateStudent-zipAddress">
				<p class="updateStudent-text">住所</p>
				<div>
					<input type="text" name="zip"
						value="<c:out value="${student.zip }"/>"
						class="updateStudent-inInput" placeholder="1234567"><br>
					<input type="text" name="address1"
						value="<c:out value="${student.address1 }"/>"
						class="updateStudent-inInput" placeholder="address1"><br>
					<input type="text" name="address2"
						value="<c:out value="${student.address2 }"/>"
						class="updateStudent-inInput" placeholder="address2">
				</div>
			</div>

			<div class="updateStudent-tel">
				<p class="updateStudent-text">連絡先</p>
				<input type="tel" name="tel"
					value="<c:out value="${student.tel }"/>"
					class="updateStudent-input" placeholder="090-1234-5678">
			</div>

			<div class="updateStudent-email">
				<p class="updateStudent-text">e-mail</p>
				<input type="email" name="email"
					value="<c:out value="${student.email }"/>"
					class="updateStudent-input">
			</div>

			<div class="updateStudent-school">
				<p class="updateStudent-text">学校名</p>
				<input type="text" name="school"
					value="<c:out value="${student.school }"/>"
					class="updateStudent-input">
			</div>

			<div class="updateStudent-grade">
				<p class="updateStudent-text">学年</p>
				<input type="text" name="grade"
					value="<c:out value="${student.grade }"/>"
					class="updateStudent-input">
			</div>

			<input type="submit" value="更新" class="updateStudent-submit">
		</form>

		<form action="deleteStudent" method="POST">
			<input type="hidden" name="user_id" value="${user_id }"> <input
				type="hidden" name="student_id" value="${student.id }"> <input
				type="submit" value="削除" class="updateStudent-submit">
		</form>
	</div>
</body>
</html>