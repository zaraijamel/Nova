<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Start of Page Container -->
<div class="page-container">
    <div class="container">
        <div class="row">

            <!-- start of page content -->
            <div class="span8 page-content">

                <article class="type-page hentry clearfix">
                    <h1 class="post-title">
                        <a href="#">Обратная связь</a>
                    </h1>
                    <hr>
                    <p>Позволяет посетителям сайта отправлять сообщения администратору.</p>
                </article>


                <form:form id="contact-form" commandName="contactForm" class="row" action="/contact/add-message" method="post">

                    <div class="span2">
                        <label for="name">Имя </label>
                    </div>
                    <div class="span6">
                        <form:input path="name" type="text" name="name" id="name" class="required input-xlarge" value="" title="* Введите имя"/>
                    </div>

                    <div class="span2">
                        <label for="email">Email </label>
                    </div>
                    <div class="span6">
                        <form:input path="email" type="text" name="email" id="email" class="email required input-xlarge" value="" title="* Введите корректный email"/>
                    </div>

                    <div class="span2">
                        <label for="reason">Тема </label>
                    </div>
                    <div class="span6">
                        <form:input path="subject" type="text" name="reason" id="reason" class="input-xlarge" value=""/>
                    </div>

                    <div class="span2">
                        <label for="message">Сообщение </label>
                    </div>
                    <div class="span6">
                        <form:textarea path="message" name="message" id="message" class="required span6" rows="6" title="* Введите сообщение"/>
                    </div>

                    <div class="span6 offset2 bm30">
                        <input type="submit" name="submit" value="Отправить" class="btn btn-inverse">
                        <img src="images/loading.gif" id="contact-loader" alt="Loading...">
                    </div>

                    <div class="span6 offset2 error-container"></div>
                    <div class="span8 offset2" id="message-sent"></div>

                </form:form>
            </div>
            <!-- end of page content -->


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
                            <li><a href="<c:url value="/resume"/>">Создание резюме</a></li>
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
<!-- End of Page Container -->