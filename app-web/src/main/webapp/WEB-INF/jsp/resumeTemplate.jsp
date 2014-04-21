<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Start of Page Container -->
<div class="page-container">
    <div class="container">
        <div class="row">

            <!-- start of page content -->
            <div class="span8 page-content">

                <article class=" page type-page hentry clearfix">
                    <h1 class="post-title"><a href="#">FAQs</a></h1>
                    <hr>
                    <p>WordPress is open source web software that you can install on your web server to create your website, blog, community or network. WordPress started out as a tool for blogging, but has evolved into a full-fledged Content Management System (CMS), capable of powering websites, networks and communities.</p>
                </article>

                <div class="row-fluid top-cats">

                    <section class="span4">
                        <h4 class="category"><a href="#">WordPress for Beginners</a></h4>
                        <div class="category-description">
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat</p>
                        </div>
                    </section>

                    <section class="span4">
                        <h4 class="category"><a href="#">Designing in WordPress</a></h4>
                        <div class="category-description">
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet</p>
                        </div>
                    </section>

                    <section class="span4">
                        <h4 class="category"><a href="#">Theme Development</a></h4>
                        <div class="category-description">
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna</p>
                        </div>
                    </section>

                    <section class="span4">
                        <h4 class="category"><a href="#">Theme Development</a></h4>
                        <div class="category-description">
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna</p>
                        </div>
                    </section>

                    <section class="span4">
                        <h4 class="category"><a href="#">Theme Development</a></h4>
                        <div class="category-description">
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna</p>
                        </div>
                    </section>

                    <section class="span4">
                        <h4 class="category"><a href="#">Theme Development</a></h4>
                        <div class="category-description">
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna</p>
                        </div>
                    </section>

                    <section class="span4">
                        <h4 class="category"><a href="#">Theme Development</a></h4>
                        <div class="category-description">
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna</p>
                        </div>
                    </section>

                    <section class="span4">
                        <h4 class="category"><a href="#">Theme Development</a></h4>
                        <div class="category-description">
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna</p>
                        </div>
                    </section>
                </div>

                <form:form action="/resume/generate">

                    <input type="submit" value="Submit"/>
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
<!-- End of Page Container -->
