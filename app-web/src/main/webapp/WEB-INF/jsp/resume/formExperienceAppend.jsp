<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:label path="resumeData.experiences[${experienceIndex}].organization">Организация <span>*</span></form:label>
<form:input path="resumeData.experiences[${experienceIndex}].organization"/>
<form:errors path="resumeData.experiences[${experienceIndex}].organization"/>

<form:label path="resumeData.experiences[${experienceIndex}].position">Должность <span>*</span></form:label>
<form:input path="resumeData.experiences[${experienceIndex}].position"/>
<form:errors path="resumeData.experiences[${experienceIndex}].position"/>

<form:label path="resumeData.experiences[${experienceIndex}].responsibility">Обязанности <span>*</span></form:label>
<form:input path="resumeData.experiences[${experienceIndex}].responsibility"/>
<form:errors path="resumeData.experiences[${experienceIndex}].responsibility"/>

<form:label path="resumeData.experiences[${experienceIndex}].startDate">Начало <span>*</span></form:label>
<form:input path="resumeData.experiences[${experienceIndex}].startDate" placeholder="01/01/2014"/>
<form:errors path="resumeData.experiences[${experienceIndex}].startDate"/>

<form:label path="resumeData.experiences[${experienceIndex}].endDate">Конец <span>*</span></form:label>
<form:input path="resumeData.experiences[${experienceIndex}].endDate" placeholder="01/01/2014"/>
<form:errors path="resumeData.experiences[${experienceIndex}].endDate"/>
<hr>