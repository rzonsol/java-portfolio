<!doctype html>
<html lang="en">
<head>
    <#-- this comes from UsersList.java, when we added
            model.addAttribute("pageTitle", "Example Freemarker Page"); -->
        <title></title>
        </head>
<body>
<div class="example-page">
    <h1>test</h1>
    <ul>
        <li>Id: ${user.id}</li>
        <li>First Name: ${user.firstName}</li>
        <li>Last Name: ${user.lastName}</li>
        <li>Login: ${user.login}</li>
        <li>Email: ${user.email}</li>
    </ul>
    <#list roles>
        <ul>
            <#items as role>
                <li>${role.roleName}</li>
            </#items>
        </ul>
    </#list>
</div>
</body>
</html>