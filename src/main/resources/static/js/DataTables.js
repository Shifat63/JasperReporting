$(document).ready( function () {
    var table = $('#employeesTable').DataTable({
        "sAjaxSource": "/employee",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "empId"},
            { "mData": "name"},
            { "mData": "salary" },
            { "mData": "designation" }
        ]
    })
});