<!doctype html>
<html lang="ru">
<#import "/spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="test/css" href="<@spring.url'/resources/css/store.css'/>" />
    <title>Phone store</title>
</head>
<body>
<h1>Добро пожаловать в магазин телефонов ${email}</h1>
<a href="/logout">Выйти</a>
<table border="1">
    <thead>
    <tr>
        <th>Model</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <#list products as product >
        <tr>
            <td> ${product.model}</td>
            <td> ${product.price}</td>
            <td> <input type="submit" value="add to shopping cart"></td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>