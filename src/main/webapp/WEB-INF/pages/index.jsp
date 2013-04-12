<%-- 
    Document   : index
    Created on : Apr 11, 2013, 11:13:20 PM
    Author     : pksu
--%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <h1>Index</h1>
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/list">List citations</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/add">Add citation</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/bibtex">Generate BibTeX</a>
            </li>
        </ul>
    </body>
</html>