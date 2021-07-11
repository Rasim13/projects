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
    <title>Live search</title>
    <script>
        $(document).ready(function () {
            $('#movieTitle').on('keyup', function() {
                let name = $('#movieTitle').val();
                let body = {
                    "movieTitle" : "movieTitle"
                };
                if ((name != '') && (name.lenght > 1)) {
                    $.ajax({
                        type: "POST",
                        url: "http://localhost/movie",
                        data: JSON.stringify(body),
                        dataType: "json",
                        contentType: "application/json",
                        success: function (response) {
                            $("#display").html(response).show();
                        },
                    });
                }
            });
        });
    </script>
</head>
<body>
    <form action = "/movie" method="post">
        <p><b>Введите название фильма</b></p>
        <input id="movieTitle" type = "text" placeholder="search movie title">
    </form>
<div id = "display"></div>
</body>
</html>