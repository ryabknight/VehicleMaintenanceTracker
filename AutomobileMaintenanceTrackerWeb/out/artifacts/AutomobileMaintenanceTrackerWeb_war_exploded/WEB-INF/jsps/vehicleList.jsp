<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table>
    <tr class="d-flex">
        <th class="col-3">Type</th>
        <th class="col-3">Owner</th>
        <th class="col-3">Make</th>
        <th class="col-3">Model</th>
    </tr>
    <c:forEach items="${vehicles}" var="vehicle">
        <tr class="d-flex" onclick="loadViewVehicleElement('${vehicle.id}')">
            <td class="col-3"><c:out value="${vehicle.type}" /></td>
            <td class="col-3"><c:out value="${vehicle.owner}" /></td>
            <td class="col-3"><c:out value="${vehicle.make}" /></td>
            <td class="col-3"><c:out value="${vehicle.model}" /></td>
        </tr>
    </c:forEach>
</table>
