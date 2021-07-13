<!doctype html>
<html lang="ru">
<head>
    <title>Регистрация</title>
</head>
<body>
<form action="/signUp" method="post">
    <label for="firstName"> Введите имя:
        <input id="firstName" name="firstName" placeholder="Имя">
    </label>
    <label for="lastName">Введите фамилию:
        <input id="lastName" name="lastName" placeholder="Last name">
    </label>
    <label for="email">Введите email:
        <input id="email" name="email" placeholder="Email">
    </label>
    <label for="password">Введите пароль:
        <input type="password" id="password" name="password" placeholder="Password">
    </label>
    <input type="submit" value="Регистрация">
</form>
</body>
</html>

