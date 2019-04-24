import scala.collection.convert.Wrappers.MutableMapWrapper

object Hello extends App {
  val ages = Seq(42, 23,55,77)
  println(s"max age is ${ages.max}")

  var salary = Seq(200, 300, 400)
  var double = (x: Int) => x * 2
  val newSalaries = salary.map(double)
  println(newSalaries)

  var list = "abc" map (x=> (x + 1))
  println("abc:" + list)

  val x = new AnyRef{val hello = "Hello world"}

  println(x.hello)
  //x.hello = "1111111"

  println(x.hello)

  var y = 30
  println(y)
  y = 15
  print(y)

  val y2 = 40

  var ss = funQs("Wang Qiusheng")


  def funQs(name:String) = "Hello" + name

  println(ss)

   val x1 = {
    println("calcualtion value of x")
    13
  }

  val y1 = {
    println("calcualtion value of y")
    15
  }

  y1 + y1

  x1 + x1


  println("How to init a sequence of donut prices")
  val donutPrices: Seq[Double] = Seq(1.5, 2.0, 2.5)
  println(s"Elements of dounutPrice = $donutPrices")

  import math.{sin}


  println(sin(1))

  val aa = 75
  val bb = 20

  val z:Int = aa.+ (bb)

  println(z)

  val my_list = List(3 ,6, 15, 34, 76)

  println(s"myList = $my_list")

  println(5 +: my_list)
  println(my_list.+: (5))

  def sum(x: Int) (y: Int) = x + y

  def sum2(x: Int, y: Int) = x + y

  def sum3 = sum(2) _

  import collection.mutable.{Map => MutableMap}

  var box =  MutableMap(("1","Wang ziqing"));


  println(s"What inside: $box")

  import math._

  sin(50)

  cos(50)

  var myh = new MyHello("wang qiusheng")

  myh.sayHello




}
