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
        <title>Add an article</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />  
    </head>
    <body>
        <div class="container">
            <h1>Add an article reference</h1>

            <form action='' method='post'>
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
                        <label for='booktitle'>Title:</label>
                        <input class='text' name="entryMap['title']" type='text'>
                    </li>
                    <li>
                        <label for='author'>Author:</label>
                        <input class='text' name="entryMap['author']" type='text'>
                    </li>
                    <li>
                        <label for='year'>Year:</label>
                        <input class='text' name="entryMap['year']" type='text'>
                    </li>
                    <li>
                        <label for='publisher'>Publisher:</label>
                        <input class='text' name="entryMap['publisher']" type='text'>
                    </li>
                    <input class='button' id="add" type='submit' value='Add citation'>
                </ul>
            </form>
            <br/>
            <a href="${pageContext.request.contextPath}/">Back</a>
        </div>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" />

    </body>
</html>
