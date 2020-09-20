---
title: Github Guide
date: 2020-07-04 22:21:15
tags: [github]
categories: [software]
top:
visible:
---

[source: tutorial](https://product.hubspot.com/blog/git-and-github-tutorial-for-beginners)

[source](https://github.com/cubeton/git101/blob/master/TurtorialInfo/Tutorial.md) 

[Source](https://learngitbranching.js.org/)

[Source](https://www.yiibai.com/git/git-quick-start.html)

<!--more-->

```bash
$ git branch [newBranchName]
$ git checkout [branchName]

$ git branch   //list all branches

$ git add [filename] // track file 暂存文件 stage
$ git status 

// ignore these files, no need to commit these to git
$ cat .gitignore
*.[oa]
*~


```

```bash [Upload to GitHub]
$ git init
$ git add .    //stage current folder
$ git commit -m "initial commit"
$ git remote add origin [repo URL]
$ git remote -v
$ git push -u origin master
```

```bash [Daily use]
$ git add .
$ git commit -m "commit message"
$ git push origin [branch name]
```