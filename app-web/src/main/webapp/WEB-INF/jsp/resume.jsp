<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!-- Start of Page Container -->
<div class="page-container">
<div class="container">
<div class="row">
<div class="span8 main-listing">

<article class=" page type-page hentry clearfix">

    <h1 class="post-title"><a href="#">Резюме</a></h1>
    <hr>
    <p>Это первое, что необходимо иметь при поиске работы.
        Можно сказать, что при устройстве на работу, обязательное предоставление резюме, это один из элементов
        современных правил делового этикета, но одновременно это одно из самых эффективных средств рекламы на рынке
        труда.
        Резюме - это краткий вывод из сказанного, написанного или прочитанного, сжато излагающий основные положения.</p>
</article>

<div class="faqs clearfix">

    <a href="<c:url value="/resume/requestLinkedin"/>"><img alt="linkedin"
                                                            src="<c:url value="/resources/images/linkedin.png"/>"/>&nbsp;Связать
        linkedin-аккаунт</a>

    <br/>
    <br/>

    <form:form method="POST" action="/resumeSettings" commandName="resumeData">

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
                    <form:input path="educations[${vs.index}].startDate" placeholder="01/01/2014"/>

                    <form:label path="educations[${vs.index}].endDate">Конец</form:label>
                    <form:input path="educations[${vs.index}].endDate" placeholder="01/01/2014"/>
                </c:forEach>

                <div id="addEducationRow"></div>

                <input class="btn btn-inverse" type="button" id="addEducation" value="Добавить"/>

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
                    <form:input path="experiences[${vs.index}].startDate" placeholder="01/01/2014"/>

                    <form:label path="experiences[${vs.index}].endDate">Конец</form:label>
                    <form:input path="experiences[${vs.index}].endDate" placeholder="01/01/2014"/>
                </c:forEach>

                <div id="addExperienceRow"></div>

                <input class="btn btn-inverse" type="button" id="addExperience" value="Добавить"/>

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
                    <hr>
                </c:forEach>

                <div id="addAbilityRow"></div>

                <input class="btn btn-inverse" type="button" id="addAbility" value="Добавить"/>

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
                    <hr>
                </c:forEach>

                <div id="addRecommendationRow"></div>

                <input class="btn btn-inverse" type="button" id="addRecommendation" value="Добавить"/>

            </div>
        </article>

        <br/>
        <br/>

        <input type="submit" value="Далее" class="btn btn-inverse"/>

        <div class="span8 offset2" id="message-sent"></div>

    </form:form>
</div>

</div>

<!-- start of sidebar -->
<aside class="span4 page-sidebar">

    <section class="widget">
        <div class="support-widget">
            <h3 class="title">Генератор резюме</h3>

            <p class="intro">Хотите создать резюме? <a href="<c:url value="/resume"/>">Создать.</a></p>
        </div>
    </section>

    <section class="widget">
        <div class="quick-links-widget">
            <h3 class="title">Полезные ссылки</h3>
            <ul id="menu-quick-links" class="menu clearfix">
                <li><a href="<c:url value="/"/>">Домашнаяя страница</a></li>
                <li><a href="<c:url value="/catalog"/>">Каталог вакансий</a></li>
                <li><a href="<c:url value="/catalog"/>">Создание резюме</a></li>
                <li><a href="<c:url value="/catalog"/>">Мой профайл</a></li>
                <li><a href="<c:url value="/contact"/>">Контакты</a></li>
            </ul>
        </div>
    </section>

</aside>
<!-- end of sidebar -->
</div>
</div>
</div>
<script type='text/javascript' src='<c:url value="/resources/js/resume.js"/>'></script>


