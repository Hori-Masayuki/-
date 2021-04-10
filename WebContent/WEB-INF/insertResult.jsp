<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>生徒管理システム</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/styles.css">
</head>
<body>
	<div class="insertResult-body">
		<p><c:out value="${message }"></c:out></p>
		<h1 class="insertResult-title">成績入力</h1>
		<form action="registResult" method="POST">
			<input type="hidden" name="user_id" value="${user_id }">

			<div class="insertResult-student">
				<p class="insertResult-text">生徒名</p>
				<select name="student_id" class="insertResult-input">
					<c:forEach var="student" items="${studentList }">
						<option value="${student.id}"><c:out value="${student.grade}:${student.name}"></c:out></option>
					</c:forEach>
				</select>
			</div>

			<div class="insertResult-semester">
				<p class="insertResult-text">セメスター</p>
				<select name="semester" class="insertResult-input">
					<option value="一学期">一学期</option>
					<option value="二学期">二学期</option>
					<option value="三学期">三学期</option>
				</select>
			</div>

			<div class="insertResult-test_date">
				<p class="insertResult-text">テスト日</p>
				<input type="date" name="test_date" class="insertResult-input" placeholder="2020/04/01">
			</div>

			<div class="insertResult-test_name">
				<p class="insertResult-text">テスト名</p>
				<input type="text" name="test_name" class="insertResult-input" placeholder="実力テスト">
			</div>

			<table>
				<thead>
					<tr>
						<th class="insertResult-th">英語</th>
						<th class="insertResult-th">数学</th>
						<th class="insertResult-th">国語</th>
						<th class="insertResult-th">理科</th>
						<th class="insertResult-th">社会</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" name="english"
							class="insertResult-inputNum"></td>
						<td><input type="text" name="math"
							class="insertResult-inputNum"></td>
						<td><input type="text" name="japanese"
							class="insertResult-inputNum"></td>
						<td><input type="text" name="science"
							class="insertResult-inputNum"></td>
						<td><input type="text" name="society"
							class="insertResult-inputNum"></td>
					</tr>
				</tbody>
			</table>

			<table>
				<thead>
					<tr>
						<th class="insertResult-th">音楽</th>
						<th class="insertResult-th">体育</th>
						<th class="insertResult-th">技家</th>
						<th class="insertResult-th">美術</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" name="music"
							class="insertResult-inputNum"></td>
						<td><input type="text" name="physical"
							class="insertResult-inputNum"></td>
						<td><input type="text" name="tech_home"
							class="insertResult-inputNum"></td>
						<td><input type="text" name="art"
							class="insertResult-inputNum"></td>
					</tr>
				</tbody>
			</table>

			<input type="submit" value="保存" class="insertResult-submit">
		</form>
	</div>
</body>
</html>