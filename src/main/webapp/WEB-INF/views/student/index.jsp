<%@ page  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>学生列表</title>
</head>
<body>
			<h4 align="center">学生信息详情表</h4>
	<table border="1" width="800px" align="center"">
		<tr align="center">
			<td>编号</td>
			<td>姓名</td>
			<td>生日</td>
			<td>性别</td>
			<td>操作</td>
		</tr>
		<c:forEach var="student" items="${student}">
		<tr align="center">
			<td>${student.id }</td>
			<td>${student.name }</td>
			<td><f:formatDate value="${student.birthday}" pattern="yyyy:MM:dd"/> </td>
			<td>${student.gender }</td>
			 <td>
				<a href="students/${student.id }/update">修改</a>
				
				<a href="${pageContext.request.contextPath }/students/${student.id }/delete">删除
				<a href="students/save">添加</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>