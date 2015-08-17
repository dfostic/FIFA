<%-- 
    Document   : trainerProfile
    Created on : Aug 17, 2015, 12:33:04 AM
    Author     : DFostic1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trainer Info</title>
    </head>
    <body>
        <form>
            <fieldset>
                <legend>Trainer details</legend><br><br>

                First name(*): <c:out value="${player.firstName}" /> <br><br>
                Last name(*): <c:out value="${player.lastName}" /><br><br>
                Age(*): <c:out value="${player.age}" /><br><br>

                <button onclick="window.location = '/player/create';
                        return false;">Return</button>&nbsp;&nbsp;&nbsp;&nbsp;

                <button onclick="window.location = '/';
                        return false;">Home</button>
            </fieldset>
        </form>
    </body>
</html>
