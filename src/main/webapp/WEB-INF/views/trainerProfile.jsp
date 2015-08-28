<%-- 
    Document   : trainerProfile
    Created on : Aug 17, 2015, 12:33:04 AM
    Author     : DFostic1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/resources/SoccerBall.ico" rel="icon" type="image/x-icon" />
        <title>Trainer Info</title>
    </head>
    <body>
        <form>
            <fieldset>
                <legend>Trainer details</legend><br><br>

                First name(*): <c:out value="${trainer.firstName}" /> <br><br>
                Last name(*): <c:out value="${trainer.lastName}" /><br><br>
                Age(*): <c:out value="${trainer.age}" /><br><br>

                <button onclick="window.location = '/trainer/create';
                        return false;">Return</button>&nbsp;&nbsp;&nbsp;&nbsp;

                <button onclick="window.location = '/';
                        return false;">Home</button>
            </fieldset>
        </form>
    </body>
</html>
