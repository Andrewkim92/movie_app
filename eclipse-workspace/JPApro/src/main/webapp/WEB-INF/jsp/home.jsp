<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>home</title>
</head>
<body>
	<h1>홈 home</h1>

	<button><a href="writeBoard">공지사항 등록</a></button>
	<div id="boardArea">
		<table id="bList" width="800" border="3" bordercolor="lightgray">
			<tr heigh="30">
				<td>글번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>

			<c:forEach var="board" items="${voList}">
				<tr>
					<td>${board.id}</td>
					<td><a href="detailBoard?id=${board.id }">${board.subject}</a></td>
					<td>${board.writer}</td>
					<td>${board.createdDate}</td>
					<td>${board.cnt}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>