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
        <title>Add</title>
    </head>
    <body>
        <h1>Add</h1>
        <form action='' method='post'>
            <ul>
                <li>
                    <label for='title'>Title:</label>>
                    <input class='text' name='title' type='text'>
                </li
                <li>
                    <label for='author'>Author:</label>
                    <input class='text' name='author' type='text'>
                </li>
                <li>
                    <label for='year'>Year:</label>
                    <input class='text' name='year' type='text'>
                </li>
                <li>
                    <label for='publisher'>Publisher:</label>
                    <input class='text' name='publisher' type='text'>
                </li>
                <input class='button' type='submit' value='Add citation'>
            </ul>
        </form>

    </body>
</html>
