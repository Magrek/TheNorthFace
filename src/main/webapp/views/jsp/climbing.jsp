<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Men's-Climbing</title>
    <link rel="image" href="views/css/image.css"/>
    <link rel="image" href="views/css/polaroid.css"/>
    <link rel="image" href="views/css/imageAlign.css"/>
    <style><%@include file="../css/gallery.css"%></style>
    <style><%@include file="../css/bagbtn.css"%></style>
</head>

<body>

<jsp:include page="header.jsp"/>
<jsp:include page="categories.jsp"/>

<h2 class="text-center">CLIMBING</h2>

<div class="row">
    <c:forEach items="${catalog}" var="product">
        <c:if test="${product.getQuantity() > 0}">
            <div class="gallery">
                <img src="static/images/categories/men/climbing/${product.getTitle().replaceAll("\\W","")}.png">
                <div class="desc">
                    <p>${product.getTitle()}</p>
                    <p>${product.getPrice()}$</p>
                </div>
                <form method="post">
                    <input type="hidden" name="id" value="${product.getId()}" />
                    <button type="submit" class="button" method="post">Add to Cart</button>
                </form>
            </div>
        </c:if>
    </c:forEach>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>