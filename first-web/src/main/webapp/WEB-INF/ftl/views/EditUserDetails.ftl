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
<h2>User detail</h2>
<div class="${hide}">
    <h3 class="alert alert-success" >${message}</h3>
</div>

<form action="/users/${user.id}" method="POST" name="user">
    <div class="form-group">
        <label for="firstName">First Name</label>
        <input type="text" class="form-control" name="firstName" value="${user.firstName}">
    </div>
    <div class="form-group">
        <label for="lastName">Last Name</label>
        <input type="text" class="form-control" name="lastName" value="${user.lastName}">
    </div>
    <div class="form-group">
        <label for="login">Login</label>
        <input type="text" class="form-control" name="login" value="${user.login}">
    </div>
    <div class="form-group">
        <label for="email">Email address</label>
        <input type="email" class="form-control" name="email" value="${user.email}">
    </div>
    <button type="submit" class="btn btn-primary" value="Save">Save</button>
</form>

<h2>Change roles</h2>
<form action="/users/${user.id}/role" method="POST">
    <div class="form-group" >
        <label for="roles">Roles</label>
        <input type="text" class="form-control" name="roles" value="${roles}">
    </div>
    <button type="submit" class="btn btn-primary" value="Save">Save</button>
</form>

<h2>Change roles</h2>
<form action="/users/${user.id}/delete" method="get">
    <button type="submit" class="btn btn-danger">Delete</button>
</form>
</body>
</html>