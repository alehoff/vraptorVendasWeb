<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<!-- Meta tags Obrigatï¿½rias -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>AleWeb systens</title>
<jsp:include page="/WEB-INF/jsp/index/bibliotecas.jsp"></jsp:include>
</head>
<body>

	<div class="container">

		<jsp:include page="/WEB-INF/jsp/index/menu.jsp"></jsp:include>

		<div class="form-row mt-2">
			<div class="form-group col-md-2">
				<a class="btn btn-outline-primary " href="${linkTo[ProdutoController].cadastro()}" role="button">Cadastro</a>
			</div>
			<div class="form-group col-md-6">
				<input class="form-control" id="filtro" type="text" placeholder="Digite noome produto para consulta">
			</div>
			<div class="form-group col-md-2">
				<button id="btConsulta" type="button" class="btn btn-outline-success">Consulta</button>
			</div>
		</div>

		<div id="divTabela"></div>

		<div id="paginacao" class="mt-2">

			<nav aria-label="Navegação de página exemplo">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="#" aria-label="Anterior"> <span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Anterior</span></a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#" aria-label="Próximo"> <span aria-hidden="true">&raquo;</span>
						<span class="sr-only">Próximo</span>
				</a></li>
			</ul>
			</nav>
		</div>

	</div>
</body>

<script type="text/javascript">

	function open() {
		$
				.ajax({
					url : '${linkTo[ProdutoController].filtroTabela}',
					data : {
						filtro : $('#filtro').val()
					},
					beforeSend : function() {
						$("#divTabela").html(
								"<h3>Localizando. Favor aguardar...</h3>");
					},
					success : function(data) {
						$("#divTabela").empty().html(data);
					}
				});
	}

	$(function() {

		open();

		$("#btConsulta").on('click', function(e) {
			e.preventDefault();
			open();
		});

	});
</script>

</html>
