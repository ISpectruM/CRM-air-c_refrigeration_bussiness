$(document).ready(function () {
    let csrfHeader = $("meta[name='_csrf_header']").attr("content");
    let csrfToken = $("meta[name='_csrf']").attr("content");
    let saveButton = $('a[name="save"]');
    let messageField = $("#message");
    let table = $('table');

    saveButton.click(function (event) {
        event.preventDefault();

        let currentEl = $(this); //<a>
        let data = {'status': {}};
        let orderId = currentEl.attr("data-id");//id
        let orderType = currentEl.attr("data-service");//service
        let scheduleDate = $(currentEl).parents('tr').find('#scheduleDate');
        let inputs = $(currentEl).parents('tr').find('form input');

        // fill result data
        fillStatusBooleans(inputs, data);

        data.id = orderId;
        data.type = orderType;
        data.scheduleDate = scheduleDate.val();
        let headers = {};
        headers[csrfHeader] = csrfToken;

        //    send to rest controller
        $.post({
            url:'/orders/save',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            headers:headers,
            success:function (data) {
                setSuccessFields(currentEl);
                showSuccessMessage(data);
            },
            error:function (e) {
                messageField.addClass('red-bold-font');
                messageField.text(e.statusMessage);
            }
        });
    });

    table.change(function (event) {
        $(event.target).addClass('is-invalid');
        messageField.addClass('red-bold-font');
        messageField.text("Запази промените!")
    });


    function fillStatusBooleans(inputs, data) {
        inputs.each(function () {
            let status = data['status'];
            let input = $(this);
            status[input.attr("id")] = $(input).is(':checked');
        });
    }

    function setSuccessFields(currentEl) {
        let redEl = currentEl.parents('tr').find('.is-invalid');
        redEl.each(function () {
            $(this).removeClass("is-invalid");
            $(this).addClass('.is-valid')
        });
    }

    function showSuccessMessage(data) {
        messageField.removeClass('red-bold-font');
        messageField.addClass('green-bold-font');
        messageField.text(data['message']);
    }

});