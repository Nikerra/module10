<%@ page contentType="text/html; charset=UTF-8" language = "java" isELIgnored="false" %>
<html>
    <head>
        <title>Deposit profitability calculator</title>
    </head>
    <body>
        <h1>Deposit profitability calculator</h1>
        <form method = "post" action="">
            <p>Amount at the time of opening:<input name="amount"></p>
            <p>Interest rate:<input name="percent"></p>
            <p>Number of years:<input name="years"></p>
            <p><input type="submit" value="Result"></p>
            <hr>
            <a href="http://localhost:8081/webapp/jsp">Back</a>
        </form>
    </body>
</html>