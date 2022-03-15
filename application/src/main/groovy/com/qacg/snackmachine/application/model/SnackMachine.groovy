package com.qacg.snackmachine.application.model

class SnackMachine {

    Money moneyInside
    Money moneyInTransaction

    void insertMoney(Money money) {
        moneyInTransaction = Money.add(moneyInTransaction, money)
    }

    void returnMoney() {
        //moneyInTransaction = 0
    }

    void buySnack() {
        moneyInside = Money.add(moneyInside, moneyInTransaction)
        //moneyInTransaction = 0
    }

}
