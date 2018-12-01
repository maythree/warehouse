package anagrams.kata.tdd

object AnagramGenerator {
  def generateAnagrams(s: String) = {
    val anagrams = List.empty[String]
    for (i <- 0 until s.length - 1){
      for (j <- i + 1 until s.length){
        anagrams.+:(swap(s, i, j))
      }
    }
    anagrams
  }

  def swap(s: String, x: Int, y: Int): Unit = {
    val cArray = s.toCharArray
    val tmp = cArray(x)
    cArray(x) = cArray(y)
    cArray(y) = tmp
    return new String(cArray)
  }
}
