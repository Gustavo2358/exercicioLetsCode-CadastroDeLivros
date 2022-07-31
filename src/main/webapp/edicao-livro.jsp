<%--
  Created by IntelliJ IDEA.
  User: gustavo
  Date: 27/07/2022
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"	%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Biblioteca</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body class="bg-dark text-light" >
    <div
        class="bg-image"
        style="
        background-image: url(<c:url value='/images/library.jpg'/>);
        background-size: auto 100%;
        height: 100vh;
      "
    >
        <div class="mask" style="background-color: rgba(0, 0, 0, 0.6);">
            <div class="row align-items-center p-5" style="height: 100vh">
                <div class="container col-8">
                    <h1>Editar Livro</h1>
                    <form action="<%= request.getContextPath() %>/livro-servlet/editar-livro" method="put">
                        <div>
                            <input type="hidden" name="id" value="${livro.id}">
                        </div>
                        <div class="mb-3">
                            <label for="name" class="form-label">Nome do livro:</label>
                            <input type="text" class="form-control" id="name" name="nome" value="${livro.nome}">
                        </div>
                        <div class="mb-3" >
                            <label for="autor" class="form-label">Nome do autor:</label>
                            <input type="text" class="form-control" id="autor" name="autor" value="${livro.autor}">
                        </div>
                        <button type="submit" class="btn btn-primary">Enviar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>

</html>
