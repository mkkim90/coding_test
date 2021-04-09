package chapt15;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 동기화를 제어하고 싶을 때 락을 사용합니다. 락을 공유자원에 붙이면 해당 자원에 대한 접근을 동기화할 수 있습니다.
 * 스레드가 해당 자원을 접근하려면 우선 그 자원에 붙어 있는 락을 획득해야합니다. 특정 시점에 락을 쥐고 있을 수 있는 스레드는 하나뿐입니다.
 * 따라서 해당 공유자원은 한번에 한 스레드만이 사용할 수 있습니다.
 */
public class LockedATM {
    private Lock lock;
    private int balance = 100;

    public LockedATM() {
        lock = new ReentrantLock();
    }

    public int withdraw(int value) {
        lock.lock();
        int temp = balance;
        try {
            Thread.sleep(100);
            temp = temp - value;
            Thread.sleep(100);
            balance = temp;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        return temp;
    }

    public int deposit(int value) {
        lock.lock();
        int temp = balance;
        try {
            System.out.println("입금 시작");
            Thread.sleep(100);
            temp = temp + value;
            Thread.sleep(100);
            System.out.println("입금 완료");
            balance = temp;
            System.out.println("현재 잔고 : "+ balance);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        return temp;
    }

    public int balance() {
        return this.balance;
    }
}
