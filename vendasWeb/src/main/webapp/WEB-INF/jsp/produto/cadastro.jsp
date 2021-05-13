<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<!-- Meta tags Obrigatorias -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>AleWeb systens</title>
<jsp:include page="/WEB-INF/jsp/index/bibliotecas.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<jsp:include page="/WEB-INF/jsp/index/menu.jsp"></jsp:include>

		<form method="post" action="${linkTo[ProdutoController].salvar()}">

			<input type="hidden" name="produto.id" value="${produto.id}">

			<div class="form-group">
				<label for="nomeProduto">Nome Produto</label> <input type="text" name="produto.nome" value="${produto.nome}"
					class="form-control" id="nomeProduto">
			</div>
			<div class="form-group">
				<label for="familia">Fam&iacute;lia</label> <input id="nomeFamilia" name="nomeFamilia"
					value="${produto.familia.nome}" type="text" class="form-control" id="familia">
			</div>
			<div class="form-row">
				<div class="form-group col-md-2">
					<label for="volume">Volume</label> <input name="produto.volume" value="${produto.volume}" type="text"
						class="form-control" id="volume">
				</div>
				<div class="form-group col-md-2">
					<label for="atacado">Atacado</label> <input name="produto.atacado" value="${produto.atacado}" type="text"
						class="form-control" id="atacado">
				</div>
				<div class="form-group col-md-2">
					<label for="margem">Margem Lucro</label> <input name="produto.margem"
						value="<fmt:formatNumber value='${produto.margem}' type='number'/>" type="text" class="form-control" id="margem">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="status">Status</label> <select class="form-control" id="status" name="produto.status">
						<c:forEach items="${status}" var="status">
							<option value="${status}" <c:if test='${status.status eq produto.status.status }'>selected="selected"</c:if>>
								${status.status}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-4">
					<label for="tipoCarga">Tipo Carga</label> <select class="form-control" id="tipoCarga" name="produto.tipoCarga">
						<c:forEach items="${tiposCarga}" var="tipoCarga">
							<option value="${tipoCarga}"
								<c:if test="${tipoCarga.tipoCarga eq produto.tipoCarga.tipoCarga }">selected="selected"</c:if>>
								${tipoCarga.tipoCarga}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<button type="submit" class="btn btn-outline-success">Salvar</button>
			<a class="btn btn-outline-warning" href="${linkTo[ProdutoController].lista()}" role="button">Cancelar</a>
		</form>
		<c:if test="${errors ne null }">
			<jsp:include page="/WEB-INF/jsp/index/paginaErro.jsp"></jsp:include>
		</c:if>
	</div>

	<script>
		$(function() {

			var itens = [];
			
			$.ajax({
				url : "${linkTo[FamiliaController].familias()}",
				dataType : "json",
				success : function(data) {
					for (var i = 0; i < data.length; i++) {
						itens.push(data[i].nome);
					}
				}
			});

			$("#nomeFamilia").autocomplete({
				source : itens
			});

		});
	</script>
</body>
</html>



