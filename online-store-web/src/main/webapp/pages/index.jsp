<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Simple Java web service</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
</head>
<body class="d-flex flex-column h-100">
<main class="flex-shrink-0">
    <div class="container">
        <h1 class="mt-5" style="color: seagreen">Hi! It's my home task number 25 .</h1>
        <div class="col-md-6">
            <h3 style="color: darkslategray">To view the list of items follow the link items:</h3>
            <ul class="icon-list">
                <a href="http://localhost:8080/items"><h2 class="m-4" style="color: #050a47">Items</h2></a>
            </ul>
        </div>
        <div class="col-md-6">
            <h3 style="color: darkslategray">To add new item follow the link  Add new item:</h3>
            <ul class="icon-list">
                <a href="http://localhost:8080/add-item"><h2 class="m-4" style="color: #050a47">Add new item</h2></a>
            </ul>
        </div>
    </div>
</main>
</body>
</html>