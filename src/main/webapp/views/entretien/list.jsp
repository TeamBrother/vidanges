<!DOCTYPE>
<html lang="fr">
	<head>
		<%@page isELIgnored="false" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<jsp:include page="/views/include/head.jsp" />
	</head>
	<body>
		<jsp:include page="/views/include/header.jsp" />
		<a href="<%=request.getContextPath()%>/entretien/ajout">Ajouter un entretien</a>
		<table>
			<tr>
				<th>Date</th>
				<th>Voiture</th>
				<th>Commentaire</th>
			</tr>
			<c:forEach items="${entretiens}" var="entretien">
				<tr>
					<td><a href="<%=request.getContextPath()%>/entretien/detail?id=${entretien.id}">${entretien.date}</a></td>
					<td><a href="<%=request.getContextPath()%>/voiture/detail?id=${entretien.voiture.id}">${entretien.voiture.marque} - ${entretien.voiture.modele}</a></td>
					<td>${entretien.commentaire}</td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="/views/include/footer.jsp" />
	</body>
</html>
