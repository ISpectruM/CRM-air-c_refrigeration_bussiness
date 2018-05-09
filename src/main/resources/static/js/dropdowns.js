$(document).ready(function(){
    let orderTypeMenu = $("#montageType");
    let productMenu = $("#productType");
    let brandMenu =$("#brand");
    let modelMenu =$("#product");

    let productHeader = $("#productHeader");
    let descriptionHeader = $("#descriptionHeader");
    let productTypeContainer = $("#productTypeContainer");
    let productContainer = $("#productContainer");
    let descriptionContainer = $("#descriptionContainer").hide();
    let productEditBin = $("#productEditBin");
    let selectedProductType;
    let selectedOrderType;

    hideDescriptionInput();

    orderTypeMenu.click(function () {

        productEditBin.hide();

        selectedOrderType = $(this).val();

        if (selectedOrderType === "MONTAGE"){
            // $("#productTypeContainer").load("/orders/productsAddForm");
            hideDescriptionInput();
            showProductMenu();
        } else {
            hideProductMenu();
            showDescriptionInput();
        }
    });

    productMenu.change(function(){
        selectedProductType = $(this).val().toLowerCase();

        $.ajax({
            url: '/'+ selectedProductType +'/search/findAllBy',
            type: 'get',
            dataType: 'json',
            success:function(data){
                let products=data._embedded[selectedProductType];
                let len = products.length;

                brandMenu.empty();
                brandMenu.append("<option value=''>- Избери марка -</option>");
                for( let i = 0; i<len; i++){
                    let brand = products[i]['brand'];

                    brandMenu.append("<option value='"+brand+"'>"+brand+"</option>");
                }
            }
        });
    });

    brandMenu.change(function(){
        let brandName = $(this).val();

        $.ajax({
            url: '/'+ selectedProductType +'/search/findAllByBrand?brand=' + brandName,
            type: 'get',
            dataType: 'json',
            success:function(data){
                let products=data._embedded[selectedProductType];
                let len = products.length;

                modelMenu.empty();
                modelMenu.append("<option value=''>- Избери модел -</option>");
                for( let i = 0; i<len; i++){
                    let model = products[i]['model'];

                    modelMenu.append("<option value='"+model+"'>"+model+"</option>");
                }
            }
        });
    });

    function showProductMenu() {
        productHeader.show();
        productContainer.show();
        productTypeContainer.show();
    }

    function showDescriptionInput() {
        descriptionHeader.show();
        descriptionContainer.show();
        productTypeContainer.show();
    }

    function hideProductMenu() {
        productHeader.hide();
        productContainer.hide();
    }

    function hideDescriptionInput() {
        descriptionHeader.hide();
        descriptionContainer.hide();
    }

});