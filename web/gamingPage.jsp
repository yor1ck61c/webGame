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

    <title>马里奥大逃亡</title>

    <style>
        .bg {
            background: url('img/bgp.jpg');
            height: 800px;
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
<body>

<div class="bg bg-blur"></div>
<div class="container-fluid content-front">
    <div class="row">
        <div class="col-md-4">
            <canvas id="gameCanvas" width="600" height="600" style="margin-left: 150px; margin-top: 100px;"></canvas>
        </div>
        <div class="col-md-2"></div>
        <div class="col-md-4">
            <div id="gamingTime" class="lead" style="margin-top: 150px; margin-left: 150px; color: honeydew">最长坚持时间：0秒</div>
            <button  id="start" onclick="startGame()" type="button" class="btn btn-primary-outline btn-lg border rounded-pill" style="color: gainsboro; margin-left: 180px;margin-top: 100px">开始游戏</button><br>
            <form action="gamingTimeServlet">
                <input type="hidden" name="gamingTime" id="time">
                <button id="uploadTime" onclick="uploadTime()" type="submit" class="btn btn-primary-outline btn-lg border rounded-pill" style="color: gainsboro; margin-left: 200px;margin-top: 50px">存档</button>
            </form>
            <a href="updateRankingServlet" type="button" class="btn btn-primary-outline btn-lg border rounded-pill" style="color: gainsboro; margin-left: 200px;margin-top: 50px">返回</a>
            <div style="margin-left: 100px;margin-top: 50px;">
                <audio controls="controls" autoplay="autoplay" style="background-color: transparent">
                    <source src="bgm/bgm.mp3" type="audio/mpeg" />
                    Your browser does not support the audio element.
                </audio>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" >
    var canvas = document.getElementById("gameCanvas");
    var ctx = canvas.getContext("2d");

    //定义游戏场景
    var bgReady = false;
    var bgImage = new Image();
    bgImage.src = "img/background1.png";
    bgImage.onload = function(){
        bgReady = true;
    }

    //定义mario对象样式
    var marioReady = false;
    var marioImage = new Image();
    marioImage.src = "img/marioJR.gif";
    marioImage.onload = function(){
        marioReady = true;
    }

    //定义怪物样式
    var monsterReady = false;
    var monsterImage = new Image();
    monsterImage.src = "img/monster.png";
    monsterImage.onload = function(){
        monsterReady = true;
    }

    //定义mario初始参数
    var mario = {
        speed: 256,
        x: canvas.width/2,
        y: canvas.height/2
    }

    //定义怪物初始参数
    function monster() {
        this.x = Math.random() * canvas.width;
        this.y = Math.random() * canvas.height;
        this.speed = 100;
        this.xDirection = 1;
        this.yDirection = 1;
        this.move = function (modifier) {
            this.x += this.xDirection * this.speed * modifier;
            this.y += this.yDirection * this.speed * modifier;
            if (this.x >= canvas.width - 32)
            {
                this.x = canvas.width - 32;
                this.xDirection = -1;
            }else if (this.x <= 0)
            {
                this.x = 0;
                this.xDirection = 1;
            }else if (this.y >= canvas.height - 32)
            {
                this.y = canvas.height - 32;
                this.yDirection = -1;
            }else if (this.y <= 0)
            {
                this.y = 0;
                this.yDirection = 1;
            }
        };
    }


    var monsterSum;
    var monsterList;

    function createMonster(){
        monsterSum = 0;
        monsterList = new Array();
        monsterList[monsterSum] = new monster();
    }




    var keysDown = {};

    //添加键盘操作监控事件
    addEventListener(
        "keydown",
        function (e) {
            keysDown[e.keyCode] = true;
        },
        false
    );
    addEventListener(
        "keyup",
        function (e) {
            delete keysDown[e.keyCode];
        }
    );

    //定义移动事件
    var Move = function (modifier) {

        if (38 in keysDown) {
            mario.y -= mario.speed * modifier;
        }
        if (40 in keysDown) {
            mario.y += mario.speed * modifier;
        }
        if (37 in keysDown) {
            mario.x -= mario.speed * modifier;
        }
        if (39 in keysDown) {
            mario.x += mario.speed * modifier;
        }

        if (mario.x >= canvas.width - 32) {
            mario.x = 0;
        }else if (mario.x <= 0) {
            mario.x = canvas.width - 32;
        }
        if (mario.y >= canvas.height - 32) {
            mario.y = 0;
        }else if (mario.y <= 0) {
            mario.y = canvas.height - 32;
        }

        for (var i = 0; i <= monsterSum; i++) {
            monsterList[i].move(modifier);
        }
    }

    //定义绘图事件
    var Draw = function () {
        if (bgReady) {
            ctx.drawImage(bgImage, 0 ,0);
            if (marioReady) {
                ctx.drawImage(marioImage, mario.x, mario.y);
            }

            if (monsterReady) {
                for (var i = 0; i <= monsterSum; i++)
                    ctx.drawImage(monsterImage, monsterList[i].x, monsterList[i].y);
            }
        }
        ctx.fillStyle = "rgb(250, 250, 250)";
        ctx.font =  "24px Helvetica";
        ctx.textAlign = "left";
        ctx.textBaseline = "top";
        last = Date.now() - start;
        ctx.fillText(last/1000, 12, canvas.height-590);
    };
    function upload(time) {
        document.getElementById("time").value = time;
    }

    function uploadTime() {
        upload(last/1000);
    };



    //
    var Check = function () {

        if (monsterSum != Math.floor(last / 5000)){
            monsterSum ++;
            monsterList[monsterSum] = new monster();
        }

        for (var i = 0; i <= monsterSum; i++) {
            if (
                (monsterList[i].x - 32) <= mario.x
                && mario.x <= (monsterList[i].x + 32)
                && (monsterList[i].y - 32) <= mario.y
                && mario.y <= (monsterList[i].y + 32)
            ) {
                end = Date.now();
                alert("不是吧阿sir就这水平？");
                End();
            }
        }
    }

    var End = function () {
        if (bgReady) {
            ctx.drawImage(bgImage, 0 ,0);
        }

        window.clearInterval(timer);
        getTime(last/1000);
        uploadTime();
        return;
    }

    var getTime = function (time) {
        var gamingTime = document.getElementById("gamingTime");
        gamingTime.innerHTML = "最长坚持时间 : " + time +"秒"
    }

    var main = function () {
        var now = Date.now();
        var delta = now - then;
        Move(delta / 1000);
        Draw();
        Check();

        then = now;
    };


    var then;
    var start;
    var timer;

    window.onload = function () {
        Draw();
    };

    function startGame(){
        keysDown = {};
        createMonster();
        then = Date.now();
        start = then;
        timer = setInterval(main, 1);

    }

</script>
</body>
</html>