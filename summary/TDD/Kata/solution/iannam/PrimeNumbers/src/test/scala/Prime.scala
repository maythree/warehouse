object Prime {
  def isPrimeNumber(num: Int) : Boolean = {
    val numbers = 2 to num - 1

    val dividedNumbers = numbers
      .map(x => (x, num % x))

    val childNumbers = dividedNumbers
      .filter(_._1 == 0)

    childNumbers.size == 0
  }
}
