package CepTelefonUygulamasi

import java.util.*

private val cepTelefonu=CepTelefonu ("5313313131")

private val tara= Scanner (System.`in`)

fun main(args:Array<String>) {
    telefonuBaslat()
    menuGöster()

    var cikis: Boolean =false

    while (!cikis){

        println("Seçimiz : (Menüye görmek için 6 ya basın)")
        var secim =tara.nextInt()

        when (secim){
            0 ->{
                println("Çıkış Yapılıyor...")
                cikis =true
            }
            1-> cepTelefonu.tümKisileriListele()

            2 ->{
                yeniKisiEkleFonksiyonu()
            }

            3-> kisiSorgulaMethodu()

            4->kisiSilMethodu()

            5->kisiGuncelleMethodu()

            6 ->{

                menuGöster()

            }
            else -> println("Yanlış bir seçim yaptınız tekrar deneyiniz ....")

        }
    }
}

fun kisiGuncelleMethodu() {
    println("Güncellenecek Kişi Adı Gir")
    val isim = tara.next()
    val bulunanKisi = cepTelefonu.kisiSorgula(isim)

    if (bulunanKisi == null){

        println("Kayıt Bulunamadı")
        return
    }
    println("Yeni Kişi Adı Gir")
    val yeniisim = tara.next()

    println("Yeni Kişi Numarası Adı Gir")
    val yeninumara = tara.next()

    cepTelefonu.kisiGuncelle(bulunanKisi, Kisi.kisiOlustur(yeniisim, yeninumara))



}

fun kisiSilMethodu() {
    println("Silincek Kişi Adı Gir")
    val isim = tara.next()
    val bulunanKisi = cepTelefonu.kisiSorgula(isim)
    if (bulunanKisi != null){

        if (cepTelefonu.kisiSil(bulunanKisi!!)){
            println("Silme Yapıldı")
        }

    }
    else{
        println("Kişi Yok")
    }
}

fun yeniKisiEkleFonksiyonu() {

    println("Yeni Kişi Adı Gir")
    val isim = tara.next()

    println("Yeni Kişi Numarası Adı Gir")
    val numara = tara.next()

    cepTelefonu.ekleYeniKisi(Kisi.kisiOlustur(isim, numara))
}

fun kisiSorgulaMethodu(){

    println("Arnacak Kişi Adı Gir")
    val isim = tara.next()
    val bulunanKisi = cepTelefonu.kisiSorgula(isim)
    if (bulunanKisi == null){
        println("Öyle Bir Kişi Yok")
        return
    }
    else {
        println("Bulunan Kişi : ${bulunanKisi.isim}--------${bulunanKisi.telNo}")
    }
}

fun menuGöster() {
    println("***************MENÜ*************** \n")
    println("0 -- Çıkış \n" +
            "1 -- Tüm Kişileri Listele \n" +
            "2 -- Yeni Kişi Ekle \n" +
            "3 -- Kişi Sorgula \n" +
            "4 -- Kişi Sil \n" +
            "5 -- Kişi Güncelle \n" +
            "6 -- Menüyü Göster" )
}

fun telefonuBaslat() {
    println("Telefon Başlatılıyor ....")
}
