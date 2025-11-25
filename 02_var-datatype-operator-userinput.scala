import scala.io.StdIn

// Scala 3 examples for "Module 2 — Variables, Data Types, Operators"
// Each example is its own @main so you can run them independently.

// -------------------------------
// Example: Basic vars and vals
// -------------------------------


// @main def m2_variables(): Unit =
//   // val is immutable (preferred)
//   val name: String = "Ashok"
//   println(s"Immutable val name = $name")
// // name = "Sharma"   // ❌ Not allowed

//   // var is mutable (use sparingly)
//   var age: Int = 40
//   println(s"Mutable var age before = $age")
//   age = 41
//   println(s"Mutable var age after  = $age")

//   // Type inference: no explicit type required
//   val city = "Bangalore"   // inferred as String
//   val count = 10           // inferred as Int
//   println(s"city = $city, count = $count")

// // -------------------------------
// // Example: Numeric Types
// // -------------------------------
// @main def m2_numericTypes(): Unit =

//   val a: Byte = 10 // 8 bits
//   val b: Short = 200 // 16 bits
//   val c: Int = 10000 //32
//   val d: Long = 10000000000L   // L suffix for Long literals 64 bits
//   val e: Float = 10.5f         // f suffix for Float literals 32 bits
//   val f: Double = 20.99 // 64 bits

//   println(s"Byte: $a, Short: $b, Int: $c, Long: $d, Float: $e, Double: $f")


// // -------------------------------
// // Example: Boolean Type
// // -------------------------------
// @main def m2_boolExample(): Unit =
//   val isScalaFun: Boolean = true
//   val isJavaBetter: Boolean = false
//   println(s"isScalaFun = $isScalaFun, isJavaBetter = $isJavaBetter")

// // -------------------------------
// // Example: Strings
// // -------------------------------
// @main def m2_stringExample(): Unit =
//   val msg: String = "Learning Scala"
//   println(msg)
//   // multiline string example
//   val text = """This is a
//                |multiline string in Scala""".stripMargin
//   val text1 = """This is a
//              |multiline string in Scala"""
//   println(text)
//   println(text1)


// // -------------------------------
// // Example: Char
// // -------------------------------
// @main def m2_charType(): Unit =
//   val letter: Char = 'A'
//   val digit: Char = '9'
//   println(s"letter = $letter, digit = $digit")

// // -------------------------------
// // Example: String Interpolators (s, f, raw)
// // -------------------------------
// @main def m2_stringInterpolators(): Unit =
//   val name = "Ashok"
//   val pi = 3.14159
//   println(s"Hello, $name!")                      // s-interpolator
//   println(f"PI formatted = $pi%.2f")             // f-interpolator for formatting
//   println(raw"Raw string: no escape \n interpreted")
//   println("Raw string: no escape \n interpreted")

// // -------------------------------
// // Example: Immutable vs Mutable in depth
// // -------------------------------
// @main def m2_immutability(): Unit =
//   val x = 10
//   println(s"Immutable x = $x")
//   // x = 20 // uncommenting will cause a compile error: reassignment to val

//   var y = 100
//   println(s"Mutable y before = $y")
//   y = 200
//   println(s"Mutable y after  = $y")

// // -------------------------------
// // Example: Arithmetic Operators
// // -------------------------------
@main def m2_arithmeticOps(): Unit =
  val a = 10
  val b = 3
  println(s"a + b = ${a + b}")

  println(s"$a + $b = ${a + b}")
  println(s"$a - $b = ${a - b}")
  println(s"$a * $b = ${a * b}")
  println(s"$a / $b = ${a / b}")   // integer division
  println(s"$a % $b = ${a % b}")   // remainder

// -------------------------------
// Example: Comparison Operators
// -------------------------------
@main def m2_comparisonOps(): Unit =
  val a = 10
  val b = 20
  println(s"a == b -> ${a == b}")
  println(s"a != b -> ${a != b}")
  println(s"a < b  -> ${a < b}")
  println(s"a > b  -> ${a > b}")
  println(s"a <= b -> ${a <= b}")
  println(s"a >= b -> ${a >= b}")

// -------------------------------
// Example: Logical Operators
// -------------------------------
@main def m2_logicalOps(): Unit =
  val x = true
  val y = false
  println(s"x && y = ${x && y}")
  println(s"x || y = ${x || y}")
  println(s"!x      = ${!x}")

// -------------------------------
// Example: Assignment Operators (+=, -=, etc.)
// -------------------------------
@main def m2_assignmentOps(): Unit =
  var x = 10
  println(s"initial x = $x")
  x += 5 //x = x+5
  println(s"after x += 5 -> $x")
  x -= 2
  println(s"after x -= 2 -> $x")
  x *= 3
  println(s"after x *= 3 -> $x")
  x /= 4
  println(s"after x /= 4 -> $x")
// 39%4 
// -------------------------------
// Example: Constants (val usage)
// -------------------------------
@main def m2_constantsEx(): Unit =
  val PI = 3.14159
  println(s"PI = $PI")

// -------------------------------
// Example: Type Inference
// -------------------------------
@main def m2_typeInference(): Unit =
  val a = 10          // Int
  val b = 10.5        // Double
  val isValid = true  // Boolean
  println(s"a = $a (${a.getClass}), b = $b (${b.getClass}), isValid = $isValid")

  println(s"a = $a (${a.getClass.getSimpleName}), b = $b (${b.getClass.getSimpleName}), isValid = $isValid")

// -------------------------------
// Example: Multiple variable declarations (tuple unpacking)
// // -------------------------------
@main def m2_multiVarEx(): Unit =
  val (name, age, city) = ("Ashok", 40, "Bangalore")
  println(s"name = $name, age = $age, city = $city")

// -------------------------------
// Example: Expression-based assignment (if expression)
// -------------------------------
@main def m2_exprAssignment(): Unit =
  val bonus =
    if 10 > 5 then 100 else 50     // if-expression returns a value
  println(s"bonus = $bonus")

// -------------------------------
// Example: String + Integer formatting best practices
// -------------------------------
@main def m2_strInt(): Unit =
  val age = 40
  println("Your age is " + age)    // Java-style concatenation
  println(s"Your age is $age")     // preferred: string interpolation

// -------------------------------
// Example: Big numbers (Long)
// -------------------------------
@main def m2_bigNumbers(): Unit =
  val big: Long = 99999999999L
  println(s"big number = $big")


// -------------------------------
// Example: Boolean conditions inside variable definitions
// -------------------------------
@main def m2_booleanExp(): Unit =
  val age = 20
  val eligible = age >= 18
  println(s"Age = $age, Eligible = $eligible")

// // -------------------------------
// // Example: Exercises (prints prompt for manual testing)
// // -------------------------------
// @main def m2_exercisesPrompt(): Unit =
//   println("Exercise checklist:")
//   println("1) Create val country = \"India\" and print it.")
//   println("2) Create var temperature = 30; update to 32 and print.")
//   println("3) Print your name using s-interpolator.")
//   println("4) Program: add/sub/mul/div two numbers.")
//   println("5) Student variables: name, roll, marks -> print using s-interpolator.")
//   println("6) Check conditions: age > 18, country == \"India\" and logical AND.")
//   println("7) Compute total marks, average, percentage from marks list.")
//   println("8) Try to declare a val and attempt reassignment to see compile error.")




// @main def temperatureConversion: Unit =
//    println("Enter temperature in Celsius:")
//    val celsius = StdIn.readLine().toDouble
//    val fahrenheit = celsius * 9/5 + 32
//    println(s"Temperature in Fahrenheit: $fahrenheit")