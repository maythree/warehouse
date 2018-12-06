import org.scalatest._

class PrimeNumbersTDDSpec extends FlatSpec with Assertion {
  // 소수인지 아닌지를 판별하는 함수를 구현

  "1는" should "소수가 아니다" in {
    assert(false == Prime.isPrimeNumber(1))
  }

  "2는" should "소수가 맞다" in {
    assert(true == Prime.isPrimeNumber(2))
  }

  "3는" should "소수가 맞다" in {
    assert(true == Prime.isPrimeNumber(3))
  }

  "4는" should "소수가 아니다" in {
    assert(false == Prime.isPrimeNumber(4))
  }

  "5는" should "소수가 맞다" in {
    assert(true == Prime.isPrimeNumber(5))
  }

  "6는" should "소수가 아니다" in {
    assert(false == Prime.isPrimeNumber(6))
  }
}
