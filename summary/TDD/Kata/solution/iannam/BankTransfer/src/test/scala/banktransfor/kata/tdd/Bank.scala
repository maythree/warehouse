package banktransfor.kata.tdd
import java.util.UUID.randomUUID

object Bank {
  def createAccount(amount: Int, accountId: String = randomUUID().toString): Account
  = new Account(accountId, amount)

  def transferMoney(acc1: Account, acc2: Account, money: Int): Unit ={
    acc1.withdrawal(acc2.getAccountId(), money)
    acc2.deposit(acc1.getAccountId(), money)
  }
}
