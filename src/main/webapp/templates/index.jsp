<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Newsfeed</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <style><%@include file="style.css"%></style>
</head>
<body>
<div class="container mt-5">

    <div class="container-fluid searchbar">
        <form class="d-flex" role="search">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="topic">
          <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
      </div>

    <h3>${batchsize} results found on ${query}</h3>

    <div id="news" name="news">
    <div class="row row-cols-1 row-cols-md-2 g-4">
        <c:forEach var="x" items="${news}">

          <div class="card-group">
            <div class="card">
              <img src="${x.imageurl}" class="card-img-top custom" alt="...">
              <div class="card-body">
                <h5 class="card-title"><a href=${x.url}>${x.title}</a></h5>
                <p class="card-text">${x.desc}</p>
              </div>
            </div>
          </div>

        </c:forEach>
    </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>

<script>
    if (window.history.replaceState) {
        window.history.replaceState(null, null, window.location.href);
    }
</script>
</body>
</html>