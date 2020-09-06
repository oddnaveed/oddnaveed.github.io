---
title: Java Conventions
date: 2020-05-28 09:22:31
tags: [java]
categories: [software]
top:
visible:
---
[CITS2200JavaConventions](https://teaching.csse.uwa.edu.au/units/CITS2200/Labs/JavaConventions.html)

## Nomenclature
The conventions for identifier names are as follows:

- Classes (and hence file names and constructor methods): begin with an upper case letter. eg QueueBlock, ReversalADT, LinkedList

<!--more-->

- Methods (other than constructors): begin with a lower case letter. eg examine, delete, isEmpty, toString

- Instance variables: begin with a lower case letter. eg items, first, q, c, list

- Constants (final static fields): all upper case. eg MAX_SEQUENCE

- In all cases except constants, upper case letters are used within identifiers to separate "English" words and make the identifiers more readable. Examples include QueueBlock and isEmpty. For constants, underscores are used.

- These conventions are designed to follow as closely as possible to those used by the creators of Java. For example, in the statement:

```java
System.out.println ("hello");
```

System is a class, out is an instance variable, and println is a method.

Similarly, in:

```java
Character.isSpace(' ');
```

Character is a class and isSpace a method.

File names should be the same as the (principal) class stored in the file and package names should match the directory structure in which the file is located. This is required by the Java packaging methodology. For example, Java will look for the class DAT.QueueBlock (where DAT is the package name) in the file:

```bash
./DAT/QueueBlock.java
```

The CITS2200 unit will cover a number of different implementations for each abstract data type. For example, we will consider at least three different representations for a queue: block, block with (cyclic) wraparound, and a linked version. To distinguish between the different implementations, the convention is to name the implementation after the abstract data type, appending after this name an indication of the representation. For example:


QueueBlock
QueueBlockCyclic
QueueLinked

would be appropriate for the three mentioned implementations of the Queue interface. This convention has the added advantage that all implementations of the same ADT will be listed together in indexes and directory listings.<br />

We will regard clarity as more important than brevity and hence sometimes use quite long filenames. This should not cause unnecessary inconvenience providing you are familiar with ideas such as cutting and pasting, filename completion, and navigation through command histories. These topics are discussed in the An Introduction to MacOSX tutorial.

--- 

## Formatting
Java code should be formatted according to the following conventions.

A class or interface should begin and end flush left, with each of its fields and methods indented one tabstop. An indentation of two spaces per tabstop is suggested:

```java
public class QueueBlock {

  private Object [] items;
  ...

  public boolean isEmpty () {return first == last + 1;}
  ...
}
```	

A method should either appear on a single line or surrounding its statements in the same way as a class. For example:

```java
String toString () {
  int i;
  String s = "";
  for (i = first; i <= last; i++)
    s = s + items[i].toString() + '\n';
  return s;
}
```	

Note that the opening brace ends the first line of the method's code and the closing brace is on its own line flush with the left side of the first line (not, for example, at the end of the sixth line). This has two advantages: it separates the text of the method "declaration" from its internal statements and it allows the reader to determine where a method ends by looking down for a brace with the same level of indentation.<br />

As is the case for a class, the internal statements are indented by one tabstop (2 spaces). <br />

An iteration statement should be formatted in the same way as a method - either on a single line:

```java
for (i = first; i <= last; i++) s = s + items[i] + "\n";
```

or on separate lines surrounding its internal statements:

```java
while (!Character.isSpace(c.charValue())) {
  q.insert(c);
  c = new Character((char)System.in.read());
}
```	

As usual, the internal statements should be indented one tabstop (2 spaces).<br />

If an iteration statement has only one clause but it is too long to appear on a single line, it should be indented on the following line:

```java
while (Character.isSpace(c.charValue()))
  c = new Character((char)System.in.read());
```	

For a conditional statement, the above rules apply to the if part and the else part (or to the switch part and to each case). The example below illustrates a case where one part appears on a single line and the other part is broken around a block of statements:

```java
if (!isFull()) {
  last++;
  items[last] = a;
}
else throw new Overflow("enqueuing to full queue");
```	

Braces and semicolons should only be included as necessary. For example:

```java
if (!isEmpty()) list = list.successor;
```

should be used in preference to:

```java
if (!isEmpty()) {list = list.successor;};
```	

Comments on a line of their own should be indented to the level of the code following the comment. For example:

```java
/**
 * delete an object from the front of the list
 * @exception Underflow if the list is empty
 */
public void delete() throws Underflow {
  if (!isEmpty()) list = list.successor;
  // Cannot delete from an empty list
  else throw new Underflow("deleting from empty list");
}
```	

Self-documenting comments should be in the above form with the /* aligned with the code, and the *s at the left of each line aligned vertically beneath the first.<br />

In-line comments (starting with //) may also appear on the same line as code:

```java
if (!isFull()) {  // Do this part if the queue is not full
```	

Finally, you should ensure all code and documentation is a maximum of 80 characters wide - the standard terminal width. Some editors will wrap lines of text without inserting carriage-return characters and when viewed on a non-wrapping editor, paragraphs will appear as a single line. <br /> 
Also, text entered in a wider window will format differently on an 80 character window and will be difficult to read and interpret.

---

## Commenting Programs
Programs submitted for this unit must be fully documented using the javadoc Java automatic documentation facility. In particular, all classes and their fields (both class and instance variables) and methods should be preceded by javadoc comments. For example:

```java
/**
 * A basic recursive (linked) list
 * @author Cara MacNish
 */
public class LinkedList {

  /**
   * Reference to the first link in the list, or null if
   * the list is empty
   */
  private Link list;

  /**
   * examine the first item in the list
   * @return the first item in the list
   * @exception Underflow if the list is empty
   */
  public Object examine() throws Underflow {
    if (!isEmpty()) return list.item;
    else throw new Underflow("examining empty list");
  }

  ...
```  

Documentation for methods should include:

- a @return statement whenever the return type is not void.

- a @param statement for each parameter passed to the method.

- an @exception statement for any exception thrown.

Note that javadoc comments may not be sufficient on their own, and you should include additional comments to improve the ease with which your code can be understood and modified by others. Additional documentation requirements for a particular project will be included in the project description.

