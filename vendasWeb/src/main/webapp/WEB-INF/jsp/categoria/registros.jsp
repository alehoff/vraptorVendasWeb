<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${categorias}" var="categoria" varStatus="st">
	<tr>
		<td><c:out value="${st.count}"></c:out></td>
		<td><c:out value="${categoria.categoria }"></c:out></td>
		<td><a href="${linkTo[CategoriaController].edita()}?id=${categoria.id}">edita</a></td>
	</tr>
</c:forEach>