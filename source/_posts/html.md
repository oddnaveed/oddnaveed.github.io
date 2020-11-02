---
title: HTML
date: 2019-12-16 13:44:29
tags: [web, html]
categories: [webDev]
top:
visible:
---

[HTML CSS Relearn](https://www.youtube.com/watch?v=GSweALMbO0k)

[html forms](https://developer.mozilla.org/en-US/docs/Learn/HTML/Forms/How_to_structure_an_HTML_form)

[w3scools' html form](https://www.w3schools.com/html/html_forms.asp)

# Links

## Link to another page

```html
<a href="second_page.html">this will link to page2</a>
```

## Link to a paragraph

```html
<a href="#me-the-bottom">take me to the bottom paragraph</a>
<p id="me-the-bottom">
    this is a paragrajioehiowhiofhiojwojfopejwpofjeopwjopjfeiohwioapjkoewj jsut
    ajsut af jioehiowhiofhiojwo jioehiowhiofhiojwo jioehiowhiofhiojwo
    jioehiowhiofhiojwo jioehiowhiofhiojwo jioehiowhiofhiojwo ranmdom
    paragraghpjdwoij
</p>
```

# Images

```html
- Width and height save the space in the browser and is recommended to keep
these attributes <img src="sunset.JPG" width="800" height="" alt="sunset" />
```

# File Path

-   %20 represents space
-   try to avoid spaces
-   relative to current folder "images/sunset.jpg"
-   / -> root directory

# Videos

-   better use MP4 <- support most browsers

`attributes`

-   controls: display option
-   loop: loop the video

```html
<video width="600" height="340" controls autoplay>
    <!--mp4 is supported by most browsers-->
    <source src="storm-clouds.MP4" type="video/MP4" />
    if you can see this, update your browser
</video>
```

# Audio

-   use MP3

`attributes`

-   muted: set it to muted by default

```html
<audio controls autoplay loop muted>
    <source src="song.mp3" type="audio/mpeg" />
    if you can see this, update your browser
</audio>
```
