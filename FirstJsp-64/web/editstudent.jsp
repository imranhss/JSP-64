<jsp:useBean class="model.Student"  id="parvej" />
<%@page  import="dao.StudentDao" %>
<jsp:setProperty  name="parvej" property="*" />

<%
        
        int result=StudentDao.updateStudent(parvej);
        if(result > 0){
             response.sendRedirect("index.jsp");
    
            }
            else{
    response.sendRedirect("error.jsp");
    }


%>
