import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Turnamen turnamen = new Turnamen("Kaltim Esport Championship 2026");

    public static void main(String[] args) {
        int pilihan;
        do {
            tampilkanMenu();
            pilihan = bacaPilihan();
            switch (pilihan) {
                case 1:
                    tambahPesertaSolo();
                    break;
                case 2:
                    tambahPesertaTim();
                    break;
                case 3:
                    turnamen.tampilkanSemuaPeserta();
                    break;
                case 4:
                    updateSkorPeserta();
                    break;
                case 5:
                    turnamen.tampilkanKlasemen();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan aplikasi. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        } while (pilihan != 0);

        scanner.close();
    }

    private static void tampilkanMenu() {
        System.out.println("\n=====================================================");
        System.out.println(" APLIKASI MANAJEMEN TURNAMEN ESPORT - " + turnamen.getNamaTurnamen());
        System.out.println("=====================================================");
        System.out.println("1. Daftarkan Peserta Solo");
        System.out.println("2. Daftarkan Peserta Tim");
        System.out.println("3. Tampilkan Semua Peserta");
        System.out.println("4. Update Skor Peserta (hasil pertandingan)");
        System.out.println("5. Tampilkan Klasemen");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    private static int bacaPilihan() {
        try {
            int input = Integer.parseInt(scanner.nextLine().trim());
            return input;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void tambahPesertaSolo() {
        System.out.println("\n-- Pendaftaran Peserta Solo --");
        System.out.print("ID Peserta      : ");
        String id = scanner.nextLine().trim();
        System.out.print("Nama Pemain     : ");
        String nama = scanner.nextLine().trim();
        System.out.print("Gamer Tag       : ");
        String gamerTag = scanner.nextLine().trim();
        System.out.print("Game yang Diikuti: ");
        String game = scanner.nextLine().trim();

        Peserta pesertaBaru = new PesertaSolo(id, nama, game, gamerTag);
        turnamen.daftarkanPeserta(pesertaBaru);
    }

    private static void tambahPesertaTim() {
        System.out.println("\n-- Pendaftaran Peserta Tim --");
        System.out.print("ID Tim          : ");
        String id = scanner.nextLine().trim();
        System.out.print("Nama Tim        : ");
        String nama = scanner.nextLine().trim();
        System.out.print("Nama Kapten     : ");
        String kapten = scanner.nextLine().trim();
        System.out.print("Game yang Diikuti: ");
        String game = scanner.nextLine().trim();

        PesertaTim tim = new PesertaTim(id, nama, game, kapten);

        System.out.print("Jumlah anggota tambahan (selain kapten): ");
        int jumlah = bacaPilihan();
        for (int i = 1; i <= jumlah && jumlah > 0; i++) {
            System.out.print("  Nama anggota ke-" + i + ": ");
            String anggota = scanner.nextLine().trim();
            tim.tambahAnggota(anggota);
        }

        turnamen.daftarkanPeserta(tim);
    }

    private static void updateSkorPeserta() {
        System.out.println("\n-- Update Skor Peserta --");
        System.out.print("Masukkan ID Peserta/Tim: ");
        String id = scanner.nextLine().trim();
        System.out.print("Tambahan poin          : ");
        int poin;
        try {
            poin = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Input poin tidak valid.");
            return;
        }

        boolean berhasil = turnamen.updateSkor(id, poin);
        if (berhasil) {
            System.out.println(">> Skor berhasil diperbarui.");
        } else {
            System.out.println(">> Peserta dengan ID tersebut tidak ditemukan.");
        }
    }
}
