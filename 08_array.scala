// =====================================================================
// Filename: 09_array.scala
// Topic: Scala Array & ArrayBuffer (Beginner Friendly)
// =====================================================================
//
// ✔ What is an Array?
//    - Fixed-size collection of elements of the same type
//    - Index-based (fast access by index)
//    - Mutable: you can change values at each index
//
// ✔ What is ArrayBuffer?
//    - Like a "resizable Array"
//    - You can grow/shrink it by adding/removing elements
//    - Part of scala.collection.mutable
//
// This file covers:
//   1) Creating Arrays
//   2) Accessing and updating elements
//   3) Looping on Arrays
//   4) Common operations: length, contains, sum, min, max
//   5) map, filter on Array
//   6) Sorting and reversing
//   7) Converting Array <-> List
//   8) ArrayBuffer basics
//   9) Building ArrayBuffer using loops
//  10) Converting between Array and ArrayBuffer
//  11) Practical examples
//  12) Exercises prompt
//
// Each @main can be run independently.
// =====================================================================


/********************************
 * 1) Creating Arrays
 ********************************/

@main def array_create(): Unit =
  // Syntax 1: using Array(...)
  val nums = Array(10, 20, 30, 40)
  val fruits = Array("apple", "banana", "mango")

  println(s"Nums   = ${nums.mkString(", ")}")
  println(s"Fruits = ${fruits.mkString(", ")}")

  // Syntax 2: new Array[type](size) -> default initialized
//   val zeros = new Array   // all 0
//   println(s"Zeros  = ${zeros.mkString(", ")}")


/********************************
 * 2) Accessing & Updating Array elements
 ********************************/
@main def array_access_update(): Unit =
  val arr = Array(1, 2, 3, 4)

  // Access by index (0-based)
  println(s"arr(0) = ${arr(0)}")
  println(s"arr(1) = ${arr(1)}")

  // Update value at an index
  arr(0) = 100
  arr(3) = 400
  println(s"Updated array = ${arr.mkString(", ")}")

  // Length of array
  println(s"Length = ${arr.length}")


/********************************
 * 3) Looping on Arrays
 ********************************/
@main def array_loop_for(): Unit =
  val colors = Array("red", "green", "blue")

  println("Loop using for:")
  for c <- colors do println(c)

@main def array_loop_index(): Unit =
  val arr = Array(5, 10, 15, 20)
  println("Loop with index:")
  for i <- 0 until arr.length do
    println(s"Index $i -> ${arr(i)}")

@main def array_loop_foreach(): Unit =
  val arr = Array("A", "B", "C")
  println("Loop using foreach:")
  arr.foreach(x => println(x))


/********************************
 * 4) Common operations: contains, sum, min, max
 ********************************/
@main def array_common_ops(): Unit =
  val nums = Array(4, 8, 2, 10, 6)

  println(s"Array = ${nums.mkString(", ")}")
  println(s"Contains 8?  = ${nums.contains(8)}")
  println(s"Contains 100?= ${nums.contains(100)}")

  // Convert to List to use many List methods
  val list = nums.toList
  println(s"Sum = ${list.sum}")
  println(s"Min = ${list.min}")
  println(s"Max = ${list.max}")
  
  val list1 = List(10, 20, 30)

  val arr = list1.toArray
  println(s"Array = ${arr.mkString(", ")}")

  

/********************************
 * 5) map and filter on Arrays
 ********************************/
@main def array_map_filter(): Unit =
  val nums = Array(1, 2, 3, 4, 5, 6)

  // Double each value
  val doubled = nums.map(n => n * 2)
  // Keep only even numbers
  val evens   = nums.filter(n => n % 2 == 0)

  println(s"Original = ${nums.mkString(", ")}")
  println(s"Doubled  = ${doubled.mkString(", ")}")
  println(s"Evens    = ${evens.mkString(", ")}")


/********************************
 * 6) Sorting and reversing Arrays
 ********************************/
@main def array_sort_reverse(): Unit =
  val nums = Array(5, 1, 4, 2, 3)

  val sortedAsc  = nums.sorted
  val sortedDesc = nums.sorted.reverse

  println(s"Array   = ${nums}")

  println(s"Original   = ${nums.mkString(", ")}")
  println(s"Ascending  = ${sortedAsc.mkString(", ")}")
  println(s"Descending = ${sortedDesc.mkString(", ")}")


/********************************
 * 7) Converting between Array and List
 ********************************/
@main def array_list_convert(): Unit =
  val arr = Array(10, 20, 30)
  val list = arr.toList
  println(s"Array -> List = $list")

  val backToArray = list.toArray
  println(s"List -> Array = ${backToArray.mkString(", ")}")


/********************************
 * 8) Intro to ArrayBuffer (mutable, resizable)
//    Needs import from scala.collection.mutable
 ********************************/
import scala.collection.mutable.ArrayBuffer

@main def arrayBuffer_basic(): Unit =
  // Empty ArrayBuffer of Int
  val ab = ArrayBuffer[Int]()

  // Add elements (similar to ListBuffer)
  ab += 10
  ab += 20
  ab += 30
  ab ++= Seq(40, 50)   // add multiple

  println(s"ArrayBuffer = $ab")

  // Remove element by value
  ab -= 20
  println(s"After -= 20 => $ab")

  // Remove by index (using remove)
  ab.remove(0)         // removes first element
  println(s"After remove(0) => $ab")


/********************************
 * 9) Building an ArrayBuffer using loop
 ********************************/
@main def arrayBuffer_build_loop(): Unit =
  val ab = ArrayBuffer[Int]()

  // Add squares 1^2, 2^2, ..., 5^2
  for i <- 1 to 5 do
    ab += (i * i)

  println(s"Squares in ArrayBuffer = $ab")

  // Convert to immutable List
  val asList: List[Int] = ab.toList
  println(s"Converted to List      = $asList")

  // Convert to Array
  val asArray: Array[Int] = ab.toArray
  println(s"Converted to Array     = ${asArray.mkString(", ")}")
  println(s"Converted to Array     = $asArray")
  
  

/********************************
 * 10) Converting Array <-> ArrayBuffer
 ********************************/
@main def array_arrayBuffer_convert(): Unit =
  val arr = Array(1, 2, 3)

  // Array to ArrayBuffer
  val ab = ArrayBuffer.from(arr)
  ab += 4
  println(s"Array       = ${arr.mkString(", ")}")
  println(s"ArrayBuffer = $ab")

  // ArrayBuffer to Array
  val arr2 = ab.toArray
  println(s"Back to Array = ${arr2.mkString(", ")}")


/********************************
 * 11) Practical examples using Array / ArrayBuffer
 ********************************/

// Example 1: Find all even numbers from an Array
@main def array_practical_evens(): Unit =
  val arr = Array(11, 12, 13, 14, 15, 16)
  val evens = arr.filter(_ % 2 == 0)
  println(s"Evens = ${evens.mkString(", ")}")

// Example 2: Count how many values are > 50
@main def array_practical_gt50(): Unit =
  val arr = Array(10, 60, 55, 40, 80, 90)
  val count = arr.count(_ > 50)
  println(s"Array   = ${arr.mkString(", ")}")
  println(s"> 50 count = $count")

// Example 3: Build ArrayBuffer of names and then sort them
@main def array_practical_names(): Unit =
  val names = ArrayBuffer[String]()
  names += "Ashok"
  names += "Meena"
  names += "Ravi"
  names += "Anita"

  println(s"Original = $names")
  val sorted = names.sorted
  println(s"Sorted   = $sorted")



/********************************
 * 12) Exercises (printed for students)
//    Students should create their own @main and solve them.
// ********************************/
@main def array_exercises(): Unit =
  println("ARRAY EXERCISES:")
  println("1) Create an Array[Int] with 10 numbers and print only odd numbers.")
  println("2) Find maximum and minimum from an Array[Int] without using .max or .min (use loop).")
  println("3) Create an Array[String] of 5 names and print names with length > 4.")
  println("4) Using ArrayBuffer, store marks of 5 subjects and calculate total.")
  println("5) Convert an Array to List, filter only even numbers, then convert back to Array.")
  println("6) Given Array(1,2,3,4,5), create new Array with each element * 10 using map.")
  println("7) Using ArrayBuffer, add numbers 1 to 10, then remove all even numbers using a loop.")
