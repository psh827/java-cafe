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
					html = '<li class="menuItem"><a class="modal-btn" onclick="test(event)" data-toggle="modal" data-target="#exampleModal" >'
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


function test(event){
	console.log(event.path[2])
	let info = event.path[2]
	let modalMenuName = info.firstChild.firstChild.getAttribute("src").split("/")[4]
	console.log(modalMenuName)
	var reqJson = new Object();
	reqJson.imgName = modalMenuName;
	httpRequest = new XMLHttpRequest();
	 httpRequest.onreadystatechange = () => {
	    	/* readyState가 Done이고 응답 값이 200일 때, 받아온 response로 name과 age를 그려줌 */
		    if (httpRequest.readyState === XMLHttpRequest.DONE) {
			      if (httpRequest.status === 200) {
			    	var result = httpRequest.response;
			    	console.log(result)
			    	var modalbody = document.querySelector(".modal-body")
					removeAllchild(modalbody)
			    	let img = document.createElement('img')
			    	img.setAttribute('src','/java-cafe/resources/menuImg/' + result.image.imgName )
			    	modalbody.appendChild(img)
			    	let textdiv = document.createElement("div")
			    	textdiv.setAttribute('class', 'text-area')
			    	modalbody.appendChild(textdiv)
			    	let menuName = document.createElement("span")
			    	menuName.innerText = result.menuItemName
			    	textdiv.appendChild(menuName)
			    	let menuPrice = document.createElement("span")
			    	menuPrice.innerText = result.menuPrice
			    	textdiv.appendChild(menuPrice)
			    	let menuihb = document.createElement("span")
			    	menuihb.innerText = result.ihb
			    	textdiv.appendChild(menuihb)
			    	
			      } else {
			        alert('request에 뭔가 문제가 있어요.');
			      }
			}
	    };
	     httpRequest.open('POST', '/java-cafe/kiosk/requestForModal', true);
	    /* Response Type을 Json으로 사전 정의 */
	    httpRequest.responseType = "json";
	    /* 요청 Header에 컨텐츠 타입은 Json으로 사전 정의 */
	    httpRequest.setRequestHeader('Content-Type', 'application/json');
	    /* 정의된 서버에 Json 형식의 요청 Data를 포함하여 요청을 전송 */
	    httpRequest.send(JSON.stringify(reqJson));
}

function removeAllchild(div) {
    while (div.hasChildNodes()) {
        div.removeChild(div.firstChild);
    }
}
