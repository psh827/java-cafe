console.log("hello")
$('.category_name').on('click', function(){
			var categoryId = $(this).attr('value')
			$(".category_name").each(function(index, el){
				$(el).removeClass("active")
				$(".menuItem_ul").empty();
			})
			$(this).addClass("active")
			if($(this).hasClass("active") == true){
	        $.ajax({
	            url: "requestObject",
	            type: "POST",
	            contentType: "application/json; charset=utf-8",
	            dataType: "text",
	            data: JSON.stringify({
				'categoryId': categoryId
				}),
	           success: function(data){
	            var html = ""
	            console.log(JSON.parse(data))
				$.each(JSON.parse(data), function(index, el){
					console.log(el.menuid)
					html = '<li class="menuItem"><a class="modal-btn" data-toggle="modal" data-target="#exampleModal" >'
					html += "<img src=/java-cafe/resources/menuImg/" + el.image.imgName + ">"
					html += "<div class='menu_text_box'><p class='menu_text'>" + el.menuItemName + "</p><p class='menu_text'>" + el.menuPrice +"원</p><p class='menu_text'>" + el.ihb +"</p></div>"
					html += "<span hidden>" + el.menuid + "</span></a><li>"
					$(".menuItem_ul").append(html)
				})	
	          },
	          error: function(){
	              alert("simpleWithObject err");
	          }
	      });			
	}
});

$(document).on('click', '.modal-btn', function() {
	console.log($(this))
	let imgName = $(this).find('img').attr('src').split('/')[4]
	console.log(imgName)
	$(".modal-body").empty();
	$.ajax({
	            url: "requestForModal",
	            type: "POST",
	            contentType: "application/json; charset=utf-8",
	            dataType: "text",
	            data: JSON.stringify({
				'imgName': imgName
				}),
	           success: function(data){
				
	            console.log(JSON.parse(data))
	            var data = JSON.parse(data)
		        var html = '<form name="form" class="modal-form"><img class="modal-img" src=/java-cafe/resources/menuImg/' + data.image.imgName + '>'
				html += '<input type="hidden" name="imgName" value="' + data.image.imgName + '">'
				html += '<div class="text-area"><span class="menu_name">'+ data.menuItemName+'</span>'
				html += '<input type="hidden" name="menuItemName" value="' + data.menuItemName + '">'
				html += '<span class="menu_price">' + data.menuPrice + '원</span>'
				html += '<input type="hidden" name="menuPrice" value="' + data.menuPrice + '">'
				html += '<span class="menu_ihb">' + data.ihb + '</span>'
				html += '<input type="hidden" name="ihb" value="' + data.ihb + '">'
				html += '<input type="number" max="10" class="numberInput" name="buyCount" value="1" />'
				html += '<div class="text-area_btngrp"><button class="modal-btn" type="button" data-dismiss="modal" aria-label="Close">이전으로</button>'
				html += '<button type="submit" class="modal-btn" formaction="main" formmethod="post">카트담기</button></div></div></form>'
				$(".modal-body").append(html)
				
	          },
	          error: function(){
	              alert("simpleWithObject err");
	          }
	      });
})

window.onload = function(){
	var sum = 0
	var total = $(".total_price")
	$(".cart_menuPrice").each(function(index, el){
		let money = $(el).text().split("원")[0]
		console.log(money)
		sum += Number(money)
	})
	total.text(sum + "원")
	
};

$(".delete_content").on("click", function(){
	var sum = 0
	let imgName = $(this).next().attr("src").split("/")[4]
	console.log(imgName)
	$(this).parents(".cart_content").remove()
	var total = $(".total_price")
	$(".cart_menuPrice").each(function(index, el){
		let money = $(el).text().split("원")[0]
		console.log(money)
		sum += Number(money)
	})
	total.text(sum + "원")
	$.ajax({
            url: "requestDelete",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            dataType: "text",
            data: JSON.stringify({
			'imgName': imgName
			}),
           success: function(data){
            console.log(JSON.parse(data))
          },
          error: function(){
              alert("simpleWithObject err");
          }
    });
	$(this).parents(".cart_content").remove()

});



