public class Customer {
    private String nama;
    private String nim;
    private double saldo;
    private int poin;

    // Constructor 1
    public Customer(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
        this.saldo = 0;
        this.poin = 0;
    }

    // Constructor 2
    public Customer(String nama, String nim, double saldoAwal) {
        this.nama = nama;
        this.nim = nim;
        this.saldo = saldoAwal;
        this.poin = 0;
    }

    public String getNama() { return nama; }
    public String getNim() { return nim; }
    public double getSaldo() { return saldo; }
    public int getPoin() { return poin; }

    public void topUpSaldo(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("Top up gagal!");
            return;
        }
        saldo += jumlah;
    }

    public boolean bayar(double jumlah) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
            return true;
        }
        System.out.println("Saldo tidak cukup");
        return false;
    }

    public void tambahPoin(int poin) {
        this.poin += poin;
    }

    public void displayInfo() {
        System.out.println(nama + " (" + nim + ") | Saldo: Rp" + saldo + " | Poin: " + poin);
    }
}