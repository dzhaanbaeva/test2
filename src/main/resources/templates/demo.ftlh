<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Homework 57. Javascript 101</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <link rel="stylesheet" href="css/styles.css">
</head>

<body class="no-scroll">
<div class="container">
    <form id="comment-form" class="comment-from none" name="comment">
        <textarea name="comment"></textarea>
        <button type="button" id="add-comment">Enter</button>
    </form>
    <div class="row justify-content-center">
        <div class="col col-lg-7 posts-container">
            <!-- single post start -->

            <a href="http://localhost:9393/posts" class="addPost">Add Post</a>
            <div class="card my-3 none">
                <!-- image block start -->
                <div>
                    <img class="d-block w-100" src="http://placekitten.com/200/200" alt="Post image">
                </div>
                <!-- image block end -->
                <div class="px-4 py-3">

                    <!-- post reactions block start -->
                    <div class="d-flex justify-content-around">
                        <!-- <span class="h1 mx-2 text-danger"> -->
                        <!-- <i class="fas fa-heart"></i>
                      </span> -->
                        <span class="h1 mx-2 muted">
					  <i class="far fa-heart"></i>
					</span>
                        <span class="h1 mx-2 muted">
					  <i class="far fa-comment"></i>
					</span>
                        <span class="mx-auto"></span>
                        <span class="h1 mx-2 muted">
					  <i class="far fa-bookmark"></i>
					</span>
                        <!-- <span class="h1 mx-2 muted">
                          <i class="fas fa-bookmark"></i>
                        </span> -->
                    </div>
                    <!-- post reactions block end -->
                    <hr>
                    <!-- post section start -->
                    <div>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsum ad est cumque nulla
                            voluptatem enim voluptas minima illum quis! Voluptatibus dolorem minus tempore aliquid
                            corrupti nesciunt, obcaecati fuga natus officiis.</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsum ad est cumque nulla
                            voluptatem enim voluptas minima illum quis! Voluptatibus dolorem minus tempore aliquid
                            corrupti nesciunt, obcaecati fuga natus officiis.</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsum ad est cumque nulla
                            voluptatem enim voluptas minima illum quis! Voluptatibus dolorem minus tempore aliquid
                            corrupti nesciunt, obcaecati fuga natus officiis.</p>
                    </div>
                    <!-- post section end -->
                    <hr>
                    <!-- comments section start -->


                    <div id="comment">
                        <div class="py-2 pl-3">
                            <a href="#" class="muted">someusername</a>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsum ad est cumque nulla
                                voluptatem enim voluptas minima illum quis! Voluptatibus dolorem minus tempore aliquid
                                corrupti nesciunt, obcaecati fuga natus officiis.</p>
                        </div>
                        <div class="py-2 pl-3">
                            <a href="#" class="muted">someusername</a>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsum ad est cumque nulla
                                voluptatem enim voluptas minima illum quis! Voluptatibus dolorem minus tempore aliquid
                                corrupti nesciunt, obcaecati fuga natus officiis.</p>
                        </div>
                    </div>
                    <!-- comments section end -->
<#--                    <div id="post"></div>-->
                </div>

            </div>
            <!-- single post end -->
<#--            <button class='addPost'>Add Post</button>-->
        </div>
    </div>
</div>

<!-- Splash screen -->
<section id="page-splash" class="page-splash">
    <div class="d-flex justify-content-center">
<#--        <div class="mx-3">-->
<#--            <form id="registration-form">-->
<#--                <h3>Регистрация</h3>-->
<#--                <input type="email"  name="email" class="form-control mb-1" placeholder="Email">-->
<#--                <input type="text"  name="name" class="form-control mb-1" placeholder="Полное имя">-->
<#--                <input type="text" name="login" class="form-control mb-1" placeholder="Логин">-->
<#--                <input type="password" name="password" class="form-control mb-1" placeholder="Пароль">-->
<#--                <button class="btn btn-outline-primary btn-block">Зарегистрироваться</button>-->
<#--            </form>-->
<#--        </div>-->
        <div class="mx-3">
            <form id="login-form">
                <h3>Вход</h3>
                <input type="text" name="login" class="form-control mb-1" placeholder="Логин">
                <input type="password" name="password" class="form-control mb-1" placeholder="Пароль">
                <button class="btn btn-outline-primary btn-block">Войти</button>
            </form>
        </div>
    </div>

</section>
</body>
<script src="js/lesson57.js"></script>


</html>
