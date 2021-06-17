<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>Hello, ${user.name}</h1>
<h2>your id is ${user.id}</h2>

<#if user.age??>
    <h3>Age is ${user.age}</h3>
<#else>
    <h3>Age is undefined</h3>
</#if>

<h4>Other users:</h4>


<table>
    <tr>
        <th>Name</th>
        <th>Age</th>
    </tr>
    <#list users as listUser>
        <tr>
            <td>Name: ${listUser.name}</td>
            <td>Age: ${listUser.age}</td>
        </tr>
    </#list>
</table>

</body>
</html>