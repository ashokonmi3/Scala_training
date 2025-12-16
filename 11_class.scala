// =====================================================================
// Filename: 12_class_details_scala2.scala
// Topic: Scala 2 - class & object 
// =====================================================================
//
// This module explains Scala classes step-by-step:
//
//  1) Basic class & object
//  2) Fields: val vs var
//  3) Methods: no args, with args, with return value
//  4) Primary constructor
//  5) Constructor body code
//  6) Auxiliary constructor (def this)
//  7) this keyword
//  8) Method overloading
//  9) Encapsulation with private fields
// 10) Real-life examples (Student, BankAccount, Order)
// 11) Exercises
//
// Each demo is in a separate object with its own main().
// Run any object directly in Scala 2.
// =====================================================================


// =====================================================================
// 1) Basic class & object
// =====================================================================

class HelloClass {
  // method inside class
  def sayHello(): Unit = {
    println("Hello from HelloClass!")
  }
}

object ClassBasicDemo {
  def main(args: Array[String]): Unit = {
    val obj = new HelloClass
    obj.sayHello()
  }
}


// =====================================================================
// 2) Class with fields (val / var)
//    val -> read-only, var -> read-write
// =====================================================================

class Person(val name: String, var age: Int) {

  def printInfo(): Unit = {
    println("Person(name=" + name + ", age=" + age + ")")
  }
}

object ClassValVarDemo {
  def main(args: Array[String]): Unit = {
    val p = new Person("Ashok", 40)
    p.printInfo()

    // p.name = "New Name"  // NOT allowed (val)
    p.age = 41              // allowed (var)
    p.printInfo()
  }
}


// =====================================================================
// 3) Class with methods (no args, with args, with return value)
// =====================================================================

class Calculator {

  // no parameters, no return
  def showTitle(): Unit = {
    println("Simple Calculator")
  }

  // parameters, no return
  def printSum(a: Int, b: Int): Unit = {
    println("Sum of " + a + " and " + b + " = " + (a + b))
  }

  // parameters, with return value
  def multiply(a: Int, b: Int): Int = {
    a * b
  }
}

object ClassMethodsDemo {
  def main(args: Array[String]): Unit = {
    val calc = new Calculator
    calc.showTitle()
    calc.printSum(10, 20)
    val product = calc.multiply(5, 4)
    println("Product = " + product)
  }
}


// =====================================================================
// 4) Primary constructor
//    Defined in the class header
// =====================================================================

class Book(val title: String, val price: Double) {

  def printDetails(): Unit = {
    println("Book(title=" + title + ", price=" + price + ")")
  }
}

object ClassPrimaryConstructorDemo {
  def main(args: Array[String]): Unit = {
    val b1 = new Book("Scala Basics", 499.0)
    val b2 = new Book("Python Basics", 399.0)
    b1.printDetails()
    b2.printDetails()
  }
}


// =====================================================================
// 5) Primary constructor with body code
//    Code in class body executes when object is created
// =====================================================================

class PersonWithWelcome(val name: String) {

  // executes when new PersonWithWelcome(...) is called
  println("Creating PersonWithWelcome for " + name)

  def sayHi(): Unit = {
    println("Hi, I am " + name)
  }
}

object ClassConstructorBodyDemo {
  def main(args: Array[String]): Unit = {
    val p1 = new PersonWithWelcome("Ashok")
    p1.sayHi()
    val p2 = new PersonWithWelcome("Meena")
    p2.sayHi()
  }
}


// =====================================================================
// 6) Auxiliary constructor (def this)
//    Multiple ways to create object
// =====================================================================

class Product(val id: Int, val name: String, val price: Double) {

  // auxiliary constructor: id + name, default price = 0.0
  def this(id: Int, name: String) = {
    this(id, name, 0.0)
  }

  def printDetails(): Unit = {
    println("Product(id=" + id + ", name=" + name + ", price=" + price + ")")
  }
}

object ClassAuxConstructorDemo {
  def main(args: Array[String]): Unit = {
    val p1 = new Product(1, "Laptop", 75000.0) // primary
    val p2 = new Product(2, "Mouse")          // auxiliary

    p1.printDetails()
    p2.printDetails()
  }
}


// =====================================================================
// 7) this keyword
//    this refers to current object
// =====================================================================

class CounterClass(private var value: Int) {

  def inc(): Unit = {
    this.value = this.value + 1
  }

  def add(n: Int): Unit = {
    this.value = this.value + n
  }

  def printValue(): Unit = {
    println("Counter value = " + this.value)
  }
}

object ClassThisKeywordDemo {
  def main(args: Array[String]): Unit = {
    val c = new CounterClass(10)
    c.printValue()
    c.inc()
    c.printValue()
    c.add(5)
    c.printValue()
  }
}


// =====================================================================
// 8) Method overloading
//    Same method name, different parameter types
// =====================================================================

class Printer {

  def printValue(v: Int): Unit = {
    println("Int value    = " + v)
  }

  def printValue(v: String): Unit = {
    println("String value = " + v)
  }

  def printValue(v: Double): Unit = {
    println("Double value = " + v)
  }
}

object ClassMethodOverloadingDemo {
  def main(args: Array[String]): Unit = {
    val pr = new Printer
    pr.printValue(10)
    pr.printValue("Hello")
    pr.printValue(3.14)
  }
}


// =====================================================================
// 9) Encapsulation with private fields + getters/setters
// =====================================================================

class BankAccount(private var balance: Double) {

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance = balance + amount
      println("Deposited " + amount + ", new balance = " + balance)
    } else {
      println("Deposit amount must be positive")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount <= 0) {
      println("Withdraw amount must be positive")
    } else if (amount > balance) {
      println("Insufficient funds")
    } else {
      balance = balance - amount
      println("Withdrew " + amount + ", new balance = " + balance)
    }
  }

  def getBalance(): Double = {
    balance
  }
}

object ClassEncapsulationDemo {
  def main(args: Array[String]): Unit = {
    val acc = new BankAccount(1000)
    println("Initial balance = " + acc.getBalance())
    acc.deposit(500)
    acc.withdraw(200)
    acc.withdraw(2000)
    println("Final balance   = " + acc.getBalance())
  }
}


// =====================================================================
// 10) Real-life example: Student with marks list
// =====================================================================

class StudentDetails(val name: String, val marks: List[Int]) {

  def total(): Int = {
    marks.sum
  }

  def average(): Double = {
    if (marks.isEmpty) 0.0
    else marks.sum.toDouble / marks.length
  }

  def printReport(): Unit = {
    println("Student: " + name +
      ", Marks: " + marks +
      ", Total: " + total() +
      ", Avg: " + average())
  }
}

object ClassStudentDemo {
  def main(args: Array[String]): Unit = {
    val s1 = new StudentDetails("Ashok", List(80, 90, 85))
    val s2 = new StudentDetails("Meena", List(70, 60, 75, 80))
    s1.printReport()
    s2.printReport()
  }
}


// =====================================================================
// 11) Real-life example: Item + Order (simple invoice)
// =====================================================================

class Item(val name: String, val quantity: Int, val unitPrice: Double) {

  def lineTotal(): Double = {
    quantity * unitPrice
  }

  def printItem(): Unit = {
    println(name + " x " + quantity + " @ " + unitPrice + " = " + lineTotal())
  }
}

class Order(val id: Int, val items: List[Item]) {

  def totalAmount(): Double = {
    items.map(_.lineTotal()).sum
  }

  def printInvoice(): Unit = {
    println("Invoice for Order #" + id)
    items.foreach(_.printItem())
    println("Total Amount = " + totalAmount())
  }
}

object ClassOrderDemo {
  def main(args: Array[String]): Unit = {
    val i1 = new Item("Pen", 2, 10.0)
    val i2 = new Item("Notebook", 3, 50.0)
    val i3 = new Item("Pencil", 5, 5.0)

    val order = new Order(101, List(i1, i2, i3))
    order.printInvoice()
  }
}


// =====================================================================
// 12) Class with default parameter values
// =====================================================================

class Course(val name: String,
             val durationDays: Int = 5,
             val mode: String = "Online") {

  def printDetails(): Unit = {
    println("Course: " + name +
      ", Duration: " + durationDays + " days" +
      ", Mode: " + mode)
  }
}

object ClassDefaultParamsDemo {
  def main(args: Array[String]): Unit = {
    val c1 = new Course("Scala Basics")
    val c2 = new Course("Advanced Scala", 10)
    val c3 = new Course("Django Web", 7, "Offline")
    c1.printDetails()
    c2.printDetails()
    c3.printDetails()
  }
}


// =====================================================================
// 13) Exercises (for students)
// =====================================================================

object ClassExercisesDemo {
  def main(args: Array[String]): Unit = {
    println("CLASS EXERCISES:")
    println("1) Create a class Car with fields (brand, model, year, price) and a method showDetails().")
    println("2) Create a class Rectangle with width & height and methods area() and perimeter().")
    println("3) Create a class Employee with fields (id, name, salary) and method raiseSalary(percent).")
    println("4) Create a ShoppingCart class that holds a List of Item, and method totalAmount().")
    println("5) Create a class Temperature with field celsius and a method toFahrenheit().")
    println("6) Create a class Student with name and a List[Int] of marks, and method bestScore().")
  }
}
