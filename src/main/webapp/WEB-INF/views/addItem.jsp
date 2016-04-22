<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Registration Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <div class="form-container">

        <h1>New Phone Book Item</h1>

        <form:form method="POST" modelAttribute="phoneBookItem" class="form-horizontal">
            <form:input type="hidden" path="id" id="id"/>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="name">Name</label>

                    <div class="col-md-7">
                        <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="name" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="surname">Surname</label>

                    <div class="col-md-7">
                        <form:input type="text" path="surname" id="surname" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="name" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="patronymic">patronymic</label>

                    <div class="col-md-7">
                        <form:input type="text" path="patronymic" id="patronymic" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="patronymic" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="mobPhone">mobPhone</label>

                    <div class="col-md-7">
                        <form:input type="text" path="mobPhone" id="mobPhone" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="mobPhone" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="homePhone">homePhone</label>

                    <div class="col-md-7">
                        <form:input type="text" path="homePhone" id="homePhone" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="homePhone" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="address">address</label>

                    <div class="col-md-7">
                        <form:input type="text" path="address" id="address" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="address" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="name">email</label>

                    <div class="col-md-7">
                        <form:input type="text" path="email" id="email" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="email" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="form-actions floatRight">

                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a
                                href="<c:url value='/listAdmin' />">Cancel</a>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="addBook" class="btn btn-primary btn-sm"/> or <a
                                href="<c:url value='/listAdmin' />">Cancel</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>

        </form:form>
    </div>
</div>
</div>
</body>
</html>