public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   SISTEM MANAJEMEN DISPENSER " + MesinDispenser.NAMA_SPBU);
        System.out.println("   Praktikan: H1D025153 (Tema Digit 3: SPBU)");
        System.out.println("==================================================\n");

        System.out.println(">>> [UJI 1: INSTANSIASI, INHERITANCE, OVERLOADING, & OVERRIDING]");
        DispenserBensin pompaPertamax = new DispenserBensin("DSP-B01", "Pertamax", 15000, 300.0, 92);
        DispenserSolar pompaBioSolar = new DispenserSolar("DSP-S01", "Bio Solar Subsidi", 10000, true);

        pompaPertamax.tampilkanInfoDispenser();
        pompaBioSolar.tampilkanInfoDispenser();

        System.out.println(">>> [UJI 2: STATE, BEHAVIOR FUNGSI, IMMUTABILITY, & ENKAPSULASI]");
        System.out.println("Kode Kekal Dispenser 1 (private final): " + pompaPertamax.getKodeDispenser());
        System.out.println("Estimasi Nilai Tangki Pertamax Awal   : Rp " + MesinDispenser.formatRupiah(pompaPertamax.hitungEstimasiNilaiTangki()));

        pompaPertamax.setHargaPerLiter(15000);
        System.out.println("Harga Pertamax setelah di-update Setter: Rp " + MesinDispenser.formatRupiah(pompaPertamax.getHargaPerLiter()));

        System.out.println("\n>>> [UJI 3: LOGIKA STATE PERCABANGAN (IF/ELSE) PADA ABSTRACT METHOD]");
        pompaPertamax.salurkanBBM(25.0);
        pompaPertamax.salurkanBBM(400.0);
        pompaBioSolar.salurkanBBM(80.0);
        pompaBioSolar.salurkanBBM(40.0);

        System.out.println("\n>>> [UJI 4: POLIMORFISME INTERFACE & MULTIPLE INTERFACE]");
        LayananTransaksi kasirDispenser = new DispenserBensin("DSP-B02", "Pertamax Turbo", 20000, 98);
        kasirDispenser.cetakStrukTransaksi("R 1234 UN", 15.0);

        KontrolKeamanan panelKeamanan = pompaPertamax;
        System.out.println("\nStatus Keamanan " + pompaPertamax.getKodeDispenser() + " Sebelum Darurat: "
                + (panelKeamanan.cekStatusKeamanan() ? "AMAN" : "BAHAYA"));

        panelKeamanan.aktifkanKunciDarurat("Terdeteksi tekanan uap berlebih pada nozzle");
        System.out.println("Status Keamanan " + pompaPertamax.getKodeDispenser() + " Setelah Darurat: "
                + (panelKeamanan.cekStatusKeamanan() ? "AMAN" : "BAHAYA"));

        pompaPertamax.salurkanBBM(10.0);
    }
}