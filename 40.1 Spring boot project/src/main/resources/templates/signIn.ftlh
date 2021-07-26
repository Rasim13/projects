<!doctype html>
<html lang="ru">
<head>
    <title>Вход</title>
</head>
<body>
<a href="/">Главная страница</a>
<br>
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