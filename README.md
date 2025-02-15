# UlasimPlanlama

Bu proje, farklı mahalleler için ulaşım planlaması yaparken nüfus yoğunluğu, altyapı, maliyet, çevresel etki ve sosyal fayda gibi kriterleri değerlendirerek en uygun güzergahı belirlemeyi amaçlar. Softmax fonksiyonu kullanılarak mahalleler için bir olasılık dağılımı oluşturulur ve en uygun mahalle seçilir.

## Özellikler
- Mahallelerin nüfus yoğunluğu, ulaşım altyapısı, maliyet, çevresel etki ve sosyal fayda gibi kriterleri değerlendirilir.
- Kriterler ağırlıklandırılarak toplam bir skor hesaplanır.
- Softmax fonksiyonu ile mahallelerin uygunluk olasılıkları hesaplanır.
- En uygun güzergah belirlenerek ekrana yazdırılır.

## Kullanılan Algoritmalar
- **Maliyet-Fayda Analizi**: Mahallelerin maliyet ve sosyal fayda oranı hesaplanarak değerlendirme sürecine dahil edilir.
- **Softmax Fonksiyonu**: Her mahalle için uygunluk skoru normalize edilerek bir olasılık dağılımı oluşturulur.

## Kullanım
Bu programı çalıştırmak için aşağıdaki adımları takip edebilirsiniz:

### 1. Java Dosyasını Çalıştırın
```bash
javac UlasimPlanlama.java
java UlasimPlanlama
```

### 2. Program Çıktısı
Program çalıştırıldığında mahallelerin skorları ve en uygun güzergah ekrana yazdırılacaktır. Örnek çıktı:
```
Mahalle Kriterleri:
Merkez -> Nüfus Yoğunluğu: 80.00, Ulaşım Altyapısı: 60.00, Maliyet: 50.00, Çevresel Etki: 40.00, Sosyal Fayda: 90.00
Sanayi -> Nüfus Yoğunluğu: 60.00, Ulaşım Altyapısı: 80.00, Maliyet: 70.00, Çevresel Etki: 30.00, Sosyal Fayda: 60.00
Üniversite -> Nüfus Yoğunluğu: 90.00, Ulaşım Altyapısı: 50.00, Maliyet: 40.00, Çevresel Etki: 50.00, Sosyal Fayda: 85.00

Mahalle Skorları ve Olasılıklar:
Merkez: Skor = X.XX, Olasılık = X.XX%
Sanayi: Skor = X.XX, Olasılık = X.XX%
Üniversite: Skor = X.XX, Olasılık = X.XX%

En uygun güzergah: Üniversite
```

## Bağımlılıklar
Bu program sadece **Java** kullanılarak yazılmıştır ve ek bir kütüphane gerektirmez.

## Katkıda Bulunma
Projeye katkıda bulunmak için **Pull Request** açabilir veya hata bildirmek için **Issues** bölümünü kullanabilirsiniz.

## Lisans
Bu proje açık kaynaklıdır ve herhangi bir lisans kısıtlaması olmadan kullanılabilir.

