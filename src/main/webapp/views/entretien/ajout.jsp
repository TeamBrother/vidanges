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
			<form>
				<span>
					<label for="date">Date</label>
					<input type="text" name="date" id="date" value="${date}"/>
				</span><br />
				<span>
					<label for="idVoiture">ID Voiture</label>
					<select name="idVoiture" id="idVoiture">
						<c:forEach items="${voitures}" var="voiture">
							<option value="${voiture.id}">${voiture}</option>
						</c:forEach>
					</select>
				</span><br />
				<span>
					<label for="commentaire">Commentaire</label>
					<textarea name="commentaire" id="commentaire" value="" >${commentaire}</textarea>
				</span><br />
				<button type="submit">Ajouter</button>
			</form>
		</article>
		<jsp:include page="/views/include/footer.jsp" />
	</body>
</html>