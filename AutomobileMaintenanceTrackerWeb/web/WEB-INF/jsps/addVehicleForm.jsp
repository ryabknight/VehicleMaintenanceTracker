<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row cardHeader">
    <h4>Add Automobile</h4>
</div>
<div class="row">
    <form method="post" id="addVehicleForm" onsubmit="event.preventDefault();">
        <table>
            <tr class="d-flex">
                <td class="col-2">Car Type:</td>
                <td class="col-4">
                    <select name="carType" id="carType">
                        <option value="electric">Electric</option>
                        <option value="gas">Gas</option>
                        <option value="diesel">Diesel</option>
                    </select>
                </td>
                <td class="col-2">Name:</td>
                <td class="col-4"><input type="text" name="carName" id="carName"></td>
            </tr>
            <tr class="d-flex">
                <td class="col-2">Make:</td>
                <td class="col-4"><input type="text" name="carMake" id="carMake"></td>
                <td class="col-2">Model:</td>
                <td class="col-4"><input type="text" name="carModel" id="carModel"></td>
            </tr>
            <tr class="d-flex">
                <td class="col-2">Year:</td>
                <td class="col-4"><input value="1900" type="number" name="carYear" id="carYear" min="1900"></td>
                <td class="col-2">Odometer:</td>
                <td class="col-4"><input value="0" type="number" name="carOdometerReading" id="carOdometerReading"
                                         min="0"></td>
            </tr>
            <tr class="d-flex">
                <td class="col-2">Owner:</td>
                <td class="col-4"><input type="text" name="carOwner" id="carOwner"></td>
                <td class="col-2">Colour:</td>
                <td class="col-4"><input type="text" name="carColour" id="carColour"></td>
            </tr>
            <tr class="d-flex">
                <td class="col-3" colspan="1">
                    <button type="button" onclick="submitAddVehicle();">Add Vehicle</button>
                </td>
                <td class="col-9" colspan="3">
                    <span id="addErrorMessage"></span>
                </td>
            </tr>
        </table>
    </form>
</div>
