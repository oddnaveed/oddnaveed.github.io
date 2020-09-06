---
title: Debugging Experience
date: 2020-05-26 23:42:37
tags: [debug]
categories: [software]
top:
visible:
---
`summary`
- make a small example when writing code, instead of thinking in the mind
- FBR principle, just get started
- Do research before coding

<!--more-->

---

## Array

if need to go through a loop with 2D/3D arrays or etc., print out the whole array to check the value

```java [Example]
//check debug
System.out.println("parent[][]:");
for(int i=0; i<rowNum; ++i){
    for(int j=0; j<colNum; ++j){
        System.out.print(parent[i][j][0]+","+parent[i][j][1]+" ;");
    }
    System.out.println();
}

System.out.println("sumOfBrightness[][]:");
for (int i = 0; i < rowNum; ++i) {
    for (int j = 0; j < colNum; ++j) {
        System.out.print(sumOfBrightness[i][j]+", ");
    }
    System.out.println();
}
//debuggggggggggggggggg
```

## Array value might change when reassigning!

```java [Example]
// to find the maximum brightness along the darkest path
int pointerR = vr;
int pointerC = vc;
maxBrightnessOfDarkestPath = image[ur][uc]; // assume the start pixel has the maximum brightness
while (true) {
    if (image[pointerR][pointerC] > maxBrightnessOfDarkestPath) {
        maxBrightnessOfDarkestPath = image[pointerR][pointerC];
    }
    // move the pointer pixel to its parent pixel
    int newPointerR = parent[pointerR][pointerC][0]; //notice here
    int pointerC = parent[pointerR][pointerC][1];
    pointerR = newPointerR; //and notice here
    if(pointerR == ur && pointerC == uc)
        break;
}
```
