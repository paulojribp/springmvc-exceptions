<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
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
		<h1>Formulário de Produto</h1>
		<form:form action="${s:mvcUrl('PC#salvar').build()}" method="post" commandName="produto">
			<div class="form-group">
				<label>Nome</label>
				<form:input path="nome" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Descrição</label>
				<form:textarea path="descricao" class="form-control" />
			</div>
			<div class="form-group">
				<label>Data de Compra</label>
				<form:input path="dataCompra" class="form-control" />
			</div>
			
			<button type="submit" class="btn btn-primary">Enviar</button>
		</form:form>
	</div>
</body>
</html>