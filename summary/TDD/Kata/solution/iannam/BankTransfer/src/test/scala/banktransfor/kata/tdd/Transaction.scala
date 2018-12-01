package banktransfor.kata.tdd

class Transaction(tranType: String, accountId: String, amount: Int) {
  override def toString = {
    s"[$tranType] $accountId $amount"
  }
}
