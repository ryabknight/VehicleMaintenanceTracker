<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row cardHeader">
    <h4>View Automobile</h4>
</div>
<div class="row">
    <table>
        <tr class="d-flex">
            <td class="col-3">Type:</td>
            <td class="col-3">${vehicle.type}</td>
            <td class="col-3">Name:</td>
            <td class="col-3">${vehicle.name}</td>
        </tr>
        <tr class="d-flex">
            <td class="col-3">Make:</td>
            <td class="col-3">${vehicle.make}</td>
            <td class="col-3">Model:</td>
            <td class="col-3">${vehicle.model}</td>
        </tr>
        <tr class="d-flex">
            <td class="col-3">Year:</td>
            <td class="col-3">${vehicle.year}</td>
            <td class="col-3">Odometer:</td>
            <td class="col-3">${vehicle.odometerReading}</td>
        </tr>
        <tr class="d-flex">
            <td class="col-3">Owner:</td>
            <td class="col-3">${vehicle.owner}</td>
            <td class="col-3">Colour:</td>
            <td class="col-3">${vehicle.colour}</td>
        </tr>
        <tr class="d-flex">
            <td class="col-12">
                <button type="button" onclick="loadUpdateVehicleElement('${vehicle.id}')">Edit Automobile</button>
            </td>
        </tr>
    </table>

</div>
<div class="row cardHeader">
    <h4>Maintenance Items</h4>
</div>
<div class="row">
    <table>
        <tr class="d-flex">
            <th class="col-12" colspan="2">Add maintenance item</th>
        </tr>
        <tr class="d-flex">
            <td class="col-6">Type:</td>
            <td class="col-6">
                <select name="maintenanceType" id="maintenanceType">
                    <c:if test="${vehicle.type ne 'electric'}">
                        <option value="Oil Change">Oil Change</option>
                    </c:if>
                    <option value="Tire Rotation">Tire Rotation</option>
                    <option value="Wax Vehicle">Wax Vehicle</option>
                </select>
            </td>
        </tr>
        <tr class="d-flex">
            <td class="col-6">Date:</td>
            <td class="col-6">
                <input value="2019-01-01" type="date" name="maintenanceDate" id="maintenanceDate">
            </td>
        </tr>
        <tr class="d-flex">
            <td class="col-12" colspan="2">
                <button type="button" onclick="addMaintenanceItem('${vehicle.id}');">Add item</button>
            </td>
        </tr>
    </table>
</div>
<div class="row">
    <table>
        <tr class="d-flex">
            <th class="col-4">Maintenance Type</th>
            <th class="col-4">Maintenance Date</th>
            <th class="col-4">Delete</th>
        </tr>
        <c:forEach items="${maintenanceItems}" var="item">
            <tr class="d-flex">
                <td class="col-4"><c:out value="${item.type}"/></td>
                <td class="col-4"><c:out value="${item.date}"/></td>
                <td class="col-4"><button type="button" onclick="deleteMaintenanceItem('${item.id}', '${vehicle.id}')">Delete</button></td>
            </tr>
        </c:forEach>
    </table>
</div>