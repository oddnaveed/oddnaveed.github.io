---
title: Learning Python
date: 2020-09-18 17:22:14
tags: [python]
categories: [software]
top:
visible:
---
# no perfectionist

# running in vs code
- to launch the python shell: 
  - right click "run selection/line in python terminal"
  - right click "run python file in terminal"

```bash [Exit the python terminal]
>>> exit()
```

# variable type
- use type() to check variable type

```py
cookies = "miiila"
print(type(cookies))
```

# reserved words
```py
import keyword
print(keyword.kwlist)
```

# get input
- input("Type input here")


# print()
- string object has that format() function
```py
x = 42
print('this is {}'.format(x))

print(f'this is {x}')
```
# loops
```py
words = ['one', 'two', 'three']

for i in words:
    print(i)
```

# function
```py
def function(n):
    print(n)
```

# class
```py
class Dog:
    def woof(self):
        print("wooooof")

    def wong(self):
        print("wooooong")

def main():
    buddy = Dog()
    buddy.woof()
    buddy.wong()
```

# multi-line
```py
x = '''

halloow

'''
```

# spaces
```py
x = 'seven "{1:<9}" "{0:>9}"'.format(8, 9)   # fills with spaces
print('x is {}'.format(x))
print(type(x))
```

# float and decimal
```py
from decimal import *
a = Decimal('.10')
b = Decimal('.30')
x = a + a + a - b
print('x is {}'.format(x))
print(type(x))
```

# tuple
- immutable
```py
x = ( 1, 2, 3, 4, 5)
for i in x:
    print(f"i is {i}")
```

# range
- immutable
```py
x = range(5, 50, 5)
for i in x:
    print(f"i is {i}")
```

```py [to change the object]
x = list(range(5))
x[2]=222
for i in x:
    print("i is {}".format(i))
```

# dictionary
```py
x = { 'one': 1, 'two': 2, 'three': 3, 'four': 4}
x['three'] = 333
for k, v in x.items():
    print('k: {}, v: {}'.format(k, v))
```

```py
def main():
    family = dict(baby = 'yue', brother = 'dog')
    for p in family:
        print(f'{p}: {family[p]}')
```


# isinstance
```py
x = (1, 'two', 3.0, [4, 'four'], 5)
if isinstance(x, tuple):
    print("yep")

```

# conditional syntax
```py
if 
elif
else
```

# conditional assignment
```py
gift = 1
say = 'thank you' if gift else 'treat or trick'
print(say)
```

# bitwise operators
```py
&   1 1 为 1
|   0 1 为 1
^   only if one is set and not the other (flip the bits)
00001111 ^ 00001010 -> 00000101
```

# boolean operators
```py
and 
or
not
in          value in set
not in
is          point to the same memory location
is not
```

```py [example]
x = ('tuple', 'is', 'me', 'so', 'unique')
y = 'tuple'

if y is x[0]:
    print('we are the same')
else:
    print('we are not the same')
print(id(y))
print(id(x[0]))
```

```py
def main():
    say_hello('hello mila', 'hello miila', 'hello miiila')

def say_hello(*args):
    if len(args):
        for s in args:
            print(s)
    else: print('no hellos')

if __name__ == '__main__': main()    
```

# decorator
- pass the following function as a parameter
```py
def f1(f):
    def f2():
        print('this is before the function call')
        f()
        print('this is after the function call')
    return f2

# @f1 is a decorator, now when we call f3(), we pass f3 as a parameter to f1
@f1
def f3():
    print('this is f3')

f3()
```

```py
import time

def elapsed_time(f):
    def wrapper():
        t1 = time.time()
        f()
        t2 = time.time()
        print(f'Elapsed time: {(t2 - t1) * 1000} ms')
    return wrapper


@elapsed_time
def big_sum():
    num_list = []
    for num in range(0, 1000):
        num_list.append(num)
    print(f'Big sum: {sum(num_list)}')


def main():
    big_sum()


if __name__ == '__main__': main()
```
