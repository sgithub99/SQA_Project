<%@page import="com.green.bank.model.AccountModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculate Interest</title>
<link rel="shortcut icon" type="image/png" href="image/favicon.png" />
<link rel="stylesheet" type="text/css" href="css/deposit.css">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="row">
		<jsp:include page="header.jsp" />
	</div>
	<div class="container-fullwidth">
		<%
		AccountModel ac = null;
		%>
		<%
		ac = (AccountModel) session.getAttribute("userDetails");
		if (ac != null) {
		%>
		<div class="row" style="margin-top: 50px;">
			<div class="col-md-4 col-md-offset-4">
				<form role="form" method="post" action="">
					<h2>Calculate interest Form</h2>
					<div class="col-md-12">
						<hr class="colorgraph">
					</div>
					<label class="col-md-4 control-label">Sending money</label>
					<div class="col-sm-8 form-group">
						<input type="text" required placeholder="Enter Sending money.."
							name="sending_money" class="form-control">
					</div>
					<label class="col-md-4 control-label">Balance</label>
					<div class="col-sm-8 form-group">
						<input type="text" required placeholder="Enter Balance.."
							name="balance" class="form-control">
					</div>

					<label class="col-md-4 control-label">Sending days</label>
					<div class="col-sm-8 form-group">
						<input type="text" required placeholder="Enter sending day..."
							name="sendingDay" class="form-control">
					</div>

					<label class="col-md-4 control-label">Period</label>
					<div class="col-sm-8 form-group">
<!-- 						<input type="number" required placeholder="Enter period"
							class="form-control" name="period">  -->
							<select>
							<option>-----Choose-----</option>
							<option>1 month</option>
							<option>2 month</option>
							<option>3 month</option>
							<option>6 month</option>
							<option>12 month</option>
							<option>24 month</option>

						</select>
					</div>
					<div class="col-md-12">
						<hr class="colorgraph">
					</div>
					<%
					String EnoughMoney = (String) request.getAttribute("EnoughMoney");
					if (EnoughMoney != null && EnoughMoney.equals("No")) {
					%>
					<div class="col-md-12">
						<div class="alert alert-danger" role="alert">
							<strong>Sorry!</strong> You do not have enough money.
						</div>
					</div>
					<%
					}
					%>
					<%
					String isPassOK = (String) request.getAttribute("isPassOK");
					if (isPassOK != null && isPassOK.equals("No")) {
					%>
					<div class="col-md-12">
						<div class="alert alert-danger" role="alert">
							<strong>Sorry!</strong> Password incorrect.
						</div>
					</div>
					<%
					}
					%>
					<div class="row col-md-10 col-md-offset-1">
						<div class="col-xs-6 col-md-6">
							<input type="submit" value="Submit"
								class="btn btn-success btn-block btn-md" tabindex="7">
						</div>
						<div class="col-xs-6 col-md-6">
							<input class="btn btn-danger btn-block btn-md" type="reset"
								value="Reset">
						</div>
					</div>
				</form>
			</div>
		</div>
		<%
		} else {
		%>
		<div class="row" style="margin-top: 150px;">
			<div class="alert alert-warning col-md-4 col-md-offset-4"
				role="alert">
				<strong>Warning!</strong> You have to login first.
			</div>
		</div>

		<%
		}
		%>

		<!-- Footer start here -->
		<div class="row" style="margin-top: 50px;">
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>