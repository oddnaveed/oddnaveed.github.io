---
title: JavaScript Learning
date: 2019-12-22 21:56:16
tags: [react, javascript, webDev]
top: 10
categories: [software]
---

# JavaScript

[Source: CSS reference](https://developer.mozilla.org/en-US/docs/Web/CSS/Reference)

<!--more-->

## Learn JavaScript via App

[Source: Tutorial](https://learnjavascript.online/app.html)
[Flashcard to recap](https://flash.learnjavascript.online/home)

### String

```js Basic String
"nice".length;
"Hello world".includes("world"); //true
.toUpperCase()
.toLowerCase()
console.log();

You can create strings with " or '.
.length is a property that gives you the length of a string
.includes(searchString) returns true or false based on whether the searchString was found or not.
.toUpperCase() is a function that converts the string to upper case
.toLowerCase() is a function that converts the string to lower case
parentheses () on functions are required. .length is a property which is already pre-computed thus why it does not need parentheses
console.log(...) is used for debugging and is NOT a replacement for return.

.substring(indexStart, indexEnd)  //include the start index, exclude the end index
.substring(indexStart)  // return a String starts from the indexStart to the end of the original string
```

- Template strings, support interpolation

```js Interpolation
`This is a
template
string
me
cool
`;

let language = "JS"`This is ${language}`;
console.log(`This is ${language}`); // This is JS

function sayHello(name) {
  return `Hello ${name}`;
}
console.log(sayHello("Mila"));

function getFullName(firstName, lastName) {
  return `${firstName} ${lastName}`;
}
console.log(getFullName("Mila", "La"));
```

- Miscellaneous string methods

```js
string.startsWith();
string.endsWith();

const milaSerialNumber = "+99911123";
milaSerialNumber.startsWith("+"); //true
milaSerialNumber.endsWith("111"); //false

string.trim(); // removes extra spaces(both ends) and newlines
```

### Numbers

```js
// number -> string    number to string
let num = 123;
num.toString(); // "123"

// string -> number    string to number
Number.parseInt("19");  // 19
Number.parseInt("19", 10) // 19  the second argument is radix (decimal system)
// parseInt does not default to a radix of 10, better specify it

// check if a number is even or odd
%  // remainder operator
=== // equal to
!== // not equal to
```

### Variables

- always use let rather than var
- always use const untile we realize we need to be able to re-assign the variable later on

---

## Learn JavaScript via Handbook

[source](https://drive.google.com/drive/folders/1B-eWVHXw6roKhQWpRkiNNwHtb-66Gzif)

```javaScript
const  // cannot be reassigned, the value can be changed

always use `const` and only use `let` when we need to reassign a value to that variable (one less source for bugs)

const five = 1 + 4
five + 1 // 6
'five' + 1 // five1 (String)

=== checks for equality
!== checks for inequality

we can even add expressions inside ${}
const string2 = `something
  ${foo() ? 'x' : 'y'}`
```

```javaScript Array
// initialize an array in 2 ways
const a = []
const a = Array()

const a = [1, 2, 3]
const a = Array.of(1, 2, 3)

// an array can hold any value, even value of different types:
const a = [1, 'Flavio', ['a', 'b']]

// we can add an array into an array
const matrix = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]

// initialize an array of 19 elements, and fills each element with the 0 number
Array(19).fill(0)

// cut the array by setting the length of the array
const a = [1, 2, 3]
a // [1, 2, 3]
a.length = 2
a // [1, 2]

// add an item to an array
a.push(8)  // add the element at the end of the array
a.unshift(0)  // add the element at the beginning of the array
a.unshift(-2, -1)

// remove an item from an array
a.pop()  // remove from the end of an array
a.shift()  // remove from the beginning of an array

// shift and unshift -> start
// push and pop -> end

// join arrays by concat()
const a = [1, 2]
const b = [4, 5]
const c = a.concat(b)  // [1, 2, 4, 5]

// ----------------------------------------
// to find a specific item in the array
a.find((element, index, array) => {
  // return true or false
})
// e.g.
a.find(x => x.id === my_id)

a.findIndex((element, index, array) => {
  // return the index of the first item found, or false if not found
})

// return true if a contains value
a.includes(value)

// return true if a contains value after position i
a.includes(value, i)
```

---

```js
const list = ["a", "b", "c"];

for (const value of list) {
  console.log(value);
}
```

```js Function
function getData(color, age) {
  // do smth
  if (typeof age !== "undefined") {
    //...
  }
}

// return multiple values, we can return an object or an array
function getData() {
  return ["Avocado", 19];
}

let [name, age] = getData();

// --------------------------
// define functions inside other functions
const getData = () => {
  const dosomething = () => {};
  dosomething();
  return "test";
};

// return a function from a function
const getData = () => {
  const dosomething = () => {};
  return dosomething();
};
```

### Object and Properties

```js
// create new object
const car = {
  color: "blue",
  "the color": "blue",
};

car.color;
car["the color"];

const car = {
  brand: {
    name: "Mila",
  },
  color: "blue",
};

car.brand.name;
car["brand"]["name"];

// add new properties to an object
car.model2 = "Sunce";

// delete a property
delete car.brand;
```

### Object Method

- we don't have access to "this" if we use an arrow function

```
const phone = {
  brand: 'Huawei',
  model: 'P20',
  start: function(){
    console.log(`
    Started ${this.brand} ${this.model}
    `)
  }
}

phone.start()

//-----------------------------------------
// !! no access to this if we use an arrow function
const phone = {
  brand: 'Huawei',
  model: 'P20',
  start: () => {
    console.log(`Started
    ${this.brand} ${this.model}
    `) // not gonna work
  }
}
// arrow functions are not bound to the object
```

### Class

```js
// take an animal object
const animal = {
  name: "mila",
};

class Person {}

// create a class named Phone
class Phone {
  constructor(model) {
    this.model = model;
  }

  start() {
    return "Boosting" + this.model + "...";
  }
}

const myPhone = new Phone("P20");
myPhone.start();
```

```js [static method in class]
// static allows the method to be executed on the class
class Phone {
  static boostPhone(){
    return 'Starting...'
  }
}

Phone.boostPhone()  //Starting
```

```js [reference the parent class calling super()]
class Animal {
  hello(){
    return 'Hello, I am an animalll'
  }
}

class Doggie extends Animal {
  hello() {
    return super.hello() + ', wang wang wang.'
  }
}

const mila = new Doggie()
mila.hello()
```

### Callbacks
```js
setTimeout(() => {
  console.log('yek it is me')
}, 2000)  //2000 milliseconds = 2 seconds

const doSomething = callback => {
  // do things
  // do things
  const result = /*   */
  callback(result)
}

doSomething(result => {
  console.log(result)
})
```

### Promises
```js 
// we declare it as a promise object
// we pass a function in the Promise constructor
const doSomething = new Promise(
  (resolve, reject) => {
    const success = /* */
    if(success){
      resolve('ok')
    }else{
      reject('this error')
    }
  }
)
```

### Async and Await
- an async function returns a promise

```js
const getData = () => {
  return new Promise((resolve, reject) => {
    setTimeout(() =>
      resolve('some data'), 2000)
  })
}

// await keyword should be used inside async function
const doSomething = async () => {
  const data = await getData()
  console.log(data)
}
```

```js [using promises]
const getFirstUserData = () => {
  return fetch('/users.json')
    .then(response => response.json())
    .then(users => users[0])
    .then(users =>
      fetch(`/users/${user.name}`))
    .then(userResponse => response.json())
}

getFirstUserData()
```

```js [using await/async]
const getFirstUserData = async () => {
  const response = await fetch('/users.json')
  const users = await response.json()
  const user = users[0]
  const userResponse = 
    await fetch(`/users/${user.name}`)
  const userData = await user.json()
  return userData
}
```

### Variable Scope

- var: function scope
- let and const: block scope




---

## What's Mongodb?



---

javaScript functions
.push() .splice()
.concat()
.slice()
