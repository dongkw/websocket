<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dkw
  Date: 2017/9/19
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 用户ID:<input id="id"><br/>
 用户名：<input id="name"> <br/>
 <button id="submit">进入</button>
<hr>
 <ul id="ul">

<c:forEach items="${list}" var="u">
<li value="${u.id}">${u.name}</li>


</c:forEach>
 </ul>
</body>
<script type="text/javascript" src="/public/js/common/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/public/js/common/httpRequest.js"></script>
<script type="text/javascript">
    $(function(){
        $("#submit").click(function(){
           var id=$("#id").val();
           var name=$("#name").val();
            post("/index",{id:id,name:name});
        });
        $("#ul").on("click","li",function(){
            var id=$("#id").val();
            var name=$("#name").val();
            var toId=$(this).val();
            post("/index",{id:id,name:name,toId:toId});
        })
    })

</script>
</html>
