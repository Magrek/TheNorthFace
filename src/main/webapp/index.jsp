<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>TheNorthFace</title>
</head>
<body>

<jsp:include page="views/jsp/header.jsp"/>

<div class="container-fluid">
    <div class="row">
        <jsp:include page="views/jsp/categories.jsp"/>
        <div class="col-xs-10">
            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>

                <div class="carousel-inner">
                    <div class="item active">
                        <img class="w-100" src="static/images/carousel/forest.jpg" alt="First slide">
                        <div class="carousel-caption">
                            <h3>Norway</h3>
                            <p>The most beautiful mountains of the world</p>
                        </div>
                    </div>

                    <div class="item">
                        <img class="w-100" src="static/images/carousel/wagons.jpg" alt="Second slide">
                        <div class="carousel-caption">
                            <h3>Thailand</h3>
                            <p>Through the misty forest</p>
                        </div>
                    </div>

                    <div class="item">
                        <img class="w-100" src="static/images/carousel/darksand.jpg" alt="Third slide">
                        <div class="carousel-caption">
                            <h3>Island</h3>
                            <p>Amazing dark beaches</p>
                        </div>
                    </div>
                </div>

                <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-2">
        </div>
        <div class="col-xs-10 text-center">
            <table>
                <thead>
                    <h2>CATEGORIES</h2>
                </thead>
                <tbody>
                    <tr>
                        <th>
                            <a href="/mens">
                                <img class="img-responsive" src="static/images/categories/men.jpg" alt="MEN'S" style="width:95%"/>
                                <h4 class="text-center">MEN'S</h4>
                            </a>
                        </th>
                        <th>
                            <a href="#">
                                <img class="img-responsive" src="static/images/categories/women.jpg" alt="WOMEN'S" style="width:95%"/>
                                <h4 class="text-center">WOMEN'S</h4>
                            </a>
                        </th>
                        <th>
                            <a href="#">
                                <img class="img-responsive" src="static/images/categories/kid.jpg" alt="KID'S" style="width:95%"/>
                                <h4 class="text-center">KID'S</h4>
                            </a>
                        </th>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<jsp:include page="views/jsp/footer.jsp"/>
</body>
</html>