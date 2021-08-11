<%--
  Created by IntelliJ IDEA.
  User: Du
  Date: 2021/6/15
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
    <%--    bootstrap美化界面--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>
</div>
<form action="${pageContext.request.contextPath}/book/updateBook" method="post">

<%--   前端传递隐藏域--%>
    <input type="hidden" name="bookId" value="${Book.bookId}">

    <div class="form-group">
        <label>书籍名称</label>
        <input type="text" name="bookName" class="form-control" value="${Book.bookName}" required>
    </div>
    <div class="form-group">
        <label>书籍数量</label>
        <input type="text" name="bookNumber" class="form-control" value="${Book.bookNumber}" required>
    </div>
    <div class="form-group">
        <input type="submit" class="form-control" value="修改">
    </div>
</form>


</body>
</html>
