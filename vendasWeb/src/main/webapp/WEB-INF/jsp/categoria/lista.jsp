<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-br">
<head>
<!-- Meta tags Obrigatórias -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<jsp:include page="/WEB-INF/jsp/index/bibliotecas.jsp"></jsp:include>

<title>Categorias</title>
</head>
<body>
	<div class="container-fluid">

		<!-- MENU -->
		<jsp:include page="/WEB-INF/jsp/index/menu.jsp"></jsp:include>

		<!-- FILTRO E NOVO CADASTRO -->
		<div class="form-row mb-3">
			<div class="col">
				<input id="filtro" type="text" class="form-control form-control-sm" placeholder="Localize pela categoria">
			</div>
			<div class="col">
				<a class="btn btn-outline-info btn-sm" href="#" role="button">Filtro</a>
			</div>
			<div class="col">
				<a class="btn btn-outline-success btn-sm" href="#" role="button">Cadastro</a>
			</div>
		</div>

		<!-- TABELA COM REGISTROS -->
		<table class="table table-hover ">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">categoria</th>
					<th scope='col'>Ações</th>
				</tr>
			</thead>
			<tbody id="tbody">

			</tbody>
		</table>

		<!-- NAVEGAÇÃO -->
		<nav aria-label="Navegação de página exemplo">
			<ul class="pagination justify-content-center">
				<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">Anterior</a></li>
				<c:forEach var="count" begin="1" end="${paginas}">
					<li class="page-item"><a id="${count}" class="page-link" href="${linkTo[CategoriaController].registros()}">${count}</a></li>
				</c:forEach>
				<li class="page-item disabled"><a class="page-link" href="#">Próximo</a></li>
			</ul>
		</nav>

		<!-- MENSAGEM DE ERROS SE OCORRER -->
		<c:if test="${not empty errors}">
			<jsp:include page="/WEB-INF/jsp/index/paginaErro.jsp"></jsp:include>
		</c:if>
	</div>
</body>
<script type="text/javascript">
	function registros(url,filtro,indice) {
		$.ajax({
			url : url,
			data : {
				filtro : filtro,
				indice : indice
			},
			dataType:'html',
			success : function(data) {
				$("#tbody").empty().html(data);
			}
		});
	};

	$(function() {

		registros("${linkTo[CategoriaController].registros()}",$("#filtro").val(),1);

		$(".page-link").on("click", function(e) {
			e.preventDefault();
			registros($(this).attr("href"),$("#filtro").val(),$(this).attr("id"));
		});
	});
</script>
</html>

