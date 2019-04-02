<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
</head>

<body>
<nav class="navbar navbar-default ">
</nav>
<nav class="navbar navbar-inverse navbar-static-top navbar-fixed-top">
    <div class="container-fluid">
        <div class="row">
            <div class="col-xs-2 navbar-header">
                <a class="navbar-brand" href="index.jsp">TheNorthFace</a>
            </div>
            <div class="navbar-nav col-xs-7">
                <ul class="nav navbar-nav">
                    <li><a href="#"><span class="glyphicon glyphicon-map-marker"></span> Find A Store</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-heart"></span> Favorites</a></li>
                    <li><a href="/bag"><span class="glyphicon glyphicon-shopping-cart"></span> Bag</a></li>
                    <form class="navbar-form navbar-left form-horizontal">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                            <button type="submit" class="btn"><span class="glyphicon glyphicon-search"></span></button>
                        </div>
                    </form>
                </ul>
            </div>

            <div class="navbar-nav col-xs-3">
                <ul class="nav navbar-nav navbar-right">
                    <c:choose>
                        <c:when test="${isLoggedIn}">
                            <li><a href="#"><span class="glyphicon glyphicon-user"></span> ${username}</a></li>
                            <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Log Out</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="/signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                            <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Log In</a></li>
                        </c:otherwise>
                    </c:choose>
                    <li class="dropdown dropdown-menu-right">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">RU<span class="caret"></span></a>
                        <ul class="dropdown-menu nav navbar-nav">
                            <li><a href="#">UA</a></li>
                            <li><a href="#">EN</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>
</body>
