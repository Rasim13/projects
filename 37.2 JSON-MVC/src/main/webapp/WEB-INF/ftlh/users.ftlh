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
<h1>это Freemarker</h1>

<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
    </tr>
    <#list accounts as account>
        <tr>
            <td> ${account.firstName}</td>
            <td> ${account.lastName}</td>
            <td> ${account.email}</td>
        </tr>
    </#list>
</table>

</body>
</html>