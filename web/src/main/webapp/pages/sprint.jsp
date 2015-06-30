<!DOCTYPE html>
<html lang="en">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap 101 Template</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Bootstrap theme</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="members">Members</a></li>
            <li><a href="#contact">Contact</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
	
	<br>
	<br>
	<br>

	<form action="/web/main">
	<button type="submit" class="btn btn-info">Main</button></form>

<P> T�H�N LISTATAAN SPRINTIN TEAMIN SIS�LT�. 

	<div class="col-md-6">
		<table class="table" action="save" method="post">
			<thead>
				<tr>
					<th>nimi</th>
					<th>rooli</th>
					<th>Commit-points</th>
				</tr>
			</thead>
			<tbody>
				<form action="save" method="post">
					<c:forEach items="${members}" var="member">
					<tr>
						<td><a href="user?id=${member.mid }">${member.name}</a></td>
						<td>${member.role}</td>
						
						<td>
						
							
							<p>Commit points: <input type="number" name="${member.name}" value=""></p>
						
						</td>
					</tr>
					</c:forEach>
					<input type="hidden" name="sprint" value="${Sprint.eid }">
					<button type="submit" class="btn btn-info">Add new team</button>
				</form>
			</tbody>
		
		</table>
		
	</div>








	


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>