public class Main {
    public static void main(String[] args) {

        // 1. Kantin
        Kantin kantin = new Kantin("Kantin Fasilkom GarudaEats");

        // 2. Menu
        MenuItem m1 = new MenuItem("Nasi Goreng", 15000, "Makanan", 5);
        MenuItem m2 = new MenuItem("Ayam Geprek", 18000, "Makanan", 5);
        MenuItem m3 = new MenuItem("Es Teh", 5000, "Minuman", 5);
        MenuItem m4 = new MenuItem("Kopi", 8000, "Minuman", 5);
        MenuItem m5 = new MenuItem("Kentang Goreng", 10000, "Snack", 5);
        MenuItem m6 = new MenuItem("Keripik", 7000, "Snack", 5);

        kantin.tambahMenu(m1);
        kantin.tambahMenu(m2);
        kantin.tambahMenu(m3);
        kantin.tambahMenu(m4);
        kantin.tambahMenu(m5);
        kantin.tambahMenu(m6);

        // 3. Customer
        Customer c1 = new Customer("Budi Santoso", "001", 50000);
        Customer c2 = new Customer("Siti Aminah", "002");
        c2.topUpSaldo(15000);

        // 4. Tampilkan Menu
        kantin.tampilkanMenuTersedia();
        kantin.tampilkanMenuByKategori("Minuman");

        // 5. Cari Menu
        System.out.println("\nCari Kopi:");
        MenuItem cari = kantin.cariMenuByNama("Kopi");
        if (cari != null) cari.displayInfo();

        // 6. Order 1 (Sukses)
        Order o1 = kantin.buatOrder("ORD-001", c1);
        o1.tambahItem(m1);
        o1.tambahItem(m3);
        kantin.selesaikanOrder(o1);
        o1.displayOrder();

        // Order 2 (Gagal)
        Order o2 = kantin.buatOrder("ORD-002", c2);
        o2.tambahItem(m2);
        o2.tambahItem(m4);
        kantin.selesaikanOrder(o2);
        o2.displayOrder();

        // Order 3 (Batal)
        Order o3 = kantin.buatOrder("ORD-003", c1);
        o3.tambahItem(m5);
        o3.batalkanOrder();
        o3.displayOrder();

        // 7. Rekap
        kantin.tampilkanRekap();

        System.out.println("\n=== Data Customer ===");
        c1.displayInfo();
        c2.displayInfo();
    }
}