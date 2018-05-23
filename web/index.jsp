
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="css/INDEX.css" rel="stylesheet" type="text/css">

</head>
<body>

<div class="container">
    <header>

        <nav class="secondary_header" id="menu">
            <ul>
                <li><a href="index.jsp">首页</a></li>
                <li><a href="">所有书籍</a></li>
                <li><a href="<%=path%>/personal.jsp">个人中心</a></li>
                <li><a href="">历史订单</a></li>
                <li><a href="">售后服务</a></li>
                <li><a href=""></a>购物车</li>
            </ul>
        </nav>
    </header>
    <br>

    <section>

        <article class="left_article">
            <h3> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;没有人能比迟子建 更能击中那些世情中的善恶 </h3>
            <p>过了凛冽的寒冬，南下的候鸟就要北归了。也不知什么时候起，瓦城里的人像候鸟一样爱上了迁徙。冬天到南方避寒，夏天回到瓦城消暑。</p>
            <p>&nbsp;一场疑似禽流感的风波爆发，令候鸟成了正义的化身。在瓦城人看来候鸟怕冷又怕热，是个十足的孬种。可如今，人们却开始称赞候鸟的勇敢。小城看似平静安逸，却是盘根错节，暗流涌动，城外世外桃源般的自然保护区，与管护站遥遥相对的娘娘庙都未曾远离俗世，动物和人类在各自的利益链中，浮沉烟云…… </p>
        </article>
        <aside class="right_article"><a href="">
            <img src="http://img62.ddimg.cn/upload_img/00608/zyc/chizijian750315-1525673539.jpg" alt="" width="400" height="200" class="placeholder"/>
        </a> </aside>
    </section>
    <div class="row">
        <div class="new_book">
            <h3>新书上架</h3>
            <hr>
        </div>
        <div class="columns">
            <p class="thumbnail_align"> <img src="http://img3m8.ddimg.cn/42/10/25228608-1_l_20.jpg" alt="" class="thumbnail"/> </p>
            <h4>刺杀骑士团长</h4>
            <p  align="center">[日]村上春树 著，林少华 译</p>
        </div>
        <div class="columns">
            <p class="thumbnail_align"> <img src="http://img3m7.ddimg.cn/15/1/25233927-1_l_2.jpg" alt="" class="thumbnail"/> </p>
            <h4>橘子不是唯一的水果</h4>
            <p align="center"> （英）珍妮特·温特森  </p>
        </div>
        <div class="columns">
            <p class="thumbnail_align"> <img src="http://img3m2.ddimg.cn/60/23/25252782-1_l_1.jpg" alt="" class="thumbnail"/> </p>
            <h4>住在书里的小熊托奥</h4>
            <p align="center">（英）凯蒂·克莱明</p>
        </div>
        <div class="columns">
            <p class="thumbnail_align"> <img src="http://img3m9.ddimg.cn/45/3/25247619-1_l_11.jpg" alt="" class="thumbnail"/> </p>
            <h4>医学就会 </h4>
            <p align="center">懒兔子</p>
        </div>
    </div>

    <div class="copyright">&copy;2018 - <strong>BookStore</strong></div>
</div>
</body>
</html>

