public abstract class MesinDispenser {
    public static final String NAMA_SPBU = "SPBU Pertamina 44.531.01 Unsoed";
    private final String kodeDispenser;

    private String jenisBBM;
    private double hargaPerLiter;
    private double stokLiter;
    private boolean mesinAktif;

    public MesinDispenser(String kodeDispenser, String jenisBBM, double hargaPerLiter, double stokLiter) {
        this.kodeDispenser = kodeDispenser;
        this.jenisBBM = jenisBBM;
        this.hargaPerLiter = hargaPerLiter;
        this.stokLiter = stokLiter;
        this.mesinAktif = true;
    }

    public MesinDispenser(String kodeDispenser, String jenisBBM, double hargaPerLiter) {
        this(kodeDispenser, jenisBBM, hargaPerLiter, 500.0);
    }

    public static String formatRupiah(double nominal) {
        return String.format("%,.0f", nominal).replace(',', '.');
    }

    public abstract void salurkanBBM(double jumlahLiter);

    public void tampilkanInfoDispenser() {
        System.out.println("Lokasi SPBU     : " + NAMA_SPBU);
        System.out.println("Kode Dispenser  : " + this.kodeDispenser);
        System.out.println("Jenis BBM       : " + this.jenisBBM);
        System.out.println("Harga / Liter   : Rp " + formatRupiah(this.hargaPerLiter));
        System.out.println("Sisa Stok Tangki: " + this.stokLiter + " Liter");
        System.out.println("Status Mesin    : " + (this.mesinAktif ? "AKTIF (Siap Pakai)" : "NONAKTIF (Terkunci)"));
    }

    public double hitungEstimasiNilaiTangki() {
        return this.stokLiter * this.hargaPerLiter;
    }

    public String getKodeDispenser() {
        return this.kodeDispenser;
    }

    public String getJenisBBM() {
        return this.jenisBBM;
    }

    public void setJenisBBM(String jenisBBM) {
        this.jenisBBM = jenisBBM;
    }

    public double getHargaPerLiter() {
        return this.hargaPerLiter;
    }

    public void setHargaPerLiter(double hargaPerLiter) {
        if (hargaPerLiter > 0) {
            this.hargaPerLiter = hargaPerLiter;
        }
    }

    public double getStokLiter() {
        return this.stokLiter;
    }

    public void setStokLiter(double stokLiter) {
        if (stokLiter >= 0) {
            this.stokLiter = stokLiter;
        }
    }

    public boolean isMesinAktif() {
        return this.mesinAktif;
    }

    public void setMesinAktif(boolean mesinAktif) {
        this.mesinAktif = mesinAktif;
    }
}