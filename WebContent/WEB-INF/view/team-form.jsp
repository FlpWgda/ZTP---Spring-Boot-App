<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="saveTeam" modelAttribute="team" method="POST">
		<form:hidden path="idP" />
		
		
		<table>
			<tbody>
				<tr>
					<td><label>Nazwa druzyny</label></td>
					<td><form:input path="nazwa" />
					<form:errors path="nazwa"/></td>
				</tr>
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Dodaj" /></td>
				</tr>
				
				
			</tbody>
		</table>
		
	</form:form>
	
	<p>
		<a href="${pageContext.request.contextPath}/">Powrot do listy</a> 
	</p>	
</body>
</html>