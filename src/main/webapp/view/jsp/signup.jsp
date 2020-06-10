<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>SignUp</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<div class="container-fluid">
    <div class="row">
        <div class="text-center">
            <form action="signup" method="post">
                <input type="text" name="username" placeholder="Username"/>
                <input type="password" name="password" placeholder="Password"/>
                <input type="password" name="repeat-password" placeholder="Repeat password"/>
                <input type="submit" name="Sign Up"/>
            </form>
        </div>
    </div>
</div>

<div class="footer navbar-fixed-bottom">
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>