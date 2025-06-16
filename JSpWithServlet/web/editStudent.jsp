<%@ page import="model.Student" %>
<%@include file="header.jsp" %>

<%
    Student s = (Student) request.getAttribute("student");
%>

<div class="container my-3">
    <div class="bg-info text-white text-center p-2 rounded">
        <h2>Edit Student</h2>
    </div>

    <form action="studentservlet" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="<%= s.getId() %>">

        <div class="row mt-3">
            <div class="col-md-6">
                <label class="form-label">Name</label>
                <input type="text" class="form-control" name="name" value="<%= s.getName() %>" required>
            </div>

            <div class="col-md-6">
                <label class="form-label">Email</label>
                <input type="email" class="form-control" name="email" value="<%= s.getEmail() %>" required>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-md-6">
                <label class="form-label">Subject</label>
                <select class="form-select" name="subject" required>
                    <option value="JEE" <%= s.getSubject().equals("JEE") ? "selected" : "" %>>JEE</option>
                    <option value="NT" <%= s.getSubject().equals("NT") ? "selected" : "" %>>NT</option>
                    <option value="DDD" <%= s.getSubject().equals("DDD") ? "selected" : "" %>>DDD</option>
                    <option value="GAVE" <%= s.getSubject().equals("GAVE") ? "selected" : "" %>>GAVE</option>
                </select>
            </div>

            <div class="col-md-6">
                <label class="form-label">Gender</label><br>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" value="Male" <%= s.getGender().equals("Male") ? "checked" : "" %>>
                    <label class="form-check-label">Male</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" value="Female" <%= s.getGender().equals("Female") ? "checked" : "" %>>
                    <label class="form-check-label">Female</label>
                </div>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-md-6">
                <label class="form-label">Contact Number</label>
                <input type="text" class="form-control" name="contactNo" value="<%= s.getContactNo() %>" required>
            </div>
        </div>

        <div class="row mt-4 text-center">
            <div class="col-md-6">
                <button type="submit" class="btn btn-success w-100">Update</button>
            </div>
            <div class="col-md-6">
                <a href="allstudent.jsp" class="btn btn-secondary w-100">Cancel</a>
            </div>
        </div>
    </form>
</div>

<%@include file="footer.jsp" %>
