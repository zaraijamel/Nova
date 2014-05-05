<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:label path="resumeData.abilities[${abilityIndex}].title">Способность <span>*</span></form:label>
<form:input path="resumeData.abilities[${abilityIndex}].title"/>
<form:errors path="resumeData.abilities[${abilityIndex}].title"/>

<form:label
        path="resumeData.abilities[${abilityIndex}].description">Дополнительная информация <span>*</span></form:label>
<form:input path="resumeData.abilities[${abilityIndex}].description"/>
<form:errors path="resumeData.abilities[${abilityIndex}].description"/>
<hr>