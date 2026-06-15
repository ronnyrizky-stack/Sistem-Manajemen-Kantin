public class Kantin {
    private String namaKantin;
    private MenuItem[] daftarMenu;
    private int jumlahMenu;
    private int totalOrderSelesai;

    public Kantin(String namaKantin) {
        this.namaKantin = namaKantin;
        this.daftarMenu = new MenuItem[50];
        this.jumlahMenu = 0;
        this.totalOrderSelesai = 0;
    }

    public void tambahMenu(MenuItem item) {
        daftarMenu[jumlahMenu++] = item;
    }

    public void tampilkanMenuTersedia() {
        System.out.println("\n=== Menu Tersedia ===");
        for (int i = 0; i < jumlahMenu; i++) {
            if (daftarMenu[i].isAvailable()) {
                daftarMenu[i].displayInfo();
            }
        }
    }

    public void tampilkanMenuByKategori(String kategori) {
        System.out.println("\n=== Kategori: " + kategori + " ===");
        for (int i = 0; i < jumlahMenu; i++) {
            if (daftarMenu[i].getKategori().equalsIgnoreCase(kategori)) {
                daftarMenu[i].displayInfo();
            }
        }
    }

    public MenuItem cariMenuByNama(String nama) {
        for (int i = 0; i < jumlahMenu; i++) {
            if (daftarMenu[i].getNama().equalsIgnoreCase(nama)) {
                return daftarMenu[i];
            }
        }
        return null;
    }

    public Order buatOrder(String orderId, Customer customer) {
        return new Order(orderId, customer);
    }

    public void selesaikanOrder(Order order) {
        if (order.prosesOrder()) {
            totalOrderSelesai++;
        }
    }

    public void tampilkanRekap() {
        System.out.println("\n=== Rekap Kantin ===");
        System.out.println("Total Order Selesai: " + totalOrderSelesai);
    }
}