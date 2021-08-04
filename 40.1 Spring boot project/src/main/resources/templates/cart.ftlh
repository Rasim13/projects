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
    <title>Корзина</title>
</head>
<body>

<button onclick="document.location = '/shop'">В магазин</button>

<button onclick="document.location = '/checkout'">Перейти к оплате</button>

<h4>Количество товаров в корзине ${cartCount}</h4>
<h4>Сумма товаров в вашей корзине ${totalSum}</h4>
<table border="1">
    <thead>
    <tr>
        <th>Товар</th>
        <th>Количество</th>
        <th>Цена</th>
    </tr>
    </thead>
    <tbody>
    <#list cart as item>
        <tr>
            <td> ${item.product.name}</td>
            <td> ${item.quantity}</td>
            <td> ${item.product.price}</td>
            <td><button onclick="document.location = '/cart/removeItem/${item.product.id}'">Удалить товар</button></td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>