let montageUrl = '@{/orders/montages/add/{id}(id=${client.id})}';
let offerViewUrl = '@{/orders/offer/add/{id}(id=${client.id})}';
$(document).ready(function () {
    let orderTypeMenu = $("#montageType");
    let productMenu = $("#productType");
    let brandMenu = $("#brand");
    let modelMenu = $("#product");

    let productHeader = $("#productHeader").hide();
    let descriptionHeader = $("#descriptionHeader").hide();
    let productTypeContainer = $("#productTypeContainer").hide();
    let newProductContainer = $("#newProductContainer").hide();
    let descriptionContainer = $("#descriptionContainer").hide();
    let selectedProductsBin = $("#selectedProducts");
    let allSelectedProducts = $("#allSelectedProducts");
    let productAddBtn = $("#productAddBtn");
    let selectedProductType;
    let selectedOrderType;

    hideDescriptionInput();
    attachDeleteBtnActions();

    productAddBtn.click(function (event) {
        event.preventDefault();

            let productType = $("#productType").val();
            let brand = $("#brand").val();
            let model = $("#product").val();
            let count = $("#count").val();
            let otherProduct = $("#otherProduct").val();
            let typeErrorField = $("#typeErrorField").hide();
            let countErrorField = $("#countErrorField").hide();

            if (count === "") {
                countErrorField.text("Въведете брой").show();
                return;
            }

            let newProduct = brand + ', ' + model + ', ' + count;
            let newOption = $('<option></option>');

            switch (productType) {
                case "AIRCONDS":
                    newOption.val(newProduct);
                    $(newOption).text(newProduct);
                    $("#aircProductsBin").append(newOption);
                    clearInputForms();
                    break;
                case "COOLERS":
                    newOption.val(newProduct);
                    $(newOption).text(newProduct);
                    $("#coolersProductsBin").append(newOption);
                    clearInputForms();
                    break;
                case "FRIDGES" || "CAMERAS":
                    newOption.val(newProduct);
                    $(newOption).text(newProduct);
                    $("#fridgeProductsBin").append(newOption);
                    clearInputForms();
                    break;
                default:
                    if (otherProduct === "" &&
                        productType === "") {
                        typeErrorField.text("Изберете продукт или въведете продукт в поле друго").show();
                        break;
                    }
                    $("#description").val(otherProduct);
                    clearInputForms();
                    break;
            }
    });

    orderTypeMenu.change(function () {

        selectedOrderType = $(this).val();

        if (selectedOrderType === "MONTAGE") {
            hideDescriptionInput();
            showProductMenu();
            let action = $("form").attr('action',montageUrl);

        } else if(selectedOrderType === ""){
            hideProductMenu();
            hideDescriptionInput();
            productTypeContainer.hide();
        } else {
            hideProductMenu();
            showDescriptionInput();
            let action = $("form").attr('action',offerViewUrl);
        }
    });

    productMenu.change(function () {
        selectedProductType = $(this).val().toLowerCase();
        if (selectedProductType !== "") {
            $.ajax({
                url: '/' + selectedProductType + '/search/findAllBy',
                type: 'get',
                dataType: 'json',
                success: function (data) {
                    let products = data._embedded[selectedProductType];
                    let len = products.length;

                    brandMenu.empty();
                    brandMenu.append("<option value=''>- Избери марка -</option>");
                    for (let i = 0; i < len; i++) {
                        let brand = products[i]['brand'];

                        brandMenu.append("<option value='" + brand + "'>" + brand + "</option>");
                    }
                }
            });
        }
    });

    brandMenu.change(function () {
        let brandName = $(this).val();

        $.ajax({
            url: '/' + selectedProductType + '/search/findAllByBrand?brand=' + brandName,
            type: 'get',
            dataType: 'json',
            success: function (data) {
                let products = data._embedded[selectedProductType];
                let len = products.length;

                modelMenu.empty();
                modelMenu.append("<option value=''>- Избери модел -</option>");
                for (let i = 0; i < len; i++) {
                    let model = products[i]['model'];

                    modelMenu.append("<option value='" + model + "'>" + model + "</option>");
                }
            }
        });
    });

    let submitBtn = $("#submitBtn");
    submitBtn.click(function () {
        selectAllChosenProducts();
    });

    function attachDeleteBtnActions() {
        selectedProductsBin.find('a').each(function () {
            $(this).click(function (event) {
                event.preventDefault();
                let selectedOptions = $(event.target).parent().prev('div').find('.form-control option:selected');
                selectedOptions.each(function () {
                    $(this).remove();
                });
            })
        })
    }

    function selectAllChosenProducts() {
        $(selectedProductsBin).find('select').each(function () {
            $(this).prop('selected');
        });
    }

    function showProductMenu() {
        productHeader.show();
        newProductContainer.show();
        allSelectedProducts.show();
        productAddBtn.show();
        productTypeContainer.show();
    }

    function showDescriptionInput() {
        descriptionHeader.show();
        descriptionContainer.show();
        productTypeContainer.show();
    }

    function hideProductMenu() {
        productHeader.hide();
        emptySelectedProducts();
        allSelectedProducts.hide();
        newProductContainer.hide();
        productAddBtn.hide();
    }

    function hideDescriptionInput() {
        descriptionHeader.hide();
        $(descriptionContainer).find('input').val("");
        descriptionContainer.hide();
    }

    function emptySelectedProducts() {
        $(selectedProductsBin).find('select').each(function () {
            $(this).empty();
        });
    }

    function clearInputForms() {
        $("#productType").val("");
        $("#brand").empty().append('<option value="">- Избери -</option>');
        $("#product").empty().append('<option value="">- Избери -</option>');
        $("#otherProduct").val("");
        $("#descriptionInput").val("");
        $("#count").val("");
    }

});