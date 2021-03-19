<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <title>用户信息</title>
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
<div class="content-front"><h1 class="display-4" style="margin-top: 100px; color: gainsboro;margin-left: 660px" >排行榜</h1></div>
<div class="content-front container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-7">
            <table class="table table-bordered" style="margin-top: 220px;margin-left: 150px;text-align: center ;color: gainsboro">
                <thead>
                <tr>
                    <th scope="col">用户名</th>
                    <th scope="col">段位</th>
                    <th scope="col">最长坚持时间</th>
                </tr>
                </thead>
                <c:forEach items="${requestScope.ranking.list}" var="ranking">
                    <tbody>
                    <tr>
                        <th scope="row">${ranking.username}</th>
                        <td>${ranking.ranking}</td>
                        <td>${ranking.gamingTime}</td>
                    </tr>
                    </tbody>
                </c:forEach>

            </table>
            <nav aria-label="Page navigation example" style="margin-left: 152px">
                <ul class="pagination">
                    <c:if test="${requestScope.ranking.currentPage == 1}">
                        <li class="page-item">
                            <a class="page-item disabled" href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${requestScope.ranking.currentPage != 1}">
                        <li class="page-item">
                            <a class="page-link " href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${requestScope.ranking.currentPage-1}&rows=5" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach begin="1" end="${requestScope.ranking.totalPage}" var="i">
                        <c:if test="${requestScope.currentPageInfo.currentPage == i}">
                            <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
                        </c:if>
                        <c:if test="${requestScope.currentPageInfo.currentPage != i}">
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
                        </c:if>

                    </c:forEach>
                    <c:if test="${requestScope.ranking.currentPage == requestScope.ranking.totalPage}">
                        <li class="page-item">
                            <a class="page-item disabled" href="" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${requestScope.ranking.currentPage != requestScope.ranking.totalPage}">
                        <li class="page-item">
                            <a class="page-link" href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${requestScope.ranking.currentPage + 1}&rows=5" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <span><h2 style="margin-left: 20px; color:gainsboro;">共${requestScope.ranking.totalCount}条记录，${requestScope.ranking.totalPage}页</h2></span>
                </ul>
            </nav>
        </div>
    </div>
    <a href="updateRankingServlet" class="btn btn-primary-outline btn-lg border rounded-pill" style="color: gainsboro; margin-left: 700px; margin-top: 10px">返回</a>


</div>
</body>
</html>