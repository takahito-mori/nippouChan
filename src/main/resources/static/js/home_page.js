 $(function(){

     if($("pageNumber") == 0){
    	 $("#page").prop("disable", true);
     } else{
    	 $("#page").prop("disable", false);
     }
 });