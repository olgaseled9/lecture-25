<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add new item</title>
</head>
<body>
<h1 class="mt-5" style="color: #703206">Add new item</h1>
    <form action="${pageContext.request.contextPath}/add-item" method="post" enctype="multipart/form-data">
    <p><b>Enter name:</b><br>
        <label>
            <input minlength="3" maxlength="30" name="name" type="text">
        </label></p>
    <p><b>Enter price:</b><br>
        <label>
            <input minlength="3" maxlength="30" name="price" type="text">
        </label></p>
    <p><b>Enter description</b><br>
        <label>
            <input minlength="3" maxlength="180" name="description" type="text">
        </label></p>
    <br>
        <tr>
            <th><label form="avatar" >Product image:</label></th>
            <td><input name="avatar" type="file"></td>
        </tr>
    <input value="Add new item!" type="submit">
</form>
</body>
</html>
