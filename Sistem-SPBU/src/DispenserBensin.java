public class DispenserBensin extends MesinDispenser implements LayananTransaksi, KontrolKeamanan {

    private int nilaiOktan;
    private boolean sensorTekananAman;

    public DispenserBensin(String kodeDispenser, String jenisBBM, double hargaPerLiter, double stokLiter, int nilaiOktan) {
        super(kodeDispenser, jenisBBM, hargaPerLiter, stokLiter);
        this.nilaiOktan = nilaiOktan;
        this.sensorTekananAman = true;
    }

    public DispenserBensin(String kodeDispenser, String jenisBBM, double hargaPerLiter, int nilaiOktan) {
        super(kodeDispenser, jenisBBM, hargaPerLiter);
        this.nilaiOktan = nilaiOktan;
        this.sensorTekananAman = true;
    }

    @Override
    public void salurkanBBM(double jumlahLiter) {
        System.out.println("\n[PROSES PENGISIAN BENSIN - " + getJenisBBM() + " (RON " + this.nilaiOktan + ")]");
        if (!isMesinAktif() || !this.sensorTekananAman) {
            System.out.println("GAGAL: Mesin dispenser " + getKodeDispenser() + " sedang terkunci/tidak aman!");
        } else if (jumlahLiter <= 0) {
            System.out.println("GAGAL: Jumlah permintaan liter harus lebih dari 0!");
        } else if (jumlahLiter > getStokLiter()) {
            System.out.println("GAGAL: Stok tidak cukup! Permintaan: " + jumlahLiter + " L, Sisa stok: " + getStokLiter() + " L.");
        } else {
            double sisaStokBaru = getStokLiter() - jumlahLiter;
            setStokLiter(sisaStokBaru);
            System.out.println("BERHASIL: Menyalurkan " + jumlahLiter + " Liter " + getJenisBBM() + ".");
            System.out.println("Sisa stok tangki sekarang: " + getStokLiter() + " Liter.");
        }
    }

    @Override
    public void tampilkanInfoDispenser() {
        super.tampilkanInfoDispenser();
        System.out.println("Nilai Oktan     : RON " + this.nilaiOktan);
        System.out.println("Sensor Tekanan  : " + (this.sensorTekananAman ? "NORMAL" : "BAHAYA"));
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
        if (isMesinAktif() && this.sensorTekananAman && jumlahLiter > 0 && jumlahLiter <= stokSebelum) {
            System.out.println("=== STRUK TRANSAKSI BENSIN ===");
            System.out.println("SPBU         : " + MesinDispenser.NAMA_SPBU);
            System.out.println("Plat Nomor   : " + platNomor);
            System.out.println("Produk BBM   : " + getJenisBBM() + " (RON " + this.nilaiOktan + ")");
            System.out.println("Volume       : " + jumlahLiter + " Liter");
            System.out.println("Harga / Liter: Rp " + formatRupiah(getHargaPerLiter()));
            System.out.println("Total Bayar  : Rp " + formatRupiah(hitungTotalBayar(jumlahLiter)));
            System.out.println("==============================");
        }
    }

    @Override
    public void aktifkanKunciDarurat(String alasan) {
        this.sensorTekananAman = false;
        setMesinAktif(false);
        System.out.println("\n[ALARM KEAMANAN] Dispenser " + getKodeDispenser() + " DIKUNCI DARURAT!");
        System.out.println("Alasan: " + alasan);
    }

    @Override
    public boolean cekStatusKeamanan() {
        return isMesinAktif() && this.sensorTekananAman;
    }

    public int getNilaiOktan() {
        return this.nilaiOktan;
    }

    public void setNilaiOktan(int nilaiOktan) {
        this.nilaiOktan = nilaiOktan;
    }

    public boolean isSensorTekananAman() {
        return this.sensorTekananAman;
    }

    public void setSensorTekananAman(boolean sensorTekananAman) {
        this.sensorTekananAman = sensorTekananAman;
    }
}