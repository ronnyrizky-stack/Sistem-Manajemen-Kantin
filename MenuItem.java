public class MenuItem {
    private String nama;
    private double harga;
    private String kategori;
    private int stok;

    // Constructor 1
    public MenuItem(String nama, double harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
        this.stok = 0;
    }

    // Constructor 2
    public MenuItem(String nama, double harga, String kategori, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
        this.stok = stok;
    }

    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public String getKategori() { return kategori; }
    public int getStok() { return stok; }

    public void setHarga(double hargaBaru) {
        this.harga = hargaBaru;
    }

    public void tambahStok(int jumlah) {
        stok += jumlah;
    }

    public boolean kurangiStok() {
        if (stok > 0) {
            stok--;
            return true;
        }
        return false;
    }

    public boolean isAvailable() {
        return stok > 0;
    }

    public void displayInfo() {
        System.out.println(nama + " | Rp" + harga + " | " + kategori + " | Stok: " + stok);
    }
}