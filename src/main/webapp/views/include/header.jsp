<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<ul>
	<li><a href="<%=request.getContextPath()%>">Accueil</a></li>
	<li><a href="<%=request.getContextPath()%>/voiture/list">Voitures</a></li>
	<li><a href="<%=request.getContextPath()%>/entretien/list">Entretiens</a></li>
	<li><a href="<%=request.getContextPath()%>/proprietaire/list">Propriétaires</a></li>
</ul>