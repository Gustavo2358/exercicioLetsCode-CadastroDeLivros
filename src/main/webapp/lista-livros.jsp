<%--
  Created by IntelliJ IDEA.
  User: gustavo
  Date: 27/07/2022
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"	%>

<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Lista de Livros</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body class="bg-dark text-light">
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
                <div class="container">
                    <h1 class="mb-3">Lista de Livros cadastrados</h1>
                    <h3 class="mb-3">Livro de id: ${livroId} cadastrado com sucesso!</h3>

                    <table class="table table-bordered bg-light mt-3">
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Autor</th>
                            <th>Opções</th>

                        </tr>
                        <c:forEach var="livro" items="${livros}" varStatus="id">
                            <tr>
                                <td>${id.count}</td>
                                <td>${livro.nome}</td>
                                <td>${livro.autor}</td>
                                <td>
                                    <div>
                                        <a href="${pageContext.request.contextPath}/livro-servlet/carregar-para-edicao?id=<c:out value='${livro.id}'/>" class=" btn btn-sm btn-success">Editar</a>
                                        <a href="${pageContext.request.contextPath}/livro-servlet/deletar?id=<c:out value='${livro.id}'/>" class=" btn btn-sm btn-danger">Deletar</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/cadastro-livro.jsp" role="button">Cadastre um novo Livro</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
