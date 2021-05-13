<%-- 
    Document   : menu
    Created on : 05/01/2021, 07:28:23
    Author     : Alessandro Hoffmann
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light mb-3">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Alterna navega��o">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(P�gina atual)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Destaques</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Pre�os</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         Produtos
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">A��o</a>
          <a class="dropdown-item" href="${linkTo[CategoriaController].totalPaginas()}">Cadastro Categorias</a>
          <a class="dropdown-item" href="#">Outra a��o</a>
          <a class="dropdown-item" href="#">Algo mais aqui</a>
        </div>
      </li>
    </ul>
  </div>
</nav>
