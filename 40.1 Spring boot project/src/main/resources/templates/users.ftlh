<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Пользователи</title>
</head>
<body>
<a href="/admin">Главная страница администратора</a>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Role</th>
    </tr>
    </thead>
    <tbody>
    <#list allAccounts as account >
        <tr>
            <td> ${account.id}</td>
            <td> ${account.firstName}</td>
            <td> ${account.lastName}</td>
            <td> ${account.email}</td>
            <td> ${account.hashPassword}</td>
            <td> ${account.role}</td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>