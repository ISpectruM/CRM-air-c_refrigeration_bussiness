$(document).ready(function(){
    let productMenu = $("#productType");
    let brandMenu =$("#brand");
    let modelMenu =$("#product");
    let productType;

    productMenu.change(function(){
        productType = $(this).val().toLowerCase();

        $.ajax({
            url: '/'+ productType +'/search/findAllBy',
            type: 'get',
            dataType: 'json',
            success:function(data){
                let products=data._embedded[productType];
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
            url: '/'+ productType +'/search/findAllByBrand?brand=' + brandName,
            type: 'get',
            dataType: 'json',
            success:function(data){
                let products=data._embedded[productType];
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


});