<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Customer List</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css">
</head>
<body>
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		</div>
		<div id="container">
			<div id="content">
				<input type="button" value="Add Customer"
					   onclick="window.location.href='show-form-for-add'; return false;"
					   class="add-button"
				>
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					<c:forEach var="customer" items="${customers}">
						<c:url var="updateLink" value="/customer/show-form-for-update">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>
						<tr>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.email}</td>
							<td>
								<a href="${updateLink}">Update</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
</body>
</html>