<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create User Page</title>
</head>
<body>

<form name="User" action="/updateUser" method="post">
    <p>Id</p>
    <input title="Id" type="text" name="Id" placeholder="Id" value="${user.id}">
    <p>Name</p>
    <input title="Name" type="text" name="name" placeholder="Name" value="${user.name}">
    <p>Email</p>
    <input title="Email" type="text" name="email" placeholder="email" value="${user.email}">
    <p>Age</p>
    <input title="Age" type="text" name="age" placeholder="age" value="${user.age}">
    <input type="submit" value="OK">
</form>

</body>
</html>