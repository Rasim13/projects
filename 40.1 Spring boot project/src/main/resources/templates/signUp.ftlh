<!doctype html>
<html lang="ru">
<#import "spring.ftl" as spring/>
<head>
    <title>Регистрация</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<a href="/">Главная страница</a>
<p><a href="?lang=ru">РУ</a></p>
<p><a href="?lang=en">EN</a></p>
<@spring.bind "signUpForm"/>
<form action="/signUp" method="post">
    <label for="firstName"><@spring.message 'signUp.label.for.firstName'/>
        <@spring.formInput "signUpForm.firstName"/>
        <@spring.showErrors "<br>" "error"/>
    </label>
    <label for="lastName"><@spring.message 'signUp.label.for.lastName'/>
        <@spring.formInput "signUpForm.lastName"/>
        <@spring.showErrors "<br>" "error"/>
    </label>
    <label for="email"><@spring.message 'signUp.label.for.email'/>
        <@spring.formInput "signUpForm.email"/>
        <@spring.showErrors "<br>" "error"/>
    </label>
    <label for="password"><@spring.message 'signUp.label.for.password'/>
        <@spring.formInput "signUpForm.password"/>
        <@spring.showErrors "<br>" "error"/>
    </label>
    <input type="submit" value="Регистрация">
</form>

</body>
</html>