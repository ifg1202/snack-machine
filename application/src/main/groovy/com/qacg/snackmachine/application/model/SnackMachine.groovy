package com.qacg.snackmachine.application.model

class SnackMachine {

    int oneCentCount
    int tenCentCount
    int quarterCount
    int oneDollarCount
    int fiveDollarCount
    int twentyDollarCount

    int oneCentCountInTransaction
    int tenCentCountInTransaction
    int quarterCountInTransaction
    int oneDollarCountInTransaction
    int fiveDollarCountInTransaction
    int twentyDollarCountInTransaction

    void insertMoney(
            int oneCentCount,
            int tenCentCount,
            int quarterCount,
            int oneDollarCount,
            int fiveDollarCount,
            int twentyDollarCount) {
        this.oneCentCountInTransaction += oneCentCount
        this.tenCentCountInTransaction += tenCentCount
        this.quarterCountInTransaction += quarterCount
        this.oneDollarCountInTransaction += oneDollarCount
        this.fiveDollarCountInTransaction += fiveDollarCount
        this.twentyDollarCountInTransaction += twentyDollarCount
    }

    void returnMoney() {
        oneCentCountInTransaction = 0
        tenCentCountInTransaction = 0
        quarterCountInTransaction = 0
        oneDollarCountInTransaction = 0
        fiveDollarCountInTransaction = 0
        twentyDollarCountInTransaction = 0
    }

    void buySnack() {
        oneCentCount += oneCentCountInTransaction
        tenCentCount += tenCentCountInTransaction
        quarterCount += quarterCountInTransaction
        oneDollarCount += oneDollarCountInTransaction
        fiveDollarCount += fiveDollarCountInTransaction
        twentyDollarCount += twentyDollarCountInTransaction

        oneCentCountInTransaction = 0
        tenCentCountInTransaction = 0
        quarterCountInTransaction = 0
        oneDollarCountInTransaction = 0
        fiveDollarCountInTransaction = 0
        twentyDollarCountInTransaction = 0
    }

}
