<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Country-page</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"></c:url>"/>

</head>
<body onload="load();">

		<input type="hidden" id="countryId">
		Name: <input type="text" id="name" required="required" name="name"><br>
		Code:&nbsp <input type="text" id="countryCode" required="required" name="countryCode"><br>
		<button onclick="submit();">Submit</button>
	
		<table id="table" border=1>
			<tr> <th> CID </th> <th> NAME </th> <th> CODE </th> <th> Edit </th> <th> Delete </th> </tr>
		
		</table>
				
	<script type="text/javascript">
	data = "";
	submit = function(){
		 
			$.ajax({
				url:'saveOrUpdate',
				type:'POST',
				data:{countryId:$("#countryId").val(),name:$('#name').val(),countryCode:$('#countryCode').val()},
				success: function(response){
						alert(response.message);
						load();		
				}				
			});			
	}
	
	delete_ = function(id){		 
		 $.ajax({
			url:'delete',
			type:'POST',
			data:{countryId:id},
			success: function(response){
					alert(response.message);
					load();
			}				
		});
}
	

	edit = function (index){
		$("#countryId").val(data[index].countryId);
		$("#name").val(data[index].name);
		$("#countryCode").val(data[index].countryCode);
		
	}

	load = function(){	
		$.ajax({
			url:'list',
			type:'POST',
			success: function(response){
					data = response.data;
					$('.tr').remove();
					for(i=0; i<response.data.length; i++){					
						$("#table").append("<tr class='tr'> <td> "+response.data[i].countryId+" </td> <td> "+response.data[i].name+" </td> <td> "+response.data[i].countryCode+" </td> <td> <a href='#' onclick= edit("+i+");> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("+response.data[i].countryId+");'> Delete </a>  </td> </tr>");
					}			
			}				
		});
		
	}
		
	</script>
	
	</body>
</html>
