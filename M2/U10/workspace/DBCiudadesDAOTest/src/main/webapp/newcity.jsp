<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<h2>Nueva ciudad</h2>
	<section>
		<div class="error">${error}</div>
		<form action="" method="post">			
			<div><input type="text" name="nombre" placeholder="Nombre" value="${city.name}"/></div>			
			<div><input type="text" name="district" placeholder="Distrito" value="${city.district}"/></div>
			<div><input type="number" name="population" placeholder="Poblaci�n" value="${city.population}"/></div>
		
			<h3>Pa�s</h3>
			<div><input type="text" name="countrycode" min-length="3" max-length="3" placeholder="C�digo de pa�s" value="${city.country.code}"/></div>
			<div><input type="text" name="countryname" placeholder="Nombre de pa�s" value="${city.country.name}"/></div>
			<p></p>
			<div><button>Guardar</button></div>
		</form>
	</section>
</body>
</html>