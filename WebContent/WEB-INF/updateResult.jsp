<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<title>生徒管理システム</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/styles.css">
</head>
<body>
<c:forEach var="result" items="${resultList }">
<p>${result.student_id }</p>
<p>${result.semester }</p>
<p>${result.test_date }</p>
<p>${result.test_name }</p>
<p>${result.english }</p>
<p>${result.math }</p>
<p>${result.japanese }</p>
<p>${result.science }</p>
<p>${result.society }</p>
<p>${result.music }</p>
<p>${result.tech_home }</p>
<p>${result.physical }</p>
<p>${result.art }</p>
</c:forEach>
</body>
</html>