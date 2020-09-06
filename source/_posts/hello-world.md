---
title: Hexo Guide
categories:
  - software
visible: hide

---

好看的分割线

---

Welcome to [Hexo](https://hexo.io/)! This is your very first post. Check [documentation](https://hexo.io/docs/) for more info. If you get any problems when using Hexo, you can find the answer in [troubleshooting](https://hexo.io/docs/troubleshooting.html) or you can ask me on [GitHub](https://github.com/hexojs/hexo/issues).

## Quick Start

### Create a new post

```bash
$ hexo new "My New Post"
```

More info: [Writing](https://hexo.io/docs/writing.html)

<!--more-->

### Add Image

- relative to source folder
  for example
  ![](/img/01.jpeg)

### Run server

```bash
$ hexo clean
$ hexo server
```

More info: [Server](https://hexo.io/docs/server.html)

### Generate static files

```bash
$ hexo generate
```

More info: [Generating](https://hexo.io/docs/generating.html)

### Deploy to remote sites

```bash
$ hexo deploy
```

More info: [Deployment](https://hexo.io/docs/one-command-deployment.html)

### Hexo Markdown

**这是加粗**

_这是斜体_

~~横线~~

- 无序列表

1. 有序列表
2. 有序列表

`内嵌代码`

```
代码块
```

Icon made by <a href="https://www.flaticon.com/authors/gregor-cresnar" title="Gregor Cresnar">Gregor Cresnar</a> from <a href="https://www.flaticon.com/">www.flaticon.com</a>

```[language] [title] [url] [link-text]

`代码`

```

/_ 分隔线 _/

<hr />
/* 注意事项 [6]：在XHTML 中，<hr> 必须被正确地关闭，比如 <hr /> */

/_ 空行 _/
<br />
/_ 注意事项同上 _/

```


<br />
引用站内文章
```

{% post_link md_file_name name_shown_on_page %}

```

```

<!-- 居中显示 -->

{% cq %}
jfdiowrjjwioejiw
{% endcq %}

```bash
$ hexo d -g
```

## [visitor counter](https://otuki.top/Hexo%E5%92%8CNexT%E4%B8%BB%E9%A2%98%E4%B8%AA%E6%80%A7%E9%85%8D%E7%BD%AE%E5%92%8C%E4%BC%98%E5%8C%96/)

"因为之前我使用 leancloud 的 Valine 评论系统，已经注册了 leancloud 的帐号，访问统计也使用 leancloud 好了。

首先前往 leancloud 登录，进入应用，如果没有的话需要先创建一个应用。然后点击“存储”，“创建 Class”，名称为 Counter。"

如果使用了 Valine 评论系统，可以直接将 Valine 字段里的 visitor 设置为 true 即可。如果没有使用 Valine，则需要前往设置-应用 Key，复制 App ID 和 App Key，填入 leancloud_visitors 字段里的 app_id 和 app_key 中。

- to hide an article:
visible: hide
