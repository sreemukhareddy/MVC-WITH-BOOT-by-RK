<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>


<div class="container"> 
${name}-ToDo

<form:form method="post" commandName="todo">
	<form:hidden path="id"/>
	
	<fieldset class="form-group">
		<form:label path="desc">Description: </form:label>
		<input path="desc" type="text" name="desc" class="form-control" required="required"></input>
		<form:errors path="desc" cssClass="text-warning"/>
	</fieldset>
	
	<fieldset class="form-group">
		<form:label path="targetDate">Target Date: </form:label>
		<input path="targetDate" type="text" name="targetDate" class="form-control" required="required"></input>
		<form:errors path="targetDate" cssClass="text-warning"/>
	</fieldset>
	
<button class="btn btn-success" type="submit">ADD</button> 

</form:form>


</div>

<%@ include file="common/footer.jspf" %>