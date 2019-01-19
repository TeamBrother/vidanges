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
				<th>Nom</th>
				<th>Prénom</th>
				<th>Adresse</th>
			</tr>
			<c:forEach items="${proprietaires}" var="proprietaire">
				<tr>
					<td><a href="<%=request.getContextPath()%>/proprietaire/detail?id=${proprietaire.id}">${proprietaire.nom}</a></td>
					<td><a href="<%=request.getContextPath()%>/proprietaire/detail?id=${proprietaire.id}">${proprietaire.prenom}</a></td>
					<td>${proprietaire.adresse}</td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="/views/include/footer.jsp" />
	</body>
</html>
