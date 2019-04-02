<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Order Confirmation</title>
    <style><%@include file="../css/bagbtn.css"%></style>
</head>

<body>

<jsp:include page="header.jsp"/>
<jsp:include page="categories.jsp"/>

<h2 class="text-center">ORDER CONFIRMATION</h2>

<div class="text-center">
    <p>First Name: ${order.getFirstName()}</p>
    <p>Last Name:  ${order.getLastName()}</p>
    <p>Country:    ${order.getCountry()}</p>
    <p>Address:    ${order.getAddress()}</p>
    <p>Phone:      ${order.getPhone()}</p>
</div>
<div class="text-center">
    <form action="confirmation" method="post">
        <button type="submit" class="bag_btn">CONFIRM ORDER</button>
    </form>
</div>

<div class="footer navbar-fixed-bottom">
    <jsp:include page="footer.jsp"/>
</div>

</body>
</html>