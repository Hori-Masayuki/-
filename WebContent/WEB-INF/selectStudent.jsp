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
	<div class="selectStudent-body">
		<h1 class="selectStudent-title">生徒一覧</h1>
		<c:forEach var="student" items="${studentList }">
			<form action="updateStudent" method="POST">
				<input type="hidden" name="user_id" value="${user_id }">
				<input type="hidden" name="student_id" value="${student.id}">
				<input type="submit" value="<c:out value="${student.grade}:${student.name}"/>" class="selectStudent-submit">
			</form>
		</c:forEach>
	</div>
</body>
</html>