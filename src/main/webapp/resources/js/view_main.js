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
	            contentType: "application/json; charset=euc-kr",
	            dataType: "text",
	            data: JSON.stringify({
				'categoryId': categoryId
				}),
	           success: function(data){
	            var html = ""
	            console.log(JSON.parse(data))
				$.each(JSON.parse(data), function(index, el){
					console.log(el.menuid)
					html = '<li class="menuItem"><a data-toggle="modal" data-target="#exampleModal" data-value='+ el.image.imageName + '>'
					html += "<img src=/java-cafe/resources/menuImg/" + el.image.imgName + ">"
					html += "<p>" + el.menuItemName + "</p><p>" + el.description + "</p><p>" + el.ihb +"</p></a><li>"
					$(".menuItem_ul").append(html)
				})	
	          },
	          error: function(){
	              alert("simpleWithObject err");
	          }
	      });			
	}
});

