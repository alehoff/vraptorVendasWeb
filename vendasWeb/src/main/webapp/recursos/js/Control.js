/**
 *
 */

 var sistema = {

  ajaxGet:function(url,data,divAlvo) {

      $.ajax({
          url: url,
          data:data,
          beforeSend:function(){
            $("#"+divAlvo).html("<h1>Localizando. Favor aguardar...</h1>")  ;
          },
          success: function (data) {
              $('#'+divAlvo).empty().html(data);
          }
      });
    },

    ajaxPost:function(form){
      $.ajax({
          url: $("#"+form).attr("action"),
          data:$("#"+form).serialize(),
          type:$("#"+form).attr("method"),
          beforeSend:function(){
            $("#pagina").html("<h1>Realizando cadastro. Favor aguardar...</h1>")  ;
          },
          success: function (data) {
              $('#pagina').empty().html(data);
          }
      });
    }
 };
