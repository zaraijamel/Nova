<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<footer id="footer-wrapper">
    <div id="footer" class="container">
        <div class="row">

            <div class="span3">
                <section class="widget">
                    <h3 class="title">Как это работает</h3>

                    <div class="textwidget">
                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod
                            tincidunt ut laoreet dolore magna aliquam erat volutpat. </p>

                        <p>Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl
                            ut aliquip ex ea commodo consequat. </p>
                    </div>
                </section>
            </div>

            <div class="span3">
                <section class="widget"><h3 class="title">Категории</h3>
                    <ul>
                        <li><a href="#" title="Lorem ipsum dolor sit amet,">Advanced Techniques</a></li>
                    </ul>
                </section>
            </div>

            <div class="span3">
                <section class="widget">
                    <h3 class="title">Последнии сообщения</h3>

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