<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Start of Page Container -->
<div class="page-container">
<div class="container">
<div class="row">
<div class="span8 main-listing">

    <article class=" page type-page hentry clearfix">

        <h1 class="post-title"><a href="#">Резюме</a></h1>
        <hr>
        <p>WordPress is open source web software that you can install on your web server to create your
            website, blog, community or network. WordPress started out as a tool for blogging, but has
            evolved into a full-fledged Content Management System (CMS), capable of powering websites,
            networks and communities.</p>
    </article>

    <div class="faqs clearfix">

        <a href="<c:url value="/resume/requestLinkedin"/>"><img alt="linkedin"
                                                                src="<c:url value="/resources/images/linkedin.png"/>"/>&nbsp;Связать
            linkedin-аккаунт</a>

        <br/>
        <br/>

        <form:form method="POST" action="/resume/generate" commandName="resumeData">

            <article class="faq-item active">
                <span class="faq-icon"></span>

                <h3 class="faq-question">
                    <a href="#">Персональные данные</a>
                </h3>

                <div class="faq-answer">
                    <p>Заполните персональные данные.</p>

                    <form:label path="firstName">Имя</form:label>
                    <form:input path="firstName"/>

                    <form:label path="lastName">Фамилия</form:label>
                    <form:input path="lastName"/>

                    <form:label path="middleName">Отчество</form:label>
                    <form:input path="middleName"/>

                    <form:label path="phone">Телефон</form:label>
                    <form:input path="phone" placeholder="(8029)123-12-34"/>

                    <form:label path="website">Персональный сайт</form:label>
                    <form:input path="website" placeholder="www.example.com"/>

                    <form:label path="email">Email</form:label>
                    <form:input path="email" placeholder="example@mail.com"/>

                </div>
            </article>

            <article class="faq-item">
                <span class="faq-icon"></span>

                <h3 class="faq-question">
                    <a href="#">Адрес</a>
                </h3>

                <div class="faq-answer">
                    <p>Заполните адрес проживания.</p>

                    <form:label path="address.city">Город</form:label>
                    <form:input path="address.city"/>

                    <form:label path="address.street">Адрес</form:label>
                    <form:input path="address.street"/>
                </div>
            </article>

            <article class="faq-item">
                <span class="faq-icon"></span>

                <h3 class="faq-question">
                    <a href="#">Образование</a>
                </h3>

                <div class="faq-answer">
                    <p>Заполните информацию об обрзованиее.</p>

                    <c:forEach varStatus="vs" items="${resumeData.educations}">
                        <form:label
                                path="educations[${vs.index}].institution">Учреждение образования</form:label>
                        <form:input path="educations[${vs.index}].institution"/>

                        <form:label path="educations[${vs.index}].specialty">Специальность</form:label>
                        <form:input path="educations[${vs.index}].specialty"/>

                        <form:label
                                path="educations[${vs.index}].additionalSpecialty">Дополнительная специальность</form:label>
                        <form:input path="educations[${vs.index}].additionalSpecialty"/>

                        <form:label
                                path="educations[${vs.index}].academicDegree">Ученая степень</form:label>
                        <form:input path="educations[${vs.index}].academicDegree"/>

                        <form:label path="educations[${vs.index}].startDate">Начало</form:label>
                        <form:input path="educations[${vs.index}].startDate"/>

                        <form:label path="educations[${vs.index}].endDate">Конец</form:label>
                        <form:input path="educations[${vs.index}].endDate"/>
                    </c:forEach>

                </div>
            </article>

            <article class="faq-item">
                <span class="faq-icon"></span>

                <h3 class="faq-question">
                    <a href="#">Опыт</a>
                </h3>

                <div class="faq-answer">
                    <p>Заполните информацию об опыте.</p>

                    <c:forEach varStatus="vs" items="${resumeData.experiences}">
                        <form:label path="experiences[${vs.index}].organization">Организация</form:label>
                        <form:input path="experiences[${vs.index}].organization"/>

                        <form:label path="experiences[${vs.index}].position">Должность</form:label>
                        <form:input path="experiences[${vs.index}].position"/>

                        <form:label path="experiences[${vs.index}].responsibility">Обязанности</form:label>
                        <form:input path="experiences[${vs.index}].responsibility"/>

                        <form:label path="experiences[${vs.index}].startDate">Начало</form:label>
                        <form:input path="experiences[${vs.index}].startDate"/>

                        <form:label path="experiences[${vs.index}].endDate">Конец</form:label>
                        <form:input path="experiences[${vs.index}].endDate"/>
                    </c:forEach>

                </div>
            </article>

            <article class="faq-item">
                <span class="faq-icon"></span>

                <h3 class="faq-question">
                    <a href="#">Навыки</a>
                </h3>

                <div class="faq-answer">
                    <p>Заполните информацию о навыках.</p>

                    <c:forEach varStatus="vs" items="${resumeData.abilities}">
                        <form:label path="abilities[${vs.index}].title">Способность</form:label>
                        <form:input path="abilities[${vs.index}].title"/>

                        <form:label
                                path="abilities[${vs.index}].description">Дополнительная информация</form:label>
                        <form:input path="abilities[${vs.index}].description"/>
                    </c:forEach>

                </div>
            </article>

            <article class="faq-item">
                <span class="faq-icon"></span>

                <h3 class="faq-question">
                    <a href="#">Рекомендации</a>
                </h3>

                <div class="faq-answer">
                    <p>Заполните информацию о рекомендациях.</p>

                    <c:forEach varStatus="vs" items="${resumeData.recommendations}">
                        <form:label path="recommendations[${vs.index}].firstName">Имя</form:label>
                        <form:input path="recommendations[${vs.index}].firstName"/>

                        <form:label path="recommendations[${vs.index}].middleName">Отчество</form:label>
                        <form:input path="recommendations[${vs.index}].middleName"/>

                        <form:label path="recommendations[${vs.index}].lastName">Фамилия</form:label>
                        <form:input path="recommendations[${vs.index}].lastName"/>

                        <form:label
                                path="recommendations[${vs.index}].text">Контактная информация</form:label>
                        <form:input path="recommendations[${vs.index}].text"/>
                    </c:forEach>

                    <div id="addRecommendationRow"></div>

                    <input type="button" id="addRecommendation" value="add"/>

                </div>
            </article>

            <br/>
            <br/>

            <input type="submit" value="Создать" class="btn btn-inverse"/>

            <div class="span8 offset2" id="message-sent"></div>

        </form:form>
    </div>

</div>
</div>
</div>
</div>


