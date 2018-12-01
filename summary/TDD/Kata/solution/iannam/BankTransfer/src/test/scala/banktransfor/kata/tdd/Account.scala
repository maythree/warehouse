package banktransfor.kata.tdd
import scala.collection.mutable.ListBuffer

class Account (accountId: String, amount: Int){
  var money: Int = amount
  var transactions = new ListBuffer[Transaction]()

  def setAmount(amount: Int): Unit = this.money = amount

  def getAmount(): Int = money

  def getAccountId(): String = accountId

  def withdrawal(accountId: String, amount: Int): Unit = {
    if(getAmount() >= amount) {
      setAmount(money - amount)
      recordTransaction("Withdrawal", accountId, amount)
    } else{
      recordTransaction("NotEnoughMoney", accountId, amount)
    }
  }

  def deposit(accountId: String, amount: Int): Unit = {
    setAmount(money + amount)
    recordTransaction("Deposit", accountId, amount)
  }

  def recordTransaction(tranType: String, accountId: String, amount: Int): Unit
  = this.transactions += new Transaction(tranType, accountId, amount)

  def getTransactions(num: Int): ListBuffer[Transaction]
  = transactions.take(num)
}
