---
title: CSS
date: 2020-08-15 21:28:50
tags: [css, webDev]
categories: [software]
top:
visible:
---


# Intro to CSS

```html
<link rel="stylesheet" type="text/css" href="css/main.css" />
```

# Comment

```css
/*  */
```

# Shortcut

- css shortcut: e.g. google: css font shortcut

# Color
Google: css color picker
- a: transparency

```css
p{
    color: rgba(242, 50, 73, 1)
}
```

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Introduction to CSS</title>
        <link rel="stylesheet" type="text/css" href="main.css" />
    </head>
    <body>
        <p style="color: blueviolet">Style me?</p>
        <p>Style me?</p>
    </body>
</html>
```

# CSS Box Model

- margin
- border
- padding

<!--more-->

# Background Image

```css
body{
    background-image: url('sunset.JPG');
    /* background-size: 250px 160px;
    background-repeat: no-repeat; */
    background-size: cover;    /* fits the browser */
```





# CSS Review

## Getting started with CSS

[source: mozilla](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps/Getting_started)

<!--more-->

- US spelling (color instead of colour)
- "Something else you might like to try is styling **a paragraph when it comes directly after a heading** at the same hierarchy level in the HTML. To do so place a + (an adjacent sibling combinator) between the selectors."

```css
h1 + p {
  font-size: 200%;
}
```

- Make a span red if it's inside a paragraph.

```javaScript
<p>This is a paragraph of text. In the text is a <span>span element</span>
and also a <a href="http://example.com">link</a>.</p>
```

```css
/* <span> inside <p>
*/
p span {
  color: red;
}
```

- Insert a link

```javaScript
<a heref="http:milayue.github.io">Home of Mila</a>
```

- Styling things based on state: "When we style a link we need to target the <a> (anchor) element. This has different states depending on whether it is unvisited, visited, being hovered over, focused via the keyboard, or in the process of being clicked (activated). You can use CSS to target these different states — the CSS below styles unvisited links pink and visited links green."

```css
a:link {
  color: pink;
}

a:visited {
  color: green;
}

a:hover {
  text-decoration: none;
}
```

```css
/*  selects <span> which is inside <p> which is inside<body> */
body p span {
  ...;
}

/* selects <special> which is inside <p> which is after h1 which is inside <body>  */
body h1 + p .special {
}
```

### How CSS is structured?

[Source](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps/How_CSS_is_structured)

```js
<p class="special">What is that?</p>
```

```css
.special {
  color: red;
}
```

```css
/* cascade--"later styles replace conflicting styles that appear earlier in the stylesheet." */
p {
  color: red;
}

p {
  color: blue;
}
```

## Function

### calc()

```js calc()
<div class="outer">
  <div class="box">The inner box is 90% - 30px.</div>
</div>
```

```css
.outer {
  border: 5px solid black;
}

.box {
  padding: 10px;
  width: calc(90% - 30px);
  background-color: rebeccapurple;
  color: white;
}
```

### rotate()

```js
<div class="box"></div>
```

```css
.box {
  margin: 30px;
  width: 100px;
  height: 100px;
  background-color: rebeccapurple;
  transform: rotate(0.8turn);
}
```

## @rules

```css
/* A media query follows that defines a blue background if the browser viewport is wider than 30em.*/
body {
  background-color: pink;
}

@media (min-width: 30em) {
  body {
    background-color: blue;
  }
}
```

# How CSS works?

```js
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <title>Using my knowledge of CSS</title>
        <link rel="stylesheet" href="styles.css" />
    </head>

    <h1>
        Jane Doe
    </h1>

    <h3>Web Developer</h2>

    <p>This is blablabla...</p>
    <p>
        Let's use:
        <span>This</span>
        <span>Is</span>
        <span>Mila</span>
    </p>

    <h2>Contact information</h2>
    <ul>
        <li>email address: <a href="milamilamilamila@gmail.com">milamilamilamila@gmail.com</a></li>
        <li>web: <a href="https://www.w3schools.com">https://www.w3schools.com</a></li>
        <li>tel: blablabla</li>
    </ul>
</html>
```

```css
span {
  border: 8px solid seagreen;
  background-color: antiquewhite;
}

h1 {
  color: hotpink;
  border-bottom: 10px;
  border-bottom-color: purple;
  border-bottom-style: dotted;
}

h2 {
  font-style: italic;
}

ul {
  background-color: #eeeeee;
  border: 5px solid purple;
  padding: 2em;
}

a:hover {
  color: green;
}

a:visited {
  color: orangered;
}
```

## CSS Font-Family

[Source: Mozilla](https://developer.mozilla.org/zh-CN/docs/Web/CSS/font-family)

---