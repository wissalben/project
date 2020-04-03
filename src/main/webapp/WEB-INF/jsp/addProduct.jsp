<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
<section>
<div class="jumbotron" <a href="<c:url value="/j_spring_security_logout" />" class="btn btn-
danger btn-mini pull-right">logout</a>>
<div class="container">
<h1>Products</h1>
<p>Add products</p>
</div>
</div>
</section>

<section class="container">
<form:form modelAttribute="newProduct" class="form-horizontal">
<fieldset>
<legend>Add new product</legend>

<div class="form-group">
<label class="control-label col-lg-2 col-lg-2" for="productId">
<spring:message code= "addProduct.form.productId.label"/> </label>
<div class="col-lg-10">
<form:input id="productId" path="productId" type="text"
class="form:input-large"></form:input>
</div>
</div>

<div class="form-group">
<label class="control-label col-lg-2 col-lg-2"
for="name">name</label>
<div class="col-lg-10">
<form:input id="name" path="name" type="text"
class="form:input-large"/>
</div>
</div>

<div class="form-group">
<label class="control-label col-lg-2 col-lg-2"
for="unitPrice"> unit Price</label>
<div class="col-lg-10">
<form:input id="unitPrice" path="unitPrice" type="text"
class="form:input-large"/>
</div>
</div>


<div class="form-group">
<label class="control-label col-lg-2"
for="description">Description</label>
<div class="col-lg-10">
<form:textarea id="description" path="description" rows =
"2"></form:textarea>
</div>
</div>

<div class="form-group">
<label class="control-label col-lg-2 col-lg-2"
for=" category"> category</label>
<div class="col-lg-10">
<form:input id="category" path="category" type="text"
class="form:input-large"></form:input>
</div>
</div>

<div class="form-group">
<label class="control-label col-lg-2 col-lg-2"
for=" manufacturer"> manufacturer</label>
<div class="col-lg-10">
<form:input id="manufacturer" path="manufacturer" type="text"
class="form:input-large"></form:input>
</div>
</div>

<div class="form-group">
<label class="control-label col-lg-2 col-lg-2"
for=" unitsInStock">units In Stock</label>
<div class="col-lg-10">
<form:input id="unitsInStock" path="unitsInStock" type="text"
class="form:input-large"></form:input>
</div>
</div>

<div class="form-group">
<label class="control-label col-lg-2 col-lg-2"
for=" unitsInOrder">units In Order</label>
<div class="col-lg-10">
<form:input id="unitsInOrder" path="unitsInOrder" type="text"
class="form:input-large"></form:input>
</div>
</div>
<div class="form-group"><label class="control-label col-lg-2"
for="discontinued">Discontinued</label>
<div class="col-lg-10">
<form:checkbox id="discontinued" path="discontinued"/>
</div>
</div>
<div class="form-group">
<label class="control-label col-lg-2"
for="condition">Condition</label>
<div class="col-lg-10">
<form:radiobutton path="condition" value="New" />New
<form:radiobutton path="condition" value="Old" />Old
<form:radiobutton path="condition" value="Refurbished"
/>Refurbished
</div>
</div>
<div class="form-group">
<div class="col-lg-offset-2 col-lg-10">
<input type="submit" id="btnAdd" class="btn btn-primary"
value ="Add"/>
</div>
</div>
</fieldset>
</form:form>
</section>
</body>
</html>