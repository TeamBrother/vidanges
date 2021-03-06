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
				<th>Marque</th>
				<th>Mod�le</th>
				<th>Couleur</th>
				<th>Propri�taire</th>
			</tr>
			<c:forEach items="${voitures}" var="voiture">
				<tr>
				<td><a href="<%=request.getContextPath()%>/voiture/detail?id=${voiture.id}">${voiture.marque}</a></td>
				<td><a href="<%=request.getContextPath()%>/voiture/detail?id=${voiture.id}">${voiture.modele}</a></td>
				<td>${voiture.couleur}</td>
				<td><a href="<%=request.getContextPath()%>/proprietaire/detail?id=${voiture.proprietaire.id}">${voiture.proprietaire}</a></td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="/views/include/footer.jsp" />
	</body>
</html>
