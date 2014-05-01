<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:label path="resumeData.recommendations[${recommendationIndex}].firstName">Имя</form:label>
<form:input path="resumeData.recommendations[${recommendationIndex}].firstName"/>

<form:label path="resumeData.recommendations[${recommendationIndex}].middleName">Отчество</form:label>
<form:input path="resumeData.recommendations[${recommendationIndex}].middleName"/>

<form:label path="resumeData.recommendations[${recommendationIndex}].lastName">Фамилия</form:label>
<form:input path="resumeData.recommendations[${recommendationIndex}].lastName"/>

<form:label
        path="resumeData.recommendations[${recommendationIndex}].text">Контактная информация</form:label>
<form:input path="resumeData.recommendations[${recommendationIndex}].text"/>
<hr>