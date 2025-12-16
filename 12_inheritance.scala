// =====================================================================
// Filename: 13_inheritance_scala2.scala
// Topic: Scala 2 - Inheritance & Polymorphism 
// =====================================================================
//
// This module explains:
//
//  1) Basic inheritance (extends)
//  2) Method overriding (override keyword)
//  3) super to call parent method
//  4) Constructor parameters with inheritance
//  5) Polymorphism (parent reference → child object)
//  6) protected vs private
//  7) Simple real-life examples (Animals, Shape, Employee)
//
// Each demo is in a separate object with its own main().
// Run any object directly in Scala 2.
// =====================================================================


// =====================================================================
// 1) Basic inheritance: Animal -> Dog
// =====================================================================

class Animal(val name: String) {
  def speak(): Unit = {
    println(name + " makes some sound.")
  }
}

class Dog(name: String) extends Animal(name) {
  override def speak(): Unit = {
    println(name + " says: Woof!")
  }
}

object InheritanceBasicDemo {
  def main(args: Array[String]): Unit = {
    val a = new Animal("SomeAnimal")
    val d = new Dog("Bruno")

    a.speak()
    d.speak() // Dog's overridden version
  }
}


// =====================================================================
// 2) Multiple child classes: Dog, Cat
// =====================================================================

class Cat(name: String) extends Animal(name) {
  override def speak(): Unit = {
    println(name + " says: Meow!")
  }
}

object InheritanceMultipleChildrenDemo {
  def main(args: Array[String]): Unit = {
    val d = new Dog("Tommy")
    val c = new Cat("Kitty")

    d.speak()
    c.speak()
  }
}


// =====================================================================
// 3) Using super to call parent class method
// =====================================================================

class SmartDog(name: String) extends Dog(name) {
  override def speak(): Unit = {
    super.speak() // call Dog.speak() (which already overrides Animal)
    println(name + " also wags tail happily.")
  }
}

object InheritanceSuperDemo {
  def main(args: Array[String]): Unit = {
    val sd = new SmartDog("Rocky")
    sd.speak()
  }
}


// =====================================================================
// 4) Constructor parameters with inheritance
//    Base: PersonBase(name)
//    Child: Employee(name, salary)
// =====================================================================

class PersonBase(val name: String) {
  def whoAmI(): Unit = {
    println("I am a person, name = " + name)
  }
}

class Employee(name: String, val salary: Double)
  extends PersonBase(name) {

  def printDetails(): Unit = {
    println("Employee name = " + name + ", salary = " + salary)
  }

  override def whoAmI(): Unit = {
    println("I am an employee, name = " + name)
  }
}

object InheritanceConstructorDemo {
  def main(args: Array[String]): Unit = {
    val e = new Employee("Ashok", 60000)
    e.whoAmI()
    e.printDetails()
  }
}


// =====================================================================
// 5) Polymorphism: Parent reference → Child objects
//    Very important concept for OOP interviews.
// =====================================================================

object PolymorphismBasicDemo {
  def main(args: Array[String]): Unit = {

    // Animal reference can point to Animal, Dog, Cat
    val a1: Animal = new Animal("GenericAnimal")
    val a2: Animal = new Dog("Bruno")
    val a3: Animal = new Cat("Kitty")

    // Same method call, different behaviour (runtime binding)
    a1.speak() // Animal version
    a2.speak() // Dog version
    a3.speak() // Cat version

    // List of Animal, but each is different child
    val animals: List[Animal] = List(a1, a2, a3)
    println("Loop on list of Animal (polymorphism in action):")
    for (a <- animals) {
      a.speak()
    }
  }
}


// =====================================================================
// 6) Shape example: base Shape -> Rectangle, Circle
//    Demonstrates overriding with different formulas.
// =====================================================================

class Shape {
  def area(): Double = {
    0.0
  }

  def name(): String = {
    "Shape"
  }

  def printArea(): Unit = {
    println("Area of " + name() + " = " + area())
  }
}

class RectangleShape(val width: Double, val height: Double)
  extends Shape {

  override def area(): Double = {
    width * height
  }

  override def name(): String = {
    "Rectangle"
  }
}

class CircleShape(val radius: Double) extends Shape {

  override def area(): Double = {
    3.14159 * radius * radius
  }

  override def name(): String = {
    "Circle"
  }
}

object ShapePolymorphismDemo {
  def main(args: Array[String]): Unit = {
    val s1: Shape = new RectangleShape(5.0, 4.0)
    val s2: Shape = new CircleShape(3.0)

    s1.printArea()
    s2.printArea()

    val shapes: List[Shape] = List(s1, s2, new Shape)
    println("Loop on list of Shape objects:")
    for (s <- shapes) {
      s.printArea()
    }
  }
}


// =====================================================================
// 7) protected vs private in inheritance
// =====================================================================

class BaseCounter {

  private var secretCount: Int = 0       // not visible in child
  protected var visibleToChild: Int = 0  // visible in child

  def incrementSecret(): Unit = {
    secretCount = secretCount + 1
    println("secretCount = " + secretCount)
  }

  def showProtected(): Unit = {
    println("visibleToChild = " + visibleToChild)
  }
}

class ChildCounter extends BaseCounter {

  def increaseProtectedBy(n: Int): Unit = {
    // secretCount = secretCount + 1  // NOT allowed, private
    visibleToChild = visibleToChild + n // allowed, protected
  }
}

object ProtectedPrivateDemo {
  def main(args: Array[String]): Unit = {
    val c = new ChildCounter
    c.increaseProtectedBy(5)
    c.showProtected()

    // c.visibleToChild = 10  // NOT allowed, protected (only class and subclass)
  }
}


// =====================================================================
// 8) toString overriding (very common in debugging / logs)
// =====================================================================

class EmployeeSimple(val id: Int, val name: String, val salary: Double) {
  override def toString: String = {
    "EmployeeSimple(id=" + id + ", name=" + name + ", salary=" + salary + ")"
  }
}

object ToStringOverrideDemo {
  def main(args: Array[String]): Unit = {
    val e = new EmployeeSimple(1, "Ashok", 70000)
    println(e)                // automatically calls toString()
    println(e.toString)       // same as above
  }
}


// =====================================================================
// 9) Simple real-life hierarchy: Vehicle -> Car / Bike
// =====================================================================

class Vehicle(val brand: String) {
  def start(): Unit = {
    println(brand + " vehicle starting...")
  }
}

class Car(brand: String, val model: String) extends Vehicle(brand) {
  override def start(): Unit = {
    println("Car " + brand + " " + model + " starting with key.")
  }
}

class Bike(brand: String) extends Vehicle(brand) {
  override def start(): Unit = {
    println("Bike " + brand + " starting with self / kick.")
  }
}

object VehicleHierarchyDemo {
  def main(args: Array[String]): Unit = {
    val v1: Vehicle = new Car("Maruti", "Swift")
    val v2: Vehicle = new Bike("Honda")

    v1.start()
    v2.start()

    val vehicles: List[Vehicle] = List(v1, v2, new Vehicle("Generic"))
    println("Loop over vehicles:")
    for (v <- vehicles) {
      v.start()
    }
  }
}


// =====================================================================
// 10) Inheritance Exercises (printed for students)
// =====================================================================

object InheritanceExercisesDemo {
  def main(args: Array[String]): Unit = {
    println("INHERITANCE EXERCISES:")
    println("1) Create a base class Employee(name, salary) and subclass Manager(name, salary, bonus).")
    println("   Override a method showDetails() in Manager to also print bonus.")
    println("2) Create a class Shape with method area(). Inherit Circle and Rectangle, override area().")
    println("3) Create base class Account with method calculateYearlyInterest(). Inherit SavingAccount and CurrentAccount.")
    println("4) Create a class Animal with method speak(). Inherit Dog, Cat, Cow and override speak(). Use polymorphism in a List.")
    println("5) Create class Vehicle with method start(). Inherit Car and Bike and override start().")
    println("6) Practice: add protected fields and show how child can modify but main() cannot.")
  }
}
