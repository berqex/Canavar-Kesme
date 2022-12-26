import java.util.Random;
public abstract class Dusman { //abstract class, bu classın diğer classlara taban olması için kullanıldı
        Random random = new Random();
    private int saglik;
    public void setSaglik(int saglik){
        this.saglik = saglik;
    }
    public int getSaglik(){
        return saglik;
    }
    public void canavarSaglik(int hasar){
        this.setSaglik(this.getSaglik() - hasar);
    }
    public abstract int canavarHasar(); //abstract metod, bu metodun diğer sub classlardaki metodlara taban olması için kullanıldı
}
class KucukCanavar extends Dusman{
    public KucukCanavar(){
        this.setSaglik(50);
    }
    @Override
    public int canavarHasar(){
        return 5 + random.nextInt(3);
    }
}
class YariPatron extends Dusman{
    public YariPatron() {
        this.setSaglik(75);
    }
    @Override
    public int canavarHasar(){
        return 10 + random.nextInt(4);
    }
}
class Patron extends Dusman{
    public Patron() {
        this.setSaglik(100);
    }
    @Override
    public int canavarHasar(){
        return 15 + random.nextInt(5);
    }
}
