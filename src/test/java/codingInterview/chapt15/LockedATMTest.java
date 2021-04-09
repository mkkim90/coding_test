package codingInterview.chapt15;

import chapt15.ATMThread;
import chapt15.LockedATM;

public class LockedATMTest {
    public static void main(String[] args) {
        LockedATM atm = new LockedATM();
        ATMThread thread1 = new ATMThread(atm, 1000);
        ATMThread thread2 = new ATMThread(atm, 1000);
        ATMThread thread3 = new ATMThread(atm, 1000);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
