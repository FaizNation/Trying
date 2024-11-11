import java.util.ArrayList;
import java.util.Scanner;

class AnggotaKas {
    String nama;
    String statusBayar;

    AnggotaKas(String nama) {
        this.nama = nama;
        this.statusBayar = "Belum Bayar"; // status awal
    }

    public void ubahStatusBayar(String statusBaru) {
        this.statusBayar = statusBaru;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Status Bayar: " + statusBayar;
    }
}

public class DaftarBayarKas {
    public static void main(String[] args) {
        ArrayList<AnggotaKas> daftarAnggota = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Menambahkan beberapa anggota secara manual
        daftarAnggota.add(new AnggotaKas("Aldo"));
        daftarAnggota.add(new AnggotaKas("Bella"));
        daftarAnggota.add(new AnggotaKas("Citra"));

        // Menampilkan daftar anggota dengan status awal
        System.out.println("Daftar Anggota dan Status Pembayaran:");
        for (AnggotaKas anggota : daftarAnggota) {
            System.out.println(anggota);
        }

        // Mengubah status bayar
        System.out.print("\nMasukkan nama anggota yang ingin diubah status pembayarannya: ");
        String namaCari = scanner.nextLine();

        boolean ditemukan = false;
        for (AnggotaKas anggota : daftarAnggota) {
            if (anggota.nama.equalsIgnoreCase(namaCari)) {
                ditemukan = true;
                System.out.print("Masukkan status baru (Sudah Bayar/Belum Bayar): ");
                String statusBayar = scanner.nextLine();
                anggota.ubahStatusBayar(statusBayar);
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Anggota dengan nama " + namaCari + " tidak ditemukan.");
        }

        // Menampilkan daftar anggota setelah perubahan status
        System.out.println("\nDaftar Anggota dan Status Pembayaran Terbaru:");
        for (AnggotaKas anggota : daftarAnggota) {
            System.out.println(anggota);
        }

        scanner.close();
    }
}
