package com.qacg.snackmachine.application.domain

import spock.lang.Specification

import static com.qacg.snackmachine.application.domain.Money.CENT
import static com.qacg.snackmachine.application.domain.Money.DOLLAR
import static com.qacg.snackmachine.application.domain.Money.NONE

class SnackMachineSpec extends Specification {

    def "Return money empties money in transaction"() {
        given:
        SnackMachine snackMachine  = new SnackMachine()
        snackMachine.insertMoney(DOLLAR)

        when:
        snackMachine.returnMoney()

        then:
        snackMachine.moneyInTransaction.amount == 0
    }

    def "Inserted money goes to money in transaction"() {
        given:
        SnackMachine snackMachine  = new SnackMachine()

        when:
        snackMachine.insertMoney(CENT)
        and:
        snackMachine.insertMoney(DOLLAR)

        then:
        snackMachine.moneyInTransaction.amount == 1.01
    }

    def "Cannot insert than one coin or note at a time"() {
        given:
        SnackMachine snackMachine = new SnackMachine()
        Money toInsert = Money.add(CENT, CENT)

        when:
        snackMachine.insertMoney(toInsert)

        then:
        thrown(IllegalArgumentException)
    }

    def "Money in transaction goes to money inside after purchase"() {
        given:
        SnackMachine snackMachine = new SnackMachine()
        snackMachine.insertMoney(DOLLAR)
        snackMachine.insertMoney(DOLLAR)

        when:
        snackMachine.buySnack()

        then:
        snackMachine.moneyInTransaction == NONE
        and:
        snackMachine.moneyInside.amount == 2
    }

}
