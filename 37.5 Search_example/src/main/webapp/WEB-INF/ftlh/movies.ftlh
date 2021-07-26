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
        // $(document).ready(function () {
        //     $('#movieTitle').on('keyup', function() {
        document.getElement('movieTitle').addEventListener('keyup', function (e) {
            LiveSearch()
        });
                function  LiveSearch() {
                    let title = document.getElement('movieTitle').value

                    $.ajax({
                        type: "GET",
                        url: "/movies",
                        data: {search: value},
                        dataType: "html",
                        // contentType: "application/json",
                        success: function (data) {
                            let html = '<tr>' +
                                '             <td>' + response['id'] + '</td>' +
                                '             <td>' + response['movieTitle'] + '</td>';
                            $('#result').append(html);
                        },
                    });
            }
    </script>
</head>
<body>
<table id="movieTable">
    <thead>
    <tr>
        <th>Id</th>
        <th>Movie title</th>
    </tr>
    </thead>
    <tbody>
    <#list movies as movie>
        <tr>
            <td> ${movie.id}</td>
            <td> ${movie.movieTitle}</td>
        </tr>
    </#list>
    </tbody>
    <form action = "/movies" method="GET">
        <p><b>Enter title movie</b></p>
        <input id="movieTitle" name = "movieTitle" type = "text" placeholder="search movie title">
    </form>

    <div id="result" class="tag-results">

    </div>
</table>
</body>
</html>