<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row cardHeader">
    <h4>Add Automobile</h4>
</div>
<div class="row">
    <form method="post" id="updateVehicleForm" onsubmit="event.preventDefault();" >
        <table>
            <tr class="d-flex">
                <td class="col-2">Car Type:</td>
                <td class="col-4">
                    <select name="carType" id="carType">
                        <c:if test="${vehicle.type eq 'electric'}"><option value="electric">Electric</option></c:if>
                        <c:if test="${vehicle.type eq 'gas'}"><option value="gas">Gas</option></c:if>
                        <c:if test="${vehicle.type eq 'diesel'}"><option value="diesel">Diesel</option></c:if>
                    </select>
                </td>
                <td class="col-2">Name:</td>
                <td class="col-4"><input value="${vehicle.name}" type="text" name="carName" id="carName"></td>
            </tr>
            <tr class="d-flex">
                <td class="col-2">Make:</td>
                <td class="col-4"><input value="${vehicle.make}" type="text" name="carMake" id="carMake"></td>
                <td class="col-2">Model:</td>
                <td class="col-4"><input value="${vehicle.model}" type="text" name="carModel" id="carModel"></td>
            </tr>
            <tr class="d-flex">
                <td class="col-2">Year:</td>
                <td class="col-4"><input value="${vehicle.year}" type="number" name="carYear" id="carYear" min="1900"></td>
                <td class="col-2">Odometer:</td>
                <td class="col-4"><input value="${vehicle.odometerReading}" type="number" name="carOdometerReading" id="carOdometerReading" min="0"></td>
            </tr>
            <tr class="d-flex">
                <td class="col-2">Owner:</td>
                <td class="col-4"><input value="${vehicle.owner}" type="text" name="carOwner" id="carOwner"></td>
                <td class="col-2">Colour:</td>
                <td class="col-4"><input value="${vehicle.colour}" type="text" name="carColour" id="carColour"></td>
            </tr>
            <tr class="d-flex">
                <td class="col-3" colspan="1">
                    <button type="button" onclick="submitUpdateVehicle('${vehicle.id}');">Save Vehicle</button>
                </td>
                <td class="col-3">
                    <button type="button" onclick="deleteAutomobile('${vehicle.id}');">Delete Vehicle</button>
                </td>
                <td class="col-6" colspan="2">
                    <span id="addErrorMessage"></span>
                </td>
            </tr>
        </table>
    </form>
</div>