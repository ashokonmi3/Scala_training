// =====================================================================
// Filename: 14_abstract_class_scala2.scala
// Topic: Scala 2 - Abstract Class (Beginner Friendly)
// =====================================================================
//
// ✔ What is an abstract class?
//    - A class that CANNOT be instantiated directly.
//    - May contain:
//        • abstract methods (no body)
//        • normal methods (with body)
//    - Child classes must extend it and implement (override) abstract methods.
//
// ✔ Why abstract class?
//    - To define a common template / base behaviour.
//    - To force child classes to implement specific methods.
//
// ✔ When to use abstract class?
//    - When you want to share code + force some methods to be implemented.
//    - When you need constructor parameters + some default implementation.
//
// This file covers:
//   1) Simple abstract class + child
//   2) Abstract + non-abstract methods mixed
//   3) Abstract class with constructor parameters
//   4) Polymorphism with abstract base
//   5) Real-life examples: Shape, Employee
//   6) Abstract vs normal class explanation
//   7) Exercises
//
// Each demo is in a separate object with main().
// =====================================================================


// =====================================================================
// 1) Simple abstract class + concrete subclass
// =====================================================================

abstract class AnimalAbstract {
  def speak(): Unit  // abstract method, no body
}

class DogAbstract extends AnimalAbstract {
  // must override speak()
  def speak(): Unit = {
    println("Dog says: Woof!")
  }
}

class CatAbstract extends AnimalAbstract {
  def speak(): Unit = {
    println("Cat says: Meow!")
  }
}

object AbstractSimpleDemo {
  def main(args: Array[String]): Unit = {
    // val a = new AnimalAbstract // NOT allowed, abstract class
    val d = new DogAbstract
    val c = new CatAbstract

    d.speak()
    c.speak()
  }
}


// =====================================================================
// 2) Abstract class with abstract + normal methods
// =====================================================================

abstract class AnimalWithInfo(val name: String) {

  // abstract method
  def speak(): Unit

  // normal (concrete) method
  def info(): Unit = {
    println("Animal name = " + name)
  }
}

class DogWithInfo(name: String) extends AnimalWithInfo(name) {
  def speak(): Unit = {
    println(name + " says: Woof!")
  }
}

class CatWithInfo(name: String) extends AnimalWithInfo(name) {
  def speak(): Unit = {
    println(name + " says: Meow!")
  }
}

object AbstractWithNormalMethodsDemo {
  def main(args: Array[String]): Unit = {
    val d = new DogWithInfo("Bruno")
    val c = new CatWithInfo("Kitty")

    d.info()
    d.speak()

    c.info()
    c.speak()
  }
}


// =====================================================================
// 3) Abstract class with constructor parameters
// =====================================================================

abstract class PersonAbstract(val name: String, val age: Int) {
  def work(): Unit    // abstract

  def printBasicInfo(): Unit = {
    println("Name: " + name + ", Age: " + age)
  }
}

class Teacher(name: String, age: Int, val subject: String)
  extends PersonAbstract(name, age) {

  def work(): Unit = {
    println("Teacher " + name + " is teaching " + subject)
  }
}

class Engineer(name: String, age: Int, val field: String)
  extends PersonAbstract(name, age) {

  def work(): Unit = {
    println("Engineer " + name + " is working in " + field)
  }
}

object AbstractConstructorDemo {
  def main(args: Array[String]): Unit = {
    val t = new Teacher("Ashok", 40, "Scala")
    val e = new Engineer("Meena", 35, "Backend")

    t.printBasicInfo()
    t.work()

    e.printBasicInfo()
    e.work()
  }
}


// =====================================================================
// 4) Abstract class + Polymorphism
// =====================================================================

abstract class ShapeAbstract {
  def area(): Double        // abstract
  def name(): String        // abstract

  def printArea(): Unit = { // concrete method
    println("Area of " + name() + " = " + area())
  }
}

class RectangleAbstract(val width: Double, val height: Double)
  extends ShapeAbstract {

  def area(): Double = {
    width * height
  }

  def name(): String = {
    "Rectangle"
  }
}

class CircleAbstract(val radius: Double)
  extends ShapeAbstract {

  def area(): Double = {
    3.14159 * radius * radius
  }

  def name(): String = {
    "Circle"
  }
}

object AbstractPolymorphismDemo {
  def main(args: Array[String]): Unit = {
    val s1: ShapeAbstract = new RectangleAbstract(5.0, 4.0)
    val s2: ShapeAbstract = new CircleAbstract(3.0)

    s1.printArea()
    s2.printArea()

    val shapes: List[ShapeAbstract] = List(s1, s2)
    println("Loop over abstract Shape list:")
    for (s <- shapes) {
      s.printArea()
    }
  }
}


// =====================================================================
// 5) Real-life example: Abstract Employee with common logic
// =====================================================================

abstract class EmployeeAbstract(val id: Int, val name: String, val baseSalary: Double) {

  // abstract method - each employee type defines own bonus
  def calculateBonus(): Double

  // concrete method - shared logic
  def totalSalary(): Double = {
    baseSalary + calculateBonus()
  }

  def printSalarySlip(): Unit = {
    println("ID: " + id +
      ", Name: " + name +
      ", Base: " + baseSalary +
      ", Bonus: " + calculateBonus() +
      ", Total: " + totalSalary())
  }
}

class DeveloperEmployee(id: Int, name: String, baseSalary: Double)
  extends EmployeeAbstract(id, name, baseSalary) {

  def calculateBonus(): Double = {
    baseSalary * 0.20  // 20% bonus
  }
}

class ManagerEmployee(id: Int, name: String, baseSalary: Double)
  extends EmployeeAbstract(id, name, baseSalary) {

  def calculateBonus(): Double = {
    baseSalary * 0.30  // 30% bonus
  }
}

object AbstractEmployeeDemo {
  def main(args: Array[String]): Unit = {
    val dev = new DeveloperEmployee(1, "Ashok", 80000)
    val mgr = new ManagerEmployee(2, "Meena", 100000)

    dev.printSalarySlip()
    mgr.printSalarySlip()

    println("Using polymorphism:")
    val employees: List[EmployeeAbstract] = List(dev, mgr)
    for (e <- employees) {
      e.printSalarySlip()
    }
  }
}


// =====================================================================
// 6) Abstract vs normal class – explanation demo
// =====================================================================

class NormalClassExample {
  def sayHello(): Unit = {
    println("Hello from NormalClassExample (can create object directly).")
  }
}

abstract class AbstractExampleBase {
  def doSomething(): Unit  // abstract, no body

  def common(): Unit = {
    println("Common code in abstract base class.")
  }
}

class AbstractExampleChild extends AbstractExampleBase {
  def doSomething(): Unit = {
    println("Child implemented doSomething().")
  }
}

object AbstractVsNormalDemo {
  def main(args: Array[String]): Unit = {
    val normal = new NormalClassExample
    normal.sayHello()

    // val base = new AbstractExampleBase   // NOT allowed (abstract)
    val child = new AbstractExampleChild
    child.common()
    child.doSomething()
  }
}


// =====================================================================
// 7) Abstract class for BankAccount type
// =====================================================================

abstract class BankAccountAbstract(val accountNumber: String, initialBalance: Double) {

  protected var balance: Double = initialBalance

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance = balance + amount
      println("Deposited " + amount + ", new balance = " + balance)
    } else {
      println("Deposit amount must be positive")
    }
  }

  def withdraw(amount: Double): Unit

  def printBalance(): Unit = {
    println("Account " + accountNumber + " balance = " + balance)
  }
}

class SavingsAccount(accountNumber: String, initialBalance: Double)
  extends BankAccountAbstract(accountNumber, initialBalance) {

  def withdraw(amount: Double): Unit = {
    if (amount <= 0) {
      println("Withdraw amount must be positive")
    } else if (amount > balance) {
      println("Insufficient funds (SavingsAccount)")
    } else {
      balance = balance - amount
      println("SavingsAccount: Withdrew " + amount +
        ", new balance = " + balance)
    }
  }
}

class CurrentAccount(accountNumber: String, initialBalance: Double)
  extends BankAccountAbstract(accountNumber, initialBalance) {

  private val overdraftLimit: Double = 5000.0

  def withdraw(amount: Double): Unit = {
    if (amount <= 0) {
      println("Withdraw amount must be positive")
    } else if (amount > balance + overdraftLimit) {
      println("Overdraft limit exceeded (CurrentAccount)")
    } else {
      balance = balance - amount
      println("CurrentAccount: Withdrew " + amount +
        ", new balance = " + balance)
    }
  }
}

object AbstractBankAccountDemo {
  def main(args: Array[String]): Unit = {
    val sa = new SavingsAccount("SA-101", 10000)
    sa.printBalance()
    sa.deposit(2000)
    sa.withdraw(5000)
    sa.printBalance()

    println("----------------------------")

    val ca = new CurrentAccount("CA-201", 5000)
    ca.printBalance()
    ca.withdraw(9000)
    ca.printBalance()
  }
}


// =====================================================================
// 8) Abstract class exercises (printed for students)
// =====================================================================

object AbstractExercisesDemo {
  def main(args: Array[String]): Unit = {
    println("ABSTRACT CLASS EXERCISES:")
    println("1) Create an abstract class Vehicle with abstract method move().")
    println("   Create subclasses Car and Bike that implement move() differently.")
    println("2) Create an abstract class Shape with methods area() and perimeter().")
    println("   Implement for Rectangle and Circle.")
    println("3) Create abstract class Employee with method calculateBonus().")
    println("   Implement for Developer and Manager with different bonus percentages.")
    println("4) Create abstract class Appliance with method powerConsumption(hours: Int).")
    println("   Implement for Fan and AC.")
    println("5) Create abstract class Report with method generate().")
    println("   Implement for PdfReport and ExcelReport.")
  }
}
