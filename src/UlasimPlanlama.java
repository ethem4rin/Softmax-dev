import java.util.*;

public class UlasimPlanlama {
    static class Mahalle {
        String ad;
        double nufusYogunlugu;
        double altyapi;
        double maliyet;
        double cevreselEtki;
        double sosyalFayda;
        double skor;
        double maliyetFaydaSkoru;  // Maliyet-Fayda Analizi için yeni alan

        Mahalle(String ad, double nufusYogunlugu, double altyapi, double maliyet,
                double cevreselEtki, double sosyalFayda) {
            this.ad = ad;
            this.nufusYogunlugu = nufusYogunlugu;
            this.altyapi = altyapi;
            this.maliyet = maliyet;
            this.cevreselEtki = cevreselEtki;
            this.sosyalFayda = sosyalFayda;
        }

        // Maliyet-Fayda Skoru hesaplama metodu
        public void maliyetFaydaSkoruHesapla(double maliyetAgirlik, double sosyalFaydaAgirlik) {
            this.maliyetFaydaSkoru = (sosyalFayda * sosyalFaydaAgirlik) / (maliyet * Math.abs(maliyetAgirlik));
        }
    }

    public static double[] softmax(double[] skorlar) {
        double toplam = 0.0;
        double[] expSkorlar = new double[skorlar.length];

        for (int i = 0; i < skorlar.length; i++) {
            expSkorlar[i] = Math.exp(skorlar[i]);
            toplam += expSkorlar[i];
        }
        for (int i = 0; i < skorlar.length; i++) {
            expSkorlar[i] /= toplam;
        }
        return expSkorlar;
    }

    public static void main(String[] args) {
        List<Mahalle> mahalleler = new ArrayList<>();
        mahalleler.add(new Mahalle("Merkez", 80, 60, 50, 40, 90));
        mahalleler.add(new Mahalle("Sanayi", 60, 80, 70, 30, 60));
        mahalleler.add(new Mahalle("Üniversite", 90, 50, 40, 50, 85));

        // Kriter ağırlıkları
        double nufusAgirlik = 0.3;
        double altyapiAgirlik = 0.2;
        double maliyetAgirlik = -0.2;
        double cevreselEtkiAgirlik = -0.1;
        double sosyalFaydaAgirlik = 0.4;

        double[] skorlar = new double[mahalleler.size()];

        System.out.println("Mahalle Kriterleri:");
        for (Mahalle m : mahalleler) {
            System.out.printf("%s -> Nüfus Yoğunluğu: %.2f, Ulaşım Altyapısı: %.2f, Maliyet: %.2f, Çevresel Etki: %.2f, Sosyal Fayda: %.2f%n",
                    m.ad, m.nufusYogunlugu, m.altyapi, m.maliyet, m.cevreselEtki, m.sosyalFayda);
        }

        for (int i = 0; i < mahalleler.size(); i++) {
            Mahalle m = mahalleler.get(i);
            m.maliyetFaydaSkoruHesapla(maliyetAgirlik, sosyalFaydaAgirlik); // Maliyet-Fayda skorunu hesapla

            // Maliyet-Fayda skorunu final skora dahil et
            skorlar[i] = m.nufusYogunlugu * nufusAgirlik +
                    m.altyapi * altyapiAgirlik +
                    m.maliyet * maliyetAgirlik +
                    m.cevreselEtki * cevreselEtkiAgirlik +
                    m.sosyalFayda * sosyalFaydaAgirlik +
                    m.maliyetFaydaSkoru;  // Maliyet-Fayda skorunu final skora ekle
            m.skor = skorlar[i];
        }

        double[] olasiliklar = softmax(skorlar);

        System.out.println("\nMahalle Skorları ve Olasılıklar:");
        for (int i = 0; i < mahalleler.size(); i++) {
            System.out.printf("%s: Skor = %.2f, Olasılık = %.2f%%%n",
                    mahalleler.get(i).ad, mahalleler.get(i).skor, olasiliklar[i] * 100);
        }

        int enIyiIndex = 0;
        for (int i = 1; i < olasiliklar.length; i++) {
            if (olasiliklar[i] > olasiliklar[enIyiIndex]) {
                enIyiIndex = i;
            }
        }
        System.out.println("\nEn uygun güzergah: " + mahalleler.get(enIyiIndex).ad);
    }
}
