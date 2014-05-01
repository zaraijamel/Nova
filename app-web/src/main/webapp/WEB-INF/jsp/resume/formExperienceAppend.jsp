<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:label path="resumeData.experiences[${experienceIndex}].organization">Организация</form:label>
<form:input path="resumeData.experiences[${experienceIndex}].organization"/>

<form:label path="resumeData.experiences[${experienceIndex}].position">Должность</form:label>
<form:input path="resumeData.experiences[${experienceIndex}].position"/>

<form:label path="resumeData.experiences[${experienceIndex}].responsibility">Обязанности</form:label>
<form:input path="resumeData.experiences[${experienceIndex}].responsibility"/>

<form:label path="resumeData.experiences[${experienceIndex}].startDate">Начало</form:label>
<form:input path="resumeData.experiences[${experienceIndex}].startDate" placeholder="01/01/2014"/>

<form:label path="resumeData.experiences[${experienceIndex}].endDate">Конец</form:label>
<form:input path="resumeData.experiences[${experienceIndex}].endDate" placeholder="01/01/2014"/>
<hr>