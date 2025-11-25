// object Hello {
//   def main(args: Array[String]): Unit = {
//     println("Hello, Scala2!")
//     Console.println("Hello, World!")
  
//   }
// }


// crtl+f5

// object Hello

// In Scala 2, every program must have an object — which is a singleton instance (i.e., only one copy exists).

// It’s similar to a class in Java, but you don’t need to create an object manually — Scala automatically creates it.

// It’s used as a container to hold methods and variables, such as main.

// ✅ Analogy: object Hello is like Java’s public class Hello with a public static void main.
// Unit : Equivalent of Java’s void → means the function doesn’t return a value.
// =================
// Comments in scala
// Single-line comment
// ctl+/



// compiler
// interpreter

// code ----> compile ----> exe/.class file will be creaetd ---> run --> output c, cpp, java, scala
// code --> run --> op Interpreter python , javascript , peral 


// bytecode
/*
 Multi-line comment
 You can add documentation for long sections
*/

// Documentation comment for tools
/** This function adds two numbers */
  @main def Hello(args: String*): Unit =
    import scala.Console
    println("Hello, Scala3!")
    Console.println("Hello, World!")

// Indention is needed if we are not using {}

// main Function name — called automatically when the program starts.

// In Scala 3, at the top level (no object/class), you don’t automatically inherit all standard imports into the local scope in the same way as inside an object.
// So, to use Console.println, you need to import here     import scala.Console

// No need for object

// No need to write a full main method

// Cleaner and modern

// Looks like Python or Kotlin — great for beginner


// object → Singleton class

// def main → Entry point

// args → Command-line args

// Unit → No return value

// How Scala Executes Code Internally (Easy Explanation)

// Scala code (Hello.scala) → Compiled

// Compiler generates JVM bytecode

// JVM executes .class files

// Output appears in console
// ===============================
//   ✔️ Exercise 1

// Create a Scala 3 program that prints:

// Your name

// Your city

// Your favorite programming language

// ✔️ Exercise 2

// Write a Scala program (Scala 2 style) using:

// object

// main

// println

// ✔️ Exercise 3

// Explain the difference between:

// println

// Console.println

// ✔️ Exercise 4

// Explain what is JVM, JDK, JRE in your own words (interview-style)