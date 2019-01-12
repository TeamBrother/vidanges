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
			<span>ID: ${proprietaire.id}</span><br />
			<span>Nom : ${proprietaire.nom}</span><br />
			<span>Prénom : ${proprietaire.prenom}</span><br />
			<span>Adresse : ${proprietaire.adresse}</span><br />
		</article>
		<jsp:include page="/views/include/footer.jsp" />
	</body>
</html>
