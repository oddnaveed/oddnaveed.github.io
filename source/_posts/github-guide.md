---
title: Github Guide
date: 2020-07-04 22:21:15
tags: [github]
categories: [software]
top:
visible:
---

[tutorial!](https://www.liaoxuefeng.com/wiki/896043488029600/896954074659008)

[source: tutorial](https://product.hubspot.com/blog/git-and-github-tutorial-for-beginners)

[source](https://github.com/cubeton/git101/blob/master/TurtorialInfo/Tutorial.md)

[Source](https://learngitbranching.js.org/)

[Source](https://www.yiibai.com/git/git-quick-start.html)

<!--more-->

# Basic commands

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
$ git remote add origin [repo URL]
$ git add .    //stage current folder
$ git commit -m "initializing repository"
$ git push -u origin master
```

```bash [Daily use]
$ git add .
$ git commit -m "commit message"
$ git push origin [branch name]
$ git push
```

```bash
$ git diff  //view changes
$ git log   //view commits
```

## Version name/id

-   current version `HEAD`
-   previous version `HEAD^`
-   the one before previous one `HEAD^^`
-   the previous 100 versions `HEAD~100`
-   to find all version ids: `git reflog`

# Secure the workflow

-   pull request review
-   merge protections
-   require status checks to pass before merging

# Enable prettier

open command palette in vscode -> format document

# Delete the latest commit & discard the changes

```bash
$ git reset --hard HEAD~1
```

# Go back to a future version

```
$ git reset --hard <version id>
```

# Undo staged changes

```
$ git checkout -- <file>
```

# Create and switch branches

```
$ git checkout -b <branch-name>
//or
$ git switch -c <branch-name>
```

# Pull changes from the master to the current branch

```bash
git pull origin master
```

# reset remote url

```
git remote -v   // check remote url
git remote set-url origin https://github.com/username/resposity.git
git remote -v
```

# Merge a specific branch to current branch

```[e.g. merge dev to current branch]
$ git merge dev
```

# Delete branch

```
$ git branch -d <branch-name>
```

# Delete Commit(NOT Reverse Commit)

```
$ git log

$ git reset --hard HEAD^

$ git push origin master -f
```
th