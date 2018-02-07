/**
 * 
 */
	data = "";
	submit = function(){
		 
			$.ajax({
				url:'saveOrUpdate',
				type:'POST',
				data:{countryId:id,name:$('#name').val(),countryCode:$('#countryCode').val()},
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
						$("#table").append("<tr class='tr'> <td> "+response.data[i].countryId+" </td> <td> "+response.data[i].name+" </td> <td> "+response.data[i].countryCode+" </td> <td> <a href='#' onclick= edit("+i+");> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("+response.data[i].user_id+");'> Delete </a>  </td> </tr>");
					}			
			}				
		});
		
	}
