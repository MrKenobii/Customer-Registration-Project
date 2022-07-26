<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.anilduyguc.customerregistration.utils.SortUtils" %>
<c:url var="sortLinkFirstName" value="/customer/list">
	<c:param name="sort" value="<%= Integer.toString(SortUtils.FIRST_NAME) %>" />
</c:url>

<c:url var="sortLinkLastName" value="/customer/list">
	<c:param name="sort" value="<%= Integer.toString(SortUtils.LAST_NAME) %>" />
</c:url>

<c:url var="sortLinkEmail" value="/customer/list">
	<c:param name="sort" value="<%= Integer.toString(SortUtils.EMAIL) %>" />
</c:url>
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
				<form:form action="search" method="GET">
					Search customer: <input type="text" name="searchName" />

					<input type="submit" value="Search" class="add-button" />
				</form:form>
				<table>
					<tr>
						<th><a href="${sortLinkFirstName}">First Name</a></th>
						<th><a href="${sortLinkLastName}">Last Name</a></th>
						<th><a href="${sortLinkEmail}">Email</a></th>
						<th>Action</th>
					</tr>
					<c:forEach var="customer" items="${customers}">
						<c:url var="updateLink" value="/customer/show-form-for-update">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>

						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>
						<tr>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.email}</td>
							<td>
								<a href="${updateLink}">Update</a>
								|
								<a href="${deleteLink}"
								   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">
									Delete
								</a>
							</td>
						</tr>
					</c:forEach>

				</table>
			</div>
		</div>
</body>
</html>