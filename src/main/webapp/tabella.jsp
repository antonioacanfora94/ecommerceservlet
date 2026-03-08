<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!-- Script Let Java TagLibrary-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tabella</title>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<style>
body {
	margin: 0;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background: #f5f5f7; /* sfondo chiaro Apple */
}

/* Navbar */
.navbar {
	justify-content: center;
	background-color: #ffffff;
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

.navbar .nav-link {
	color: #1d1d1f;
	font-weight: 500;
}

.navbar .nav-link:hover {
	color: #0071e3;
}

.navbar-brand {
	color: #1d1d1f;
	font-weight: bold;
}

.navbar-brand:hover {
	color: #0071e3;
}

/* Tabella stile Apple */
table {
	width: 90%;
	margin: 30px auto;
	border-collapse: collapse;
	background: rgba(255, 255, 255, 0.8);
	backdrop-filter: blur(10px);
	box-shadow: 0 8px 32px rgba(0, 0, 0, 0.1);
	border-radius: 10px;
	overflow: hidden;
}

th, td {
	padding: 12px 15px;
	text-align: center;
	border-bottom: 1px solid #d1d1d6;
}

th {
	background-color: #f5f5f7;
	color: #1d1d1f;
	font-weight: 600;
}

tr:hover {
	background-color: rgba(0, 113, 227, 0.1); /* effetto hover blu Apple */
}

button {
	background-color: #0071e3;
	color: #fff;
	border: none;
	border-radius: 8px;
	padding: 5px 10px;
	font-weight: bold;
	cursor: pointer;
	transition: all 0.2s ease;
}

button:hover {
	opacity: 0.85;
	transform: translateY(-1px);
}

/* Link Torna alla Home */
a.home-link {
	display: block;
	text-align: center;
	margin: 20px;
	color: #0071e3;
	font-weight: 500;
	text-decoration: none;
}

a.home-link:hover {
	text-decoration: underline;
}
</style>
</head>
<body>

	<!-- NAVBAR -->
	<nav class="navbar navbar-expand-lg navbar-light">
  <a class="navbar-brand" href="home.html">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" 
          aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse justify-content-center" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="Avvio?scelta=2">Tabella</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="Avvio?scelta=2" role="button" data-toggle="dropdown" aria-expanded="false">
          Operazioni
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="formFK.html">Inserisci Marche/Categorie</a>
          <a class="dropdown-item" href="Avvio?scelta=0">Inserisci Prodotti</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="Avvio?scelta=2">Visualizza Tabella</a>
        </div>
      </li>
    </ul>
  </div>
</nav>

	<a href="home.html" class="home-link">Torna alla Home</a>

	<table>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Marca</th>
			<th>Categorie</th>
			<th>Prezzo</th>
			<th>Data Produzione</th>
			<th>Quantità</th>
			<th>Rimozione</th>
			<th>Modifica</th>
		</tr>
		<c:forEach var="p" items="${prodottiTotali}">
			<tr>
				<td>${p.id}</td>
				<td>${p.nomeProdotto}</td>
				<td>${p.nomeMarca}</td>
				<td>${p.nomeCategoria}</td>
				<td>${p.prezzo}</td>
				<td>${p.dataProduzione}</td>
				<td>${p.quantita}</td>

				<td><a href="Avvio?scelta=3&id=${p.id}"><button>Rimuovi</button></a></td>
				<td><a href="Avvio?scelta=4&id=${p.id}"><button>Modifica</button></a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
