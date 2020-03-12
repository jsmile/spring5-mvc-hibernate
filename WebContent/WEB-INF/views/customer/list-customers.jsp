<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>List Customer</title>

<link type="text/css" rel="stylesheet"
  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
  <div id="wrapper">
    <div id="header">
      <h2>CRM - Customer Relationship Manager</h2>
    </div>
  </div>

  <div id="container">
    <div id="content">
      <!-- add search box -->
      <form:form action="search" method="GET">
        Search Customer : <input type="text" name="searchName" />
        <button type="submit" class="add-button">Search</button>
      </form:form>
      <!-- add html table -->
      <table>
        <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Action</th>
        </tr>
        <c:forEach var="customer" items="${customers}">
          <c:url var="updateLink" value="/customer/showFormForUpdate">
            <c:param name="customerId" value="${customer.id}" />
          </c:url>
          <c:url var="deleteLink" value="/customer/delete">
            <c:param name="customerId" value="${customer.id}" />
          </c:url>

          <tr>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.email}</td>
            <td><a href="${updateLink}">Update</a> <a
              href="${deleteLink}"
              onclick="if( !(confirm( 'Are you sure you want to delete this customer ?')) ) return false;">Delete</a>
            </td>
          </tr>
        </c:forEach>
      </table>
      <!-- showFormForAdd is a relative path -->
      <input type="button" value="Add Customer"
        onclick="window.location.href='showFormForAdd'; return false;"
        class="add-button" />
    </div>
  </div>
</body>
</html>