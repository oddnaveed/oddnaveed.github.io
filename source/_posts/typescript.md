---
title: TypeScript Beginning
date: 2020-01-07 17:13:59
tags: [typescript, angular]
categories: [software]
top:
---

[TypeScript Tutorial](https://www.typescriptlang.org/docs/handbook/typescript-in-5-minutes.html)

<!--more-->

```bash install typescript
$ sudo npm install -g typescript
```

```javaScript greeter.ts
function greeter(person) {
    return "Hello, " + person;
}

let user = "Jane User";

document.body.textContent = greeter(user);
```

```bash run the TypeScript compiler -> generate greeter.js file
tsc greeter.ts
```

then we are up and running using TypeScript in our JavaScript app

```javaScript
funtion greeter(person: string) {
    return "Hello, " + person;
}

let user = "Jane User";

document.body.textContent = greeter(user);
```

```javaScript
interface Person {
    firstName: string;
    lastName: string;
}

funtion greeter(person: Person) {
    return "Hello, " + person.firstName + " " + person.lastName;
}

let user = { firstName: "Jane", lastName: "User" };

document.body.textContent = greeter(user);
```

```javaScript
class Student {
    fullName: string;
    constructor( public firstName: string, public middleInitial: string, public lastName: string) {
        this.fullName = firstName + " " + middleInitial + " " + lastName;
    }
}

interface Person {
    firstName: string;
    lastName: string;
}

funtion greeter(person: Person) {
    return "Hello, " + person.firstName + " " + person.lastName;
}

let user = new Student("Jane", "M.", "User");

document.body.textContent = greeter(user);
```
