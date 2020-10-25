---
title: React Essentials
date: 2020-10-13 20:55:06
tags:
categories: [webDev]
top:
visible:
---

- Site to deploy: Netlify

# Create React Elements
```js [index.js]
let style = {
    backgroundColor: "orange",
    color: "white",
    fontFamily: "Arial",
};

const header = React.createElement(
    "h2", //type
    { id: "header", className: "header", style: style }, //attributes
    "hello world"
);

ReactDOM.render(header, document.getElementById("root"));
```

# Create React Element Using JSX
