public class Visitor implements Runnable {
    Restaraunt restaraunt;

    public Visitor(Restaraunt restaraunt) {
        this.restaraunt = restaraunt;
    }

    @Override
    public void run() {
        if (restaraunt.restarauntOrders <3) {
            System.out.println("Посетитель" + Thread.currentThread().getName() + ": в ресторане");
            restaraunt.makeOrder();
            restaraunt.takeOrder();
            System.out.println("Посетитель" + Thread.currentThread().getName() + ": покинул ресторан");
        }
    }



}
