<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Emp"%>
<%@page import="dao.EmpDao"%>
<%@page import="java.util.*"%>

<%@include file="header.jsp" %>

<%
    List<Emp> list = EmpDao.getAllEmp();
    request.setAttribute("list", list);
%>

<div class="container my-5">
    <h1 class="text-primary text-center mb-4">All Employees</h1>

    <table class="table table-bordered table-hover">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Salary</th>
                
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            
            
            <c:forEach items="${list}" var="s">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.salary}</td>
                    
                    <td>
                        <a href="empServelet?action=edit&id=${s.id}" class="btn btn-sm btn-primary">Edit</a>
                        <a href="empServelet?action=delete&id=${s.id}" class="btn btn-sm btn-danger"
                           onclick="return confirm('Are you sure you want to delete this Employee?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="footer.jsp" %>