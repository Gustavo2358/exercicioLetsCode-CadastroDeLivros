<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Exercício Biblioteca</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body class="bg-dark text-light">
    <div
            class="bg-image"
            style="
        background-image: url('images/library.jpg');
        background-size: auto 100%;
        height: 100vh;
      "
    >
        <div class="mask" style="background-color: rgba(0, 0, 0, 0.6);">
            <div class="text-center row align-items-center" style="height: 100vh">
                <div>
                    <h1 class="text-white ">Cadastre seu livro</h1>
                    <a class="btn btn-primary btn" href="cadastro-livro.jsp" role="button">Cadastro</a>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>