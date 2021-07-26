<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script
            src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
            crossorigin="anonymous"></script>
    <title>Товары</title>
</head>
<a href="/admin">Главная страница администратора</a>
<body>
<a href="/admin/products/add">Добавить товар</a>
<table border="1">
    <thead>
    <tr>
        <th>Товар</th>
        <th>Цена</th>
    </tr>
    </thead>
    <tbody>
    <#list products as product>
        <tr>
            <td> ${product.name}</td>
            <td> ${product.price}</td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>