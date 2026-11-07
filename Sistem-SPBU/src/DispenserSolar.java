public class DispenserSolar extends MesinDispenser implements LayananTransaksi {

    private boolean wajibSubsidiQR;
    private double batasKuotaHarianLiter;

    public DispenserSolar(String kodeDispenser, String jenisBBM, double hargaPerLiter, double stokLiter, boolean wajibSubsidiQR, double batasKuotaHarianLiter) {
        super(kodeDispenser, jenisBBM, hargaPerLiter, stokLiter);
        this.wajibSubsidiQR = wajibSubsidiQR;
        this.batasKuotaHarianLiter = batasKuotaHarianLiter;
    }

    public DispenserSolar(String kodeDispenser, String jenisBBM, double hargaPerLiter, boolean wajibSubsidiQR) {
        super(kodeDispenser, jenisBBM, hargaPerLiter);
        this.wajibSubsidiQR = wajibSubsidiQR;
        this.batasKuotaHarianLiter = 60.0;
    }

    @Override
    public void salurkanBBM(double jumlahLiter) {
        System.out.println("\n[PROSES PENGISIAN SOLAR - " + getJenisBBM() + "]");
        if (!isMesinAktif()) {
            System.out.println("GAGAL: Dispenser Solar " + getKodeDispenser() + " sedang nonaktif!");
        } else if (this.wajibSubsidiQR && jumlahLiter > this.batasKuotaHarianLiter) {
            System.out.println("GAGAL: Permintaan (" + jumlahLiter + " L) melebihi batas kuota subsidi QR (" + this.batasKuotaHarianLiter + " L)!");
        } else if (jumlahLiter > getStokLiter()) {
            System.out.println("GAGAL: Stok Solar di tangki tidak mencukupi (Tersisa: " + getStokLiter() + " L)!");
        } else {
            setStokLiter(getStokLiter() - jumlahLiter);
            System.out.println("BERHASIL: Menyalurkan " + jumlahLiter + " Liter " + getJenisBBM() + ".");
            System.out.println("Sisa stok tangki solar sekarang: " + getStokLiter() + " Liter.");
        }
    }

    @Override
    public void tampilkanInfoDispenser() {
        super.tampilkanInfoDispenser();
        System.out.println("Wajib QR Subsidi: " + (this.wajibSubsidiQR ? "YA (Terbatas Kuota)" : "TIDAK (Non-Subsidi)"));
        System.out.println("Batas Kuota/Isi : " + this.batasKuotaHarianLiter + " Liter");
        System.out.println("--------------------------------------------------");
    }

    @Override
    public double hitungTotalBayar(double jumlahLiter) {
        return jumlahLiter * getHargaPerLiter();
    }

    @Override
    public void cetakStrukTransaksi(String platNomor, double jumlahLiter) {
        double stokSebelum = getStokLiter();
        salurkanBBM(jumlahLiter);
        if (isMesinAktif() && (!this.wajibSubsidiQR || jumlahLiter <= this.batasKuotaHarianLiter) && jumlahLiter <= stokSebelum) {
            System.out.println("=== STRUK TRANSAKSI SOLAR ===");
            System.out.println("SPBU         : " + MesinDispenser.NAMA_SPBU);
            System.out.println("Plat Nomor   : " + platNomor);
            System.out.println("Produk BBM   : " + getJenisBBM());
            System.out.println("Volume       : " + jumlahLiter + " Liter");
            System.out.println("Harga / Liter: Rp " + formatRupiah(getHargaPerLiter()));
            System.out.println("Total Bayar  : Rp " + formatRupiah(hitungTotalBayar(jumlahLiter)));
            System.out.println("=============================");
        }
    }

    public boolean isWajibSubsidiQR() {
        return this.wajibSubsidiQR;
    }

    public void setWajibSubsidiQR(boolean wajibSubsidiQR) {
        this.wajibSubsidiQR = wajibSubsidiQR;
    }

    public double getBatasKuotaHarianLiter() {
        return this.batasKuotaHarianLiter;
    }

    public void setBatasKuotaHarianLiter(double batasKuotaHarianLiter) {
        this.batasKuotaHarianLiter = batasKuotaHarianLiter;
    }
}