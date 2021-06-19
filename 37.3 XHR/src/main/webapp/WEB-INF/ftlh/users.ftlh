<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script>
        function addUser(firstName, lastName, email, password) {
            // создаем тело запроса (это будет работать в браузере)
            let body = {
                "firstName" : firstName,
                "lastName" : lastName,
                "email" : email,
                "password" : password
            };
            // создали объект для отправки запроса (запрос который отправляется с фронтэнда)
            let request = new XMLHttpRequest();
            // указали URl на который будем отправлять запрос
            let url = "http://localhost/api/users";
            // написали, что будет, когд  получим ответ
            request.onreadystatechange = function () {
                // срабатывает только при успешной отправки запроса
                if (request.readyState === XMLHttpRequest.DONE && request.status === 200) {
                    let response = JSON.parse(this.responseText);
                    let usersTableBody = document.getElementById("usersTable").getElementsByTagName("tbody")[0];
                    let row = usersTableBody.insertRow(-1);
                    let firstNameCell = row.insertCell(0);
                    let lastNameCell = row.insertCell(1);
                    let emailCell= row.insertCell(2);
                    firstNameCell.innerHTML = response["firstName"];
                    lastNameCell.innerHTML = response["lastName"];
                    emailCell.innerHTML = response["email"];
                }
            }

            //указали метод запроса
            request.open("POST", url);
            // указали заголовок, который обозначает тип содержимого
            request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            // отправляем json на сервер
            request.send(JSON.stringify(body));

        }
    </script>
</head>
<body>
<#--<h1>это Freemarker</h1>-->
<table id="usersTable">
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <#list accounts as account>
    <tr>
        <td> ${account.firstName}</td>
        <td> ${account.lastName}</td>
        <td> ${account.email}</td>
    </tr>
    </#list>
    </tbody>
    <div>
        <input id="firstName" type = "text" name = "firstName" placeholder="First Name">
        <input id="lastName" type = "text" name = "lastName" placeholder="Last Name">
        <input id="email" type = "email" name = "email" placeholder="Email">
        <input id="password" type = "password" name = "password" placeholder="Password">
        <button onClick="addUser(
            document.getElementById('firstName').value,
            document.getElementById('lastName').value,
            document.getElementById('email').value,
            document.getElementById('password').value
        )">Send</button>
    </div>
</table>

</body>
</html>