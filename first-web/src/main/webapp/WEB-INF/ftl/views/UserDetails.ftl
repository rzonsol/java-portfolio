<!doctype html>
<html lang="en">
<head>
    <#-- this comes from UsersList.java, when we added
            model.addAttribute("pageTitle", "Example Freemarker Page"); -->
    <title></title>
    </head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <style>
        body{
            width: 50%;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
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
</body>
</html>