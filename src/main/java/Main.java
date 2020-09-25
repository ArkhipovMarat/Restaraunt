public class Main {
    public static void main(String[] args) throws InterruptedException {
    Restaraunt restaraunt = new Restaraunt();
    Officiant officiant = new Officiant(restaraunt);
    Visitor visitor = new Visitor(restaraunt);
    Kitchener kitchener = new Kitchener(restaraunt);


    new Thread(officiant, "1").start();
    new Thread(officiant, "2").start();
    new Thread(officiant, "3").start();
    new Thread(kitchener).start();

    Thread.sleep(100);

    new Thread(visitor, "1").start();
    new Thread(visitor, "2").start();
    new Thread(visitor, "3").start();
    new Thread(visitor, "4").start();
    }
}
