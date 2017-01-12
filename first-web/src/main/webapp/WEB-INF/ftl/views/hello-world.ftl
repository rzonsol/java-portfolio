<!doctype html>
<html lang="en">
<head>
<#-- this comes from HelloWorld.java, when we added
      model.addAttribute("pageTitle", "Example Freemarker Page"); -->
    <title></title>
</head>
<body>
<div class="example-page">
    <h1>Users List</h1>
    <#list userListString>
        <ul>
            <#items as user>
                <li>${user}</li>
            </#items>
        </ul>
    </#list>
    </div>
</body>
</html>