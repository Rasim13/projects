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
    <title>Добавление товара</title>
<#--    <script>-->
<#--        function addProduct(name, price) {-->
<#--            // создаем тело запроса (это будет работать в браузере)-->
<#--            let body = {-->
<#--                "model" : model,-->
<#--                "price" : price-->
<#--            };-->
<#--            $.ajax({-->
<#--                type: "POST",-->
<#--                url: "http://localhost/admin/products/add",-->
<#--                data: JSON.stringify(body),-->
<#--                success: function (response) {-->

<#--                    let html = '<tr>' +-->
<#--                        '             <td>' + response['model'] + '</td>'+-->
<#--                        '             <td>' + response['price'] + '</td>';-->

<#--                    $('#productTable > tbody:last-child').append(html);-->
<#--                },-->
<#--                dataType: "json",-->
<#--                contentType:"application/json"-->
<#--            });-->
<#--        }-->
<#--    </script>-->
</head>
<a href="/admin/products">Товары</a>
<body>
<h3>Добавить новый товар</h3>
<form action = "/admin/products/add" method = "POST">
    <div>
        <label for="name">Name</label>
        <input type="text" name = "name" placeholder="Enter name">
    </div>
    <div>
        <label for="name">Price</label>
        <input type="text" name = "price" placeholder="Enter price">
    </div>
        <input type="submit" value="Add Product">
</form>
</table>
</body>
</html>