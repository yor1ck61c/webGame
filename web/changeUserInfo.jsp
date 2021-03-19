<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <title>用户注册</title>
    <script type="text/javascript">
        var xmlHttp;
        function createXMLHttpRequest(){
            if(window.XMLHttpRequest){
                xmlHttp = new XMLHttpRequest();
            }else {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
        }
        function validate() {
            createXMLHttpRequest();
            var username = document.getElementById("username").value;
            var url = "validationServlet?username="+username;
            xmlHttp.open("GET",url,true);
            xmlHttp.onreadystatechange = handleStateChange;
            xmlHttp.send(null);
        }
        function handleStateChange() {
            if (xmlHttp.readyState == 4) {
                if (xmlHttp.status == 200) {
                    var message = xmlHttp.responseXML.getElementsByTagName("message")[0].firstChild.data;
                    alert(message);
                }
            }
        }
        function checkUsername() {
            var username = document.getElementById("username").value;
            var reg = /^\S{1,8}$/;
            var flag = reg.test(username);
            var uPrompt = document.getElementById("username_prompt");
            if (flag) {
                uPrompt.innerHTML = "";
                return true;
            } else {
                uPrompt.innerHTML = "用户名格式有误,格式：1-8个任意字符";
                return false;
            }
        }

        function checkPassword() {
            var password = document.getElementById("password").value;
            var reg = /^\w{8,16}$/;
            var flag = reg.test(password);
            var uPrompt = document.getElementById("password_prompt");
            if (flag) {
                uPrompt.innerHTML = "";
                return true;
            } else {
                uPrompt.innerHTML = "密码格式有误。格式：8-16个英文字符或数字";
                return false;
            }
        }


        window.onload = function () {
            document.getElementById("form").onsubmit=function () {
                return checkUsername() && checkPassword();
            }
        }

        function changeCode() {
            var img = document.getElementById("codeImg");
            var time = new Date().getTime();
            img.src = img.src + "?" + time;
        }
    </script>
    <style>
        .bg {
            background: url('img/bgp.jpg');
            height: 1000px;
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
<body >
<div class="bg bg-blur"></div>
<div class="content-front container-fluid">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <h1 class="display-4" style="margin-top: 80px; text-align: center; color: gainsboro">修改我的信息</h1>
            <form id="form" action="${pageContext.request.contextPath}/changeUserInfoServlet2?id=${requestScope.userId}" method="post" style="margin-top: 50px; color: gainsboro" >
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input type="text" class="form-control" value="${requestScope.beforeChange.username}" name="username" id="username" placeholder="1-8个任意字符" onblur="checkUsername()" style="background-color: transparent; color: gainsboro"  aria-describedby="emailHelp">
                    <span id="username_prompt"></span>
                </div>
                <div class="form-group">
                    <label for="Password">密码</label>
                    <input type="password" class="form-control" value="${requestScope.beforeChange.password}" onblur="checkPassword()" name="password" id="password" placeholder="8~16位英文和数字的组合" style="background-color: transparent; color: gainsboro" id="Password">
                    <span id="password_prompt"></span>
                </div>
                <div class="form-group">
                    <label for="email">邮箱</label>
                    <input type="email" id="email" value="${requestScope.beforeChange.email}" class="form-control" name="email" placeholder="请输入邮箱" style="background-color: transparent; color: gainsboro" id="email">
                </div>
                <div class="form-group">
                    <label for="socialAccount">QQ/微信</label>
                    <input type="text" id="socialAccount" value="${requestScope.beforeChange.socialAccount}" class="form-control" name="socialAccount" placeholder="请输入QQ/微信" style="background-color: transparent; color: gainsboro" id="socialAccount">
                </div>
                <hr class="my-4">
                <button type="submit" class="btn btn-primary-outline btn-lg border rounded-pill" style="color: gainsboro; margin-left: 40%; margin-top: 10px">确认修改</button>
            </form>
        </div>
        <div class="col-md-4" style="margin-top: 235px;">
            <a href="#" style="color: gainsboro" onclick="validate()">检查用户名是否可用</a>
        </div>
    </div>
</div>