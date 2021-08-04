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

<button onclick="document.location = '/cart'">Перейти в корзину</button> <br>

<form action=" " method="post">
    <label for="firstName"> Введите имя:
        <input id="firstName" name="firstName" placeholder="Имя">
    </label>
    <label for="lastName">Введите фамилию:
        <input id="lastName" name="lastName" placeholder="Фамилия">
    </label>
    <label for="city">Введите город:
        <input id="city" name="city" placeholder="Город">
    </label>
    <label for="postcode">Введите почтовый индекс:
        <input id="postcode" name="postcode" placeholder="Почтовый индекс">
    </label>
    <h4>Сумма товаров в вашей корзине ${totalSum}</h4> <input type="submit" value="Оплатить">
</form>

</body>
</html>