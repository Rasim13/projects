<!doctype html>
<html lang="ru">
<#import "spring.ftl" as spring/>
<head>
    <title>Регистрация</title>
</head>
<body>
<p><a href="?lang=ru">РУ</a></p>
<p><a href="?lang=en">EN</a></p>
<form action="/signUp" method="post">
    <label for="firstName"><@spring.message 'signUp.label.for.firstName'/>
        <input id="firstName" name="firstName" placeholder="Имя">
    </label>
    <label for="lastName"><@spring.message 'signUp.label.for.lastName'/>
        <input id="lastName" name="lastName" placeholder="Last name">
    </label>
    <label for="email"><@spring.message 'signUp.label.for.email'/>
        <input id="email" name="email" placeholder="Email">
    </label>
    <label for="password"><@spring.message 'signUp.label.for.password'/>
        <input type="password" id="password" name="password" placeholder="Password">
    </label>
    <input type="submit" value="Регистрация">
</form>
</body>
</html>

