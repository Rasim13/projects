<!doctype html>
<html lang="ru">
<#import "/spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="/css/main.css" />
    <title>Магазин товаров</title>
</head>
<body>
<h1>Добро пожаловать в наш магазин</h1>

<button onclick="document.location = '/logout'">Выйти</button>

<button onclick="document.location = '/cart'">Перейти в корзину</button>

<table border="1">
    <thead>
    <tr>
        <th>Наименование</th>
        <th>Цена</th>
    </tr>
    </thead>
    <tbody>
    <#list allProducts as product >
        <tr>
            <td> ${product.name}</td>
            <td> ${product.price}</td>
            <td><button onclick="document.location = '/shop/viewproduct/${product.id}'">Посмотреть товар</button></td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>