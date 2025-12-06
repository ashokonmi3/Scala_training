// =====================================================================
// Filename: 06_strings.scala
// Topic: Scala Strings 
// =====================================================================
//
// ✔ What is a String?
//    A String is a sequence of characters written inside double quotes.
//    Examples: "Hello", "Ashok Sharma", "Scala Training"
//
// ✔ In Scala:
//    "A"  = String
//    'A'  = Char   (single character only)
//
// ✔ Why Strings are important?
//    ‣ Used in printing values, names, messages, input, text processing
//    ‣ Very important for automation, logs, UI testing, file processing
//
// ✔ This file contains:
//    ‣ Basic string operations
//    ‣ Loops on strings
//    ‣ Multiline strings
//    ‣ Interpolation (s, f, raw)
//    ‣ Practical interview-level examples
//
// =====================================================================


// ---------------------------------------------------------------------
// 1) Basic String Creation & Printing
// ---------------------------------------------------------------------
@main def str_basic(): Unit =
  val s1 = "Hello Scala"
  val s2 = "Welcome to Strings module"
  println(s1)
  println(s2)

  // Char uses single quotes
  val c: Char = 'A'
  println(s"Char value = $c")


// ---------------------------------------------------------------------
// 2) Escape Sequences — special characters inside strings
// ---------------------------------------------------------------------
@main def str_escape(): Unit =
  println("Line1\nLine2")       // new line
  println("A\tB")  
  println("A\\tB")               // tab space
               // tab space
  println("He said \"Scala\"")  // double quote inside string
  println("Path: C:\\files")    // backslash


// ---------------------------------------------------------------------
// 3) Multiline Strings — triple quotes """  """
// ---------------------------------------------------------------------
@main def str_multiline(): Unit =
  val t =
    """
    This is a multiline string.
    It prints exactly as written including newlines.
    """
  println(t)


// stripMargin → removes indentation nicely
@main def str_stripMargin(): Unit =
  val msg =
    """
      |Hello
      |Scala
      |Welcome!
      |""".stripMargin
  println(msg)


// ---------------------------------------------------------------------
// 4) Interpolation — insert variables into strings
// ---------------------------------------------------------------------
@main def str_interpolation(): Unit =
  val name = "Ashok"
  val marks = 92
  val pi = 3.14159

  println(s"My name is $name and marks = $marks")     // s-interpolator
  println(s"Next year marks = ${marks + 1}")          // expression inside {}
  println(f"Formatted PI = $pi%.2f")                  // fixed decimal places
  println(raw"Raw ignores escape: \n remains \n")     // raw ignores \n \t


// ---------------------------------------------------------------------
// 5) Common String Operations
// ---------------------------------------------------------------------
@main def str_operations(): Unit =
  val s = "ScalaProgramming"

  println(s"Length = ${s.length}")         // number of characters
  println(s"First char = ${s(0)}")         // character at index 0
  println(s"Substring = ${s.substring(0, 5)}") // from index 0 to 4
  println("Concatenation = " + s + " Language") // join strings
  println(s"Concatenation =  ${s} Language") // join strings


// ---------------------------------------------------------------------
// 6) Trimming spaces, Case conversion, Searching
// ---------------------------------------------------------------------
@main def str_clean_search(): Unit =
  val raw = "  Hello Scala  "
  println(raw.trim)               // remove edges spaces
  println(raw.trim.toUpperCase)   // HELLO SCALA
  println(raw.trim.toLowerCase)   // hello scala

  val file = "welcome.scala.example"
  println(file.contains("scala"))
  println(file.startsWith("welcome"))
  println(file.endsWith("example"))
  println(file.indexOf("."))       // first dot
  println(file.lastIndexOf("."))   // last dot


// ---------------------------------------------------------------------
// 7) Splitting & Joining Strings
// ---------------------------------------------------------------------
@main def str_split_join(): Unit =
  val csv = "apple,banana,mango"

  val arr = csv.split(",")
  
  // println(arr)   // join with separator
  println(arr.mkString(""))   // join with separator
  println(arr.mkString(" "))   // join with separator

  println(arr.mkString(" | "))   // join with separator
// till here 
  val sentence = "Scala is easy to learn"
  val words = sentence.split("\\s+") // split by spaces
  println(s"Word count = ${words.length}")


// ---------------------------------------------------------------------
// 8) Replace / replaceAll / replaceFirst
// ---------------------------------------------------------------------
@main def str_replace(): Unit =
  val s = "Call 12345"
  println(s.replace("12345", "XXXXX"))     // normal replace
  println(s.replaceAll("\\d", "*"))        // regex — replace digits
  println(s.replaceFirst("\\d+", "NUM"))   // replace first occurrence


// ---------------------------------------------------------------------
// 9) Loop on String (important for automation & parsing)
// ---------------------------------------------------------------------
@main def str_loop_reverse_palindrome(): Unit =
  val str = "Scala"
  for ch <- str do print(s"$ch ")     // loop characters
  println()
  println(s"Reverse = ${str.reverse}") // reverse full string

  val word = "madam"
  println(s"Is '$word' palindrome? ${word == word.reverse}")


// Extra Loop Examples
@main def str_loop_index(): Unit =
  val name = "Ashok"
  for i <- 0 until name.length do println(s"$i -> ${name(i)}")

@main def str_loop_case_count(): Unit =
  val text = "Hello SCaLa"
  var upper = 0; var lower = 0
  for ch <- text do
    if ch.isUpper then upper += 1
    if ch.isLower then lower += 1
  println(s"Uppercase = $upper, Lowercase = $lower")

@main def str_loop_words(): Unit =
  val sentence = "Scala is a powerful language"
  for w <- sentence.split(" ") do println(w)

@main def str_char_frequency(): Unit =
  val text = "scala programming"
  var freq = Map[Char, Int]()
  for ch <- text.replace(" ", "") do
    freq = freq.updated(ch, freq.getOrElse(ch, 0) + 1)
  for (k, v) <- freq do println(s"$k -> $v")


// ---------------------------------------------------------------------
// 10) Vowel Count (Practical Interview Question)
// ---------------------------------------------------------------------
@main def str_vowel_count(): Unit =
  val text = "Ashok Sharma"
  var count = 0
  for ch <- text.toLowerCase do
    if "aeiou".contains(ch) then count += 1
  println(s"Vowel count = $count")


// ---------------------------------------------------------------------
// 11) Safe Substring (prevents errors)
// ---------------------------------------------------------------------
@main def str_safe_substring(): Unit =
  val s = "Hello" //hello jello aello
  // s[0]= "h"
  val end = math.min(100, s.length)
  println(s.substring(0, end))


// ---------------------------------------------------------------------
// 12) String ↔ Number / Boolean conversions
// ---------------------------------------------------------------------
@main def str_conversion(): Unit =
  val n = "123".toInt
  val d = "12.5".toDouble
  println(n)
  println(d)
  // println(n, d, n.toString)
  println("true".toBoolean)


// ---------------------------------------------------------------------
// 13) Real Time Practical Examples
// ---------------------------------------------------------------------
@main def str_practical(): Unit =
  val full = "Ashok Sharma"
  val p = full.split(" ")
  println(s"Initials = ${p(0)(0)}.${p(1)(0)}.")

  val sentence = "Scala is super easy"
  println(sentence.split(" ").map(_.reverse).mkString(" "))

  println("Hello@#123".replaceAll("[^A-Za-z0-9 ]", ""))

// =====================================================================
// 14) StringBuilder and StringBuffer
// =====================================================================
//
// Why do we need StringBuilder / Buffer?
// --------------------------------------
// Normal String is IMMUTABLE.
// Meaning: every modification creates a NEW string in memory.
//
// When we need a lot of string changes (append, insert, delete),
// immutable string becomes slow.
//
// So Scala provides:
//  • StringBuilder  — FAST & MUTABLE   (recommended)
//  • StringBuffer   — MUTABLE & THREAD-SAFE (rarely needed for beginners)
// String         = Immutable (cannot change)
// StringBuilder  = Mutable (can change, fastest for append/insert)
// StringBuffer   = Mutable + thread-safe (slow but safe in multi-threading)
//
// Note: Both use the same methods (.append, .insert, .delete, .toString)
// =====================================================================


// -----------------------------------------------------------
// StringBuilder — best choice for frequent modifications
// -----------------------------------------------------------
@main def str_stringBuilder(): Unit =
  val sb = new StringBuilder("Hello")
  sb.append(" Scala")         // add text
  sb.append(" Training")      // add more
  sb.insert(0, "Welcome ")    // insert at index 0
  sb.delete(8, 14)            // delete index 8 to 13 (remove "Hello ")
  println(sb.toString)        // convert to String to print


// -----------------------------------------------------------
// StringBuffer — same as StringBuilder but thread-safe
// Slower; used only when many threads modify same text
// -----------------------------------------------------------
@main def str_stringBuffer(): Unit =
  val sb = new StringBuffer("Hello")
  sb.append(" Scala")
  sb.insert(0, "Welcome ")
  println(sb.toString)


// -----------------------------------------------------------
// PERFORMANCE DEMO — difference between String and StringBuilder
// -----------------------------------------------------------
@main def str_builder_vs_string(): Unit =
  var s = ""                      // normal string (slow if too many +)
  for i <- 1 to 5 do s = s + i    // creates new objects each loop
  println(s"Normal String result = $s")

  val sb = new StringBuilder("")
  for i <- 1 to 5 do sb.append(i)  // keeps modifying same object
  println(s"StringBuilder result = ${sb.toString()}")

  println("→ StringBuilder is better when we need many updates.")
