---
title: 进步本
date: 2021-03-09 18:35:34
tags:
categories: [software]
top:
visible:
---


### 取个位数
- 模除%

### 数位左移，个位数变十位数
- *10

### 简化模型利用class
- 泳池问题简化成两个同心圆

```cpp
#include <iostream>
using namespace std;

const float PI = 3.14159;
const float FENCE_PRICE = 35;
const float CONCRETE_PRICE = 20;

//构建模型来模拟同心圆
class Circle
{
public:
    Circle(float r);
    float circumference();
    float area();

private:
    float radius;
};

Circle::Circle(float r)
{
    radius = r;
}

float Circle::circumference()
{
    return 2 * PI * radius;
}

float Circle::area()
{
    return PI * radius * radius;
}

int main(){
    float radius;
    cout<<"enter radius: ";
    cin>>radius;

    Circle pool(radius);
    Circle out(radius +3);

    float fence_cost = FENCE_PRICE * (out.circumference());

    float passage_cost = CONCRETE_PRICE * (out.area() - pool.area());

    cout<<"fence cost="<<fence_cost<<endl;
    cout<<"passage cost="<<passage_cost<<endl;


    return 0;
}
```

### 转换数据类型convert variable type
```cpp
int sum;
double p = power(2, i);
sum += stactic_cast<int> p;
```

### to check if two double values equal
```cpp
if (abs(a-b) < 1e-10)
    return a;
```