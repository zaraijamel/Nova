<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:label path="resumeData.recommendations[${recommendationIndex}].firstName">Имя <span>*</span></form:label>
<form:input path="resumeData.recommendations[${recommendationIndex}].firstName"/>
<form:errors path="resumeData.recommendations[${recommendationIndex}].firstName"/>

<form:label path="resumeData.recommendations[${recommendationIndex}].middleName">Отчество <span>*</span></form:label>
<form:input path="resumeData.recommendations[${recommendationIndex}].middleName"/>
<form:errors path="resumeData.recommendations[${recommendationIndex}].middleName"/>

<form:label path="resumeData.recommendations[${recommendationIndex}].lastName">Фамилия <span>*</span></form:label>
<form:input path="resumeData.recommendations[${recommendationIndex}].lastName"/>
<form:errors path="resumeData.recommendations[${recommendationIndex}].lastName"/>

<form:label
        path="resumeData.recommendations[${recommendationIndex}].text">Рекомендация <span>*</span></form:label>
<form:input path="resumeData.recommendations[${recommendationIndex}].text"/>
<form:errors path="resumeData.recommendations[${recommendationIndex}].text"/>
<hr>