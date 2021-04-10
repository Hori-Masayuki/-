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

	<div class="updateResult-name">
		<p class="updateResult-text">生徒名</p>
		<p class="updateResult-value"><c:out value="${student_name }"></c:out></p>
	</div>

	<c:forEach var="result" items="${resultList }">

		<div class="updateResult-body">

			<div class="updateResult-semester">
				<p class="updateResult-text">セメスター</p>
				<p class="updateResult-value"><c:out value="${result.semester }"></c:out></p>
			</div>

			<div class="updateResult-test_date">
				<p class="updateResult-text">テスト日</p>
				<p class="updateResult-value"><c:out value="${result.test_date }"></c:out></p>
			</div>

			<div class="updateResult-test_name">
				<p class="updateResult-text">テスト名</p>
				<p class="updateResult-value"><c:out value="${result.test_name }"></c:out></p>
			</div>

			<table>
				<thead>
					<tr>
						<th class="updateResult-th">英語</th>
						<th class="updateResult-th">数学</th>
						<th class="updateResult-th">国語</th>
						<th class="updateResult-th">理科</th>
						<th class="updateResult-th">社会</th>
						<th class="updateResult-th">五教科合計</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="updateResult-inputNum">${result.english }</td>
						<td class="updateResult-inputNum">${result.math }</td>
						<td class="updateResult-inputNum">${result.japanese }</td>
						<td class="updateResult-inputNum">${result.science }</td>
						<td class="updateResult-inputNum">${result.society }</td>
						<td class="updateResult-inputNum">${result.english + result.math+result.japanese+result.science+ result.society}</td>
					</tr>
				</tbody>
			</table>

			<table>
				<thead>
					<tr>
						<th class="updateResult-th">音楽</th>
						<th class="updateResult-th">技家</th>
						<th class="updateResult-th">体育</th>
						<th class="updateResult-th">美術</th>
						<th class="updateResult-th">九教科合計</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="updateResult-inputNum">${result.music }</td>
						<td class="updateResult-inputNum">${result.tech_home }</td>
						<td class="updateResult-inputNum">${result.physical }</td>
						<td class="updateResult-inputNum">${result.art }</td>
						<td class="updateResult-inputNum">${result.english + result.math+result.japanese+result.science+ result.society+result.music + result.tech_home + result.physical + result.art}</td>
					</tr>
				</tbody>
			</table>

			<form action="deleteResult" method="POST">
				<input type="hidden" name="user_id" value="${user_id}">
				<input type="hidden" name="result_id" value="${result.id}">
				<input type="submit" value="削除" class="updateResult-submit">
			</form>

		</div>
	</c:forEach>
</body>
</html>