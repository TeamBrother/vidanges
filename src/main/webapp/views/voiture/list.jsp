<!DOCTYPE>
<html lang="fr">
	<head>
		<%@page isELIgnored="false" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
		<title>C.DEFAYE's Blog</title>
	</head>
	<body>
		<ul>
			<c:forEach items="${voitures}" var="voiture">
				<li>${voiture}</li>
			</c:forEach>
		</ul>
	</body>
</html>
