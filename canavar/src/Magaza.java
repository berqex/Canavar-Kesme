public class Magaza {
    Oyuncu oyuncu = new Oyuncu();

    public void kilicSatinAlma(){
        oyuncu.setPara(oyuncu.getPara() - 100);
        if(oyuncu.getPara()<0){
            oyuncu.setPara(oyuncu.getPara() + 100);
            System.out.println("Yetersiz bakiye");
        } else {
            oyuncu.setHasar(oyuncu.getHasar() + 3);
        }
    }
    public void armorSatinAlma(){
        oyuncu.setPara(oyuncu.getPara() - 50);
        if(oyuncu.getPara()<0){
            oyuncu.setPara(oyuncu.getPara() + 50);
            System.out.println("Yetersiz bakiye");
        } else {
            oyuncu.setMax_saglik(oyuncu.getMax_saglik() + 25);
            oyuncu.setSaglik(oyuncu.getMax_saglik());
            System.out.println("Canınız yenilenmiştir.");
        }
    }
    public void iksirSatinAlma(){
        oyuncu.setPara(oyuncu.getPara() - 10);
        if(oyuncu.getPara()<0){
            oyuncu.setPara(oyuncu.getPara() + 10);
            System.out.println("Yetersiz bakiye");
        } else {
            oyuncu.setIksir(oyuncu.getIksir() + 1);
        }
    }
}
