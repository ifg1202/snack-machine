package com.qacg.snackmachine.application.domain

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
final class Money {

    static final Money NONE = new Money(0,0,0,0,0,0)
    static final Money CENT = new Money(1,0,0,0,0,0)
    static final Money TEN_CENT = new Money(0,1,0,0,0,0)
    static final Money QUARTER = new Money(0,0,1,0,0,0)
    static final Money DOLLAR = new Money(0,0,0,1,0,0)
    static final Money FIVE_DOLLAR = new Money(0,0,0,0,1,0)
    static final Money TWENTY_DOLLAR = new Money(0,0,0,0,0,1)

    final int oneCentCount
    final int tenCentCount
    final int quarterCount
    final int oneDollarCount
    final int fiveDollarCount
    final int twentyDollarCount

    Money(int oneCentCount,
          int tenCentCount,
          int quarterCount,
          int oneDollarCount,
          int fiveDollarCount,
          int twentyDollarCount) {
        if (oneCentCount < 0) throw new IllegalArgumentException()
        if (tenCentCount < 0) throw new IllegalArgumentException()
        if (quarterCount < 0) throw new IllegalArgumentException()
        if (oneDollarCount < 0) throw new IllegalArgumentException()
        if (fiveDollarCount < 0) throw new IllegalArgumentException()
        if (twentyDollarCount < 0) throw new IllegalArgumentException()
        this.oneCentCount = oneCentCount
        this.tenCentCount = tenCentCount
        this.quarterCount = quarterCount
        this.oneDollarCount = oneDollarCount
        this.fiveDollarCount = fiveDollarCount
        this.twentyDollarCount = twentyDollarCount
    }


    static Money add(Money money1, Money money2) {
        Money sum = new Money(
                money1.oneCentCount + money2.oneCentCount,
                money1.tenCentCount + money2.tenCentCount,
                money1.quarterCount + money2.quarterCount,
                money1.oneDollarCount + money2.oneDollarCount,
                money1.fiveDollarCount + money2.fiveDollarCount,
                money1.twentyDollarCount + money2.twentyDollarCount
        )
        return sum
    }
    
    static Money subtract(Money money1, Money money2) {
        new Money(money1.oneCentCount - money2.oneCentCount,
                money1.tenCentCount - money2.tenCentCount,
                money1.quarterCount - money2.quarterCount,
                money1.oneDollarCount - money2.oneDollarCount,
                money1.fiveDollarCount - money2.fiveDollarCount,
                money1.twentyDollarCount - money2.twentyDollarCount)
    }

    
    double getAmount() {
        return oneCentCount * 0.01 +
                tenCentCount * 0.10 +
                quarterCount * 0.25 +
                oneDollarCount +
                fiveDollarCount * 5 +
                twentyDollarCount * 20
    }

}
