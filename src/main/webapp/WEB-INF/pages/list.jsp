<%-- 
    Document   : list
    Created on : Apr 11, 2013, 11:21:33 PM
--%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />

    </head>
    <body>
        <div class="container">
            <h1>List</h1>
            <ul>
                <c:forEach var="ctn" items="${citationList}">
                    <li><strong>Shorthand: ${ctn.shorthand}</strong>
                        <ul>
                            <c:forEach var="field" items = "${ctn.entries}">
                                <li>
                                    ${field.key}: ${field.value}
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                </c:forEach>
            </ul>
            <a href="${pageContext.request.contextPath}/add">Add another</a><br/>
            <a href="${pageContext.request.contextPath}/">Back</a>
        </div>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" />
    </body>
</html>
