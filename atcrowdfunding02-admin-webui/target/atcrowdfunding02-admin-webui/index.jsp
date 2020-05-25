<%--
  Created by IntelliJ IDEA.
  User: liling
  Date: 2020/5/21
  Time: 5:28 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Title</title>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
</head>

<body>

    <script>

        $(function () {

            var student = {
                "sId": 1,
                "stuName": "张三",
                "address":{
                    "province":"广东",
                    "city":"深圳",
                    "street":"宝山"
                },
                "subjectList":[
                    {
                        "subjectName":"javaSE",
                        "subjectScore":100
                    },{
                        "subjectName":"jvm",
                        "subjectScore":99
                    }
                ],
                "map":{
                    "k1":"v1",
                    "k2":"v2"
                }
            };
            var responseBody2 = JSON.stringify(student);

            $("#btn3").click(function () {
                $.ajax({
                    "url":"send/student/three.json",
                    "type":"post",
                    "data":responseBody2,
                    "contentType":"application/json;charset=UTF-8",
                    "dataType":"json",
                    "success":function (response) {
                        console.log(response);
                    },
                    "error":function (response) {
                        console.log(response);
                    }
                });
            });


            var array = [5,8,12];
            var requestBody = JSON.stringify(array);

            $("#btn2").click(function () {
                $.ajax({
                    "url":"send/array/two.html",
                    "type":"post",
                    "data":requestBody,
                    "contentType": "application/json;charset=UTF-8",
                    "dataType": "text",
                    "success":function (response) {
                        alert(response);
                    },
                    "error":function (response) {
                        alert(response);
                    }
                });
            });


            $("#btn").click(function () {
                $.ajax({
                    "url":"send/array.html",
                    "type":"post",
                    "data":{
                        "array":[5,8,12]
                    },
                    "dataType": "text",
                    "success":function (response) {
                        alert(response);
                    },
                    "error":function (response) {
                        alert(response);
                    }
                });
            });


            $("#btn4").click(function () {
                layer.msg("layer的弹框");
            });
        });

    </script>

    <a href="test/ssm.html">测试ssm环境</a>
    <br>

    <button id="btn">test ajax</button>
    <br>

    <button id="btn2">test ajax</button>

    <br>

    <button id="btn3">test ajax</button>

    <br>
    <br>

    <button id="btn4">layer弹框</button>


</body>
</html>
