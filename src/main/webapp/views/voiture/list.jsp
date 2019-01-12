<!DOCTYPE>
<html lang="fr">
	<head>
		<%@page isELIgnored="false" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<jsp:include page="/views/include/head.jsp" />
	</head>
	<body>
		<jsp:include page="/views/include/header.jsp" />
		<table>
			<tr>
				<th>ID</th>
				<th>Propriétaire</th>
				<th>Marque</th>
				<th>Modèle</th>
				<th>Couleur</th>
			</tr>
			<c:forEach items="${voitures}" var="voiture">
				<tr>
				<td><a href="<%=request.getContextPath()%>/voiture/detail?id=${voiture.id}">${voiture.id}</a></td>
				<td><a href="<%=request.getContextPath()%>/proprietaire/detail?id=${voiture.proprietaire.id}">${voiture.proprietaire.nom} ${voiture.proprietaire.prenom}</a></td>
				<td>${voiture.marque}</td>
				<td>${voiture.modele}</td>
				<td>${voiture.couleur}</td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="/views/include/footer.jsp" />
	</body>
</html>
