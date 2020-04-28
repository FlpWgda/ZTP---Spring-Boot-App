<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title> Druzyny</title>	
</head>

<body>

	
		<h2>Druzyny</h2>
		<c:forEach var="tempTeam" items="${teams}">
				
					<c:url var="updateLink" value="/showFormForUpdateTeam">
						<c:param name="teamId" value="${tempTeam.numer}" />
					</c:url>
					
					<c:url var="deleteLink" value="/deleteTeam">
						<c:param name="teamId" value="${tempTeam.numer}" />
					</c:url>
					
					<c:url var="detailsLink" value="/listPlayers">
						<c:param name="teamId" value="${tempTeam.numer}" />
					</c:url>
					
					<tr>
						<td> <a href="${detailsLink}">${tempTeam.nazwa}</a></td>
						<td> 
							
							<a href="${updateLink}">Modyfikuj</a>
							|
							<a href="${deleteLink}"
							onclick="if (!(confirm('Czy na pewno chcesz usunac druzyne?'))) return false">Usun</a>
						</td>
					</tr>
		 </c:forEach>
		 <input type="button" value="Dodaj druzyne"
				onclick="window.location.href='showFormForAddTeam'; return false;"
			/>
			

</body>

</html>