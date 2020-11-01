<!DOCTYPE html>
<html>
<head>
    <title>carouselle</title>
</head>
<style type="text/css">
    *{margin: 0;padding: 0;}
    #div1{position: relative;border:1px solid #0ff;width:1100px; height: 180px;margin:50px auto 0;overflow: hidden;}
    #div1 ul{position: absolute;left: 0;}
    #div1 ul li{list-style: none;width:200px;float: left;padding: 10px;height: 160px;}
    #div1 ul li img{width:100%;}
</style>
<script type="text/javascript">
    window.onload=function(){
        var oDiv=document.getElementById('div1');
        var oUl=oDiv.getElementsByTagName('ul')[0];
        var aLi=oUl.getElementsByTagName('li');
        var aA=document.getElementsByTagName('a');//获取向右向左的箭头
        var timer=null;
        var iSpeed=10;
        oUl.innerHTML+=oUl.innerHTML;//定义图片可以循环播放
        oUl.style.width=aLi.length*aLi[0].offsetWidth+'px';//定义外层ul的宽度，根据图片的个数和每个图片的宽度计算，保证总宽度是可调整的
        function fnMove(){
            if(oUl.offsetLeft<-oUl.offsetWidth/2){
                oUl.style.left=0;
            }else if(oUl.offsetLeft>0){
                oUl.style.left=-oUl.offsetWidth/2+'px';
            }//定义到边界的时候，实现无缝衔接
            oUl.style.left=oUl.offsetLeft+iSpeed+'px';
//定义图片的右边距随着速度不断不断增加，或减小，实现运动的效果
        }
        timer=setInterval(fnMove,30);
        aA[0].onclick=function(){
            iSpeed=-10;
//按下左箭头，定义向左运动
        }
        aA[1].onclick=function(){
            iSpeed=10;
//按下右箭头，定义向右运动
        }
        oDiv.onmouseover=function(){
            clearInterval(timer);
//鼠标移动到图片上，清除定时器，停止运动
        }
        oDiv.onmouseout=function(){
            timer=setInterval(fnMove,30);
//鼠标移出，重新开启定时器，重新运动
        }
    };
</script>
<body>
<a href="javascript:;">clique vers gauche</a>
<a href="javascript:;">clique vers droite</a>
<div id="div1">
    <ul>
        <li><img src="flechG.png"></li>
        <li><img src="flechD.png"></li>
        <li><img src="search.png"></li>
        <div style="clear: none;"></div>
    </ul>
</div>
</body>
</html>