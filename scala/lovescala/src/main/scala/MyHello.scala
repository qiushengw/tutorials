class MyHello(name: String) {

  println("New instance with name: " + name)

  def sayHello = println("Hello" + name)

  def apply(name: String): MyHello = new MyHello(name)

}
