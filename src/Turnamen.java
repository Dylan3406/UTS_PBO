import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Turnamen {
    private String namaTurnamen;
    private List<Peserta> daftarPeserta;

    public Turnamen(String namaTurnamen) {
        this.namaTurnamen = namaTurnamen;
        this.daftarPeserta = new ArrayList<>();
    }

    public String getNamaTurnamen() {
        return namaTurnamen;
    }

    public void daftarkanPeserta(Peserta peserta) {
        daftarPeserta.add(peserta);
        System.out.println(">> Peserta \"" + peserta.getNama() + "\" berhasil didaftarkan.");
    }

    public List<Peserta> getDaftarPeserta() {
        return daftarPeserta;
    }

    public Peserta cariPesertaById(String id) {
        for (Peserta p : daftarPeserta) {
            if (p.getIdPeserta().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    public void tampilkanSemuaPeserta() {
        if (daftarPeserta.isEmpty()) {
            System.out.println("Belum ada peserta terdaftar.");
            return;
        }
        System.out.println("\n===== DAFTAR PESERTA TURNAMEN: " + namaTurnamen + " =====");
        for (Peserta p : daftarPeserta) {
            // p.tampilkanDetail() akan memanggil versi override sesuai jenis objeknya
            // (PesertaSolo atau PesertaTim) -> ini contoh nyata polymorphism saat runtime.
            System.out.println("-----------------------------------");
            System.out.println(p.tampilkanDetail());
        }
        System.out.println("-----------------------------------");
    }

    public boolean updateSkor(String id, int tambahanPoin) {
        Peserta p = cariPesertaById(id);
        if (p == null) {
            return false;
        }
        p.tambahPoin(tambahanPoin);
        return true;
    }

    public void tampilkanKlasemen() {
        if (daftarPeserta.isEmpty()) {
            System.out.println("Belum ada peserta untuk ditampilkan di klasemen.");
            return;
        }
        List<Peserta> urut = new ArrayList<>(daftarPeserta);
        urut.sort(Comparator.comparingInt(Peserta::getPoin).reversed());

        System.out.println("\n===== KLASEMEN TURNAMEN: " + namaTurnamen + " =====");
        int peringkat = 1;
        for (Peserta p : urut) {
            System.out.println(peringkat + ". " + p.infoRingkas());
            peringkat++;
        }
    }
}
