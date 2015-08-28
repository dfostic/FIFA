<%-- 
    Document   : displayPlayer
    Created on : Aug 8, 2015, 5:20:20 PM
    Author     : dfostic1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/resources/SoccerBall.ico" rel="icon" type="image/x-icon" />
        <title>Player Info</title>
    </head>
    <body>
        <form>
            <fieldset>
                <legend>Player details</legend><br><br>

                First name(*): <c:out value="${player.firstName}" /> <br><br>
                Last name(*): <c:out value="${player.lastName}" /><br><br>
                Age(*): <c:out value="${player.age}" /><br><br>
                Country(*): <c:out value="${player.country}" /><br><br>
                Position(*): <c:out value="${player.position}" /><br><br>
                Annual salary(*): <c:out value="${player.salary}" /><br><br>
                Stats(*): <c:out value="${player.statistics.goals} goals"/>&nbsp;&nbsp;&nbsp;&nbsp;
                           <c:out value="${player.statistics.bookings} bookings"/> <br><br>
                           
                <!--<button type="button" onclick="/">Return</button>-->
                
                <button onclick="window.location = '/player/create';
                        return false;">Return</button>&nbsp;&nbsp;&nbsp;&nbsp;
                
                <button onclick="window.location = '/';
                        return false;">Home</button>
            </fieldset>
        </form>
    </body>
</html>
