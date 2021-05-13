<%-- 
    Document   : paginaErro
    Created on : 23/12/2020, 19:01:23
    Author     : mbs-6
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="alert alert-primary" role="alert">
	<ul>
		<c:forEach var="error" items="${errors}">
			${error.message}
		</c:forEach>
	</ul>
</div>

