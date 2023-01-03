<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New License</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		
		
		<form:form action="/create/licence" method="post" modelAttribute="licencia">
		
			<h1>New License</h1>
			
			<div class="form-group">
				<form:label path="person">Person:</form:label>
				<form:select path="person">
					<c:forEach items="${persona}" var="personita">
						<form:option value="${personita.id}">${personita.getFirst_name()}   ${personita.getLast_name()}</form:option>
					</c:forEach>
				</form:select>
			</div>
			
			
			<div class="form-group">
				<form:label path="state">State: </form:label>
				<form:input path="state" class="form-control"/>
				<form:errors path="state" class="text-danger"/>
			</div>
			
			<div class="form-group">
                 <input type="date" name ="expiration_date"  value ="expiration_date"  class="form-control"/>
                 <form:errors path="expiration_date" class="text-danger"/>
            </div>
            <div class="form-group">
                 <form:hidden path="number" class="form-control"/>
                 <form:errors path="number" class="text-danger"/>
            </div>
			
			<input type="submit" value="Create" class="btn btn-success"/>
		
		</form:form>

		
		
		
	</div>
</body>
</html>