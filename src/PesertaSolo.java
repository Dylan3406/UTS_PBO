/**
 * PesertaSolo.java
 * Subclass dari Peserta (relasi INHERITANCE: "extends Peserta").
 * Merepresentasikan peserta yang bertanding secara perorangan,
 * contoh: pemain PUBG Mobile mode solo, pemain Tekken, dsb.
 */
public class PesertaSolo extends Peserta {
    private String gamerTag; // atribut khusus milik PesertaSolo saja

    public PesertaSolo(String idPeserta, String nama, String gameYangDiikuti, String gamerTag) {
        // "super" memanggil constructor kelas induk (Peserta)
        super(idPeserta, nama, gameYangDiikuti);
        this.gamerTag = gamerTag;
    }

    public String getGamerTag() {
        return gamerTag;
    }

    /**
     * Override method abstrak dari superclass -> contoh POLYMORPHISM.
     * Detail yang ditampilkan berbeda dengan PesertaTim.
     */
    @Override
    public String tampilkanDetail() {
        return "=== Peserta Solo ===\n"
                + "ID          : " + getIdPeserta() + "\n"
                + "Nama        : " + getNama() + "\n"
                + "Gamer Tag   : " + gamerTag + "\n"
                + "Game        : " + getGameYangDiikuti() + "\n"
                + "Poin        : " + getPoin();
    }
}
