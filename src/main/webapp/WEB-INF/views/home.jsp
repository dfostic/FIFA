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
            <button style="color: purple; font-weight: bold" onclick="window.location = '/player/create';
                    return false;">Create Player</button>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button style="color: purple; font-weight: bold" onclick="window.location = '/trainer/create';
                    return false;">Create Trainer</button></pre>

        <br/><br/>
        <p>Player's REST implementation</p>
        <table>
            <c:forEach items="${playerList}" var="player">
                <br/><br/>
                <button style="color:blue; font-weight: bold" onclick="window.location = '/rest/player/id/${player.playerId}';
                        return false;">${player.lastName} ${player.firstName}</button>               

            </c:forEach>
        </table>

        <br><br><br><br>
        <button style="color: green; font-weight: bold" onclick="window.location = '/rest/player/all';
                return false;">View all players REST</button></pre>
    <br/>
    <p>Due to lack of time, could not do it looking better</p>
</form>
</body>
</html>
