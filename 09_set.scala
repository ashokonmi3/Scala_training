// =====================================================================
// Filename: 10_set.scala
// Topic: Scala Set & Mutable Set (Beginner Friendly)
// =====================================================================
//
// ✔ What is a Set?
//    - A Set is a collection of UNIQUE values (no duplicates).
//    - Example: Set(1, 2, 2, 3) becomes Set(1, 2, 3)
//    - Order is NOT guaranteed (not indexed like List/Array)
//
// ✔ Types of Sets in Scala:
//    • Immutable Set (default)
//    • Mutable Set (scala.collection.mutable.Set)
//
// ✔ When to use Set?
//    • Remove duplicates
//    • Check whether value exists (very fast lookup)
//    • Mathematical operations — union, intersection, difference
//
// Each @main can be run separately.
// =====================================================================



/********************************
 * 1) Creating Sets (immutable)
 ********************************/
@main def set_create(): Unit =
  val nums = Set(1, 2, 2, 3, 4, 4)
  val names = Set("Ashok", "Meena", "Ravi")

  println(s"Nums  = $nums")   // duplicates removed
  println(s"Names = $names")

  val empty: Set[Int] = Set()
  println(s"Empty = $empty")



/********************************
 * 2) Adding & Removing (immutable)
//    Immutable = original Set NEVER changes, new Set created
 ********************************/
@main def set_add_remove(): Unit =
  val base = Set(10, 20, 30)

  val addOne = base + 40
  val addMany = base ++ Set(40, 50)
  val removeOne = base - 20

  println(s"Base set    = $base")
  println(s"Add 40      = $addOne")
  println(s"Add 40 & 50 = $addMany")
  println(s"Remove 20   = $removeOne")



/********************************
 * 3) Searching in Set (contains)
 ********************************/
@main def set_search(): Unit =
  val s = Set("apple", "banana", "mango")

  println(s"Contains 'banana'? = ${s.contains("banana")}")
  println(s"Contains 'grapes'? = ${s.contains("grapes")}")



/********************************
 * 4) Looping on Set
 ********************************/
@main def set_loop(): Unit =
  val s = Set("A", "B", "C", "D")

  println("Loop using for:")
  for x <- s do println(x)

  println("Loop using foreach:")
  s.foreach(x => println(x))



/********************************
 * 5) UNION, INTERSECTION, DIFFERENCE
 ********************************/
@main def set_math_operations(): Unit =
  val s1 = Set(1, 2, 3, 4)
  val s2 = Set(3, 4, 5, 6)

  val union = s1 ++ s2           // all unique elements
  val intersection = s1 & s2     // common elements
  val difference = s1 -- s2      // in s1 but not in s2

  println(s"Set1         = $s1")
  println(s"Set2         = $s2")
  println(s"Union        = $union")
  println(s"Intersection = $intersection")
  println(s"Difference   = $difference")



/********************************
 * 6) Sorting a Set (converted to List before sorting)
 ********************************/
@main def set_sort(): Unit =
  val s = Set(8, 2, 5, 1, 4)

  val sortedAsc = s.toList.sorted
  val sortedDesc = sortedAsc.reverse

  println(s"Original     = $s")
  println(s"Ascending    = $sortedAsc")
  println(s"Descending   = $sortedDesc")



/********************************
 * 7) Mutable Set — can change without creating new collections
 ********************************/
import scala.collection.mutable.Set as MutableSet

@main def set_mutable_basic(): Unit =
  val ms = MutableSet(1, 2, 3)

  ms.add(4)
  ms -= 2
  ms ++= Set(5, 6)

  println(s"Mutable set = $ms")



/********************************
 * 8) Mutable vs Immutable difference demo
 ********************************/
@main def set_mutable_vs_immutable(): Unit =
  val im = Set(1, 2, 3)                  // immutable
  val newIm = im + 4                     // im unchanged

  val mu = MutableSet(1, 2, 3)           // mutable
  mu += 4                                // same object changes

  println(s"Immutable original = $im")
  println(s"Immutable new      = $newIm")
  println(s"Mutable updated    = $mu")



/********************************
 * 9) Conversion between Set, List, Array
 ********************************/
@main def set_conversion(): Unit =
  val s = Set(10, 20, 30)

  // Set -> List
  val list = s.toList
  // Set -> Array
  val arr = s.toArray
  // List -> Set
  val set2 = list.toSet

  println(s"Set     = $s")
  println(s"List    = $list")
  println(s"Array   = ${arr.mkString(", ")}")
  println(s"Back to Set = $set2")



/********************************
 * 10) Practical examples using Set
 ********************************/

// Example 1: Remove duplicates from List
@main def set_practical_unique(): Unit =
  val fruits = List("apple", "apple", "mango", "grapes", "mango")
  val unique = fruits.toSet
  println(s"Unique fruits = $unique")

// Example 2: Common students in both batches (intersection)
@main def set_practical_common(): Unit =
  val batchA = Set("Ravi", "Ashok", "Meena", "Anita")
  val batchB = Set("Raj", "Meena", "Ravi", "Tom")
  println(s"Common = ${batchA & batchB}")

// Example 3: Students who passed only 1 subject
@main def set_practical_subject(): Unit =
  val subject1 = Set("Ashok", "Ravi", "Meena")
  val subject2 = Set("Ravi", "Tom", "Meena")
  println(s"Subject1 only = ${subject1 -- subject2}")



/********************************
 * 11) Exercises (printed for students)
//     Students should solve using new @main functions.
// ********************************/
@main def set_exercises(): Unit =
  println("SET EXERCISES:")
  println("1) Create a Set[Int] with 10 numbers and print only even numbers.")
  println("2) Take a List of words and print only unique words using Set.")
  println("3) From Set(1,2,3,4,5), create new Set containing only numbers > 3.")
  println("4) Find union, intersection, difference between two Sets of names.")
  println("5) Convert Set to List, sort, convert back to Set.")
  println("6) Using mutable Set, add numbers 1 to 10 in a loop and remove all odd numbers.")

// =====================================================================
// Quick Comparison: List vs Array vs Set
// =====================================================================
// List  → Immutable + ordered + allows duplicates
// Array → Mutable + ordered + allows duplicates + very fast indexing
// Set   → Immutable + no duplicates + fast contains(), order not guaranteed
//
// When to use?
//  • Use List for functional programming and string/data processing
//  • Use Array for performance-critical numeric/index loops
//  • Use Set when uniqueness and fast search are required
// =====================================================================

import scala.collection.mutable.{Set => MutableSet}

// =====================================================================
// 1) Creating Sets (immutable)
// =====================================================================
object SetCreateDemo {

  def main(args: Array[String]): Unit = {
    val nums = Set(1, 2, 2, 3, 4, 4)
    val names = Set("Ashok", "Meena", "Ravi")

    println(s"Nums  = $nums")   // duplicates removed
    println(s"Names = $names")

    val empty: Set[Int] = Set()
    println(s"Empty = $empty")
  }
}

// =====================================================================
// 2) Adding & Removing (immutable)
//    Immutable = original Set NEVER changes, new Set created
// =====================================================================
object SetAddRemoveDemo {

  def main(args: Array[String]): Unit = {
    val base = Set(10, 20, 30)

    val addOne    = base + 40
    val addMany   = base ++ Set(40, 50)
    val removeOne = base - 20

    println(s"Base set    = $base")
    println(s"Add 40      = $addOne")
    println(s"Add 40 & 50 = $addMany")
    println(s"Remove 20   = $removeOne")
  }
}

// =====================================================================
// 3) Searching in Set (contains)
// =====================================================================
object SetSearchDemo {

  def main(args: Array[String]): Unit = {
    val s = Set("apple", "banana", "mango")

    println(s"Contains 'banana'? = ${s.contains("banana")}")
    println(s"Contains 'grapes'? = ${s.contains("grapes")}")
  }
}

// =====================================================================
// 4) Looping on Set
// =====================================================================
object SetLoopDemo {

  def main(args: Array[String]): Unit = {
    val s = Set("A", "B", "C", "D")

    println("Loop using for:")
    for (x <- s) println(x)

    println("Loop using foreach:")
    s.foreach(x => println(x))
  }
}

// =====================================================================
// 5) UNION, INTERSECTION, DIFFERENCE
// =====================================================================
object SetMathOperationsDemo {

  def main(args: Array[String]): Unit = {
    val s1 = Set(1, 2, 3, 4)
    val s2 = Set(3, 4, 5, 6)

    val union        = s1 ++ s2           // all unique elements
    val intersection = s1 & s2            // common elements
    val difference   = s1 -- s2           // in s1 but not in s2

    println(s"Set1         = $s1")
    println(s"Set2         = $s2")
    println(s"Union        = $union")
    println(s"Intersection = $intersection")
    println(s"Difference   = $difference")
  }
}

// =====================================================================
// 6) Sorting a Set (converted to List before sorting)
// =====================================================================
object SetSortDemo {

  def main(args: Array[String]): Unit = {
    val s = Set(8, 2, 5, 1, 4)

    val sortedAsc  = s.toList.sorted
    val sortedDesc = sortedAsc.reverse

    println(s"Original     = $s")
    println(s"Ascending    = $sortedAsc")
    println(s"Descending   = $sortedDesc")
  }
}

// =====================================================================
// 7) Mutable Set — can change without creating new collections
// =====================================================================
object SetMutableBasicDemo {

  def main(args: Array[String]): Unit = {
    val ms = MutableSet(1, 2, 3)

    ms.add(4)
    ms -= 2
    ms ++= Set(5, 6)

    println(s"Mutable set = $ms")
  }
}

// =====================================================================
// 8) Mutable vs Immutable difference demo
// =====================================================================
object SetMutableVsImmutableDemo {

  def main(args: Array[String]): Unit = {
    val im    = Set(1, 2, 3)      // immutable
    val newIm = im + 4            // im unchanged

    val mu = MutableSet(1, 2, 3)  // mutable
    mu += 4                       // same object changes

    println(s"Immutable original = $im")
    println(s"Immutable new      = $newIm")
    println(s"Mutable updated    = $mu")
  }
}

// =====================================================================
// 9) Conversion between Set, List, Array
// =====================================================================
object SetConversionDemo {

  def main(args: Array[String]): Unit = {
    val s = Set(10, 20, 30)

    // Set -> List
    val list = s.toList
    // Set -> Array
    val arr  = s.toArray
    // List -> Set
    val set2 = list.toSet

    println(s"Set     = $s")
    println(s"List    = $list")
    println(s"Array   = ${arr.mkString(", ")}")
    println(s"Back to Set = $set2")
  }
}

// =====================================================================
// 10) Practical examples using Set
// =====================================================================

// Example 1: Remove duplicates from List
object SetPracticalUniqueDemo {

  def main(args: Array[String]): Unit = {
    val fruits = List("apple", "apple", "mango", "grapes", "mango")
    val unique = fruits.toSet
    println(s"Unique fruits = $unique")
  }
}

// Example 2: Common students in both batches (intersection)
object SetPracticalCommonDemo {

  def main(args: Array[String]): Unit = {
    val batchA = Set("Ravi", "Ashok", "Meena", "Anita")
    val batchB = Set("Raj", "Meena", "Ravi", "Tom")
    println(s"Common = ${batchA & batchB}")
  }
}

// Example 3: Students who passed only 1 subject
object SetPracticalSubjectDemo {

  def main(args: Array[String]): Unit = {
    val subject1 = Set("Ashok", "Ravi", "Meena")
    val subject2 = Set("Ravi", "Tom", "Meena")
    println(s"Subject1 only = ${subject1 -- subject2}")
  }
}


// =====================================================================
// Set with different types (mixed datatype example)
// =====================================================================
object SetMixedTypesDemo {

  def main(args: Array[String]): Unit = {
    // Set containing Int, String, Double, Boolean, Char
    val mixed = Set(1, "Ashok", 3.14, true, 'Z')

    println(s"Mixed Set = $mixed")   // order not guaranteed

    // Showing datatype of the Set
    println(s"Internal Type = ${mixed.getClass}")

    // Loop through each item and print with its datatype
    println("\nPrinting each element with detected type:")
    for (x <- mixed) {
      x match {
        case i: Int    => println(s"Integer    → $i")
        case s: String => println(s"String     → $s")
        case d: Double => println(s"Double     → $d")
        case b: Boolean => println(s"Boolean    → $b")
        case c: Char   => println(s"Char       → $c")
        case other     => println(s"Other Type → $other")
      }
    }
  }
}


// =====================================================================
// 11) Exercises (printed for students)
// =====================================================================
object SetExercisesDemo {

  def main(args: Array[String]): Unit = {
    println("SET EXERCISES:")
    println("1) Create a Set[Int] with 10 numbers and print only even numbers.")
    println("2) Take a List of words and print only unique words using Set.")
    println("3) From Set(1,2,3,4,5), create new Set containing only numbers > 3.")
    println("4) Find union, intersection, difference between two Sets of names.")
    println("5) Convert Set to List, sort, convert back to Set.")
    println("6) Using mutable Set, add numbers 1 to 10 in a loop and remove all odd numbers.")
  }
}

// =====================================================================
// Quick Comparison: List vs Array vs Set  (kept as comments for notes)
// =====================================================================
// List  → Immutable + ordered + allows duplicates
// Array → Mutable + ordered + allows duplicates + very fast indexing
// Set   → Immutable + no duplicates + fast contains(), order not guaranteed
//
// When to use?
//  • Use List for functional programming and string/data processing
//  • Use Array for performance-critical numeric/index loops
//  • Use Set when uniqueness and fast search are required
// =====================================================================

