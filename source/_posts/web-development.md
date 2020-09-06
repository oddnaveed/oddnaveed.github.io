---
title: web-development
date: 2019-12-13 13:24:06
tags: [web, css, html, javascript, json]
categories: [software]
---

## [Dealing with files](https://developer.mozilla.org/en-US/docs/Learn/Getting_started_with_the_web/Dealing_with_files)

It's better to separate words with dashes, rather than underscores: my-file.html vs. my_file.html.

<!--more-->

### folder structure

- index.html: This file will generally contain your homepage content, that is, the text and images that people see when they first go to your site. Using your text editor, create a new file called index.html and save it just inside your test-site folder.
- images folder: This folder will contain all the images that you use on your site. Create a folder called images, inside your test-site folder.
- styles folder: This folder will contain the CSS code used to style your content (for example, setting text and background colors). Create a folder called styles, inside your test-site folder.
- scripts folder: This folder will contain all the JavaScript code used to add interactive functionality to your site (e.g. buttons that load data when clicked). Create a folder called scripts, inside your test-site folder.

* To reference a file in a subdirectory, write the directory name in front of the path, plus a forward slash, e.g. subdirectory/my-image.jpg.
* To link to a target file in the directory above the invoking HTML file, write two dots. So for example, if index.html was inside a subfolder of test-site and my-image.jpg was inside test-site, you could reference my-image.jpg from index.html using ../my-image.jpg.

## [css basics](https://developer.mozilla.org/en-US/docs/Learn/Getting_started_with_the_web/CSS_basics)

### set fonts for the whole page

put this between <head> and </head> tags
`<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">`

```css
html {
  font-size: 10px; /* px means "pixels": the base font size is now 10 pixels high  */
  font-family: "Open Sans", sans-serif; /* this should be the rest of the output you got from Google fonts */
}
```

### css comment

## [JavaScript basics](https://developer.mozilla.org/en-US/docs/Learn/Getting_started_with_the_web/JavaScript_basics)

```javaScript
const myHeading = document.querySelector('h1');
myHeading.textContent = 'Hello world!';
let myVariable = [1, 'Bob', 'Steve', 10];

/*
Comment here
*/

// comment

// equality: ===

// not: !

// does not equal: !==

let burek = 'mybaby';
if(burek === 'mybaby'){
    alert('Aha, i miss burek!');
} else {
    alert('Awwww, wheres my baby');
}
```

### function

```javaScript
function multiply(num1, num2){
    let result = num1 * num2;
    return result;
}

document.querySelector('html').onclick = function(){
    alert('Ouch! Stop poking me!');
}
```

There are many ways to attach an event to an element. Here we select the <html> element, setting its onclick handler property equal to an anonymous (i.e. nameless) function, which contains the code we want the click event to run.

Note that

`document.querySelector('html').onclick = function() {};`
is equivalent to

```javaScript
let myHTML = document.querySelector('html');
myHTML.onclick = function() {};
```

### image changer

```javaScript
let myImage = document.querySelector('img');

myImage.onclick = function() {
    let mySrc = myImage.getAttribute('src');
    if(mySrc === 'images/firefox-icon.png') {
      myImage.setAttribute ('src','images/firefox2.png');
    } else {
      myImage.setAttribute ('src','images/firefox-icon.png');
    }
}
```

## publishing website

## how the web works

## [javascript](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/First_steps/Useful_string_methods)

`<button>Press me</button>`

```javaScript
const button = document.querySelector('button');

button.onclick = function() {
  let name = prompt('What is your name?');
  alert('Hello ' + name + ', nice to see you!');
}
```

`console.log(typeof variableName)`

- to test strictly identical
  use ===
  otherwise == give it some room.
  e.g. 5 == "5

`a == b ? console.log("Match") : console.log("No match");`

### function

Named function

```javaScript
function findBiggestFraction(a,b) {
  var result;
  a>b ? result = ["firstFraction", a] : result = ["secondFraction", b];
  return result;
}

var firstFraction = 3/4;
var secondFraction = 5/7;

var fractionResult = findBiggestFraction(firstFraction, secondFraction);

console.log("First fraction result: ", firstFraction);
console.log("Second fraction result: ", secondFraction);
console.log("Fraction " + fractionResult[0] + " with a value of " + fractionResult[1] + " is the biggest!");
```

<br />
anonymous function
``` javaScript
var theBiggest = function(a,b) {
  var result;
  a>b ? result = ["a", a] : result = ["b", b];
  return result;
}

console.log(theBiggest(7/9, 13/25));

````

[immediately invoked functional expressions]
``` javaScript
var theBiggest = (function)(a,b) {
  var result;
  a>b ? result = ["a", a] : result = ["b", b];
  return result;
})(7/9, 13/25)

console.log(theBiggest);
````

### let

```javaScript
function logScope() {
  let localVar = 2;

  if (localVar) {
    let localVar = "I'm different variable";
    console.log("nested localVar: ", localVar);
  }

  console.log("logScope localVar: ", localVar);
}

logScope();
```

## [javascript overview](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/A_re-introduction_to_JavaScript)

### var and let

> var is global variable (visible by the whole class)
> let is local variable

### create object

#### method 1

```javaScript
var obj = new Object();
```

#### method 2

```javaScript
var obj = {};
```

### rest arguments 剩余参数 ...args

```javaScript
function avg(...args) {
  var sum = 0;
  for (let value of args) {
    sum += value;
  }
  return sum / args.length;
}

avg(2, 3, 4, 5); // 3.5
```

> 传入数组

```javaScript
function avgArray(arr) {
    var sum = 0;
    for (var i = 0, j = arr.length; i < j; i++) {
        sum += arr[i];
    }
    return sum / arr.length;
}
avgArray([2, 3, 4, 5]); // 3.5
```

> 自定义对象

```javaScript
function makePerson(first, last) {
    return {
        first: first,
        last: last,
        fullName: function() {
            return this.first + ' ' + this.last;
        },
        fullNameReversed: function() {
            return this.last + ', ' + this.first;
        }
    }
}
s = makePerson("Simon", "Willison");
s.fullName(); // Simon Willison
s.fullNameReversed(); // Willison, Simon
```

> 运用 Person.prototype

```javaScript
function Person(first, last) {
    this.first = first;
    this.last = last;
}
Person.prototype.fullName = function() {
    return this.first + ' ' + this.last;
}
Person.prototype.fullNameReversed = function() {
    return this.last + ', ' + this.first;
}
```

---

## Json

JavaScript Object Notation

---

## [Html DOM](https://www.w3schools.com/js/js_htmldom.asp)

DOM: Document object model
Html DOM: a standard for how to get, change, add, or delete Html elements
