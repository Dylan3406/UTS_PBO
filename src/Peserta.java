/**
 * Peserta.java
 * Superclass (kelas induk) yang bersifat abstrak.
 * Merepresentasikan peserta turnamen esport secara umum.
 * Kelas ini menjadi dasar relasi INHERITANCE untuk PesertaSolo dan PesertaTim.
 */
public abstract class Peserta {
    // Encapsulation: seluruh field bersifat private
    private String idPeserta;
    private String nama;
    private String gameYangDiikuti;
    private int poin;

    public Peserta(String idPeserta, String nama, String gameYangDiikuti) {
        this.idPeserta = idPeserta;
        this.nama = nama;
        this.gameYangDiikuti = gameYangDiikuti;
        this.poin = 0; // poin awal selalu 0 saat peserta baru mendaftar
    }

    // ===== Getter & Setter (Encapsulation) =====
    public String getIdPeserta() {
        return idPeserta;
    }

    public String getNama() {
        return nama;
    }

    public String getGameYangDiikuti() {
        return gameYangDiikuti;
    }

    public int getPoin() {
        return poin;
    }

    public void tambahPoin(int nilai) {
        if (nilai > 0) {
            this.poin += nilai;
        }
    }

    /**
     * Method abstrak: WAJIB diimplementasikan berbeda oleh setiap subclass.
     * Inilah bentuk POLYMORPHISM (method overriding) dalam program ini.
     */
    public abstract String tampilkanDetail();

    /**
     * Method biasa yang bisa dipakai bersama (diwariskan) oleh semua subclass
     * tanpa perlu ditulis ulang -> contoh nyata manfaat inheritance.
     */
    public String infoRingkas() {
        return String.format("[%s] %s | Game: %s | Poin: %d",
                idPeserta, nama, gameYangDiikuti, poin);
    }
}
