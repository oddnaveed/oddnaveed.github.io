---
title: Think Java
date: 2019-12-09 14:44:16
tags: [java]
categories: [software]
---
[Think Java](https://books.trinket.io/thinkjava/chapter5.html)

## Chapter 1

Git - a “version control system” that allows you to keep track of the files that make up a project
repository - a collection of files under Git’s control
A program is a sequence of instructions that specifies how to perform a computation
So you can think of programming as the process of breaking down a large, complex task into smaller and smaller subtasks.
Computer science is the science of algorithms, including their discovery and analysis. An algorithm is a sequence of steps that specifies how to solve a problem. 
“integrated development environment” (IDE)
<!--more-->
## Chapter 2
You might expect the variable y to get the value 0.333333, which is a legal floating-point value. But instead it gets the value 0.0. The expression on the right divides two integers, so Java does integer division, which yields the int value 0. Converted to double, the value assigned to y is 0.0.

## Chapter 5 (11 Dec)
[chapter 5](https://books.trinket.io/thinkjava/chapter5.html)
5.10  Binary numbers
The countdown example has three parts: (1) it checks the base case, (2) displays something, and (3) makes a recursive call. What do you think happens if you reverse steps 2 and 3, making the recursive call before displaying?
``` java
public static void countup(int n) {
    if (n == 0) {
        System.out.println("Blastoff!");
    } else {
        countup(n - 1);
        System.out.println(n);
    }
}
```


The stack diagram is the same as before, and the method is still called n times. But now the System.out.println happens just before each recursive call returns. As a result, it counts up instead of down:
``` bash
Blastoff!
1
2
3
```

### random number

``` java
import java.util.Random;
public class GuessStarter{
    public static void main(String[] args){
        Random random = new Random();
        int number = random.nextInt(100) + 1;
        System.out.println(number);
    }
}
```

### scanner

``` java
import java.util.Scanner;
public class Convert{
    public static void main(String[] args) {
        double cm;
        Scanner in = new Scanner(System.in);

        System.out.print("Exactly how many cm? ");
        cm = in.nextDouble();
    }
}
```

## Chapter 6
### Exercise2

``` java
public static boolean isDivisible(int n, int m){
    return (m != 0 && n % m ==0);    
}    
```
### Exercise3
``` java
public static boolean isTriangle(int a, int b, int c){
    return a+b>c && a+c>b && b+c>a;
}
```
### Exercise4
```java

```

### Ex5
``` java
flag1 = false;
flag2 = true
```

``` console
false
true
pong
```

### Ex9
``` java
public static power(double x, int n){
    return Math.pow(x, n);
}
```

## Cha 8

