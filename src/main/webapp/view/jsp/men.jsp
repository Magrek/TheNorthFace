<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Men's</title>
</head>
<body>

<jsp:include page="header.jsp"/>
<jsp:include page="categories.jsp"/>

<div class="container-fluid">
    <div class="row">
        <table>
            <thead>
                <h2 class="text-center">MEN'S</h2>
            </thead>
            <tbody>
            <tr>
                <th>
                    <a href="/climbing">
                        <img class="img-responsive" src="static/images/categories/men/climbing/climbing.png" style="width:90%">
                        <h4 class="text-center">SHOP CLIMBING</h4>
                    </a>
                </th>
                <th>
                    <a href="#">
                        <img class="img-responsive" src="static/images/categories/men/jackets.jpg" style="width:90%">
                        <h4 class="text-center">SHOP MEN'S RAINWEAR</h4>
                    </a>
                </th>
                <th>
                    <a href="#">
                        <img class="img-responsive" src="static/images/categories/men.jpg" style="width:90%">
                        <h4 class="text-center">SHOP THE TECHNO HOODIE</h4>
                    </a>
                </th>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<div class="footer navbar-fixed-bottom">
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>