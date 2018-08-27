$(document).ready(function () {
    let csrfHeader = $("meta[name='_csrf_header']").attr("content");
    let csrfToken = $("meta[name='_csrf']").attr("content");
    let saveButton = $('a[name="save"]');
    let errMessageField = $("#exception-message");
    let table = $('table');

    saveButton.click(function (event) {
        event.preventDefault();
        $(event.target).addClass('is-invalid');
        let messageField = $(event.target).parents('tr').find('.message');


        let currentEl = $(this); //<a>
        let data = {'status': {}};
        let orderId = currentEl.attr("data-id");//id
        let orderType = currentEl.attr("data-service");//service
        let scheduleDate = $(currentEl).parents('tr').find('#scheduleDate');
        let inputs = $(currentEl).parents('tr').find('form input');

        // fill result data
        inputs.each(function () {
            let status = data['status'];
            let input = $(this);
            status[input.attr("name")] = $(input).is(':checked');
        });

        data.id = orderId;
        data.type = orderType;
        data.scheduleDate = scheduleDate.val();
        let headers = {};
        headers[csrfHeader] = csrfToken;

        //    send to rest controller
        $.post({
            url: '/orders/save',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            headers: headers,
            success: function (data) {
                setSuccessFields(currentEl);
                showSuccessMessage(data, messageField);
            },
            error: function (e) {
                errMessageField.addClass('red-bold-font');
                errMessageField.text(e.statusMessage);
            }
        });
    });
    //Show warnings if changes are present in schedule`s orders
    $('.changeEvent').change(function (event) {
        $(event.target).parent('label').addClass('red-bold-font');
        $(event.target).addClass('red-bold-font');
        let messageField = $(event.target).parents('tr').find('.message');
        messageField.addClass('red-bold-font');
        messageField.text("Запази промените!")
    });


    function setSuccessFields(currentEl) {
        let redEl = currentEl.parents('tr').find('.red-bold-font');
        redEl.each(function () {
            $(this).removeClass("red-bold-font");
            $(this).addClass('.green-bold-font')
        });
    }

    function showSuccessMessage(data, messageField) {
        messageField.removeClass('red-bold-font');
        messageField.addClass('green-bold-font');
        messageField.text(data['message']);
    }

});