/**
 *
 */

 window.onload = function() {
 }

 $(document).ready(function() {

     var status = $('#status').text();
     alert(status);

     if(status != null || status != "") {
         if(status == "masoOK") {
             $('#formMatKhau').show();
             $('#formMaSo').hide();
         }
     } else {
         $('#formMatKhau').hide();
         $('#formMaSo').show();
     }

 });
