<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:label
        path="resumeData.educations[${educationIndex}].institution">Учреждение образования</form:label>
<form:input path="resumeData.educations[${educationIndex}].institution"/>

<form:label path="resumeData.educations[${educationIndex}].specialty">Специальность</form:label>
<form:input path="resumeData.educations[${educationIndex}].specialty"/>

<form:label
        path="resumeData.educations[${educationIndex}].additionalSpecialty">Дополнительная специальность</form:label>
<form:input path="resumeData.educations[${educationIndex}].additionalSpecialty"/>

<form:label
        path="resumeData.educations[${educationIndex}].academicDegree">Ученая степень</form:label>
<form:input path="resumeData.educations[${educationIndex}].academicDegree"/>

<form:label path="resumeData.educations[${educationIndex}].startDate">Начало</form:label>
<form:input path="resumeData.educations[${educationIndex}].startDate" placeholder="01/01/2014"/>

<form:label path="resumeData.educations[${educationIndex}].endDate">Конец</form:label>
<form:input path="resumeData.educations[${educationIndex}].endDate" placeholder="01/01/2014"/>
<hr>