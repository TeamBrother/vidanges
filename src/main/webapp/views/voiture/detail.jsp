<!DOCTYPE>
<html lang="fr">
	<head>
		<%@page isELIgnored="false" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<jsp:include page="/views/include/head.jsp" />
	</head>
	<body>
		<jsp:include page="/views/include/header.jsp" />
		<article>
			<span>ID: ${voiture.id}</span><br />
			<span>Propriétaire: <a href="<%=request.getContextPath()%>/proprietaire/detail?id=${voiture.proprietaire.id}">${voiture.proprietaire.nom} ${voiture.proprietaire.prenom}</a></span><br />
			<span>Marque : ${voiture.marque}</span><br />
			<span>Modèle : ${voiture.modele}</span><br />
			<span>Couleur : ${voiture.couleur}</span><br />
		</article>
		<table>
			<tr>
				<th>Date</th>
				<th>Commentaire</th>
			</tr>
			<c:forEach items="${entretiens}" var="entretien">
				<tr>
					<td><a href="<%=request.getContextPath()%>/entretien/detail?id=${entretien.id}">${entretien.date}</a></td>
					<td>${entretien.commentaire}</td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="/views/include/footer.jsp" />
	</body>
</html>
