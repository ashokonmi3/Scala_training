// =====================================================================
// Filename: 11_map.scala
// Topic: Scala Map & Mutable Map (Beginner Friendly)
// =====================================================================
//
// ✔ What is a Map?
//    - A Map stores data as KEY → VALUE pairs.
//    - Example: "India" -> 91, "USA" -> 1
//    - Like a dictionary / hash map in other languages.
//
// ✔ Types of Map in Scala:
//    • Immutable Map (default)       -> values cannot be changed directly
//    • Mutable Map (scala.collection.mutable.Map) -> can update in place
//
// ✔ When to use Map?
//    • Storing lookup data: code → description, id → name, etc.
//    • Fast key-based access (much faster than searching in List).
//
// Each @main function can be run independently.
// =====================================================================



/********************************
 * 1) Creating Immutable Maps
 ********************************/
@main def map_create_basic(): Unit =
  // Key: String, Value: Int
  val countryCode = Map(
    "India" -> 91,
    "USA"   -> 1,
    "UK"    -> 44
  )

  println(s"Country codes = $countryCode")

  // Another example: subject -> marks
  val marks = Map(
    "Math"    -> 90,
    "Science" -> 85,
    "English" -> 92
  )
  println(s"Marks = $marks")



/********************************
 * 2) Accessing values by key
 ********************************/
@main def map_access(): Unit =
  val codes = Map("India" -> 91, "USA" -> 1, "UK" -> 44)

  // Direct access using key (throws error if key not found)
  println(s"Code for India = ${codes("India")}")
  // println(codes("Japan"))  // would crash (NoSuchElementException)

  // Safe access using getOrElse
  val japanCode = codes.getOrElse("Japan", -1)
  println(s"Code for Japan (default -1) = $japanCode")



/********************************
 * 3) Checking keys and values
 ********************************/
@main def map_key_value_checks(): Unit =
  val marks = Map("Math" -> 90, "Science" -> 85)

  println(s"Has 'Math'?       = ${marks.contains("Math")}")
  println(s"Has 'History'?    = ${marks.contains("History")}")
  println(s"Keys   = ${marks.keys}")
  println(s"Values= ${marks.values}")



/********************************
 * 4) Looping over a Map (key, value)
//    Very important for reporting & printing.
// ********************************/
@main def map_loop(): Unit =
  val marks = Map("Math" -> 90, "Science" -> 85, "English" -> 92)

  println("Loop using for:")
  for (subject, score) <- marks do
    println(s"$subject -> $score")

  println("Loop using foreach:")
  marks.foreach { case (subject, score) =>
    println(s"$subject = $score")
  }



/********************************
 * 5) Adding and removing entries (immutable Map)
//    Immutable = original Map is NOT changed, new Map is returned.
// ********************************/
@main def map_add_remove(): Unit =
  val base = Map("A" -> 1, "B" -> 2)

  val addOne   = base + ("C" -> 3)
  val addMany  = base ++ Map("D" -> 4, "E" -> 5)
  val removed  = base - "A"

  println(s"Base    = $base")
  println(s"Add C   = $addOne")
  println(s"Add D,E = $addMany")
  println(s"Remove A= $removed")



/********************************
 * 6) Updating values (immutable Map)
//    We actually create a NEW Map with updated value.
// ********************************/
@main def map_update_immutable(): Unit =
  val prices = Map("Pen" -> 10, "Pencil" -> 5)

  // change Pen's price to 12 (creates new map)
  val newPrices = prices + ("Pen" -> 12)

  println(s"Old prices = $prices")
  println(s"New prices = $newPrices")



/********************************
 * 7) Transforming Map with map / filter
 ********************************/
@main def map_transform(): Unit =
  val marks = Map("Math" -> 90, "Science" -> 75, "English" -> 60)

  // Increase all marks by 5
  val increased = marks.map { case (sub, m) => (sub, m + 5) }

  // Only subjects with marks >= 70
  val passed = marks.filter { case (_, m) => m >= 70 }

  println(s"Original marks = $marks")
  println(s"Increased      = $increased")
  println(s"Passed         = $passed")



/********************************
 * 8) Mutable Map — updatable in place
 ********************************/
import scala.collection.mutable.Map as MutableMap

@main def map_mutable_basic(): Unit =
  val m = MutableMap(
    "India" -> 91,
    "USA"   -> 1
  )

  println(s"Initial mutable map = $m")

  // Add entries
  m += ("UK" -> 44)
  m("Japan") = 81       // another way to add/update
  println(s"After adding UK & Japan = $m")

  // Update existing value
  m("India") = 100
  println(s"After updating India   = $m")

  // Remove entry
  m -= "USA"
  println(s"After removing USA     = $m")



/********************************
 * 9) Difference: Immutable Map vs Mutable Map
 ********************************/
@main def map_mutable_vs_immutable(): Unit =
  val im = Map("A" -> 1, "B" -> 2)
  val newIm = im + ("B" -> 20) // B updated in NEW map

  val mu = MutableMap("A" -> 1, "B" -> 2)
  mu("B") = 20                // modifies same map

  println(s"Immutable original = $im")
  println(s"Immutable new      = $newIm")
  println(s"Mutable updated    = $mu")



/********************************
 * 10) Converting between Map, List, Array
 ********************************/
@main def map_conversion(): Unit =
  val m = Map("A" -> 1, "B" -> 2, "C" -> 3)

  // Map to List of pairs
  val listPairs: List[(String, Int)] = m.toList
  println(s"Map -> List[(K,V)] = $listPairs")

  // Map to Array of pairs
  val arrPairs: Array[(String, Int)] = m.toArray
  println(s"Map -> Array[(K,V)] = ${arrPairs.mkString(", ")}")

  // List of pairs to Map
  val backToMap = listPairs.toMap
  println(s"List[(K,V)] -> Map = $backToMap")



/********************************
 * 11) Practical Example: Student marks report
 ********************************/
@main def map_practical_marks(): Unit =
  val marks = Map("Ashok" -> 85, "Ravi" -> 72, "Meena" -> 91)

  // Print results with pass/fail
  for (name, score) <- marks do
    val status = if score >= 75 then "PASS" else "FAIL"
    println(s"$name -> $score -> $status")



/********************************
 * 12) Practical Example: Counting word frequency using Map
 ********************************/
@main def map_practical_word_frequency(): Unit =
  val sentence = "scala is fun and scala is powerful and scala is simple"
  val words = sentence.split(" ")

  var freq = Map[String, Int]()

  for w <- words do
    freq = freq.updated(w, freq.getOrElse(w, 0) + 1)

  println("Word frequency:")
  for (word, count) <- freq do
    println(s"$word -> $count")



/********************************
 * 13) Practical Example: Price list and bill calculation
 ********************************/
@main def map_practical_bill(): Unit =
  val prices = Map(
    "Pen"    -> 10,
    "Pencil" -> 5,
    "Book"   -> 50
  )

  // Items bought: (itemName, quantity)
  val cart = List(
    ("Pen", 2),
    ("Book", 1),
    ("Pencil", 3)
  )

  var total = 0
  for (item, qty) <- cart do
    val price = prices.getOrElse(item, 0)
    val cost = price * qty
    println(s"$item x $qty = $cost")
    total += cost

  println(s"Total bill = $total")

/********************************
 * ⚡ Looping on a Map — FULL EXPLANATION
 ********************************/
//
// A Map contains KEY → VALUE pairs.
// So when looping, we receive *two variables*:
//     (key, value)
//
// Very commonly used in reporting, logging, file processing, billing, etc.
//
@main def map_loop_full(): Unit =
  val marks = Map(
    "Math"    -> 90,
    "Science" -> 85,
    "English" -> 92
  )

  println("Loop method 1: for (k, v) <- map")
  for (subject, score) <- marks do
    println(s"$subject -> $score")

  println("\nLoop method 2: for entry <- map (entry is a pair)")
  for entry <- marks do
    println(entry)                     // shows (key,value)
    println(s"Subject = ${entry._1}, Score = ${entry._2}")

  println("\nLoop method 3: foreach { case (k, v) => ... }")
  marks.foreach { case (subject, score) =>
    println(s"$subject = $score")
  }

  println("\nLoop method 4: loop only on keys or values")
  println("Keys:")
  for key <- marks.keys do println(key)

  println("Values:")
  for value <- marks.values do println(value)


/********************************
 * 14) Exercises (for students to implement in their own @main)
// ********************************/
@main def map_exercises(): Unit =
  println("MAP EXERCISES:")
  println("1) Create a Map[String, Int] of 5 students and their marks. Print students who scored >= 80.")
  println("2) Write a program that takes a Map[product -> price] and prints the highest priced product.")
  println("3) Using a Mutable Map, add, update, and remove some entries and print after each operation.")
  println("4) From a sentence, use Map to count vowels and consonants.")
  println("5) Create a country -> capital Map and allow lookup by country name (hardcode values for now).")
  println("6) Convert a List of pairs List((\"A\",1),(\"B\",2)) into a Map and print all keys and values.")



// =====================================================================
// Filename: 11_map.scala  (Scala 2 version)
// Topic: Scala Map & Mutable Map 
// =====================================================================
//
// ✔ What is a Map?
//    - A Map stores data as KEY → VALUE pairs.
//    - Example: "India" -> 91, "USA" -> 1
//    - Like a dictionary / hash map in other languages.
//
// ✔ Types of Map in Scala:
//    • Immutable Map (default)       -> values cannot be changed directly
//    • Mutable Map (scala.collection.mutable.Map) -> can update in place
//
// ✔ When to use Map?
//    • Storing lookup data: code → description, id → name, etc.
//    • Fast key-based access (much faster than searching in List).
//
// In Scala 2 we don't use @main or top-level defs.
// Each example is an object with its own main().
// =====================================================================

import scala.collection.mutable.{Map => MutableMap}
// val nums = List(11, 12, 13, 14, 15, 16)
// [11,12,13,14,15,11]         
    // 0   1 2   3  4
//  firstno secondno thirdno  forutrh nums['firstnum]
// =====================================================================
// 1) Creating Immutable Maps
// =====================================================================
object MapCreateBasicDemo {

  def main(args: Array[String]): Unit = {
    // Key: String, Value: Int
    val countryCode = Map(
      "India" -> 91,
      "USA"   -> 1,
      "UK"    -> 44
    )

    println(s"Country codes = $countryCode")

    // Another example: subject -> marks
    val marks = Map(
      "Math"    -> 90,
      "Science" -> 85,
      "English" -> 92
    )
    println(s"Marks = $marks")
  }
}

// =====================================================================
// 2) Accessing values by key
// =====================================================================
object MapAccessDemo {

  def main(args: Array[String]): Unit = {
    val codes = Map("India" -> 91, "USA" -> 1, "UK" -> 44)

    // Direct access using key (throws error if key not found)
    println(s"Code for India = ${codes("India")}")
    // println(codes("Japan"))  // would crash (NoSuchElementException)

    // Safe access using getOrElse
    val japanCode = codes.getOrElse("Japan", -1)
    println(s"Code for Japan (default -1) = $japanCode")
  }
}

// =====================================================================
// 3) Checking keys and values
// =====================================================================
object MapKeyValueChecksDemo {

  def main(args: Array[String]): Unit = {
    val marks = Map("Math" -> 90, "Science" -> 85)

    println(s"Has 'Math'?       = ${marks.contains("Math")}")
    println(s"Has 'History'?    = ${marks.contains("History")}")
    println(s"Keys   = ${marks.keys}")
    println(s"Values= ${marks.values}")
  }
}

// =====================================================================
// 4) Looping over a Map (key, value)
// =====================================================================
object MapLoopDemo {

  def main(args: Array[String]): Unit = {
    val marks = Map("Math" -> 90, "Science" -> 85, "English" -> 92)

    println("Loop using for:")
    for ((subject, score) <- marks) {
      println(s"$subject -> $score")
    }

    println("Loop using foreach:")
    marks.foreach {
      case (subject, score) =>
        println(s"$subject = $score")
    }
  }
}

// =====================================================================
// 5) Adding and removing entries (immutable Map)
// =====================================================================
object MapAddRemoveDemo {

  def main(args: Array[String]): Unit = {
    val base = Map("A" -> 1, "B" -> 2)

    val addOne  = base + ("C" -> 3)
    val addMany = base ++ Map("D" -> 4, "E" -> 5)
    val removed = base - "A"

    println(s"Base    = $base")
    println(s"Add C   = $addOne")
    println(s"Add D,E = $addMany")
    println(s"Remove A= $removed")
  }
}

// =====================================================================
// 6) Updating values (immutable Map)
// =====================================================================
object MapUpdateImmutableDemo {

  def main(args: Array[String]): Unit = {
    val prices = Map("Pen" -> 10, "Pencil" -> 5)

    // change Pen's price to 12 (creates new map)
    val newPrices = prices + ("Pen" -> 12)

    println(s"Old prices = $prices")
    println(s"New prices = $newPrices")
  }
}

// =====================================================================
// 7) Transforming Map with map / filter
// =====================================================================
object MapTransformDemo {

  def main(args: Array[String]): Unit = {
    val marks = Map("Math" -> 90, "Science" -> 75, "English" -> 60)

    // Increase all marks by 5
    val increased = marks.map { case (sub, m) => (sub, m + 5) }

    // Only subjects with marks >= 70
    val passed = marks.filter { case (_, m) => m >= 70 }

    println(s"Original marks = $marks")
    println(s"Increased      = $increased")
    println(s"Passed         = $passed")
  }
}

// =====================================================================
// 8) Mutable Map — updatable in place
// =====================================================================
object MapMutableBasicDemo {

  def main(args: Array[String]): Unit = {
    val m = MutableMap(
      "India" -> 91,
      "USA"   -> 1
    )

    println(s"Initial mutable map = $m")

    // Add entries
    m += ("UK" -> 44)
    m("Japan") = 81       // another way to add/update
    println(s"After adding UK & Japan = $m")

    // Update existing value
    m("India") = 100
    println(s"After updating India   = $m")

    // Remove entry
    m -= "USA"
    println(s"After removing USA     = $m")
  }
}

// =====================================================================
// 9) Difference: Immutable Map vs Mutable Map
// =====================================================================
object MapMutableVsImmutableDemo {

  def main(args: Array[String]): Unit = {
    val im = Map("A" -> 1, "B" -> 2)
    val newIm = im + ("B" -> 20) // B updated in NEW map

    val mu = MutableMap("A" -> 1, "B" -> 2)
    mu("B") = 20                // modifies same map

    println(s"Immutable original = $im")
    println(s"Immutable new      = $newIm")
    println(s"Mutable updated    = $mu")
  }
}

// =====================================================================
// 10) Converting between Map, List, Array
// =====================================================================
object MapConversionDemo {

  def main(args: Array[String]): Unit = {
    val m = Map("A" -> 1, "B" -> 2, "C" -> 3)

    // Map to List of pairs
    val listPairs: List[(String, Int)] = m.toList
    println(s"Map -> List[(K,V)] = $listPairs")

    // Map to Array of pairs
    val arrPairs: Array[(String, Int)] = m.toArray
    println(s"Map -> Array[(K,V)] = ${arrPairs.mkString(", ")}")

    // List of pairs to Map
    val backToMap = listPairs.toMap
    println(s"List[(K,V)] -> Map = $backToMap")
  }
}

// =====================================================================
// 11) Practical Example: Student marks report
// =====================================================================
object MapPracticalMarksDemo {

  def main(args: Array[String]): Unit = {
    val marks = Map("Ashok" -> 85, "Ravi" -> 72, "Meena" -> 91)

    // Print results with pass/fail
    for ((name, score) <- marks) {
      val status = if (score >= 75) "PASS" else "FAIL"
      println(s"$name -> $score -> $status")
    }
  }
}

// =====================================================================
// 12) Practical Example: Counting word frequency using Map
// =====================================================================
object MapPracticalWordFrequencyDemo {

  def main(args: Array[String]): Unit = {
    val sentence = "scala is fun and scala is powerful and scala is simple"
    val words = sentence.split(" ")

    var freq = Map[String, Int]()

    for (w <- words) {
      freq = freq.updated(w, freq.getOrElse(w, 0) + 1)
    }

    println("Word frequency:")
    for ((word, count) <- freq) {
      println(s"$word -> $count")
    }
  }
}

// =====================================================================
// 13) Practical Example: Price list and bill calculation
// =====================================================================
object MapPracticalBillDemo {

  def main(args: Array[String]): Unit = {
    val prices = Map(
      "Pen"    -> 10,
      "Pencil" -> 5,
      "Book"   -> 50
    )

    // Items bought: (itemName, quantity)
    val cart = List(
      ("Pen", 2),
      ("Book", 1),
      ("Pencil", 3)
    )

    var total = 0
    for ((item, qty) <- cart) {
      val price = prices.getOrElse(item, 0)
      val cost = price * qty
      println(s"$item x $qty = $cost")
      total += cost
    }

    println(s"Total bill = $total")
  }
}

// =====================================================================
// 14) Looping on a Map — FULL EXPLANATION
// =====================================================================
object MapLoopFullDemo {

  def main(args: Array[String]): Unit = {
    val marks = Map(
      "Math"    -> 90,
      "Science" -> 85,
      "English" -> 92
    )

    println("Loop method 1: for ((k, v) <- map)")
    for ((subject, score) <- marks) {
      println(s"$subject -> $score")
    }

    println("\nLoop method 2: for (entry <- map) (entry is a pair)")
    for (entry <- marks) {
      println(entry)                     // shows (key,value)
      println(s"Subject = ${entry._1}, Score = ${entry._2}")
    }

    println("\nLoop method 3: foreach { case (k, v) => ... }")
    marks.foreach {
      case (subject, score) =>
        println(s"$subject = $score")
    }

    println("\nLoop method 4: loop only on keys or values")
    println("Keys:")
    for (key <- marks.keys) println(key)

    println("Values:")
    for (value <- marks.values) println(value)
  }
}

// =====================================================================
// 15) Exercises (for students)
// =====================================================================
object MapExercisesDemo {

  def main(args: Array[String]): Unit = {
    println("MAP EXERCISES:")
    println("1) Create a Map[String, Int] of 5 students and their marks. Print students who scored >= 80.")
    println("2) Write a program that takes a Map[product -> price] and prints the highest priced product.")
    println("3) Using a Mutable Map, add, update, and remove some entries and print after each operation.")
    println("4) From a sentence, use Map to count vowels and consonants.")
    println("5) Create a country -> capital Map and allow lookup by country name (hardcode values for now).")
    println("6) Convert a List of pairs List((\"A\",1),(\"B\",2)) into a Map and print all keys and values.")
  }
}
