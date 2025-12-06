// =====================================================================
// Filename: 08_list.scala
// Topic: Scala List & ListBuffer 
// =====================================================================
//
// ✔ What is a List?
//    - An ordered collection of elements.
//    - Immutable in Scala (cannot change original list).
//    - Very commonly used in Scala programs.
//
// ✔ What is ListBuffer?
//    - A mutable (changeable) version of List.
//    - We can add/remove elements without creating a new collection.
//    - Useful when we need to build a list step by step.
//
// This file covers:
//   1) Creating Lists
//   2) Accessing elements
//   3) Looping over Lists
//   4) Common List operations: head, tail, length, contains, etc.
//   5) Map, Filter, Reduce on List
//   6) Sorting and Reversing
//   7) Introduction to ListBuffer (mutable list)
//   8) Converting between List and ListBuffer
//   9) Practical tasks using List
//
// Each @main can be run independently.
// =====================================================================



/********************************
 * 1) Creating Lists
 ********************************/
@main def list_create(): Unit =
  // List of Int
  val numbers = List(10, 20, 30, 40)
  // List of String
  val fruits = List("apple", "banana", "mango")

  println(s"Numbers = $numbers")
  println(s"Fruits  = $fruits")

  // Empty List
  val emptyList: List[Int] = List()
  println(s"Empty List = $emptyList")



/********************************
 * 2) Accessing elements in a List
 ********************************/
@main def list_access(): Unit =
  val fruits = List("apple", "banana", "mango", "orange")

// Index :  0       1         2        3
// Fruit : apple   banana   mango   orange

  // Indexing starts at 0
  println(s"First element  = ${fruits(0)}")
  println(s"Second element = ${fruits(1)}")
  println(s"Last element   = ${fruits(fruits.length - 1)}") //4-1 fruits(3)

  // Safer way: using head and last
  println(s"Head = ${fruits.head}")
  println(s"Last = ${fruits.last}")



/********************************
 * 3) List properties: length, isEmpty, contains
 ********************************/
@main def list_properties(): Unit =
  val nums = List(1, 2, 3, 4, 5)

  println(s"List = $nums")
  println(s"Length = ${nums.length}")
  println(s"Is empty? = ${nums.isEmpty}")
  println(s"Contains 3? = ${nums.contains(3)}")
  println(s"Contains 10? = ${nums.contains(10)}")



/********************************
 * 4) Looping over a List
 ********************************/
@main def list_loop_basic(): Unit =
  val nums = List(2, 4, 6, 8)

  // Simple for loop
  println("Loop using for:")
  for n <- nums do println(n)

  // foreach method
  println("Loop using foreach:")
  nums.foreach(n => println(n))



/********************************
 * 5) Adding elements (creates NEW List)
//      Original list is NOT changed because List is immutable
 ********************************/
@main def list_add_elements(): Unit =
  val base = List(1, 2, 3)

  // Add at end
  val listEnd = base :+ 4
  // Add at beginning
  val listStart = 0 +: base
  // Add multiple elements
  val listMore = base ++ List(4, 5, 6)

  println(s"Base       = $base")
  println(s"Add end    = $listEnd")
  println(s"Add start  = $listStart")
  println(s"Add more   = $listMore")



/********************************
 * 6) Map — apply a function to each element
 ********************************/
@main def list_map_example(): Unit =
  val nums = List(1, 2, 3, 4, 5)

  // Double each element
  val doubled = nums.map(n => n * 2)
  println(s"Original = $nums")
  println(s"Doubled  = $doubled")

  // Convert to String with prefix
  val asString = nums.map(n => s"Num:$n")
  println(asString)



/********************************
 * 7) Filter — keep only elements that match a condition
 ********************************/
@main def list_filter_example(): Unit =
  val nums = List(3, 4, 7, 8, 9, 10)

  val evens = nums.filter(n => n % 2 == 0)
  val odds  = nums.filter(n => n % 2 != 0)
  val gt5   = nums.filter(n => n > 5)

  println(s"Original = $nums")
  println(s"Evens    = $evens")
  println(s"Odds     = $odds")
  println(s"> 5      = $gt5")



/********************************
 * 8) Reduce / Sum / Min / Max
 ********************************/
@main def list_reduce_sum_min_max(): Unit =
  val nums = List(10, 5, 8, 20)

  // Built-in functions
  println(s"List = $nums")
  println(s"Sum  = ${nums.sum}")
  println(s"Min  = ${nums.min}")
  println(s"Max  = ${nums.max}")

  // Reduce example: multiply all elements
  val product = nums.reduce((a, b) => a * b)
  println(s"Product = $product")

  val sum = nums.reduce((a, b) => a + b )
  println(s"Sum = $sum")

/********************************
 * 9) Sorting and Reversing
 ********************************/
@main def list_sort_reverse(): Unit =
  val nums = List(5, 1, 4, 2, 3)

  val sortedAsc = nums.sorted
  val sortedDesc = nums.sorted.reverse

  println(s"Original   = $nums")
  println(s"Ascending  = $sortedAsc")
  println(s"Descending = $sortedDesc")



/********************************
 * 10) Working with List of Strings
 ********************************/
@main def list_strings_example(): Unit =
  val names = List("Ashok sharma", "Meena", "Ravi", "Anita")

  // Find names starting with 'A'
  val startsWithA = names.filter(n => n.startsWith("A"))
  // Convert all names to upper case
  val upper = names.map(n => n.toUpperCase)
  // Find longest name
  val longest = names.maxBy(n => n.length)

  println(s"Names        = $names")
  println(s"Starts with A= $startsWithA")
  println(s"Upper case   = $upper")
  println(s"Longest name = $longest")



/********************************
 * 11) Nested List (List of List)
//      Useful in tables, matrices, etc.
//      We'll keep it very simple for beginners.
// ********************************/

@main def list_of_list(): Unit =
  val matrix = List(
    List(1, 2, 3),
    List(4, 5, 6),
    List(7, 8, 9)
  )
  
    
  val row1= List(1, 2, 3)
  println(row1.mkString("*"))
  

  println("Matrix elements:")
  for row <- matrix do
    println(row.mkString(" "))

  println("All numbers printed one by one:")
  for row <- matrix do
    for col <- row do
      println(col)



// =====================================================================
// 12) ListBuffer — Mutable List (can change contents)
// =====================================================================
//
// Why ListBuffer?
//  • ListBuffer allows us to add/remove elements directly
//  • No need to recreate new lists every time
//  • Useful when building a list in a loop
//
// ListBuffer is in scala.collection.mutable package.
// =====================================================================
import scala.collection.mutable.ListBuffer

@main def listBuffer_basic(): Unit =
  // Create an empty ListBuffer of Int
  val lb = ListBuffer[Int]()

  // Add elements
  lb += 10          // add single element
  lb += 20
  lb += 30
  println(s"ListBuffer contents = $lb")

  // Add multiple at once
  lb ++= List(40, 50)

  println(s"ListBuffer contents = $lb")

  // Remove an element by value
  lb -= 20
  println(s"After removing 20    = $lb")

  val lb1= lb.map(x=>x*2)
  println(s"After map     = $lb1")


/********************************
 * 13) Building a ListBuffer using a loop
 ********************************/
@main def listBuffer_build_with_loop(): Unit =
  val lb = ListBuffer[Int]()

  // Append numbers 1 to 5 in a loop
  for i <- 1 to 5 do
    lb += i

  println(s"ListBuffer = $lb")

  // Convert to immutable List
  val finalList: List[Int] = lb.toList
  println(s"Converted to List = $finalList")



/********************************
 * 14) Converting between List and ListBuffer
 ********************************/
@main def list_listBuffer_convert(): Unit =
  // List to ListBuffer
  val list = List(1, 2, 3)
  val lb   = ListBuffer.from(list)
  lb += 4
  println(s"Original List      = $list")
  println(s"After in ListBuffer= $lb")

  // ListBuffer to List
  val list2 = lb.toList
  println(s"Converted back List= $list2")



/********************************
 * 15) Practical Examples using List
 ********************************/

// Example 1: Find all even numbers from a list
@main def list_practical_evens(): Unit =
  val nums = List(11, 12, 13, 14, 15, 16)
  val evens = nums.filter(_ % 2 == 0)
  println(s"Evens = $evens")

// Example 2: Create list of squares from 1 to 10
@main def list_practical_squares(): Unit =
  val nums = (1 to 10).toList
  val squares = nums.map(n => n * n)
  println(s"Numbers = $nums")
  println(s"Squares = $squares")

// Example 3: Count how many names have length > 4
@main def list_practical_name_length(): Unit =
  val names = List("Ram", "Shyam", "Ashok", "Anita", "Ravi")
  val longNames = names.filter(n => n.length > 4)
  println(s"Names with length > 4 = $longNames")
  println(s"Count = ${longNames.length}")



// =====================================================================
// 16) Exercises (Printed for students)
// =====================================================================
@main def list_exercises(): Unit =
  println("LIST EXERCISES:")
  println("1) Create a List[Int] with 10 numbers and print only odd numbers.")
  println("2) From List(\"apple\",\"mango\",\"banana\"), print only fruits containing 'a'.")
  println("3) Find smallest and largest number from a List[Int].")
  println("4) Create a List[String] of 5 names, convert all to upper case.")
  println("5) Using ListBuffer, build a list of numbers entered by the user (for now, hardcode values).")
  println("6) Given List(1,2,3,4,5), create new List with each value multiplied by 10.")
  println("7) Convert a List to ListBuffer, add 2 more elements, and convert back to List.")
