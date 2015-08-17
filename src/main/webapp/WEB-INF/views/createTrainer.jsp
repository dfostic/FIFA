<%-- 
    Document   : createTrainer
    Created on : Aug 8, 2015, 1:33:58 PM
    Author     : dfostic1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Create Trainer</title>   
        <style>
            form {
                display: inline-block;
                height: 400px;
                width: 400px;
                position: relative;
                top: 10%;
                left: 30%;
            }
            fieldset {
                width: 50em;
                height: 50em;
            }
            input {
                margin-left: 50px
            }
            select {
                margin-left:5em
            }
        </style>
    </head>
    <body>

    <sf:form method="POST" commandName="trainer">
        <sf:errors path="*" element="div" cssClass="errors"></sf:errors>
        <fieldset>
            <legend>Create player</legend><br><br>

            First name(*): <input type="text" name="FirstName" value="AAA"><br><br>
            Last name(*): <input type="text" name="LastName" value="BBB"><br><br>

            Date of Birth(*): <input type="text" name="dateOfBirth" value="1960-01-01"><br><br>
            <!--Date of Birth(*): <input type="date" name="dateOfBirth"><br><br>--> 

            Annual salary(*): <input type="text" name="salary" value="250000"><br><br>


            <input type="submit" value="Create" />
            <button onclick="window.location = '/';
                            return false;">Cancel</button>

            <br><br><br><br><br><br><br><br><br><br><br><br>
            <p><b>Note:</b> Date of Birth is not supported in older Internet Explorer.</p>

        </fieldset>
    </sf:form>
</body>
</html>
