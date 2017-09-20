<%--
  Created by IntelliJ IDEA.
  User: dkw
  Date: 2017/9/18
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${aa}</h1>
<div id="body" style="width: 500px;height: 300px"></div>
消息：<input id="msg"/>
<button id="connect">发送</button>
</body>
<script type="text/javascript" src="/public/js/common/jquery-1.7.2.min.js"></script>
<script type="text/javascript">

    $(function () {
        var id="${id}";
        var name="${name}";
        var toId="${toId}"
        var websocket = null;
        //判断当前浏览器是否支持WebSocket
        if ('WebSocket' in window) {
            websocket = new WebSocket("ws://172.16.2.135:8080/socket/" + id + "/" + name);
        } else {
            alert('当前浏览器 Not support websocket')
        }
        //连接发生错误的回调方法
        websocket.onerror = function () {
            setMessageInnerHTML("WebSocket连接发生错误");
        }

        //连接成功建立的回调方法
        websocket.onopen = function () {
            setMessageInnerHTML("WebSocket连接成功");
        }

        //接收到消息的回调方法
        websocket.onmessage = function (event) {
            setMessageInnerHTML(event.data);
        }

        //连接关闭的回调方法
        websocket.onclose = function () {
            setMessageInnerHTML("WebSocket连接关闭");
        }


        //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
        window.onbeforeunload = function () {
            closeWebSocket();
        }
        function setMessageInnerHTML(innerHTML) {
            $("#body").append(innerHTML + "<br/>");
        }

        $("#connect").click(function () {
            var message = $("#msg").val();
            websocket.send(toJson(message));
        })
        function toJson(message){
            var json={};
            json.id=id;
            json.name=name;
            json.toId=toId;
            json.message=message;
            return JSON.stringify(json);
        }

    })


</script>
</html>
