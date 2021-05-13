<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SGB</title>
<jsp:include page="/WEB-INF/jsp/index/bibliotecas.jsp"></jsp:include>
</head>
<body>
	<div class="divMenu"><jsp:include page="/WEB-INF/jsp/index/menu.jsp"></jsp:include></div>
	<div class="divCorpo">
		<div class="divTitulo">
			<div class="menuLeft">
				<h2>Cadastro Categorias</h2>
			</div>
			<div class="menuRight">
				<a id="btCancelar" href="${linkTo[CategoriaController].lista() }">Cancelar</a>
			</div>
		</div>
		<form action="${linkTo[CategoriaController].salvar()}" method="post">
			<input type="hidden" name="categoria.id" value="${categoria.id }">
			<table style="width: 100%">
				<tr>
					<td><label id="label-1">Categoria:</label></td>
					<td><input type="text" name="categoria.categoria" value="${categoria.categoria}"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Salvar"></td>
				</tr>
			</table>
		</form>
	</div>
</body>

<c:if test="${not empty errors}">
	<jsp:include page="/WEB-INF/jsp/index/paginaErro.jsp"></jsp:include>
</c:if>
<script type="text/javascript">
	$(function() {
		$("#btCancelar, input[type='submit']").button();
	});
</script>
</html>
