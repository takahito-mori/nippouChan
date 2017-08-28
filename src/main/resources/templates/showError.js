<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script type="text/javascript">
	//入力チェックのための関数
	function input_check(){
		var result = true;

		//エラー用装飾のためのクラスリセット
		$('#title').removeClass("inp_error");
		$('#date').removeClass("inp_error");

		//入力エラー文をリセット
		$("#title_error").empty();
		$("#date_error").empty();

		//入力内容セット
		var title = $("#title").val();
		var date = $("#date").val();

		//入力内容チェック

		//タイトル
		if(title == ""){
			$("#title_error").html("<i class='fa fa-exclamation-circle'></i> タイトルを入力してください。");
			$("#title").addClass("inp_error");
			result = false;
		}

		//日付
		if(date == ""){
			$("#date_error").html("<i class='fa fa-exclamation-circle'></i> 日付を入力してください。");
			$("#date").addClass("inp_error");
			result = false;
		}

		return result;
	}

</script>