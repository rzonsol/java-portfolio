<!doctype html>
<html lang="en">
<head>
    <title></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        body{
            width: 50%;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>
<body>
    <#include "Nav.ftl">
    <div>
        <h1>Users List</h1>
        <#list userListString>
            <ul>
                <#items as user>
                    <li><a href="/users/${user.id}"> ${user.firstName} ${user.lastName}</a></li>
                </#items>
            </ul>
        </#list>
    </div>
</body>
</html>