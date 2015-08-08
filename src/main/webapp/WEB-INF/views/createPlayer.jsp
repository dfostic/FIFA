<%-- 
    Document   : createPlayer
    Created on : Aug 8, 2015, 1:33:46 PM
    Author     : dfostic1
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Create Player</title>
        <style>
            form {
                height:400px;
                width:400px;
                position: absolute;
                left: 30%;
                top: 30%;
                margin: -200px 0 0 -200px;
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
        </style>
    </head>

    <body>
        <form method="POST">
            <fieldset>
                <legend>Create player</legend><br><br>
                First name(*): <input type="text" name="FirstName" value=""><br><br>
                Last name(*): <input type="text" name="LastName" value=""><br><br>
                Date of Birth(*): <input type="text" name="dateOfBirth" value=""><br><br>
                Country(*): <input type="text" name="country" value=""><br><br>

                Country(*): <select>
                    <option value="Canada">Canada</option>
                    <option value="usa">USA</option>
                    <option value="Russia">Russia</option>
                    <option value="Spain">Spain</option>
                </select><br><br>

                Position(*): <input type="text" name="position" value=""><br><br>

                Position(*): <select>
                    <option value="Goalkeeper">Goalkeeper</option>
                    <option value="Defender">Defender</option>
                    <option value="Midfielder">Midfielder</option>
                    <option value="Forward">Forward</option>
                </select><br><br>

                Annual salary(*): <input type="text" name="salary" value=""><br><br>
                Statistics(*): <input type="text" name="goals" value="number of goals"><br><br>
                <input type="text" name="bookings" value="number of bookings"><br><br>


                <input type="submit" value="Create" />
                <button onclick="window.location = '/';
                        return false;">Cancel</button>
                
            </fieldset>
        </form>
    </body>

</html>
