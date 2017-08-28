$(function(){
	//alert('A');
	//作成ボタンを押したとき
	$('#update').submit(function(){
		var isErr = false;
		//alert('A');
		//タイトルが未入力の場合
		if($("input[name='nippouTitle']").val() == ''){
			$('#update_contents').text('');
			$('#err_title').text('タイトルを入力してください');

			isErr = true;
		} else{
			$('#err_title').text('');
		}
		//日付が未入力の場合
		var strDate = $("input[name='nippouTraining']").val();

		//var datetime_parse = strDate.replace(\/\g, '-');

		if(strDate == ''){
			$('#update_contents').text('');
			$('#err_date').text('日付を入力してください');
			isErr = true;
		} else{
			if(checkDate(strDate) == false){
				$('#update_contents').text('');
				$('#err_date').text('日付の形式を確認してください');
				isErr = true;
			} else{
				$('#err_date').text('');
			}
		}
		if(isErr){
			$('body').animate({scrollTop: 0}, 'fast');
			return false;
		}


		$("form").submit();
	});
});

//入力した文字列が日付の形式になっているかチェック
var checkDate = function(strDate){
	//正規表現による書式チェック
	if(!strDate.match(/^\d{4}\/\d{2}\/\d{2}$/)){ return false; }

	var vYear = strDate.substr(0, 4);
	var vMonth = strDate.substr(5, 2) - 1; //Javascriptは、月を0-11で表現
	var vDay = strDate.substr(8, 2);

	//月,日の妥当性チェック
	if(vMonth < 0){ return false; }
	if(vMonth > 31){ return false; }
	if(vDay < 1){ return false; }
	if(vDay > 31){ return false; }

	var vDt = new Date(vYear, vMonth, vDay);
	if(isNaN(vDt)){ return false; }
	if(vDt.getFullYear() != vYear){ return false; }
	if(vDt.getMonth() != vMonth){ return false; }
	if(vDt.getDate() != vDay){ return false; }

	return true;
}