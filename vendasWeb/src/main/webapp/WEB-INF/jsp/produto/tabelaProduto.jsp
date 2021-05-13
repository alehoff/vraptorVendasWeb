<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="table-responsive mt-3">
	<table class="table">
		<thead>
			<tr>
				<th>Produto</th>
				<th>Família</th>
				<th>Volume</th>
				<th>Atacado</th>
				<th>Ativo</th>
				<th>Margem</th>
				<th>Opção</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${produtos}" var="produto">
				<tr>
					<td>${produto.nomeProduto}</td>
					<td>${produto.nomeFamilia }</td>
					<td>${produto.volume }</td>
					<td>${produto.atacado }</td>
					<td>${produto.ativo }</td>
					<td>${produto.margem}</td>
					<td><a href="${linkTo[ProdutoController].edita()}?id=${produto.id}">editar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>