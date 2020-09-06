---
title: Build a Portfolio with Django
date: 2019-12-05 14:18:50
tags:
- [django]
- [python]
categories: [software]
---
use Atom or Pycharm
[LinkedIn Learning](https://www.linkedin.com/learning/building-a-personal-portfolio-with-django/connecting-your-django-project-to-postgres)

# Start a new project
``` bash
$ cd desired_directory
$ django-admin startproject project_name
$ cd project_name
$ ls
$ python3 manage.py runserver
```
<!--more-->

``` bash
Meteor:portfolio-project Meteor$ python3 manage.py runserver
Watching for file changes with StatReloader
Performing system checks...

System check identified no issues (0 silenced).

You have 17 unapplied migration(s). Your project may not work properly until you apply the migrations for app(s): admin, auth, contenttypes, sessions.
Run 'python manage.py migrate' to apply them.

December 03, 2019 - 06:28:25
Django version 2.2.7, using settings 'portfolio.settings'
Starting development server at http://127.0.0.1:8000/
Quit the server with CONTROL-C.
```

# create a Django app in a project
``` bash
$ django-admin startapp jobs
```

# setting app in project
* in settings.py
``` py
INSTALLED_APPS = [
    'django.contrib.admin',
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.messages',
    'django.contrib.staticfiles',
    'jobs',
]
```


# setting up URLs in django project
* in urls.py
``` py
from django.conf.urls import url
from django.contrib import admin
import jobs.views

urlpatterns = [
    url(r'^admin/', admin.site.urls),
    url('mila', jobs.views.mila, name='mila')
]
```

* create folders
jobs/templates/jobs


* in views.py
``` py
def mila(request):
    return render(request, 'jobs/mila.html')
```    


# create models in django
* model: a python class that can be saved into database
* in models.py

``` py
class Job(models.Model):
    #Images
    image = models.ImageField(upload_to = 'images/')
    #summary
    summary = models.CharField(max_length=200)
```

# set keyword
``` bash
postgres=# \password postgres
Enter new password: 
Enter it again: 
postgres=# 
```

- username: postgres
- key: 1234

# database
## create database
``` bash
postgres=# CREATE DATABASE portfoliodb;
CREATE DATABASE
```

## change default database
* in settings.py
``` py
DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.postgresql',
        'NAME': 'portfoliodb',
        'USER': 'postgres',
        'PASSWORD': 'django1234',
        'HOST': 'localhost',
        'PORT': '5432',
    }
}
```


























