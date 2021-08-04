<!doctype html>
<html lang="ru">
<head>
    <title>Вход</title>
</head>
<body>

<button onclick="document.location = '/'">Главная страница</button>

<form action="/signIn" method="post">
    <label for="email">Введите email:
        <input id="email" name="email" placeholder="Email">
    </label>
    <label for="password">Введите пароль:
        <input id="password" type="password" name="password" placeholder="Password">
    </label>
    <input type="submit" value="Вход">
</form>

</body>
</html>