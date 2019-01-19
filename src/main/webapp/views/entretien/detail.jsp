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
			<span>Voiture: <a href="<%=request.getContextPath()%>/voiture/detail?id=${entretien.voiture.id}">${entretien.voiture}</a></span><br />
			<span>Commentaire: ${entretien.commentaire}</span><br />
			<a href="<%=request.getContextPath()%>/entretien/supprimer?id=${entretien.id}">Supprimer</a>
		</article>
		<jsp:include page="/views/include/footer.jsp" />
	</body>
</html>