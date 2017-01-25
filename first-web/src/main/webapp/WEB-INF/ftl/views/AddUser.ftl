<!doctype html>
<html lang="en">
<head>

    <title>Add User</title>
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
        <h1>Add User</h1>
        <div class="${hide}">
            <h3 class="alert alert-success" >${message}</h3>
        </div>

        <form name="user" action="/users/add" method="POST">
            <div class="form-group">
                <label for="firstName">First Name</label>
                <input type="text" class="form-control" name="firstName" placeholder="First Name">
            </div>
            <div class="form-group">
                <label for="lastName">First Name</label>
                <input type="text" class="form-control" name="lastName" placeholder="Last Name">
            </div>
            <div class="form-group">
                <label for="email">Email address</label>
                <input type="email" class="form-control" name="email" placeholder="Enter email">
            </div>
            <div class="form-group">
                <label for="login">Login</label>
                <input type="text" class="form-control" name="login" placeholder="Login">
            </div>
            <button type="submit" class="btn btn-primary" value="Save">Submit</button>
        </form>

    </body>
</html>