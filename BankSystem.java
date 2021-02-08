import java.util.*;

class RBI{
    float minimum_interest_rate = 4;
    int minimum_allowed_balance = 10000;
    int maximum_withdrawal_limit = 49000;

    float calculate_interest(float deposit, int time)
    {
        return deposit*time*minimum_interest_rate/100;
    }
    void transact(float deposit, int withdrawal, int time)
    {
        float interest = calculate_interest(deposit, time);
        deposit = deposit+interest;
        if (deposit-withdrawal<minimum_allowed_balance)
        {
            System.out.println("Maintain minimum balance!");
        }
        else
        {
            System.out.println(deposit-withdrawal);
        }

    }
}

class SBI extends RBI
{
    float interest_rate = 6;

    float calculate_interest(float deposit, int time)
    {
        return deposit*time*interest_rate/100;
    }

    void transact(float deposit, int withdrawal, int time)
    {
        float interest = calculate_interest(deposit, time);
        deposit = deposit+interest;
        if (deposit-withdrawal<super.minimum_allowed_balance)
        {
            System.out.println("Maintain minimum balance!");
        }
        else
        {
            System.out.println(deposit-withdrawal);
        }
    }
}


class ICICI extends RBI
{
    float interest_rate = 5.5f;

    float calculate_interest(float deposit, int time)
    {
        return deposit*time*interest_rate/100;
    }

    void transact(float deposit, int withdrawal, int time)
    {
        float interest = calculate_interest(deposit, time);
        deposit = deposit+interest;
        if (deposit-withdrawal<super.minimum_allowed_balance)
        {
            System.out.println("Maintain minimum balance!");
        }
        else
        {
            System.out.println(deposit-withdrawal);
        }
    }
}


class PNB extends RBI
{
    float interest_rate = 4.67f;

    float calculate_interest(float deposit, int time)
    {
        return deposit*time*interest_rate/100;
    }

    void transact(float deposit, int withdrawal, int time)
    {
        float interest = calculate_interest(deposit, time);
        deposit = deposit+interest;
        if (deposit-withdrawal<super.minimum_allowed_balance)
        {
            System.out.println("Maintain minimum balance!");
        }
        else
        {
            System.out.println(deposit-withdrawal);
        }
    }
}

public class BankSystem {
    public static void main(String args[])
    {
        RBI BankSBI = new SBI();
        BankSBI.transact(12000, 0, 4);
        BankSBI.transact(12000, 400, 4);
        BankSBI.transact(12000, 4881, 4);
        System.out.println();

        RBI BankICICI = new ICICI();
        BankICICI.transact(12000, 0, 4);
        BankICICI.transact(12000, 400, 4);
        BankICICI.transact(12000, 4881, 4);
        System.out.println();

        RBI BankPNB = new PNB();
        BankPNB.transact(12000, 0, 4);
        BankPNB.transact(12000, 400, 4);
        BankPNB.transact(12000, 4881, 4);

    }

}
