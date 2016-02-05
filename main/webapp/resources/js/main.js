"use strict";
$(document).ready(function() {

      // Initialize the plugin
      $('#my_popup').popup();
    $('#login_popup').popup();
    $('#edit_popup').popup();
    $('#addanidea_popup').popup();
    });
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide",
    animationLoop: true,
    itemWidth: 620,
    itemMargin: 1
  });
});
$(document).ready(function() {

    $('#headerlogin').on('click',function(){
    $('.loginmodal').show();
    })
    if($('.invaliduserpass').length>0){
        $('.loginmodal').show();
    }
    
    $("input[name='firstName']").on("blur",function(){
          var fnval = $("input[name='firstName']").val();
          if(!fnval.match(/^[a-zA-Z0-9_]*$/)){
              $("#firstNameerror").show();
              document.getElementById("firstNameerror").innerHTML = "Please enter valid Name";
          }else{
              $("#firstNameerror").hide();
          }
          });
    
    
    $("input[name='lastName']").on("blur",function(){
          var lnval = $("input[name='lastName']").val();
          if(!lnval.match(/^[a-zA-Z0-9_]*$/)){
              $("#lastNameerror").show();
              document.getElementById("lastNameerror").innerHTML = "Please enter valid Name";
          }else{
              $("#lastNameerror").hide();
          }
        })
    $("input[name='email']").on("blur",function(){
          var email = $("input[name='email']").val();
          if(!email.match(/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i) && email.length > 0){
              $("#emailerror").show();
              document.getElementById("emailerror").innerHTML = "Please enter valid Email";
          }else{
              $.ajax({
              type: "Get",
              url: "http://localhost:8080/checkemail",
              data: "email=" + $("input[name='email']").val(),
              success: function(response){
               if(response == 'true'){
                   $("#emailerror").show();
                   document.getElementById("emailerror").innerHTML = "Email already Exist";
               }else{
                $("#emailerror").hide();   
               }
              }
              });
              
          }
    	})     
            
    $("input[name='password']").on("blur",function(){
          var pwd = $("input[name='password']").val();
          if(pwd.length > 0 && !pwd.match(/^[a-zA-Z0-9_]*$/)){
              $("#passworderror").show();
              document.getElementById("passworderror").innerHTML = "Please enter valid password";
          }else if(pwd.length > 0 && pwd.length < 6){
              $("#passworderror").show();
          document.getElementById("passworderror").innerHTML = "Password should be minimum 6 letter";
          }
          else{
              $("#passworderror").hide();
          }
            })   
                
                
    $("input[name='confirmPassword']").on("blur",function(){
          var pwd = $("input[name='password']").val();
          var cpwd = $("input[name='confirmPassword']").val();
          if(cpwd.length > 0 && !cpwd.match(/^[a-zA-Z0-9_]*$/)){
              $("#confirmPassworderror").show()
              document.getElementById("confirmPassworderror").innerHTML = "Please enter valid password";
          }                                 
          else if(pwd != cpwd){
              $("#confirmPassworderror").show()
                document.getElementById("confirmPassworderror").innerHTML = "Password Mismatch";
          }else{
              $("#confirmPassworderror").hide();
          }
      });
    $("input[name='phone']").on("blur",function(){
    var phone = $("input[name='phone']").val();
        if(!phone.match(/^[2-9]{1}[0-9]{9}$/) && phone.length > 0){
              $("#phoneerror").show();
              document.getElementById("phoneerror").innerHTML = "<br>Please enter 10 digit phone number";
          } 
        else{
              $("#phoneerror").hide();
          }
    });
     
    $('.registersubmit').on('click',function(){
    var error = $('.error').filter(":visible");
        if(error.length > 0){
        return false;
        }
    })
    
   $('.accounticonbutton').on('hover',function(){
    var account = $('.useraccountdropdown');
    var divele = $('#singledropdownelement');
       
    	   divele.html(function(){
           var htmlele = '';
               for(var i=0;i<account.length;i++){
    	   var userAccount = account[i];
    	   var ji = 10 + i*20;
           htmlele = htmlele + '<div style="margin-top: 6px;border-bottom-style: ridge;border-bottom-color: #DB7878;border-bottom-width: thin;"><a style="text-decoration: inherit" href="'+$(userAccount).data('linkRef')+'">'+$(userAccount).data('displayName')+'</a></div>';        
               }
               return htmlele;
           });
    	   divele.show();
           
               
       
   });
    $('#singledropdownelement').on('mouseleave',function(){
    $('#singledropdownelement').hide();
    });
     });
    $(document).ready(function(){
   
    $('#loginbutton').on('click',function(){
        var postform = {
            "userName" : $("input[name='userName']").val(),
            "passWord" :$("input[name='passWord']").val()
        };
        $.ajax({
              type: "Post",
              url: "http://localhost:8080/verifyuser",
              data: postform,
              success: function(response){
               if(response == 'false'){
                  $('#userForm').submit();
                   
               }else{
                $(".error").show();   
                  
               }
    
              }
            
              });
        return false;
    });
        
        $('#searchbutton').on('click',function(){
            if($("input[name='searchterm']").val() != ''){
        window.location.href = '/search?searchTerm='+$("input[name='searchterm']").val();
           if($.isEmptyObject($('.searchresults') .data('ideaSearchData') == false)) { 
              
              }
                
            }
        });
        $('#suggesttextarea').on('keyup',function(e){
            var count = $('#suggesttextarea').val().length;
        if(count > 900){
            $('#suggesttextarea').val($('#suggesttextarea').val().substring(0,900));
        }else{
            document.getElementById('countsuggestiontext').innerHTML=900 - count;
        }
        })
        $('#addanideatextarea').on('keyup',function(e){
            var count = $('#addanideatextarea').val().length;
        if(count > 900){
            $('#addanideatextarea').val($('#addanideatextarea').val().substring(0,900));
        }else{
            document.getElementById('countaddanidetext').innerHTML=900 - count;
        }
        })
        $('#addanideaheadingtextarea').on('keyup',function(e){
            var count = $('#addanideaheadingtextarea').val().length;
        if(count > 400){
            $('#addanideaheadingtextarea').val($('#addanideaheadingtextarea').val().substring(0,400));
        }else{
            document.getElementById('countaddanideaheadingtext').innerHTML=400 - count;
        }
        })
        $('#addanideasubmit').on('click',function(){
            if($('#addanideaheadingtextarea').val().length < 20){
                $('.ideaheadingerror').show();
                return false;
            }else{
                $('.ideaheadingerror').hide();
            }
            
            if($('#addanideatextarea').val().length < 20){
                $('.ideabodyerror').show();
                return false;
            }else{
                $('.ideabodyerror').hide();
            }
            
            var selectVal = $('#selectcategoryid').val();
        if(selectVal != 'science' && selectVal != 'technology' && selectVal != 'politics' && selectVal != 'entertainment' && selectVal != 'others'){
            $('.selecterror').show();
            return false;
        }else{
            $('.selecterror').hide();
        }
        
        })
     });
   
