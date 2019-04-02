<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Checkout</title>
    <style><%@include file="../css/gallery.css"%></style>
    <style><%@include file="../css/bagbtn.css"%></style>
    <style><%@include file="../css/form.css"%></style>
</head>

<body>

<jsp:include page="header.jsp"/>
<jsp:include page="categories.jsp"/>

<h2 class="text-center">CHECKOUT</h2>

<div class="row">
    <c:forEach items="${bag}" var="product">
        <div class="gallery">
            <img src="static/images/categories/men/climbing/${product.getTitle().replaceAll("\\W","")}.png"/>
            <div class="desc">
                <p>${product.getTitle()}</p>
                <p>${product.getPrice()}$</p>
            </div>
        </div>
    </c:forEach>
</div>

<div class="col-xs-2">
</div>
<div class="col-xs-10 text-center">
    <div class="container">
        <form action="checkout" method="post">
            <div class="row">
                <div class="col-25">
                    <label for="fname">First Name</label>
                </div>
                <div class="col-75">
                    <input type="text" id="fname" name="firstname" placeholder="Your name..">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="lname">Last Name</label>
                </div>
                <div class="col-75">
                    <input type="text" id="lname" name="lastname" placeholder="Your last name..">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="country">Country</label>
                </div>
                <div class="col-75">
                    <select id="country" name="country">
                        <option value="australia">Australia</option>
                        <option value="canada">Canada</option>
                        <option value="usa">USA</option>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="address">Address</label>
                </div>
                <div class="col-75">
                    <input type="text" id="address" name="address" placeholder="Your address..">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="phone">Phone</label>
                </div>
                <div class="col-75">
                    <input type="text" id="phone" name="phone" placeholder="Your phone..">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="subject">Subject</label>
                </div>
                <div class="col-75">
                    <textarea id="subject" name="subject" placeholder="Write something.." style="height:200px"></textarea>
                </div>
            </div>
            <c:set var="totalPrice" value="${0}"/>
            <c:forEach items="${bag}" var="product">
                <c:set var="totalPrice" value="${totalPrice + product.getPrice()}"/>
            </c:forEach>
            <p>Total price: ${totalPrice}$</p>
            <input class="bag_btn" type="submit" href="/checkout" method="post" value="PLACE ORDER">
        </form>
    </div>

</div>

<jsp:include page="footer.jsp"/>

</body>
</html>