<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<h1>The Number Quiz</h1>
<p>Your current score is ${score}<%-- <%=session.getAttribute("score") %> --%>.</p>
<p>Guess the next number in the sequence.</p>
${currentQuiz }
<%-- <%=session.getAttribute("currentQuiz") %> --%>
<form action="QuizJspServlet" method="post">
    <p>
        Your answer: <input type="text" name="answer">
    </p>
    <input type="submit" value="Submit">
</form>

</body>
</html>