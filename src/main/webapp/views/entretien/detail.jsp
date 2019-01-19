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
			<span>ID: ${entretien.id}</span><br />
			<span>Date: ${entretien.date}</span><br />
			<span>Voiture: <a href="<%=request.getContextPath()%>/voiture/detail?id=${entretien.voiture.id}">${entretien.voiture.marque} ${entretien.voiture.modele}</a> <a href="<%=request.getContextPath()%>/proprietaire/detail?id=${entretien.voiture.proprietaire.id}">(${entretien.voiture.proprietaire.nom} ${entretien.voiture.proprietaire.prenom})</a></span><br />
			<span>Commentaire: ${entretien.commentaire}</span><br />
			<a href="<%=request.getContextPath()%>/entretien/supprimer?id=${entretien.id}">Supprimer</a>
		</article>
		<jsp:include page="/views/include/footer.jsp" />
	</body>
</html>