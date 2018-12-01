package banktransfor.kata.tdd

import org.scalatest.{Assertions, FlatSpec}

class BankTransferKataTDDSpec extends FlatSpec with Assertions {
  "Payer" should "transfor a specified amount of money to payee" in {
    val acc1: Account = Bank.createAccount(100)
    val acc2: Account = Bank.createAccount(100)

    Bank.transferMoney(acc1, acc2, 50)

    assert(acc1.getAmount() == 50)
    assert(acc2.getAmount() == 150)
  }

  "Transactions" should "recorded in both accounts as a transaction history" in {
    val acc1: Account = Bank.createAccount(100)
    val acc2: Account = Bank.createAccount(100)

    Bank.transferMoney(acc1, acc2, 50)

    assert(acc1.getTransactions(1)(0).toString() == s"[Withdrawal] ${acc2.getAccountId()} 50")
    assert(acc2.getTransactions(1)(0).toString() == s"[Deposit] ${acc1.getAccountId()} 50")
  }

  "Bank" should "query the account" in {
    val ALL = 9999
    val A: Account = Bank.createAccount(100)
    val B: Account = Bank.createAccount(100)

    Bank.transferMoney(A, B, 50)
    Bank.transferMoney(B, A, 50)
    Bank.transferMoney(B, A, 50)
    Bank.transferMoney(A, B, 50)
    Bank.transferMoney(A, B, 50)
    Bank.transferMoney(B, A, 50)

    println(s"===============================================================")
    println(s"====================  Transaction History  ====================")
    println(s"AccountID: ${A.getAccountId()}")
    A.getTransactions(ALL).map(_.toString).foreach(println)
    println(s"===============================================================\n")

    println(s"===============================================================")
    println(s"====================  Transaction History  ====================")
    println(s"AccountID: ${B.getAccountId()}")
    B.getTransactions(ALL).map(_.toString).foreach(println)
    println(s"===============================================================\n")
  }
}
