package chapt15;

public class ATMThread extends Thread {
    private int money;
    private LockedATM atm;

    public ATMThread(LockedATM atm, int money) {
        this.atm = atm;
        this.money = money;
    }

    public void run() {
        atm.deposit(money);
    }
}
