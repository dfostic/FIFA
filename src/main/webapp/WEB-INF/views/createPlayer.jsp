<%-- 
    Document   : createPlayer
    Created on : Aug 8, 2015, 1:33:46 PM
    Author     : dfostic1
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link href="/resources/SoccerBall.ico" rel="icon" type="image/x-icon" />
        <title>Create Player</title>   
        <style>
            form {
                display: inline-block;
                height: 400px;
                width: 400px;
                position: relative;
                top: 10%;
                left: 30%;
                /*margin: -200px 0 0 -200px;*/
            }
            input {
                /*text-indent: 300px;*/
                margin-left:50px
                    /*padding-left:5em*/
            }
            select {
                margin-left:5em
            }
            fieldset {
                width: 50em;
                height: 50em;
            }
            span.error {
                color: red;
            }
        </style>
    </head>

    <body>
        <sf:form method="POST" commandName="player">
            <sf:errors path="*" element="div" cssClass="errors"></sf:errors>
                <fieldset>
                    <legend>Create player</legend><br><br>

                    First name(*): <input type="text" name="FirstName" value="FirstName"><br><br>
                    Last name(*): <input type="text" name="LastName" value="LastName"><br><br>

                    Date of Birth(*): <input type="text" name="dateOfBirth" value="1993-01-01"><br><br>
                    <!--Date of Birth(*): <input type="date" name="dateOfBirth"><br><br>-->                

                    Country(*): <select name="country">
                        <option value="Canada">Canada</option>
                        <option value="USA">USA</option>
                        <option value="Russia">Russia</option>
                        <option value="Spain">Spain</option>
                    </select><br><br>

                    Position(*): <select name="position">
                        <option value="GOALKEEPER">Goalkeeper</option>
                        <option value="DEFENDER">Defender</option>
                        <option value="MIDFIELDER">Midfielder</option>
                        <option value="FORWARD">Forward</option>
                    </select><br><br>

                    Annual salary(*): <input type="text" name="salary" value="100000"><br><br>
                    Statistics(*): <input type="text" name="statistics.goals" value="0" size="3"> goals <br><br>
                    <input type="text" name="statistics.bookings" value="0" size="3"> bookings<br><br>


                    <input type="submit" value="Create" />
                    <button onclick="window.location = '/';
                        return false;">Cancel</button>

                    <br><br><br><br><br><br><br><br><br><br><br><br>
                    <p><b>Note:</b> Date of Birth is not supported in older Internet Explorer.</p>

                </fieldset>
        </sf:form>
    </body>

</html>
