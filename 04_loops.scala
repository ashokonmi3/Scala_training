// ModuleLoopsSimple.scala
// PURE LOOP EXAMPLES — NO class, NO case class, NO functions.
// Beginner-friendly.
// inital counter 
//condition 
// body of the loop
// increment/decrement
// ---------------------------------------------
// 1) Basic for loop (1 to 5)
// ---------------------------------------------
@main def loop_basicRange(): Unit =
  for i <- 1 to 5 do
    println(s"i = $i")

// ---------------------------------------------
// 2) Exclusive range (until) last range is exclusive
// ---------------------------------------------
@main def loop_until(): Unit =
  for i <- 1 until 5 do
    println(s"i (until) = $i") // prints 1,2,3,4

// ---------------------------------------------
// 3) Step using 'by'
// ---------------------------------------------
@main def loop_byStep(): Unit =
  for i <- 0 to 10 by 2 do
    println(s"step = $i")


// ---------------------------------------------
// 4) Reverse loop
// ---------------------------------------------
@main def loop_reverse(): Unit =
  for i <- (5 to 1 by -1) do
    println(s"reverse = $i")

// ---------------------------------------------
// 5) Loop over List
// ---------------------------------------------
@main def loop_list(): Unit =
  val nums = List(10, 20, 30)
  for n <- nums do
    println(s"n = $n")

// ---------------------------------------------
// 6) Loop over Array
// ---------------------------------------------
@main def loop_array(): Unit =
  val arr = Array("A", "B", "C")
  for i <- 0 until arr.length do
    println(s"arr($i) = ${arr(i)}")

// ---------------------------------------------
// 7) Loop with index (zipWithIndex)
// ---------------------------------------------
@main def loop_index(): Unit =
  val items = List("apple", "banana", "orange")
  for (item, idx) <- items.zipWithIndex do
    println(s"index=$idx, item=$item")

// ---------------------------------------------
// 8) For with condition (filter / guard)
// ---------------------------------------------
@main def loop_filter(): Unit =
  for n <- 1 to 20 if n % 2 == 0 do
    println(s"Even = $n")

// ---------------------------------------------
// 9) Nested for loops
// ---------------------------------------------
@main def loop_nested(): Unit =
  for i <- 1 to 3 do
    for j <- 1 to 2 do
      println(s"i=$i, j=$j")

// ---------------------------------------------
// 10) For-Yield (return a new list) - to do later
// ---------------------------------------------
@main def loop_yield(): Unit =
  val squares = for i <- 1 to 5 yield i * i
  println(s"squares = $squares")

// ---------------------------------------------
// 11) Multiple generators - to do later
// ---------------------------------------------
@main def loop_generators(): Unit =
  val nums = List(1, 2)
  val letters = List("a", "b")

  val output =
    for
      n <- nums
      l <- letters
    yield s"$n-$l"

  println(output)

// ---------------------------------------------
// 12) Pattern matching in for (LIST ONLY) to do later
// ---------------------------------------------
@main def loop_deconstruct(): Unit =
  val pairs = List((1, "one"), (2, "two"))

  for (num, word) <- pairs do
    println(s"$num -> $word")

// ---------------------------------------------
// 13) Loop through Map
// ---------------------------------------------
@main def loop_map(): Unit =
  val ages = Map("Ashok" -> 40, "Priya" -> 30)

  for (name, age) <- ages do
    println(s"$name = $age")

// ---------------------------------------------
// 14) foreach loop
// ---------------------------------------------
@main def loop_foreach(): Unit =
  val nums = List(1, 2, 3, 4)
  nums.foreach(n => println(s"value = $n"))

// ---------------------------------------------
// 15) While loop
// ---------------------------------------------
@main def loop_while(): Unit =
  var i = 1
  while i <= 5 do
    println(s"i = $i")
    i += 1 // i = i+1

// ---------------------------------------------
// 16) Simulate do-while (Scala removed do-while)
// ---------------------------------------------
@main def loop_doWhile(): Unit =
  var n = 1
  var continue = true

  while continue do
    println(s"n = $n")
    n += 1
    continue = n <= 5

// ---------------------------------------------
// 17) Break out of loop- till here
// ---------------------------------------------
@main def loop_break(): Unit =
  import scala.util.control.Breaks.{break, breakable}

  val nums = List(2, 4, 6, 9, 10)

  breakable {
    for n <- nums do
      if n % 2 != 0 then
        println(s"Found odd → $n, breaking loop")
        break()
      println(s"$n is even")
  }

// ---------------------------------------------
// 18) Practical Example: Multiplication Table
// ---------------------------------------------
@main def loop_table(): Unit =
  for i <- 1 to 10 do
    println(s"5 x $i = ${5 * i}")

// ---------------------------------------------
// 19) Practical Example: Sum of 1..100
// ---------------------------------------------
@main def loop_sum(): Unit =
  var sum = 0
  for i <- 1 to 100 do
    sum += i  // sum= 0+1 =1 , sum= 1+2 =3,  i=3 sum = 3+3 = 6 , i = 4 sum = 6+4 = 10
    println(s"i = $i") //1

    println(s"Sum = $sum") //1

  println(s"Sum = $sum")

// ---------------------------------------------
// 20) Practical Example: Count vowels
// ---------------------------------------------
@main def loop_vowels(): Unit =
  val text = "Ashok Sharma"
  var count = 0

  for ch <- text.toLowerCase do
    if "aeiou".contains(ch) then count += 1

  println(s"Vowel count = $count")

// ---------------------------------------------
// 21) Exercises for Students
// ---------------------------------------------
@main def loop_exercises(): Unit =
  println("LOOP EXERCISES:")
  println("1) Print all odd numbers from 1 to 50.")
  println("2) Print multiplication table of any number.")
  println("3) Count digits in a string (use for loop).")
  println("4) Create a new list using for-yield: cubes of 1..10.")
  println("5) From List(1,2,3,4,5,6), print only numbers > 3.")
