<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 6/14/2019
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add New Phone</h1>
<div>
    <form action="/phone/addnew" method="post">
    <div>
      Name :  <input type="text" name="name">
    </div>
    <div>
       <select name="brand">
           <option value="Other">Other</option>
           <option value="Apple">Apple</option>
           <option value="SamSung">SamSung</option>
           <option value="Nokia">Nokia</option>
       </select>
</div>
    <div>
      Price :  <input type="number" name="price">
    </div>
    <div>
      Description :  <input type="text" name="description">
    </div>
    <div>
        <input type="submit" value="Submid">
        <input type="reset" value="Reset">
    </div>
    </form>
</div>

</body>
</html>
