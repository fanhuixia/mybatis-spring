<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

	<s:form modelAttribute="student">
	
		姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<s:input path="name" /><s:errors path="name"/>   <br/>
		性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<s:input path="gender"/><s:errors path="gender"/><br/>
		出生年月：<s:input path="birthday"/>
		<%--调用集合或者数组中“元素”对象的getText()方法      --%>
		
		<br /><br/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit">保存</button>
	</s:form>
