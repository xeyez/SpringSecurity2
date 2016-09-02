<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 가입</title>
</head>
<body>

<form:form method="post" commandName="newUser">
    ID : <form:input path="userid"/> 
    <form:errors path="userid"/> <br/>
    
    암호 : <form:password path="userpw"/> 
    <form:errors path="userpw"/> <br/>
    
    암호 확인 : <form:password path="confirm"/> 
    <form:errors path="confirm"/> <br/>
    
    <input type="submit" value="가입" />
</form:form>

</body>
</html>