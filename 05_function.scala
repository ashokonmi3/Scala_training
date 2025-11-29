// Scala 3 — Module 4: Functions 
// Each example is a separate @main so students can run them one-by-one.

// -----------------------------
// 1) Simple function with no parameters and no return (Unit)
// -----------------------------
@main def fn_noParams_example1(): Unit =
  // Define a function greet which prints a message
  def greet(): Unit =
    println("Hello! This is a simple greeting.")

  // Call the function
  greet()
  println("Hello! This is a after greeting.")

@main def fn_noParams_example2(): Unit =
  // Another no-arg function that prints current lesson title
  def showLesson(): Unit =
    println("Lesson: Functions - Basic examples")

  showLesson()

// -----------------------------
// 2) Function with one parameter (prints result)
// -----------------------------
@main def fn_oneParam_example1(): Unit =
  // Function that accepts a name and prints a welcome
  def welcome(name: String): Unit =
    println(s"Welcome, $name!")

  welcome("Ashok")
  welcome("Alekya")


@main def fn_oneParam_example2(): Unit =
  // Function that accepts an integer and prints whether it's positive
  def printSign(n: Int): Unit =
    if n > 0 then println(s"$n is positive")
    else if n < 0 then println(s"$n is negative")
    else println("Zero")

  printSign(5)
  // printSign("5")

  printSign(-3)
  printSign(0)

// -----------------------------
// 3) Function with two parameters (prints or computes)
// -----------------------------
@main def fn_twoParams_example1(): Unit =
  // Print sum of two numbers
  def printSum(a: Int, b: Int): Unit =
    println(s"Sum of $a and $b = ${a + b}")

  printSum(10, 20)

@main def fn_twoParams_example2(): Unit =
  // Combine first and last name and print
  def printFullName(first: String, last: String): Unit =
    println(s"Full Name: ${first + " " + last}")

  printFullName("Ashok", "Sharma")

// -----------------------------
// 4) Function that returns a value (Int)
// -----------------------------
@main def fn_returnInt_example1(): Unit =
  // Multiply two numbers and return result
  def multiply(x: Int, y: Int): Int =
    x * y  // last expression is returned implicitly return x*y

  val m = multiply(6, 7)
  println(s"6 * 7 = $m")

@main def fn_returnInt_example2(): Unit =
  // Calculate square of a number
  def square(n: Int): Int = n * n

  println(s"square(9) = ${square(9)}")

// -----------------------------
// 5) Function that returns a String
// -----------------------------
@main def fn_returnString_example1(): Unit =
  // Build a greeting message and return it
  def buildGreeting(name: String): String =
    s"Hi, $name! Have a great day." //return

  val msg = buildGreeting("Student")
  println(msg)
  val msg1 = buildGreeting("Trainer")
  println(msg1)

@main def fn_returnString_example2(): Unit =
  // Convert a name to uppercase and return
  def shout(name: String): String =
    name.toUpperCase

  println(shout("ashok"))

// -----------------------------
// 6) Function that returns Boolean (predicate examples)
// -----------------------------
@main def fn_returnBoolean_example1(): Unit =
  // Check evenness
  def isEven(n: Int): Boolean =
    n % 2 == 0 //true
    // n/2 -> 5

  println(s"isEven(10) = ${isEven(10)}")
  println(s"isEven(7) = ${isEven(7)}")

@main def fn_returnBoolean_example2(): Unit =
  // Check if string contains only letters
  def isAlpha(s: String): Boolean =
    s.matches("[A-Za-z]+")

  println(isAlpha("Hello"))
  println(isAlpha("Hello123"))

// -----------------------------
// 7) Function with default parameter value
// -----------------------------
@main def fn_defaultParam_example1(): Unit =
  // Welcome with default name "Guest"
  def welcome(name: String = "Guest"): Unit =
    println(s"Welcome, $name")

  welcome()           // uses default
  welcome("Ashok")    // uses provided value

@main def fn_defaultParam_example2(): Unit =
  // Multiply with default multiplier 2
  def times(n: Int, factor: Int = 2): Int =
    n * factor

  println(times(5))      // 5 * 2
  println(times(5, 3))   // 5 * 3

// -----------------------------
// 8) Function calling another function (composition)
// -----------------------------
@main def fn_calling_example1(): Unit =
  // Small helper functions
  def add(a: Int, b: Int): Int = 
    a + b
  def double(n: Int): Int = n * 2

  // Use one function's result in another
  val sum = add(3, 4)
  val doubledSum = double(sum)
  println(s"sum = $sum, doubled = $doubledSum")

@main def fn_calling_example2(): Unit =
  // String helper
  def firstChar(s: String): Char = s.charAt(0)
  def greetWithFirst(name: String): Unit =
    println(s"Hello, ${firstChar(name)}!")

  greetWithFirst("Ashok")

// -----------------------------
// 9) Single-line (inline) function style
// -----------------------------
@main def fn_inline_example1(): Unit =
  // Simple one-line function to triple a number
  def triple(n: Int): Int = n * 3

  println(s"triple(4) = ${triple(4)}")

@main def fn_inline_example2(): Unit =
  // Return boolean in one line
  def isPositive(n: Int): Boolean = n > 0

  println(isPositive(5))
  println(isPositive(-1))

// -----------------------------
// 10) Function with explicit return (showing alternative, not required)
// -----------------------------
@main def fn_returnKeyword_example(): Unit =
  // Using return; not necessary in Scala but shown for clarity
  def subtract(a: Int, b: Int): Int =
    return a - b

  println(subtract(10, 3))

// -----------------------------
// 11) Function that demonstrates string operations and return
// -----------------------------
@main def fn_stringOps_example1(): Unit =
  def concatNames(first: String, last: String): String =
    first + " " + last

  println(concatNames("Ashok", "Sharma"))

@main def fn_stringOps_example2(): Unit =
  def initials(first: String, last: String): String =
    // safe: assume non-empty strings for beginners
    s"${first.charAt(0)}.${last.charAt(0)}."

  println(initials("Ashok", "Sharma"))

// -----------------------------
// 12) Functions with simple conditional logic inside
// -----------------------------
@main def fn_conditional_example1(): Unit =
  def grade(marks: Int): String =
    if marks >= 90 then "A"
    else if marks >= 75 then "B"
    else if marks >= 60 then "C"
    else "D"

  println(grade(92))
  println(grade(70))
  println(grade(50))

@main def fn_conditional_example2(): Unit =
  def sign(n: Int): String =
    if n > 0 then "Positive"
    else if n < 0 then "Negative"
    else "Zero"

  println(sign(10))
  println(sign(-5))
  println(sign(0))

// -----------------------------
// 13) Small calculator examples (multiple simple functions)
// -----------------------------
@main def fn_calc_example1(): Unit =
  def add(a: Int, b: Int): Int = a + b
  def sub(a: Int, b: Int): Int = a - b
  def mul(a: Int, b: Int): Int = a * b
  def div(a: Int, b: Int): Int = a / b // integer division for beginners

  println(s"10 + 5 = ${add(10,5)}")
  println(s"10 - 5 = ${sub(10,5)}")
  println(s"10 * 5 = ${mul(10,5)}")
  println(s"10 / 5 = ${div(10,5)}")

@main def fn_calc_example2(): Unit =
  def average(a: Int, b: Int): Double =
    (a + b) / 2.0  // returning Double

  println(s"Average of 5 and 7 = ${average(5,7)}")

// -----------------------------
// 14) Functions demonstrating getOrElse like behavior (simple)
// -----------------------------
@main def fn_optionLike_example1(): Unit =
  // Beginners: simulate optional input with empty string check
  def greetOrDefault(name: String): String =
    if name == "" then "Hello, Guest" else s"Hello, $name"

  println(greetOrDefault(""))
  println(greetOrDefault("Ashok"))

// -----------------------------
// 15) Using functions in simple loops (practical)
// -----------------------------
@main def fn_loopUse_example1(): Unit =
  def square(n: Int): Int = n * n

  // Use function inside for loop and print results
  for i <- 1 to 5 do
    println(s"${i}^2 = ${square(i)}")

@main def fn_loopUse_example2(): Unit =
  def isEven(n: Int): Boolean = n % 2 == 0

  val nums = List(1,2,3,4,5,6)
  for n <- nums do
    if isEven(n) then println(s"$n is even")
    else println(s"$n is odd")

// -----------------------------
// 16) Small practical tasks as examples (students can copy-paste)
// -----------------------------
@main def fn_practical_examples(): Unit =
  // Convert Celsius to Fahrenheit and print
  def cToF(c: Double): Double = (c * 9.0/5.0) + 32.0
  println(s"0°C = ${cToF(0)}°F, 37°C = ${cToF(37)}°F")

  // Count number of characters in a string (simple)
  def lengthOf(s: String): Int = s.length
  println(s"Length of 'Ashok' = ${lengthOf("Ashok")}")

// -----------------------------
// 17) Exercises prompt printed for students
// -----------------------------
@main def fn_exercisesPrompt(): Unit =
  println("FUNCTIONS EXERCISES:")
  println("1) Write a function add(a:Int, b:Int) that returns sum.")
  println("2) Write a function isOdd(n:Int) that returns true for odd numbers.")
  println("3) Write a function areaRect(l:Int, w:Int) that returns area.")
  println("4) Write a function greet(name:String = \"User\") with default param.")
  println("5) Write a function countVowels(s:String) that returns number of vowels.")
