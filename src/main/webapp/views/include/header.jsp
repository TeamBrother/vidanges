<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<div id="nav">
	<ul>
		<c:if test="${menu eq 'accueil'}">
			<c:set var="current_accueil" value=" class=\"current\""></c:set>
		</c:if>
		<c:if test="${menu eq 'voiture'}">
			<c:set var="current_voiture" value=" class=\"current\""></c:set>
		</c:if>
		<c:if test="${menu eq 'entretien'}">
			<c:set var="current_entretien" value=" class=\"current\""></c:set>
		</c:if>
		<c:if test="${menu eq 'proprietaire'}">
			<c:set var="current_proprietaire" value=" class=\"current\""></c:set>
		</c:if>
		<li><a href="<%=request.getContextPath()%>"${current_accueil}>Accueil</a></li>
		<li><a href="<%=request.getContextPath()%>/voiture/list"${current_voiture}>Voitures</a></li>
		<li><a href="<%=request.getContextPath()%>/entretien/list"${current_entretien}>Entretiens</a></li>
		<li><a href="<%=request.getContextPath()%>/proprietaire/list"${current_proprietaire}>Propriétaires</a></li>
	</ul>
</div>