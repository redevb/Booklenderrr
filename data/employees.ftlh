<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
<div class="container mt-5">
    <header class="d-flex justify-content-center py-3">
        <ul class="nav nav-pills">
            <li class="nav-item"><a href="/" class="nav-link active" aria-current="page">Home</a></li>
            <li class="nav-item"><a href="/books" class="nav-link">Books</a></li>
            <li class="nav-item"><a href="/employees" class="nav-link">Employees</a></li>
        </ul>
    </header>
    <table class="table" border="2">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Age</th>
            <th scope="col">Taken books</th>
            <th scope="col">Reads now</th>
        </tr>
        </thead>

        <tfoot>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Age</th>
            <th scope="col">Taken books</th>
            <th scope="col">Reads now</th>
        </tr>
        </tfoot>

        <tbody>
        <#list employees as employee>
        <tr>
        <td>${employee.name}</td>
        <td>${employee.age}</td>
        <td>
        <table>
            <#list employee.takenBooks as book>
            <tr>
                <td>${book}</td>
            </tr>
        </#list>
    </table>
</td>
<td>
    <table>
        <#list employee.readsNow as book>
        <tr>
            <td>${book}</td>
        </tr>
    </#list>
</table>
</td>
</tr>
        </#list>
        </tbody>
        </table>
        </div>
        </body>
        </html>