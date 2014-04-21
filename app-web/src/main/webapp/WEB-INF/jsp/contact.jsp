<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Start of Page Container -->
<div class="page-container">
    <div class="container">
        <div class="row">

            <!-- start of page content -->
            <div class="span8 page-content">

                <article class="type-page hentry clearfix">
                    <h1 class="post-title">
                        <a href="#">Contact</a>
                    </h1>
                    <hr>
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>
                </article>


                <form id="contact-form" class="row" action="contact_form_handler.php" method="post">

                    <div class="span2">
                        <label for="name">Your Name <span>*</span> </label>
                    </div>
                    <div class="span6">
                        <input type="text" name="name" id="name" class="required input-xlarge" value="" title="* Please provide your name">
                    </div>

                    <div class="span2">
                        <label for="email">Your Email <span>*</span></label>
                    </div>
                    <div class="span6">
                        <input type="text" name="email" id="email" class="email required input-xlarge" value="" title="* Please provide a valid email address">
                    </div>

                    <div class="span2">
                        <label for="reason">Subject </label>
                    </div>
                    <div class="span6">
                        <input type="text" name="reason" id="reason" class="input-xlarge" value="">
                    </div>

                    <div class="span2">
                        <label for="message">Your Message <span>*</span> </label>
                    </div>
                    <div class="span6">
                        <textarea name="message" id="message" class="required span6" rows="6" title="* Please enter your message"></textarea>
                    </div>

                    <div class="span6 offset2 bm30">
                        <input type="submit" name="submit" value="Send Message" class="btn btn-inverse">
                        <img src="images/loading.gif" id="contact-loader" alt="Loading...">
                    </div>

                    <div class="span6 offset2 error-container"></div>
                    <div class="span8 offset2" id="message-sent"></div>

                </form>
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