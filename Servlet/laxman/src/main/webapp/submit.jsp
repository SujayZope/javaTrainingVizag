<h1>heyy submit</h1>
 <script
 	src="https://code.jquery.com/jquery-3.6.0.min.js">
 </script>
  <% String name = request.getParameter("name"); %>
    <% String email = request.getParameter("email");
    %>
   <% String[] nameArray = {"laksh","sujay","saurabh"};
   		StringBuilder jsonArray = new StringBuilder("[");
   		for(int i=0;i<nameArray.length;i++){
   			jsonArray.append("'"+nameArray[i]+"'");
   			if(i<nameArray.length-1){
   				jsonArray.append(", ");
   			}
   		}
   		jsonArray.append("]");
   		
   %>
   
    
    <%-- Display retrieved parameters --%>
    <p>Name: <%= name %></p>
    <p>Email: <%= email %></p>
     <button onclick="myFunction()">Click Me</button>
    
    <script>
    function myFunction(){
    	console.log("calling myFunction");
    	console.log("my name"+ "<%=name %>");
		name ="<%=name %>";
		paramNamesC="<%=jsonArray.toString() %>";
		console.log("yyyy"+paramNamesC)
		jsonDataToSend= JSON.stringify(paramNamesC);
		console.log("hey n"+jsonDataToSend);
		
		  $.ajax({
              url: "process.jsp", // URL of the JSP file you want to send the AJAX request to
              method: "POST",
              data: {
                  param1:name,
                  param2:jsonDataToSend
              },
              success: function(response) {
                  // Handle the response here
               	console.log("response is here  "+response);
              },
              error: function( error) {
                  // Handle errors here
                  console.error(error);
              }
          });
        }
		
    </script>