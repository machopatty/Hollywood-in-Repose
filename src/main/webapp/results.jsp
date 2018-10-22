<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>


<%@include file="head.jsp"%>

<html>
<body>

<div class="container-fluid">
    <h2>Search Results: </h2>


    <table width="100%" cellpadding="5px" border="1">
        <thead>
        <th>First Name </th>
        <th>Last Name </th>
        <th>User Name</th>
        <th>Email</th>
        <th>Celebrity Searches</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.lastName}</td>
                <td>${user.firstName}</td>
                <td>${user.userName}</td>
                <td>
                    <d:forEach var="userSearchResult" items="${user.userSearchResults}">
                        ${userSearchResult.id} ${userSearchResult.celebrityName}<br />
                    </d:forEach>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>


</div>

</body>
</html>
