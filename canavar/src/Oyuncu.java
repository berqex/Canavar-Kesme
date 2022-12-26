import java.util.Random;
public class Oyuncu {
    Random random = new Random();
    private static int max_saglik = 100;
    private static int saglik = 100;
    private static int hasar = 10;              //static, değişkenlerin her nesne oluşturulduğunda yenilenmemesi ve sınıf değişkeni yapılması için kullanıldı
    private static int iksir = 2;
    private static int para = 0;
    private int kacma_hakki = 3;
    private int sansa_saglik_doldurma;

    public void setMax_saglik(int max_saglik){
        this.max_saglik = max_saglik;
    }
    public int getMax_saglik(){
        return this.max_saglik;
    }

    public void setSaglik(int saglik){
        this.saglik = saglik;
    }
    public int getSaglik(){
        return this.saglik;
    }

    public void setHasar(int hasar){
        this.hasar = hasar;
    }
    public int getHasar(){
        return hasar + random.nextInt(3);
    }

    public void setIksir(int iksir){
        this.iksir = iksir;
    }
    public int getIksir(){
        return this.iksir;
    }

    public void setPara(int para){
        this.para = para;
    }
    public int getPara(){
        return this.para;
    }

    public void setKacma_hakki(int kacma_hakki){
        this.kacma_hakki = kacma_hakki;
    }
    public int getKacma_hakki(){
        return this.kacma_hakki;
    }


    public void canYenileme() {
        if(iksir == 0)
            System.out.println("İksiriniz bulunmamaktadır!");
        else {
            this.saglik += 25;
            this.iksir--;
            if (this.saglik > max_saglik)
                this.saglik = max_saglik;
        }
    }

    public void kacma() {
        if (kacma_hakki != 0) {
            sansa_saglik_doldurma = random.nextInt(2);
            if (sansa_saglik_doldurma == 1) {
                System.out.println("Canavardan kaçarken şansına yerde can buldun.");
                this.saglik += 15;
                if (this.saglik > max_saglik)
                    this.saglik = max_saglik;
            }
            kacma_hakki--;
        } else {
            System.out.println("Kaçma hakkınız kalmamıştır.");
        }
    }
}
