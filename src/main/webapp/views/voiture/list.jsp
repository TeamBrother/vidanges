<!DOCTYPE>
<html lang="fr">
	<head>
		<%@page isELIgnored="false" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
		<title>Vidanges Manager</title>
	</head>
	<body>
		<ul>
			<li><a href="<%=request.getContextPath()%>">Accueil</</a></li>
			<li><a href="<%=request.getContextPath()%>/voiture/list">Voitures</</a></li>
			<li><a href="<%=request.getContextPath()%>/entretien/list">Entretiens</</a></li>
		</ul>
		<table>
			<tr>
				<th>ID</th>
				<th>Propri�taire</th>
				<th>Marque</th>
				<th>Mod�le</th>
				<th>Couleur</th>
			</tr>
			<c:forEach items="${voitures}" var="voiture">
				<tr>
				<td>${voiture.id}</td>
				<td>${voiture.proprietaire}</td>
				<td>${voiture.marque}</td>
				<td>${voiture.modele}</td>
				<td>${voiture.couleur}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
