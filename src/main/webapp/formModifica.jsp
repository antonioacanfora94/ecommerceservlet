<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

	
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<title>Form Modifica</title>

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

/* Contenitore form */
.form-container {
	background: rgba(255, 255, 255, 0.8);
	border-radius: 20px;
	padding: 40px 60px;
	text-align: center;
	backdrop-filter: blur(15px);
	-webkit-backdrop-filter: blur(15px);
	box-shadow: 0 12px 40px rgba(0, 0, 0, 0.1);
	width: fit-content;
	margin: 50px auto;
}

/* Input e bottoni */
input[type="text"], input[type="date"] {
	display: block;
	width: 300px;
	margin: 15px auto;
	padding: 10px 12px;
	font-size: 16px;
	border-radius: 10px;
	border: 1px solid #d1d1d6;
	outline: none;
	transition: 0.2s;
}

input[type="text"]:focus, input[type="date"]:focus {
	border-color: #0071e3;
	box-shadow: 0 0 5px rgba(0, 113, 227, 0.3);
}

button {
	background-color: #0071e3;
	color: #fff;
	border: none;
	border-radius: 12px;
	padding: 12px 25px;
	font-weight: bold;
	font-size: 16px;
	cursor: pointer;
	margin-top: 20px;
	transition: all 0.2s ease;
}

button:hover {
	opacity: 0.85;
	transform: translateY(-2px);
}
select {
	display: block;
	width: 300px;
	margin: 15px auto;
	padding: 10px 12px;
	font-size: 16px;
	border-radius: 10px;
	border: 1px solid #d1d1d6;
	background-color: #ffffff;
	outline: none;
	transition: 0.2s;
	appearance: none;
	-webkit-appearance: none;
	-moz-appearance: none;
	cursor: pointer;
}

select:focus {
	border-color: #0071e3;
	box-shadow: 0 0 5px rgba(0, 113, 227, 0.3);
}

/* Freccia custom stile Apple */
.select-wrapper {
	position: relative;
	width: 300px;
	margin: 15px auto;
}

.select-wrapper::after {
	content: "⌄";
	position: absolute;
	right: 15px;
	top: 50%;
	transform: translateY(-50%);
	color: #6e6e73;
	pointer-events: none;
	font-size: 18px;
}
</style>
</head>
<body>

	<!-- NAVBAR -->
	<nav class="navbar navbar-expand-lg navbar-light">
		<a class="navbar-brand" href="home.html">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse justify-content-center"
			id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="Avvio?scelta=2">Tabella</a>
				</li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="Avvio?scelta=2"
					role="button" data-toggle="dropdown" aria-expanded="false">
						Operazioni </a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="form.html">Inserisci Marche/Categorie</a>
						<a class="dropdown-item" href="Avvio?scelta=0">Inserisci Prodotti</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="Avvio?scelta=2">Visualizza Tabella</a>
					</div></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>

	<!-- FORM -->
	<div class="form-container">
		<form action="Avvio" method="post">
			<input type="hidden" name="scelta" value="5"> <input
				type="hidden" name="id" value="${prodotto.id}"> <input
				type="text" placeholder="Inserisci Nome Prodotto"
				name="nomeProdotto" value="${prodotto.nomeProdotto}">

			<div class="select-wrapper">
				<select name="idCategoria">
					<option value="" disabled>Seleziona Categoria</option>
					<c:forEach var="c" items="${categorie}">
						<option value="${c.id}">
							<c:if test="${c.id == prodotto.id_categorie}"></c:if>
							${c.nomeCategoria}</option>
					</c:forEach>

				</select>
			</div>

			<div class="select-wrapper">
				<select name="idMarca">
					<option value="" disabled>Seleziona Marca</option>
					<c:forEach var="m" items="${marche}">
						<option value="${m.id}">
							<c:if test="${m.id == prodotto.id_marche}"></c:if>
							${m.nomeMarca}</option>
					</c:forEach>
				</select>
			</div>

			<input type="text" placeholder="Inserisci Prezzo Prodotto"
				name="prezzoProdotto" value="${prodotto.prezzo}"> <input
				type="date" name="dataProduzione" required
				value="${prodotto.dataProduzione}"> <input type="text"
				placeholder="Inserisci Quantità Prodotto" name="quantitaProdotto"
				value="${prodotto.quantita}">

			<button type="submit">Invia</button>
		</form>
	</div>

</body>
</html>
