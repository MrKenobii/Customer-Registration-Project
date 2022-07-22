<%@taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Add Customer</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" type="text/css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Registration Manager</h2>
        </div>
    </div>
    <div id="container">
        <h3>Add Customer</h3>
        <c:form action="save-customer" modelAttribute="customer" method="POST">
            <table>
                <tbody>
                <tr>
                    <td><label>First name:</label></td>
                    <td><c:input path="firstName" /></td>
                </tr>

                <tr>
                    <td><label>Last name:</label></td>
                    <td><c:input path="lastName" /></td>
                </tr>

                <tr>
                    <td><label>Email:</label></td>
                    <td><c:input path="email" /></td>
                </tr>

                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save" class="save" /></td>
                </tr>


                </tbody>
            </table>
        </c:form>
        <div style="clear: both"></div>
        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
        </p>
    </div>
</body>
</html>