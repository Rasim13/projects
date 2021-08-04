<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Товары</title>
</head>
<body>

<button onclick="document.location = '/shop'">Перейти в магазин</button>

<table border="1" >
    <thead>
    <tr>
        <th>ID</th>
        <th>Товар</th>
        <th>Цена</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td> ${id}</td>
            <td> ${name}</td>
            <td> ${price}</td>
            <td><button onclick="document.location = '/addToCart/${id}'">Добавить товар в корзину</button></td>
        </tr>
    </tbody>
</table>
</body>
</html>