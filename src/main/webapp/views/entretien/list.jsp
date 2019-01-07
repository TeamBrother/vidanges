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
				<th>Date</th>
				<th>ID Voiture</th>
			</tr>
			<c:forEach items="${entretiens}" var="entretien">
				<tr>
					<td>${entretien.id}</td>
					<td>${entretien.date}</td>
					<td>${entretien.idVoiture}</td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="/views/include/footer.jsp" />
	</body>
</html>
