<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<footer id="footer-wrapper">
    <div id="footer" class="container">
        <div class="row">

            <div class="span3">
                <section class="widget">
                    <h3 class="title">Как это работает</h3>

                    <div class="textwidget">
                        <p>Интернет-сервис, созданный для быстрого поиска работы</p>
                        <p>Позволяет найти работу в Беларуси.</p>
                    </div>
                </section>
            </div>

            <div class="span3">
                <section class="widget"><h3 class="title">Навигация</h3>
                    <ul>
                        <li><a href="<c:url value="/"/>">Домашнаяя страница</a></li>
                        <li><a href="<c:url value="/catalog"/>">Каталог вакансий</a></li>
                        <li><a href="<c:url value="/catalog"/>">Создание резюме</a></li>
                        <li><a href="<c:url value="/catalog"/>">Мой профайл</a></li>
                        <li><a href="<c:url value="/contact"/>">Контакты</a></li>
                    </ul>
                </section>
            </div>

            <div class="span3">
                <section class="widget">
                </section>
            </div>

            <div class="span3">
                <section class="widget">
                    <h3 class="title">Последнии twitter-сообщения</h3>

                    <div id="twitter_update_list">
                        <ul>
                            <li>Нет твитов</li>
                        </ul>
                    </div>
                    <script src="http://twitterjs.googlecode.com/svn/trunk/src/twitter.min.js"
                            type="text/javascript"></script>
                    <script type="text/javascript">
                        getTwitters("twitter_update_list", {
                            id: "447820895940132864",
                            count: 4,
                            enableLinks: true,
                            ignoreReplies: true,
                            clearContents: true,
                            template: "%text% <span>%time%</span>"
                        });
                    </script>
                </section>
            </div>

        </div>
    </div>
</footer>