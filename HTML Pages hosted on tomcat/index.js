window.onload=function(){

alert ("admin page");
}



 
$.ajax({
url : "http://localhost:9000/transactionHistory",
type: "GET",
dataType : "json",
success function(data){

$("#transactionTable").dataTable({

data:data,
columns :[
{data : "id"},
{data : "amount"},
{data : "transactionType"},
{data : "createdOn"},
{data : "description"}

]
});
