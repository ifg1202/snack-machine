package com.qacg.snackmachine.application.domain

import spock.lang.Specification

class MoneySpec extends Specification {

    def "Sum of two money produces correct result"() {
        given:
        Money money1 = new Money(1,2,3,4,5,6)
        Money money2 = new Money(1,2,3,4,5,6)

        when:
        Money sum = Money.add money1, money2

        then:
        sum.oneCentCount == 2
        sum.tenCentCount == 4
        sum.quarterCount == 6
        sum.oneDollarCount == 8
        sum.fiveDollarCount == 10
        sum.twentyDollarCount == 12
    }

    def "Tow money instances equal if contain the same money amount"() {
        when:
        Money money1 = new Money(1,2,3,4,5,6)
        Money money2 = new Money(1,2,3,4,5,6)

        then:
        money1 == money2
        money1.hashCode() == money2.hashCode()
    }

    def "Two money instances do not equal if contain differetn money amounts"() {
        when:
        Money dollar = new Money(0,0,0,1,0,0)
        Money hundredCents = new Money(100,0,0,0,0,0)

        then:
        dollar != hundredCents
        dollar.hashCode() != hundredCents.hashCode()
    }

    def "Cannot create money with negative value"() {
        when:
        new Money(oneCentCount,
                tenCentCount,
                quarterCount,
                oneDollarCount,
                fiveDollarCount,
                twentyDollarCount)

        then:
        thrown(IllegalArgumentException)

        where:
        oneCentCount | tenCentCount | quarterCount | oneDollarCount | fiveDollarCount | twentyDollarCount
        -1           | 0            | 0            | 0              | 0               | 0
        0            | -2           | 0            | 0              | 0               | 0
        0            | 0            | -3           | 0              | 0               | 0
        0            | 0            | 0            | -4             | 0               | 0
        0            | 0            | 0            | 0              | -5              | 0
        0            | 0            | 0            | 0              | 0               | -6
    }

    def "Amount is calculated correctly" () {
        given:
        Money money = new Money(oneCentCount,
                tenCentCount,
                quarterCount,
                oneDollarCount,
                fiveDollarCount,
                twentyDollarCount)
        when:
        double amount = money.getAmount()

        then:
        amount == expectedAmount

        where:
        oneCentCount | tenCentCount | quarterCount | oneDollarCount | fiveDollarCount | twentyDollarCount || expectedAmount
        0            | 0            | 0            | 0              | 0               | 0                 || 0
        1            | 0            | 0            | 0              | 0               | 0                 || 0.01
        1            | 2            | 0            | 0              | 0               | 0                 || 0.21
        1            | 2            | 3            | 0              | 0               | 0                 || 0.96
        1            | 2            | 3            | 4              | 0               | 0                 || 4.96
        1            | 2            | 3            | 4              | 5               | 0                 || 29.96
        1            | 2            | 3            | 4              | 5               | 6                 || 149.96
        11           | 0            | 0            | 0              | 0               | 0                 || 0.11
        110          | 0            | 0            | 0              | 100             | 0                 || 501.1
    }

    def "Subtraction of two money produces correct result"() {
        given:
        Money money1 = new Money(10,10,10,10,10,10)
        Money money2 = new Money(1,2,3,4,5,6)

        when:
        Money result = Money.subtract money1, money2

        then:
        result.oneCentCount == 9
        result.tenCentCount == 8
        result.quarterCount == 7
        result.oneDollarCount == 6
        result.fiveDollarCount == 5
        result.twentyDollarCount == 4
    }

    def "Cannot subtract more than exists"() {
        given:
        Money money1 = new Money(0,1,0,0,0,0)
        Money money2 = new Money(1,0,0,0,0,0)

        when:
        Money.subtract money1, money2

        then:
        thrown(IllegalArgumentException)

    }
 }
