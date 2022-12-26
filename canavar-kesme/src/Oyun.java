import java.util.Scanner;
public class Oyun {
    Oyuncu oyuncu = new Oyuncu();
    Magaza magaza = new Magaza();
    KucukCanavar kucukCanavar = new KucukCanavar();
    YariPatron yariPatron = new YariPatron();
    Patron patron = new Patron();
    Scanner klavye = new Scanner(System.in);
    private int hasarYeme;
    private int hasarVerme;
    private int level = 1;
    private int oyunTus = 1;

        public void catisma(){
        if(level%5==0){
            if(level%10==0){
                this.hasarYeme = patron.canavarHasar();
                oyuncu.setSaglik(oyuncu.getSaglik() - this.hasarYeme);
                System.out.println(this.hasarYeme + " hasar aldın.");

                this.hasarVerme = oyuncu.getHasar();
                patron.canavarSaglik(this.hasarVerme);
                System.out.println(this.hasarVerme + " hasar verdin.");
                System.out.println("Kalan patron sağlığı " + patron.getSaglik());

                if(patron.getSaglik()==0 || patron.getSaglik()<0){
                    level++;
                    oyuncu.setKacma_hakki(3);
                    patron.setSaglik(100);
                    oyuncu.setPara(oyuncu.getPara() + 60);
                }
            }
            else {
                this.hasarYeme = yariPatron.canavarHasar();
                oyuncu.setSaglik(oyuncu.getSaglik() - this.hasarYeme);
                System.out.println(this.hasarYeme + " hasar aldın.");

                this.hasarVerme = oyuncu.getHasar();
                yariPatron.canavarSaglik(this.hasarVerme);
                System.out.println(this.hasarVerme + " hasar verdin.");
                System.out.println("Kalan yarı-patron sağlığı " + yariPatron.getSaglik());

                if(yariPatron.getSaglik()==0 || yariPatron.getSaglik()<0){
                    level++;
                    oyuncu.setKacma_hakki(3);
                    yariPatron.setSaglik(75);
                    oyuncu.setPara(oyuncu.getPara() + 40);
                }
            }
        }
        else {
            this.hasarYeme = kucukCanavar.canavarHasar();
            oyuncu.setSaglik(oyuncu.getSaglik() - this.hasarYeme);
            System.out.println(this.hasarYeme + " hasar aldın.");;

            this.hasarVerme = oyuncu.getHasar();
            kucukCanavar.canavarSaglik(this.hasarVerme);
            System.out.println(this.hasarVerme + " hasar verdin.");
            System.out.println("Kalan canavar sağlığı " + kucukCanavar.getSaglik());

            if(kucukCanavar.getSaglik()==0 || kucukCanavar.getSaglik()<0){
                level++;
                oyuncu.setKacma_hakki(3);
                kucukCanavar.setSaglik(50);
                oyuncu.setPara(oyuncu.getPara() + 20);
            }
        }
    }
    public void oyun() {
        while (oyunTus != 0) {
            if (oyuncu.getSaglik() < 0 || oyuncu.getSaglik() == 0) {
                System.out.println("Öldünüz!");
                break;
            } else {
                System.out.println();
                System.out.println("Level " + level);
                System.out.println(oyuncu.getSaglik() + " canınız var.");
                System.out.println("Level başına 3 kaçma hakkınız bulunmaktadır. Kalan: " + oyuncu.getKacma_hakki());
                System.out.println(oyuncu.getIksir() + " adet iksiriniz var.");
                System.out.println(oyuncu.getPara() + " paranız var.");
                System.out.println("1 - Canavarla savaş\n" +
                        "2 - Kaç\n" +
                        "3 - Iksır kullan\n" +
                        "4 - Mağazayı aç\n" +
                        "0 - Oyundan çık");

                oyunTus = klavye.nextInt();
                if (oyunTus == 1) {
                    catisma();
                }
                if (oyunTus == 2) {
                    oyuncu.kacma();
                }
                if (oyunTus == 3) {
                    oyuncu.canYenileme();
                }
                if (oyunTus == 4) {
                    System.out.println("1 - Kılıç al - 100 para (+3 Hasar)\n" +
                            "2 - Armor al - 50 para (+25 Can - Can Yenilenir)\n" +
                            "3 - Iksir al - 10 para (+1 Iksir)");

                    oyunTus = klavye.nextInt();
                    if (oyunTus == 1) {
                        magaza.kilicSatinAlma();
                    }
                    if (oyunTus == 2) {
                        magaza.armorSatinAlma();
                    }
                    if (oyunTus == 3) {
                        magaza.iksirSatinAlma();
                    }
                }
            }
        }
    }
}
