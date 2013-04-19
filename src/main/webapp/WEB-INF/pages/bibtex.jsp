<%-- 
    Document   : add
    Created on : Apr 11, 2013, 11:21:50 PM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Generated bibtex</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" /> 
    </head>
    <body>
        <div class="container">
            <h1>Generated bibtex</h1>
            <pre>${bibtexSource}
            </pre>
            <br/>
            <a href="${pageContext.request.contextPath}/">Back</a>
            <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" />
        </div>
    </body>
</html>
