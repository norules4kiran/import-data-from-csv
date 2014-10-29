<%@ page import="test.Contact" %>



<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="contact.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${contactInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'phone', 'error')} ">
	<label for="phone">
		<g:message code="contact.phone.label" default="Phone" />
		
	</label>
	<g:textField name="phone" value="${contactInstance?.phone}"/>

</div>

