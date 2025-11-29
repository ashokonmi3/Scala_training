// // ModuleIfElse.scala
// // Scala 3 — Module: If / Else
// // All examples use top-level @main so students can run independently.
// // Heavily commented for training use.

// // -----------------------------
// // 1) Basic if / else statement
// // -----------------------------
@main def if_basic(): Unit =
  // Simple condition
  val age = 20
  if age >= 18 then

    println("You are an adult")
  else
    println("You are a minor")

// -----------------------------
// 2) If / else as expression (returns a value)
// -----------------------------
@main def if_expression(): Unit =
  val marks = 72

  // In Scala, if can return a value — this is an expression
  val result =
    if marks >= 60 then "Pass"
    else "Fail"

  println(s"Marks = $marks, Result = $result")

// -----------------------------
// 3) If / else if / else ladder
// -----------------------------
@main def if_elseIf_ladder(): Unit =
  val score = 88

  val grade =
    if score >= 90 then "A"
    else if score >= 75 then "B"
    else if score >= 60 then "C"
    else "D"

  println(s"Score = $score, Grade = $grade")

// -----------------------------
// 4) Nested ifs (avoid deep nesting in practice)
// -----------------------------
@main def if_nested(): Unit =
  val x = 10
  val y = 5

  if x > 0 then
    if y > 0 then
      println("Both are positive")
    else
      println("x positive, y not positive")
  else
    println("x is not positive")

// // -----------------------------
// // 5) Using boolean operators with if
// // -----------------------------
@main def if_booleanOps(): Unit =
  val isMember = true
  val age = 17

  if isMember && age >= 18 then
    println("Member adult: discount applies")
  else if isMember && age < 18 then
    println("Member under 18: youth discount")
  else if !isMember && age >= 18 then
    println("Non-member adult: regular price")
  else
    println("Non-member under 18")

// // -----------------------------
// // 6) Compact single-line if (not recommended for complex logic)
// // -----------------------------
@main def if_singleLine(): Unit =
  val flag = true
  if flag then println("Flag is true") else println("Flag is false")

// // -----------------------------
// // 7) If expression with different types (common type required)
// // -----------------------------
@main def if_differentTypes(): Unit =
  // Both branches must produce compatible types
  val cond = true
  val value =
    if cond then 10      // Int
    else 20             // Int (compatible)
  println(s"value = $value")

// // -----------------------------
// // 8) If expression with incompatible types (shows compile error concept)
// // -----------------------------
@main def if_incompatibleShow(): Unit =
  // This example is to show students *why* both branches must be compatible.
  // Uncommenting the next lines will cause a compilation error.
  
  val v =
    if true then 10
    else "ten"   // incompatible types: Int vs String
  println(v)
//   

// // -----------------------------
// // 9) Using if with string comparisons
// // -----------------------------
@main def if_stringCompare(): Unit =
  val city = "Bangalore"
  if city == "Bangalore" then
    println("Local city")
  else
    println("Other city")

// // -----------------------------
// // 10) Null safety & using Option instead of null (basic)
// // -----------------------------
@main def if_nullVsOption(): Unit =
  // Avoid null in Scala; use Option instead
  val maybeName: Option[String] = Some("Ashok") // or None
  // Using pattern match-like if via getOrElse for beginner students:
  if maybeName.isDefined then
    println(s"Name = ${maybeName.get}")
  else
    println("Name missing")

  // More idiomatic:
  println("Using getOrElse -> " + maybeName.getOrElse("DefaultName"))

// // -----------------------------
// // 11) Practical example: discount calculation
// // -----------------------------
@main def if_practicalDiscount(): Unit =
  val price = 1200.0
  val customerType = "gold" // silver/gold/regular

  val finalPrice =
    if customerType == "gold" then price * 0.8
    else if customerType == "silver" then price * 0.9
    else price

  println(f"Final price for $customerType = $finalPrice%.2f")

// // -----------------------------
// // 12) Exercises prompt for students
// // -----------------------------
@main def if_exercises(): Unit =
  println("If/Else Exercises:")
  println("1) Write a program (copy/paste) to check whether a given number is even or odd.")
  println("2) Check if a year is a leap year (basic rule: divisible by 4).")
  println("3) Given three numbers (a,b,c) using only if/else print the maximum.")
  println("4) Given temperature value, print Cold/Moderate/Hot thresholds.")
