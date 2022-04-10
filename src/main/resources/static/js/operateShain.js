/**
 *
 */

 function cancel(){
	if(window.confirm("一覧画面に戻ります。よろしいですか？")){
		location.href = "/mst_shain";
	}
}

function registShinki(){
	//画面情報取得
	arrData = {
		"shain_code" : document.getElementById("shain_code").value,
		"shian_name" : document.getElementById("shain_name").value,
		"shian_name_kana" : document.getElementById("shain_name_kana").value,
		"password" : document.getElementById("password").value,
		"password2" : document.getElementById("password2").value,
		"login_flg" : 
	}

}