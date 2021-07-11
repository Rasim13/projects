<!doctype html>
<html lang="ru">
<head>
    <title>Регистрация</title>
</head>
<body>
<form action="/signUp" method="post">
    <label for="firstName">Введите имя:
        <input id="firstName" name="firstName" placeholder="First Name">
    </label>
    <label for="lastName">Введите фамилию:
        <input id="lastName" name="lastName" placeholder="Last Name">
    </label>
    <label for="email">Введите email:
        <input id="email" name="email" placeholder="email">
    </label>
    <label for="password">Введите пароль:
        <input id="password" name="password" type="password" placeholder="Password">
    </label>
    <input type="submit" value="Регистрация">
</form>
</body>
</html>

