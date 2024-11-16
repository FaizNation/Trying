import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ClassCashManagementApp {
    public static void main(String[] args) {

        // Nama aplikasi
        System.out.println("|==============================================|");
        System.out.println("|>>>                                        <<<|");
        System.out.println("|>>       Aplikasi Pendataan Kas Kelas       <<|");
        System.out.println("|>>>                                        <<<|");
        System.out.println("|==============================================|");

        // Deklarasi variabel
        ArrayList<String> namaSiswa = new ArrayList<>();
        ArrayList<Double> kasSiswa = new ArrayList<>();
        ArrayList<String> alasanPengeluaran = new ArrayList<>();
        ArrayList<Double> pengeluaranKas = new ArrayList<>();
        boolean running = true;
        try (Scanner scanner = new Scanner(System.in)) {
            double totalKas = 0;
            double totalPemasukan = 0;
            double totalPengeluaran = 0;

            // Looping aplikasi (while)
            while (running) {

                // Tampilkan menu utama dalam format
                System.out.println("\n|==============================================|");
                System.out.println("|>>               Menu Utama                 <<|");
                System.out.println("|==============================================|");
                System.out.printf("| %-2s | %-39s |\n", "1", "Tambah data siswa");
                System.out.println("|----------------------------------------------|");
                System.out.printf("| %-2s | %-39s |\n", "2", "Tambah kas pada siswa yang sama");
                System.out.println("|----------------------------------------------|");
                System.out.printf("| %-2s | %-39s |\n", "3", "Pengeluaran kas");
                System.out.println("|----------------------------------------------|");
                System.out.printf("| %-2s | %-39s |\n", "4", "Tampilkan rekap kas");
                System.out.println("|----------------------------------------------|");
                System.out.printf("| %-2s | %-39s |\n", "5", "Hapus data siswa");
                System.out.println("|----------------------------------------------|");
                System.out.printf("| %-2s | %-39s |\n", "6", "Edit nama siswa");
                System.out.println("|----------------------------------------------|");
                System.out.printf("| %-2s | %-39s |\n", "7", "Manipulasi String");
                System.out.println("|----------------------------------------------|");
                System.out.printf("| %-2s | %-39s |\n", "8", "Tampilkan total kas");
                System.out.println("|----------------------------------------------|");
                System.out.printf("| %-2s | %-39s |\n", "9", "Keluar");
                System.out.println("|==============================================|");
                System.out.print("Pilih menu: ");
                int pilihan = scanner.nextInt();

                // Pilihan menu menggunakan switch case
                switch (pilihan) {

                    // Tambah data siswa
                    case 1 -> {
                        System.out.print("Masukkan nama siswa: ");
                        scanner.nextLine();
                        String nama = scanner.nextLine().trim();

                        // Validasi nama tidak kosong dan tidak mengandung angka
                        if (nama.isEmpty() || nama.matches(".*\\d.*")) {
                            System.out.println("Nama tidak boleh kosong atau mengandung angka. Coba lagi.");
                            break;
                        }

                        // Manipulasi string
                        System.out.println("Nama disimpan dengan huruf kapital: " + nama.toUpperCase());
                        System.out.print("Masukkan jumlah kas " + nama.toUpperCase() + ": ");
                        double kas = scanner.nextDouble();

                        // Tambahkan data ke ArrayList
                        namaSiswa.add(nama.toUpperCase());
                        kasSiswa.add(kas);
                        totalKas += kas; // Tambahkan ke total kas
                        totalPemasukan += kas; // Tambahkan ke total pemasukan
                        System.out.println("Data berhasil ditambahkan!");
                    }

                    // Tambah kas pada siswa yang sama
                    case 2 -> {
                        if (namaSiswa.isEmpty()) {
                            System.out.println("Belum ada data siswa.");
                        } else {
                            System.out.println("\nDaftar Siswa:");
                            for (int i = 0; i < namaSiswa.size(); i++) {
                                System.out.printf("%d. %s - Kas: Rp %.2f\n", (i + 1), namaSiswa.get(i), kasSiswa.get(i));
                            }

                            System.out.print("Masukkan nomor siswa yang ingin menambah kas: ");
                            int nomorSiswa = scanner.nextInt();

                            if (nomorSiswa > 0 && nomorSiswa <= namaSiswa.size()) {
                                System.out.print("Masukkan jumlah kas tambahan: ");
                                double tambahanKas = scanner.nextDouble();

                                // Tambahkan kas pada siswa yang dipilih
                                kasSiswa.set(nomorSiswa - 1, kasSiswa.get(nomorSiswa - 1) + tambahanKas);
                                totalKas += tambahanKas; // Tambahkan ke total kas
                                totalPemasukan += tambahanKas; // Tambahkan ke total pemasukan
                                System.out.println("Kas berhasil ditambahkan untuk siswa " + namaSiswa.get(nomorSiswa - 1) + ".");
                            } else {
                                System.out.println("Nomor siswa tidak valid.");
                            }
                        }
                    }

                    // Pengeluaran kas
                    case 3 -> {
                        System.out.print("Masukkan jumlah pengeluaran kas: ");
                        double pengeluaranKasAmount = scanner.nextDouble();
                        scanner.nextLine();
                        
                        System.out.print("Masukkan keterangan pengeluaran: ");
                        String keteranganPengeluaran = scanner.nextLine();

                        if (pengeluaranKasAmount <= totalKas) {
                            // Kurangi total kas
                            totalKas -= pengeluaranKasAmount;
                            totalPengeluaran += pengeluaranKasAmount; // Tambahkan ke total pengeluaran
                            pengeluaranKas.add(pengeluaranKasAmount);
                            alasanPengeluaran.add(keteranganPengeluaran);
                            System.out.println("Pengeluaran sebesar Rp " + pengeluaranKasAmount + " berhasil dicatat.");
                            System.out.println("Keterangan: " + keteranganPengeluaran);
                            System.out.println("Total kas sekarang: Rp " + totalKas);
                        } else {
                            System.out.println("Total kas tidak mencukupi untuk pengeluaran sebesar itu.");
                        }
                    }

                    // Tampilkan rekap kas
                    case 4 -> {
                        if (namaSiswa.isEmpty()) {
                            System.out.println("Belum ada data siswa.");
                        } else {
                            System.out.println("|==========================================================================|");
                            System.out.println("|    |            PEMASUKAN               |            PENGELUARAN         |");
                            System.out.println("|==========================================================================|");
                            System.out.println("| NO | NAMA SISWA          |    JUMLAH    | KETERANGAN        |   JUMLAH   |");
                            System.out.println("|----|---------------------|--------------|-------------------|------------|");
                            
                            // Tampilkan Pemasukan
                            for (int i = 0; i < namaSiswa.size(); i++) {
                                // Format untuk nama dan kas
                                System.out.printf("| %-2d | %-19s | %-12.2f | %-17s | %-10s |\n", 
                                                  (i + 1), 
                                                  namaSiswa.get(i), 
                                                  kasSiswa.get(i), 
                                                  "", 
                                                  "");
                            }
                            System.out.println("|----|---------------------|--------------|-------------------|------------|");
                            // Tampilkan Pengeluaran
                            for (int i = 0; i < alasanPengeluaran.size(); i++) {
                                // Format untuk pengeluaran
                                System.out.printf("| %-2s | %-19s | %-12s | %-17s | %-10.2f |\n", 
                                (i + 1), 
                                                  "", 
                                                  "", 
                                                  alasanPengeluaran.get(i), 
                                                  pengeluaranKas.get(i));
                            }

                            System.out.println("|----|---------------------|--------------|-------------------|------------|");
                            System.out.printf("| %-24s | %-45.2f |\n", "TOTAL PEMASUKAN:", totalPemasukan);
                            System.out.printf("| %-24s | %-45.2f |\n", "TOTAL PENGELUARAN:", totalPengeluaran);
                            System.out.println("|--------------------------|-----------------------------------------------|");
                            System.out.printf("| %-24s | %-45.2f |\n", "JUMLAH KAS SEKARANG:", totalKas);
                            System.out.println("|==========================================================================|");
                        }
                    }

                    // Hapus data siswa (menghapus siswa sepenuhnya)
                    case 5 -> {

                        if (namaSiswa.isEmpty()) {
                            System.out.println("Belum ada data siswa untuk dihapus.");
                        } else {
                            System.out.println("\nDaftar Siswa:");
                            for (int i = 0; i < namaSiswa.size(); i++) {
                                System.out.printf("%d. %s - Kas: Rp %.2f\n", (i + 1), namaSiswa.get(i), kasSiswa.get(i));
                            }

                            System.out.print("Masukkan nomor siswa yang ingin dihapus: ");
                            int nomorSiswa = scanner.nextInt();

                            if (nomorSiswa > 0 && nomorSiswa <= namaSiswa.size()) {
                                // Kurangi total kas
                                totalKas -= kasSiswa.get(nomorSiswa - 1);
                                totalPemasukan -= kasSiswa.get(nomorSiswa - 1);

                                // Hapus data siswa
                                System.out.println("Data siswa " + namaSiswa.get(nomorSiswa - 1) + " berhasil dihapus.");
                                namaSiswa.remove(nomorSiswa - 1);
                                kasSiswa.remove(nomorSiswa - 1);
                            } else {
                                System.out.println("Nomor siswa tidak valid.");
                            }
                        }
                    }

                    // Edit nama siswa
                    case 6 -> {
                        if (namaSiswa.isEmpty()) {
                            System.out.println("Belum ada data siswa.");
                        } else {
                            System.out.println("\nDaftar Siswa:");
                            for (int i = 0; i < namaSiswa.size(); i++) {
                                System.out.printf("%d. %s - Kas: Rp %.2f\n", (i + 1), namaSiswa.get(i), kasSiswa.get(i));
                            }

                            System.out.print("Masukkan nomor siswa yang ingin diedit namanya: ");
                            int nomorSiswa = scanner.nextInt();
                            scanner.nextLine(); // Membersihkan input buffer

                            if (nomorSiswa > 0 && nomorSiswa <= namaSiswa.size()) {
                                System.out.print("Masukkan nama baru untuk siswa: ");
                                String namaBaru = scanner.nextLine().trim();

                                // Validasi nama tidak kosong dan tidak mengandung angka
                                if (namaBaru.isEmpty() || namaBaru.matches(".*\\d.*")) {
                                    System.out.println("Nama tidak boleh kosong atau mengandung angka. Coba lagi.");
                                    break;
                                }

                                // Edit nama siswa
                                namaSiswa.set(nomorSiswa - 1, namaBaru.toUpperCase());
                                System.out.println("Nama siswa berhasil diubah menjadi " + namaBaru.toUpperCase() + ".");
                            } else {
                                System.out.println("Nomor siswa tidak valid.");
                            }
                        }
                    }

                    // Manipulasi String Submenu
                    case 7 -> {
                        boolean manipulasiStringRunning = true;

                        while (manipulasiStringRunning) {
                            System.out.println("\n|==============================================|");
                            System.out.println("|>>           Submenu Manipulasi String      <<|");
                            System.out.println("|==============================================|");
                            System.out.printf("| %-2s | %-39s |\n", "1", "Cari siswa berdasarkan nama");
                            System.out.println("|----------------------------------------------|");
                            System.out.printf("| %-2s | %-39s |\n", "2", "Urutkan nama siswa (A-Z)");
                            System.out.println("|----------------------------------------------|");
                            System.out.printf("| %-2s | %-39s |\n", "3", "Statistik panjang nama siswa");
                            System.out.println("|----------------------------------------------|");
                            System.out.printf("| %-2s | %-39s |\n", "4", "Tampilkan nama terbalik");
                            System.out.println("|----------------------------------------------|");
                            System.out.printf("| %-2s | %-39s |\n", "5", "Kembali ke menu utama");
                            System.out.println("|==============================================|");
                            System.out.print("Pilih menu manipulasi string: ");
                            int pilihanString = scanner.nextInt();

                            switch (pilihanString) {
                                // Cari siswa berdasarkan nama
                                case 1 -> {
                                    scanner.nextLine(); // Membersihkan input buffer
                                    System.out.print("Masukkan nama siswa yang ingin dicari: ");
                                    String cariNama = scanner.nextLine().trim().toUpperCase();

                                    boolean ditemukan = false;
                                    for (String nama : namaSiswa) {
                                        if (nama.contains(cariNama)) {
                                            System.out.println("Ditemukan siswa: " + nama);
                                            ditemukan = true;
                                        }
                                    }

                                    if (!ditemukan) {
                                        System.out.println("Nama siswa tidak ditemukan.");
                                    }
                                }

                                // Urutkan nama siswa (A-Z)
                                case 2 -> {
                                    if (namaSiswa.isEmpty()) {
                                        System.out.println("Belum ada data siswa.");
                                    } else {
                                        Collections.sort(namaSiswa);
                                        System.out.println("Nama siswa berhasil diurutkan (A-Z):");
                                        for (String nama : namaSiswa) {
                                            System.out.println(nama);
                                        }
                                    }
                                }

                                // Statistik panjang nama siswa
                                case 3 -> {
                                    if (namaSiswa.isEmpty()) {
                                        System.out.println("Belum ada data siswa.");
                                    } else {
                                        System.out.println("Statistik panjang nama siswa:");
                                        for (String nama : namaSiswa) {
                                            System.out.println(nama + " - Panjang: " + nama.length() + " karakter");
                                        }
                                    }
                                }

                                // Tampilkan nama terbalik
                                case 4 -> {
                                    if (namaSiswa.isEmpty()) {
                                        System.out.println("Belum ada data siswa.");
                                    } else {
                                        System.out.println("Nama siswa dalam urutan terbalik:");
                                        for (String nama : namaSiswa) {
                                            StringBuilder sb = new StringBuilder(nama);
                                            System.out.println(sb.reverse().toString());
                                        }
                                    }
                                }

                                // Kembali ke menu utama
                                case 5 -> {
                                    manipulasiStringRunning = false;
                                }

                                // Pilihan tidak valid
                                default -> {
                                    System.out.println("Pilihan tidak valid, coba lagi.");
                                }
                            }
                        }
                    }

                    // Tampilkan total kas
                    case 8 -> {
                        System.out.println("Total kas saat ini adalah: Rp " + totalKas);
                    }

                    // Keluar
                    case 9 -> {
                        System.out.println("Terima kasih telah menggunakan aplikasi ini!");
                        running = false;
                    }

                    // Pilihan tidak valid
                    default -> {
                        System.out.println("Pilihan tidak valid, coba lagi.");
                    }
                }
            }
        }
    }
}
