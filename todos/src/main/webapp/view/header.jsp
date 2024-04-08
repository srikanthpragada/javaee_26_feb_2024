<link rel="stylesheet" href="/todos/view/styles.css" />
<div class="banner">ToDo List</div>
<div class="menu">
	<a href="/todos/home">Home</a> &nbsp; <a href="/todos/add">Add Todo</a> &nbsp; <a
		href="/todos/list">List Todos</a> &nbsp; <a href="/todos/searchform">Search Todos</a> &nbsp;
	<span style="float: right"> User : <%=request.getUserPrincipal().getName()%> &nbsp;
	  <a href="logout">Logout</a>
	</span>
</div>
