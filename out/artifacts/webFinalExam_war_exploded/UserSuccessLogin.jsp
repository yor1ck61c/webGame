<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:directive.page import="web.listener.onlineListener"/>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/jquery@3.4.1/dist/jquery.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="https://lib.sinaapp.com/js/jquery/2.0.2/jquery-2.0.2.min.js"></script>

    <title>认真学习认真游戏</title>

    <style>
        .bg {
            background: url('img/bgp.jpg');
            height: 820px;
            text-align: center;
            line-height: 800px;
        }
        .bg-blur {
            float: left;
            width: 100%;
            background-repeat: no-repeat;
            background-position: center;
            background-size: cover;
            -webkit-filter: blur(15px);
            -moz-filter: blur(15px);
            -o-filter: blur(15px);
            -ms-filter: blur(15px);
            filter: blur(15px);
        }
        .content-front {
            position:absolute;
        }
    </style>

</head>
<body>
<div class="bg bg-blur"></div>
<div class="content-front container-fluid">
    <div style="margin-right: 30px; margin-top: 10px"><a class="lead btn btn-primary-outline btn-sm border " href="quitServlet?id=${sessionScope.userInfo.id}" style=" color: aquamarine; margin-top: 15px; float: right;">退出登录</a></div>
    <div class="row">
        <div style="margin-top: 110px; margin-left: 220px; ">

            <h1 class="display-4" style="color:gainsboro">${sessionScope.time},${sessionScope.userInfo.username}</h1>
            <p class="lead" style="margin-top: 30px; color: gold">当前在线人数:${sessionScope.onlinePlayers}</p><%--<%=onlineListener.count%>--%>
            <hr class="my-4 "style="margin-top: 90px">
            <p  style="color:burlywood; margin-top: 50px">您的段位 : ${sessionScope.userInfo.ranking}</p>
            <p  style="color:burlywood; margin-top: 50px">最长坚持时间 :${sessionScope.userInfo.gamingTime}</p>
            <div style="margin-top: 100px">
                <a class="btn btn-primary-outline btn-lg border rounded-pill" href="gamingPage.jsp" role="button" style="margin-left: 250px; color: gainsboro">我要玩游戏</a>
                <a class="btn btn-primary-outline btn-lg border rounded-pill" href="findUserByPageServlet" role="button" style="margin-left: 150px; color: gainsboro">查看排行榜</a>
                <a class="btn btn-primary-outline btn-lg border rounded-pill" href="changeUserInfoServlet1?id=${sessionScope.userInfo.id}" role="button" style="margin-left: 150px; color: gainsboro">修改我的信息</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>