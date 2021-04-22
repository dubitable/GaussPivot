# Gaussian Pivot

The Gaussian Pivot is an algorithm to solve systems of linear equations with n variables. It's just math.

## Introduction

My math teacher originally asked me to code this in Python, which I successfully did, but I decided to challenge myself by remaking it in Java, a language I am still appropriating myself with. The concept of the Gaussian Pivot is pretty simple: it's a recursive algorithm that cancels out a variable every call until only one remains. We can then ladder back up, plugging in more and more variables to finally obtain the solution. 

## Lots and lots of elimination

Let's say we have a two variable system:

```
3x + 2y = 4
4x - y = 2
```

In order to simplify the system by a variable, we can multiply each equation with the coefficient in front of the x from the other:
```
3x + 2y = 4  <=>  4 (3x + 2y) = 4(4)  <=> 12x + 8y = 16
4x + y = 2   <=>  3 (4x + y) = 3(2)   <=> 12x + 3y = 6
```
Now the equations have the same coefficient in front of the x, so we can use elimination, in this case by substraction:
```
12x + 8y = 16  
12x - 3y = 6   <=>  (12x - 12x) + (8y - 3y) = 16 - 6  <=>  5y = 10  <=>  y = 2
```
We have thus found y from a two variable system. For n variables, the concept stays the same. In the code, we establish a "reference" equation (the first in the system) to repeat this process against.

## "Laddering"

To obtain the other variables in the system, we just have to go through a process I like to call "laddering". Previous "stages" of the system are saved with the result during recursion, so we just have to plug the variables back into the old equations.
```
3x + 2y = 4  <=>  3x + 2(2) = 4  <=>  3x + 4 = 4  <=>  3x = 0  <=>  x = 0
```
And there we go: we have found both x (0), and y (2) for our two variable system, but the laddering technique can of course be applied to n variables.
