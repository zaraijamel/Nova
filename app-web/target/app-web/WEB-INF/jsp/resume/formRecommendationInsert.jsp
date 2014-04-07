<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:label path="resumeData.recommendations[${number}].firstName">Имя</form:label>
<form:input path="resumeData.recommendations[${number}].firstName"/>

<form:label path="resumeData.recommendations[${number}].middleName">Отчество</form:label>
<form:input path="resumeData.recommendations[${number}].middleName"/>

<form:label path="resumeData.recommendations[${number}].lastName">Фамилия</form:label>
<form:input path="resumeData.recommendations[${number}].lastName"/>

<form:label
        path="resumeData.recommendations[${number}].text">Контактная информация</form:label>
<form:input path="resumeData.recommendations[${number}].text"/>