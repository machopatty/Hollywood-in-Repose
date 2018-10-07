<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@include file="head.jsp"%>

<html>
<body>

    <div class="container-fluid">
        <h2>Search Results: </h2>


               <table width="100%" cellpadding="5px" border="1">
                   <tr>
                       <th>Last Name </th>
                       <th>First Name </th>
                       <th>User Name</th>
                       <th>Age</th>
                   </tr>
                   <c:forEach var="user" items="${users}">
                       <tr>
                           <td>${user.lastName}</td>
                           <td>${user.firstName}</td>
                           <td>${user.userName}</td>
                           <td>${user.age}</td>
                       </tr>
                    </c:forEach>
               </table>


    </div>

</body>
</html>
