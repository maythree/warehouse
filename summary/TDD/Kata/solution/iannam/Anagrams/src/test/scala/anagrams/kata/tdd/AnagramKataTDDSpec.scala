package anagrams.kata.tdd

import org.scalatest._

class AnagramKataTDDSpec extends FlatSpec with Assertions {
  val possibleAnagrams = List(
    "biro", "bior", "brio", "broi", "boir", "bori",
    "ibro", "ibor", "irbo", "irob", "iobr", "iorb",
    "rbio", "rboi", "ribo", "riob", "roib", "robi",
    "obir", "obri", "oibr", "oirb", "orbi", "orib"
  )

  "anagram generator" should "contains all cases of given word" in {
    val potentialAngrams: List[String] = AnagramGenerator.generateAnagrams("biro")
    for(anagram <- potentialAngrams) {
      assert(possibleAnagrams.contains(anagram))
    }
  }
}
