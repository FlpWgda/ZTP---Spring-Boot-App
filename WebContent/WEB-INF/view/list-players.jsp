<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title> Zawodnicy</title>	
</head>

<body>

	
		<h2>Zawodnicy druzyny "${teamName}"</h2>
		<c:forEach var="tempPlayer" items="${players}">
				
					<c:url var="updateLink" value="/showFormForUpdatePlayer">
						<c:param name="playerId" value="${tempPlayer.idP}" />
					</c:url>
					
					<c:url var="deleteLink" value="/deletePlayer">
						<c:param name="playerId" value="${tempPlayer.idP}" />
					</c:url>
										
					
					<tr>
						<td> <a href="${detailsLink}">${tempPlayer.idP}</a></td>
						<td> 
							
							<a href="${updateLink}">Modyfikuj</a>
							|
							<a href="${deleteLink}"
							onclick="if (!(confirm('Czy na pewno chcesz usunac zawodnika?'))) return false">Usun</a>
						</td>
					</tr>
		 </c:forEach>
		 <input type="button" value="Dodaj zawodnika"
				onclick="window.location.href='showFormForAddPlayer'; return false;"
			/>
			

</body>

</html>