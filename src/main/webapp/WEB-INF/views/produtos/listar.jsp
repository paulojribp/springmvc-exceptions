<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livros de Java, Android, iPhone, PHP, Ruby e muito mais - Casa do Código</title>
	<c:url value="/resources/css" var="cssPath" />
	<link rel="stylesheet" href="${cssPath}/bootstrap.min.css">
	<style type="text/css">
		body {
		  padding-top: 60px;
		}
	</style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">App</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="${s:mvcUrl('PC#listar').build() }">Listagem de Produtos</a></li>
                <li><a href="${s:mvcUrl('PC#form').build() }">Cadastro de Produtos</a></li>
            </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
	<div class="container">
		<h1>Produtos Cadastrados</h1>
		<c:if test="${not empty sucesso }">
		  <div class="alert alert-success">${sucesso }</div>
		</c:if>
		
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th class="text-center">Nome</th>
					<th class="text-center">Descrição</th>
					<th class="text-center">Data da Compra</th>
				</tr>
			</thead>
			<c:forEach items="${produtos }" var="produto">
				<tr>
					<td>${produto.nome }</td>
					<td>${produto.descricao }</td>
					<td><fmt:formatDate value="${produto.dataCompra.time }" pattern="dd/MM/yyyy" />
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>