/**
	*
 */

 function kensaku(){
	//alert("call kengen success");

	var arrData = {
		"shain" : document.getElementById("shain").value,
		"login_flg" : document.getElementById("login_flg").value,
		"kengen_code" : document.getElementById("kengen_code").value,
		"delete_flg" : document.getElementById("delete_flg").value
	}

	$.post(
		"/getPages",
		arrData,
		function(data){

			if(data == 0){
				$('#pagination').twbsPagination("destroy");
				document.getElementById("list").textContent = "該当データなし";
				return false;
			}
			$("#pagination").twbsPagination("destroy");
			$("#pagination").twbsPagination({
				totalPages: data,
				visiblePages: 5,
				onPageClick: function(event, page){
					arrData['page'] = page;
					getList(arrData);
				}
			})
		}
	)

}

function getList(arrData){
	$.post(
		"/getList",
		arrData,
		function(data){
			document.getElementById("list").innerHTML = data;
		}
	)
}