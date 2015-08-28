<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/resources/SoccerBall.ico" rel="icon" type="image/x-icon" />
        <title>--- FIFA ---</title>

        <style>
            form {
                height:300px;
                width:300px;
                position: absolute;
                left: 30%;
                top: 30%;
                margin: -150px 0 0 -150px;
            }
        </style>
    </head>

    <body>
        <form>
            <button onclick="window.location = '/player/create';
                    return false;">Create Player</button>&nbsp; &nbsp; &nbsp;

            &nbsp; &nbsp; &nbsp;        
            <button onclick="window.location = '/trainer/create';
                    return false;">Create Trainer</button></pre>
        </form>
    </body>
</html>
