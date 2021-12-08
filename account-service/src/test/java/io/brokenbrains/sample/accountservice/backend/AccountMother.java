package io.brokenbrains.sample.accountservice.backend;

import io.brokenbrains.sample.accountservice.common.AccountInfo;
import io.brokenbrains.sample.commondomain.Money;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AccountMother {
    public static Money initialBalance = new Money("12.34");
    public static long accountId = 102L;
    public static long moneyTransferId = 103L;
    public static long recipientId = 104L;
    public static String recipientName = "john";
    public static Date acceptDate = new GregorianCalendar(2021, Calendar.FEBRUARY, 1).getTime();

    public static Money amount = new Money("12.45");
    public static AccountInfo makeAccount() {
        return new AccountInfo("Checking", initialBalance);
    }

}