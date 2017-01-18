<!doctype html>
<html lang="en">
<head>
    <title></title>
    </head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <style>
        body{
            width: 50%;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
<body>
    <#include "Nav.ftl">
    <div >
        <h1>User</h1>
        <ul>
            <li>Id: ${user.id}</li>
            <li>First Name: ${user.firstName}</li>
            <li>Last Name: ${user.lastName}</li>
            <li>Login: ${user.login}</li>
            <li>Email: ${user.email}</li>
        </ul>
        <#list roles>
            <ul class="list-group">
                <#items as role>
                    <li class="list-group-item-text">${role.roleName}</li>
                </#items>
            </ul>
        </#list>

        <#list messages>
            <ul class="list-group">
                <#items as message>
                    <li class="list-group-item">
                        <h3 class="list-group-item-heading">${message.title}</h3>
                        <p class="list-group-item-text">${message.content}</p>
                    </li>
                </#items>
            </ul>
        </#list>
    </div>
    <form action="/editUserDetails/${user.id}" method="get">
        <button type="submit" class="btn btn-primary error" value="Edit">Edit</button>
    </form>
</body>
</html>