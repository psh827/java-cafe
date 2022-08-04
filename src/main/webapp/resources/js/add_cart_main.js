/**
 * 
 */
let quantity = $(".buyCount").val();
$(".plus_btn").on("click", function(){
	$(".buyCount").val(++quantity);
});
$(".minus_btn").on("click", function(){
	if(quantity > 1){
			$(".buyCount").val(--quantity);	
		}
});

