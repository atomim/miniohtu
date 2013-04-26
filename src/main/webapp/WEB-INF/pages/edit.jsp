<%-- 
    Document   : add
    Created on : Apr 11, 2013, 11:21:50 PM
    Author     : pksu
--%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />  
    </head>
    <body>
        <div class="container">
            <h1>Edit</h1>
            
            <p>${message}</p>

            <form action='${pageContext.request.contextPath}/save' method='post'>
                <ul>
                    <li>

                        <label for='type'>Type:</label>
                        <select name="type">
                            <c:forEach var="type" items="${validTypes}">
                                <option>
                                    ${type}
                                </option>
                            </c:forEach>
                        </select>
                    </li>
                    <li>
                        <label for='shorthand'>shorthand: </label>
                        <input class='text' name="shorthand" type='text' value="${existingData.shorthand}">
                    </li>
                    <c:forEach var="existingItem" items="${existingData.entries}">
                        <li>
                            <label for='${existingItem.key}'>${existingItem.key}: </label>
                            <input class='text' name="${existingItem.key}" type='text' value="${existingItem.value}">
                        </li>
                    </c:forEach>
                    <button type="button" id="newForm">New field</button>
                    <div id="formSpace"></div>
                    <input class='button' id="add" type='submit' value='Edit citation'>
                </ul>
            </form>
            <br/>
            <a href="${pageContext.request.contextPath}/">Back</a>
        </div>
        <script src="<c:url value="${pageContext.request.contextPath}/resources/js/jquery.js"/>"/></script>
    <script src="<c:url value="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"/>"/></script>
<script src="<c:url value="${pageContext.request.contextPath}/resources/js/form.js"/>"/></script>
</body>
</html>
