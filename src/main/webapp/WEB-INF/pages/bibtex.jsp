<%-- 
    Document   : add
    Created on : Apr 11, 2013, 11:21:50 PM
    Author     : pksu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Generated bibtex</title>
    </head>
    <body>
        <h1>Generated bibtex</h1>
        <pre>${bibtexSource}
        </pre>
        <br/>
        <a href="${pageContext.request.contextPath}/">Back</a>
    </body>
</html>
