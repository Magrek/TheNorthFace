<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bag</title>
    <link rel="image" href="view/css/image.css"/>
    <link rel="image" href="view/css/polaroid.css"/>
    <link rel="image" href="view/css/imageAlign.css"/>
    <style><%@include file="../css/gallery.css"%></style>
    <style><%@include file="../css/bagbtn.css"%></style>
</head>

<body>

<jsp:include page="header.jsp"/>

<div
<jsp:include page="categories.jsp"/>

<h2 class="text-center">BAG</h2>

<div class="row">
    <c:choose>
        <c:when test="${bag.isEmpty() || empty bag}">
            <div class="text-center">
                <img src="static/images/cart_empty.png" style="width:20%"/>
                <div>
                    <a class="bag_btn" href="/">SHOP NOW</a>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <c:forEach items="${bag}" var="product">
                <div class="gallery">
                    <img src="static/images/categories/men/climbing/${product.getTitle().replaceAll("\\W","")}.png"/>
                    <div class="desc">
                        <p>${product.getTitle()}</p>
                        <p>${product.getPrice()}$</p>
                    </div>
                    <form method="post">
                        <input type="hidden" name="id" value="${product.getId()}"/>
                        <button type="submit" class="button" method="post">Delete From Cart</button>
                    </form>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>

<c:if test="${bag.size() > 0}">
    <div class="col-xs-2">
    </div>
    <div class="col-xs-10 text-center">
        <a class="bag_btn" href="/checkout">CHECKOUT</a>
    </div>
</c:if>

<jsp:include page="footer.jsp"/>

</body>
</html>