<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link rel="stylesheet" href="/style.css"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<nav>
    <div class="nav-wrapper">
        <a href="/hello" class="brand-logo">Main</a>
        <ul class="right hide-on-and-down">
            <li><a href="/note">Send Post</a></li>
            <li><a href="#">All Posts</a></li>
        </ul>
    </div>
</nav>
<nav>
    <div class="nav-wrapper">
        <form>
            <div class="input-field">
                <input name="query" id="search" type="search" required>
                <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                <i class="material-icons">close</i>
            </div>
        </form>
    </div>
</nav>
<#list notes as note>
    <div class="note">
        <div class="row">
            <div class="s12 m6 l3">
                <div class="card">
                    <div class="card-content">
                        <span class="card-title">${note.title}</span>
                        <p>${note.body}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </#list>
<#if pages?? && pages != 0>
    <nav>
        <ul class="pagination">
            <#list 1..pages as page>
                <li>
                    <a class="active" href="/notes?page=${page}">${page}</a>
                </li>
            </#list>
        </ul>
    </nav>
</#if>
</body>
</html>