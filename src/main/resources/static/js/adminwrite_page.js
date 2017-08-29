$(function(){

	//作成ボタンを押したとき
	$("form").submit(function(){
		var isErr = false;
		//名前が未入力の場合
		if($("input[name='userName']").val() == ''){
			$('#err_name').text('名前を入力してください');
			isErr = true;
		} else{
			$('#err_name').text('');
		}
		//フリガナが未入力の場合
		if($("input[name='userKana']").val() == ''){
			$('#err_kana').text('フリガナを入力してください');
			isErr = true;
		} else{
			$('#err_kana').text('');
		}
		//社員IDが未入力の場合
		if($("input[name='userId']").val() == ''){
			$('#err_id').text('社員IDを入力してください');
			isErr = true;
		} else{
			$('#err_id').text('');
		}
		//メールアドレスが未入力の場合
		if($("input[name='userMail']").val() == ''){
			$('#err_mail').text('メールアドレスを入力してください');
			isErr = true;
		} else{
			$('#err_mail').text('');
		}

		//パスワードが未入力の場合
		if($("input[name='userPassword']").val() == ''){
			$('#err_password').text('パスワードを入力してください');
			isErr = true;
		} else{
			$('#err_password').text('');
		}


		if(isErr){
			//$('body').animate({scrollTop: 0}, 'fast');
			return false;
		}
		$("form").submit();
	});
});