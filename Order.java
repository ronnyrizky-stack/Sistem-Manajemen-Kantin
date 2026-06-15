public class Order {
    private String orderId;
    private Customer customer;
    private MenuItem[] items;
    private int jumlahItem;
    private String status;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new MenuItem[10];
        this.jumlahItem = 0;
        this.status = "MENUNGGU";
    }

    public String getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public String getStatus() { return status; }
    public int getJumlahItem() { return jumlahItem; }

    public boolean tambahItem(MenuItem item) {
        if (!status.equals("MENUNGGU")) {
            System.out.println("Order tidak bisa diubah");
            return false;
        }
        if (jumlahItem >= 10) {
            System.out.println("Keranjang penuh");
            return false;
        }
        if (!item.isAvailable()) {
            System.out.println("Stok habis");
            return false;
        }

        items[jumlahItem++] = item;
        return true;
    }

    public double hitungTotal() {
        double total = 0;
        for (int i = 0; i < jumlahItem; i++) {
            total += items[i].getHarga();
        }
        return total;
    }

    public boolean prosesOrder() {
        double total = hitungTotal();

        if (!customer.bayar(total)) {
            return false;
        }

        for (int i = 0; i < jumlahItem; i++) {
            items[i].kurangiStok();
        }

        customer.tambahPoin(jumlahItem);
        status = "SELESAI";
        return true;
    }

    public void batalkanOrder() {
        if (status.equals("SELESAI")) {
            System.out.println("Tidak bisa dibatalkan");
        } else {
            status = "DIBATALKAN";
        }
    }

    public void displayOrder() {
        System.out.println("\nID: " + orderId);
        System.out.println("Customer: " + customer.getNama());

        for (int i = 0; i < jumlahItem; i++) {
            System.out.println("- " + items[i].getNama() + " : Rp" + items[i].getHarga());
        }

        System.out.println("Total: Rp" + hitungTotal());
        System.out.println("Status: " + status);
    }
}