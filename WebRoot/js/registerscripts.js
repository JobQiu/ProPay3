		$(function(){
		var flagpwd = 0;
		var flagname= 0;
			$("#pwd2").keyup(function (e) {
			var pwd1 = $(this).val();
			var pwd2 = $("#pwd1").val();
		lastTime = e.timeStamp;
		setTimeout(function () {
		
		if (lastTime - e.timeStamp == 0) {
			if(pwd1 != pwd2){
			$(".page-container form").find('.error').fadeOut('fast', function(){
                $(this).css('top', '165px');
            });
				 $(".page-container form").find('.error').fadeIn('fast');
				 flagpwd=0;
				}
				else{
					flagpwd=1;
				}
			}
		
		}, 300); 
	});
	$("#text").keyup(function (e) {
		lastTime = e.timeStamp;
		setTimeout(function () {
		
		if (lastTime - e.timeStamp == 0) {
		//alert("进来了1");
			$.ajax({
				url:"canRegister",
				type:"post",
				data:{
				userName:$("#text").val()
				},
				success:function(data){
				//alert(data);
				var result=data.toString();
					if(result=="true"){
						flagname=1;
						
					}
					if(result=="false"){
					//alert("进来了2");
					$(".page-container form").find('.error').fadeOut('fast', function(){
                $(this).css('top', '25px');
            });
				 $(".page-container form").find('.error').fadeIn('fast');
						flagname=0;
					}
				}
			})
		}
		}, 300);
	});
		 $(".page-container form").submit(function(){
        var username = $(this).find('.username').val();
        var password = $(this).find('.password').val();
        var password2 =  $(this).find('.again').val();
        if(flagpwd+flagname==2){
		 			return true;
		 		}else{
		 			if(flagname==0){
		 				$(".page-container form").find('.error').fadeOut('fast', function(){
                $(this).css('top', '27px');
            });
				 $(".page-container form").find('.error').fadeIn('fast');
		 			}else if(flagpwd==0){
		 			
		 				$(".page-container form").find('.error').fadeOut('fast', function(){
                			$(this).css('top', '165px');
          			  });
						 $(".page-container form").find('.error').fadeIn('fast');
		 			}else{
					 			if(username == '') {
			            $(this).find('.error').fadeOut('fast', function(){
			                $(this).css('top', '27px');
			            });
			            $(this).find('.error').fadeIn('fast', function(){
			                $(this).parent().find('.username').focus();
			            });
			            return false;
			        }
			        if(password == '') {
			            $(this).find('.error').fadeOut('fast', function(){
			                $(this).css('top', '96px');
			            });
			            $(this).find('.error').fadeIn('fast', function(){
			                $(this).parent().find('.password').focus();
			            });
			            
			            return false;
			        }
			        if(password2 == '') {
			            $(this).find('.error').fadeOut('fast', function(){
			                $(this).css('top', '165px');
			            });
			            $(this).find('.error').fadeIn('fast', function(){
			                $(this).parent().find('.again').focus();
			            });
		 			
		 			return false;
		 			}
		 		}
		 	
        
            return false;
        }
    });
    

    $('.page-container form .username, .page-container form .password,.page-container form .again ').keyup(function(){
        $(this).parent().find('.error').fadeOut('fast');
    });
		 
		 		
		 
		 
		
		
});