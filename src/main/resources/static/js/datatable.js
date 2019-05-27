$(document).ready( function () {
    var table = $('#contractTable').DataTable({
        "sAjaxSource": "getList",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "id"},
            { "mData": "contractNumber" },
            { "mData": "software.name" },
            { "mData": "startDate" },
            { "mData": "endDate" },
            { "mData": "income" },
            { "mData": "range" },
            { "mData": "enabled" }
        ]
    })
});