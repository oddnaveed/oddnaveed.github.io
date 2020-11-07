---
title: Break It Down
date: 2020-11-06 20:03:20
tags:
categories: [webDev]
top:
visible: hide
---

# add [nextjs](https://nextjs.org/docs/getting-started)

# add [typescript](https://nextjs.org/docs/basic-features/typescript) support

# add babel check nextjs site

-   javascript compiler


# yarn.lock file

-   goal: keep track of the exact version of every package that is installed

# sass and sourcemaps support

[sass](https://sass-lang.com/install)
[next-sass plugin](https://github.com/vercel/next-plugins/tree/master/packages/next-sass)
[sourcemaps](https://github.com/vercel/next-plugins/tree/master/packages/next-source-maps)

# add typescript eslint parser & related packages

[@typescript-eslint/parser](https://www.npmjs.com/package/@typescript-eslint/parser)
- use `--dev` to add to dev dependencies

```json
"devDependencies": {
    "@typescript-eslint/parser": "^1.4.2",
    "eslint": "^5.15.1",
    "eslint-config-standard": "^12.0.0",
    "eslint-config-standard-react": "^7.0.2",
    "eslint-plugin-import": "^2.16.0",
    "eslint-plugin-node": "^8.0.1",
    "eslint-plugin-promise": "^4.0.1",
    "eslint-plugin-react": "^7.12.4",
    "eslint-plugin-standard": "^4.0.0"
}
```

todo: [learn about husky and lint-staged](https://juejin.im/post/6844903778227847181)
[source](https://segmentfault.com/a/1190000009546913)

# configure prettier via .prettierrc
```
{
    "semi": false,
    "singleQuote": true,
    "jsxSingleQuote": true,
    "arrowParens": "avoid",
    "trailingComma": "none",
    "tabWidth": 4
}
```

