<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
</head>
<body>

<c:if test="${param.error == 'true'}">
<strong>아이디와 암호가 일치하지 않습니다.</strong>
</c:if>
<form action="<c:url value='/user/login'/>" method="post">
	<input type="hidden" name="returl" value="${param.returl}">

    <label for="name">사용자ID</label>:
    <input type="text" name="userid" /> 
    <br/>
    
    <label for="password">암호</label>:
    <input type="password" name="password" /> 
    <br/>
    
    
    <input id = "remember_me" name ="_spring_security_remember_me" type = "checkbox" />Remember me
    <br />
    
    
    <input type="submit" value="로그인" />
</form>

</body>
</html>