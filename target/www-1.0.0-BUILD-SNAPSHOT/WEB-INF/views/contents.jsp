<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>content</title>
</head>
<body>
	<form id="listForm" action="" method="post">
			�Խù� ��ȣ : ${user.u_num}
			<br>
			�Խù� ���� : ${user.u_name}
			<br>
			�Խù�
			<br>
			<textarea rows="10" cols="50" name="u_contents">${ user.u_contents }</textarea>
			<br>
			��й�ȣ : <input  type="password" id="c_pw" name="c_pw" />
			<br>
			<input type="button" value="����" onclick="updateBoard('update')"/>
			<input type="button" value="delete" onclick="doDelete('${ user.u_num }')"/>
			<input type="button" value="back" onclick="back()"/>
			<input type="hidden" id="u_num" name="u_num" value="${ user.u_num }">
	</form>

	<script>
		function updateBoard(args) {
			var formData1 = new FormData();
			formData1.append("c_pw", document.getElementById("c_pw").value);
			formData1.append("u_num", document.getElementById("u_num").value);
			$.ajax({
				method:"post",
	            url:"http://localhost:8080/www/"+args,
	            data:$("#listForm").serialize(),
	            success:function(data){
	            	console.log(data);
	                if (data==false) {
	                	alert("��й�ȣ�� �ٸ��ϴ�");
	                } else {
	                	document.getElementById("listForm").action=args;
						document.getElementById("listForm").submit();		
	                }
	            },
	            error:function(e){  
	                alert(e.responseText);  
	            }  
	        })
	        
			/* var formData1 = new FormData();
			formData1.append("c_pw", document.getElementById("c_pw").value);
			formData1.append("u_num", document.getElementById("u_num").value);
			if ("" == document.getElementById("c_pw").value){
				alert("��й�ȣ�� �Է����ּ���");
			} else {
			 	var xhr = new XMLHttpRequest();
			 	xhr.onreadystatechange = function() {
			    	if (xhr.status == 200) {
			    		if (xhr.responseText == false) {
					    	alert("��й�ȣ�� �ٸ��ϴ�"); 
			    		} else {
			    			document.getElementById("listForm").action=args;
							document.getElementById("listForm").submit();			    			
			    		}
			    	}
		    	};
		    	xhr.open("POST", args);
		    	//xhr.send(formData1);
		    	xhr.send(formData1);
			} */
			
		}
		function doDelete(){
			//location.href = "delete?u" + arguments[0];
			var form = document.getElementById("listForm");
			form.action="delete";
			form.submit();
		}
		function back(){
			location.href = "list";
		}
	</script>
</body>
</html>

