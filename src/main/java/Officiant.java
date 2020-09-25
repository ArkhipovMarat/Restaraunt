public class Officiant implements Runnable{

    Restaraunt restaraunt;

    public Officiant(Restaraunt restaraunt) {
        this.restaraunt = restaraunt;
    }

    @Override
    public void run() {
        System.out.println("Оффициант" + Thread.currentThread().getName() + ": в ресторане");
        while (restaraunt.restarauntOrders<3) {
            restaraunt.awaitingOrder();
        }
    }
}
