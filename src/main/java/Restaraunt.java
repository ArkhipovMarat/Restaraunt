public class Restaraunt {
    volatile boolean orderToOfficiant;
    volatile boolean orderToKitchener;
    volatile boolean orderCoocked;
    volatile boolean meatReady;
    volatile int restarauntOrders;

    public synchronized void makeOrder() {
        System.out.println("Посетитель" + Thread.currentThread().getName() + ": сделал заказ");
        orderToOfficiant = true;
        notify();
    }

    public synchronized void takeOrder() {
        while (!meatReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Посетитель" + Thread.currentThread().getName() + ": получил заказ и приступил к еде");
        meatReady = false;
    }

    public synchronized void awaitingOrder() {
        while (!orderToOfficiant & !orderCoocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (orderToOfficiant) {
            System.out.println("Оффициант" + Thread.currentThread().getName() + ": принял заказ");
            orderToOfficiant = false;
            orderToKitchener = true;
        } else if (orderCoocked) {
            System.out.println("Оффициант" + Thread.currentThread().getName() + ": несет заказ посетителю");
            meatReady = true;
            orderCoocked = false;
        }
    }

    public synchronized void cooking() {
        while (!orderToKitchener) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Повар: готовит заказ");
        System.out.println("Повар: приготовил заказ");
        orderToKitchener = false;
        orderCoocked = true;
        notify();
    }
}
