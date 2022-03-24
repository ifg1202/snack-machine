package com.qacg.snackmachine.application.domain

import static com.qacg.snackmachine.application.domain.Money.CENT
import static com.qacg.snackmachine.application.domain.Money.DOLLAR
import static com.qacg.snackmachine.application.domain.Money.FIVE_DOLLAR
import static com.qacg.snackmachine.application.domain.Money.NONE
import static com.qacg.snackmachine.application.domain.Money.QUARTER
import static com.qacg.snackmachine.application.domain.Money.TEN_CENT
import static com.qacg.snackmachine.application.domain.Money.TWENTY_DOLLAR

class SnackMachine extends Entity {

    Money moneyInside = NONE
    Money moneyInTransaction = NONE

    void insertMoney(Money money) {
        List<Money> coinsAndNotes = List.of(CENT, TEN_CENT, QUARTER, DOLLAR, FIVE_DOLLAR, TWENTY_DOLLAR)
        if (!coinsAndNotes.contains(money))
            throw new IllegalArgumentException()

        moneyInTransaction = Money.add(moneyInTransaction, money)
    }

    void returnMoney() {
        moneyInTransaction = NONE
    }

    void buySnack() {
        moneyInside = Money.add(moneyInside, moneyInTransaction)
        moneyInTransaction = NONE
    }

}
