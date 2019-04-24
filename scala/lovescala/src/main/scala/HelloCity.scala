class HelloCity(CityName: String) {
  def syaHelloToCity = println("Hello "+ CityName)
}

object HelloCity{
  def apply(CityName: String, country: String): HelloCity = {
    println(country)
    return new HelloCity(CityName)

  }

  def main(args: Array[String]): Unit = {
    var firstObj = HelloCity("Shenyang", "China")

    firstObj.syaHelloToCity

    val second = new HelloCity("Shang Hai")

    second.syaHelloToCity
  }
}