public class Kitchener implements Runnable{
    Restaraunt restaraunt;

    public Kitchener(Restaraunt restaraunt) {
        this.restaraunt = restaraunt;
    }

    @Override
    public void run() {
        System.out.println("Повар: в ресторане");
        while (restaraunt.restarauntOrders<3) {
            restaraunt.cooking();
        }
    }
}
