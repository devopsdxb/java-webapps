<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<title>Owners</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<h3 align="center">List of Owners</h3>
	<div style="float: left; width: 15%; padding-left: 25px;">
		<form id="form1" name="form1" method="post" action="/ownerapp/owner">
			<select multiple name="selectID" size="15" class="form-control">
				<c:forEach items="${allOwners}" var="owner">
					<option value="${owner.id}">${owner.firstName} ${owner.lastName}</option>
				</c:forEach>
			</select> <br>
			<input type="submit" name="Submit" value="Submit"
				class="btn btn-default" />
		</form>
	</div>
	<div style="float: left; padding-left: 75px;">
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th style="text-align: center;">Owners</th>
			</tr>
			<c:forEach items="${ownerList}" var="owner">
				<tr>
					<td>
					ID: ${owner.id}<br>
					Name: ${owner.firstName} ${owner.lastName}<br>
					Address: ${owner.address}<br>
					City: ${owner.city}<br>
					Telephone: ${owner.telephone}<br>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<script type="text/javascript">
	window.onmousedown = function(e) {
		var el = e.target;
		if (el.tagName.toLowerCase() == 'option'
				&& el.parentNode.hasAttribute('multiple')) {
			e.preventDefault();
			if (el.hasAttribute('selected'))
				el.removeAttribute('selected');
			else
				el.setAttribute('selected', '');
			var select = el.parentNode.cloneNode(true);
			el.parentNode.parentNode.replaceChild(select, el.parentNode);
		}
	}
</script>
</html>
