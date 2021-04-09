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
	<div class="selectResult-body">
		<h1 class="selectResult-title">生徒一覧</h1>
		<c:forEach var="student" items="${studentList }">
			<form action="updateResult" method="POST">
				<input type="hidden" name="student_id" value="${student.id}">
				<input type="hidden" name="student_name" value="${student.name}">
				<input type="submit" value="${student.grade}:${student.name}" class="selectResult-submit">
			</form>
		</c:forEach>
	</div>
</body>
</html>