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
	</body>
</html>
