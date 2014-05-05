<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:label
        path="resumeData.educations[${educationIndex}].institution">Учреждение образования <span>*</span></form:label>
<form:input path="resumeData.educations[${educationIndex}].institution"/>
<form:errors path="resumeData.educations[${educationIndex}].institution"/>

<form:label path="resumeData.educations[${educationIndex}].specialty">Специальность <span>*</span></form:label>
<form:input path="resumeData.educations[${educationIndex}].specialty"/>
<form:errors path="resumeData.educations[${educationIndex}].specialty"/>

<form:label
        path="resumeData.educations[${educationIndex}].additionalSpecialty">Дополнительная специальность <span>*</span></form:label>
<form:input path="resumeData.educations[${educationIndex}].additionalSpecialty"/>
<form:errors path="resumeData.educations[${educationIndex}].additionalSpecialty"/>

<form:label
        path="resumeData.educations[${educationIndex}].academicDegree">Ученая степень <span>*</span></form:label>
<form:input path="resumeData.educations[${educationIndex}].academicDegree"/>
<form:errors path="resumeData.educations[${educationIndex}].academicDegree"/>

<form:label path="resumeData.educations[${educationIndex}].startDate">Начало <span>*</span></form:label>
<form:input path="resumeData.educations[${educationIndex}].startDate" placeholder="01/01/2014"/>
<form:errors path="resumeData.educations[${educationIndex}].startDate"/>

<form:label path="resumeData.educations[${educationIndex}].endDate">Окончание <span>*</span></form:label>
<form:input path="resumeData.educations[${educationIndex}].endDate" placeholder="01/01/2014"/>
<form:errors path="resumeData.educations[${educationIndex}].endDate"/>
<hr>