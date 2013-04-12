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
        <title>${message}</title>
    </head>
    <body>
        <h1>Index</h1>
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/list">Listaa viitteet</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/add">Lisää viite</a>
            </li>
        </ul>
    </body>
</html>