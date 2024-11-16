import java.util.ArrayList;
import java.util.Scanner;

public class AdminCashManagementApp {
    public static void main(String[] args) {
        ArrayList<String> namaSiswa = new ArrayList<>();
        ArrayList<Double> kasSiswa = new ArrayList<>();
        ArrayList<String> alasanPengeluaran = new ArrayList<>();
        ArrayList<Double> pengeluaranKas = new ArrayList<>();
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        double totalKas = 0;
        double totalPemasukan = 0;
        double totalPengeluaran = 0;

        // Halaman Utama Admin
        while (running) {
            System.out.println("\n|==============================================|");
            System.out.println("|>>               Halaman Admin              <<|");
            System.out.println("|==============================================|");
            System.out.printf("| %-2s | %-39s |\n", "1", "AKUN");
            System.out.printf("| %-2s | %-39s |\n", "2", "MANAJEMEN DATA");
            System.out.printf("| %-2s | %-39s |\n", "3", "LAPORAN");
            System.out.printf("| %-2s | %-39s |\n", "4", "Keluar");
            System.out.println("|==============================================|");
            System.out.print("Pilih menu: ");
            int pilihanMenuUtama = scanner.nextInt();

            // Switch menu utama
            switch (pilihanMenuUtama) {

                // AKUN
                case 1 -> {
                    boolean akunRunning = true;
                    while (akunRunning) {
                        System.out.println("\n|==============================================|");
                        System.out.println("|>>                 AKUN                     <<|");
                        System.out.println("|==============================================|");
                        System.out.printf("| %-2s | %-39s |\n", "1", "Perbarui Profil");
                        System.out.printf("| %-2s | %-39s |\n", "2", "Ubah Password");
                        System.out.printf("| %-2s | %-39s |\n", "3", "Kembali");
                        System.out.println("|==============================================|");
                        System.out.print("Pilih menu akun: ");
                        int pilihanAkun = scanner.nextInt();
                        scanner.nextLine(); // Membersihkan input buffer

                        // Switch untuk submenu akun
                        switch (pilihanAkun) {
                            case 1 -> {
                                // Fitur untuk perbarui profil
                                System.out.println("Perbarui Profil");
                                System.out.print("Masukkan nama baru: ");
                                String namaBaru = scanner.nextLine();
                                System.out.println("Profil diperbarui menjadi: " + namaBaru);
                            }
                            case 2 -> {
                                // Fitur untuk ubah password
                                System.out.println("Ubah Password");
                                System.out.print("Masukkan password baru: ");
                                String passwordBaru = scanner.nextLine();
                                System.out.println("Password berhasil diubah.");
                            }
                            case 3 -> {
                                // Kembali ke menu utama
                                akunRunning = false;
                            }
                            default -> {
                                System.out.println("Pilihan tidak valid, coba lagi.");
                            }
                        }
                    }
                }

                // MANAJEMEN DATA
                case 2 -> {
                    boolean manajemenDataRunning = true;
                    while (manajemenDataRunning) {
                        System.out.println("\n|==============================================|");
                        System.out.println("|>>             MANAJEMEN DATA               <<|");
                        System.out.println("|==============================================|");
                        System.out.printf("| %-2s | %-39s |\n", "1", "Data User");
                        System.out.printf("| %-2s | %-39s |\n", "2", "Data Kelas");
                        System.out.printf("| %-2s | %-39s |\n", "3", "Data Siswa");
                        System.out.printf("| %-2s | %-39s |\n", "4", "Data Uang Kas");
                        System.out.printf("| %-2s | %-39s |\n", "5", "Data Kas Masuk");
                        System.out.printf("| %-2s | %-39s |\n", "6", "Data Kas Keluar");
                        System.out.printf("| %-2s | %-39s |\n", "7", "Kembali");
                        System.out.println("|==============================================|");
                        System.out.print("Pilih menu manajemen data: ");
                        int pilihanManajemenData = scanner.nextInt();

                        // Switch untuk submenu manajemen data
                        switch (pilihanManajemenData) {
                            case 1 -> {
                                System.out.println("Data User");
                                // Implementasi untuk mengelola data user
                            }
                            case 2 -> {
                                System.out.println("Data Kelas");
                                // Implementasi untuk mengelola data kelas
                            }
                            case 3 -> {
                                // Data Siswa (berhubungan dengan data yang sudah ada)
                                if (namaSiswa.isEmpty()) {
                                    System.out.println("Belum ada data siswa.");
                                } else {
                                    System.out.println("\nDaftar Siswa:");
                                    for (int i = 0; i < namaSiswa.size(); i++) {
                                        System.out.printf("%d. %s - Kas: Rp %.2f\n", (i + 1), namaSiswa.get(i), kasSiswa.get(i));
                                    }
                                }
                            }
                            case 4 -> {
                                System.out.println("Data Uang Kas");
                                // Implementasi untuk mengelola data uang kas
                            }
                            case 5 -> {
                                System.out.println("Data Kas Masuk");
                                // Implementasi untuk menampilkan kas masuk
                            }
                            case 6 -> {
                                System.out.println("Data Kas Keluar");
                                // Implementasi untuk menampilkan kas keluar
                            }
                            case 7 -> {
                                // Kembali ke menu utama
                                manajemenDataRunning = false;
                            }
                            default -> {
                                System.out.println("Pilihan tidak valid, coba lagi.");
                            }
                        }
                    }
                }

                // LAPORAN
                case 3 -> {
                    boolean laporanRunning = true;
                    while (laporanRunning) {
                        System.out.println("\n|==============================================|");
                        System.out.println("|>>                LAPORAN                   <<|");
                        System.out.println("|==============================================|");
                        System.out.printf("| %-2s | %-39s |\n", "1", "Laporan Kas");
                        System.out.printf("| %-2s | %-39s |\n", "2", "Kembali");
                        System.out.println("|==============================================|");
                        System.out.print("Pilih menu laporan: ");
                        int pilihanLaporan = scanner.nextInt();

                        // Switch untuk submenu laporan
                        switch (pilihanLaporan) {
                            case 1 -> {
                                // Fitur Laporan Kas
                                System.out.println("Laporan Kas");
                                // Implementasi untuk menampilkan laporan kas
                            }
                            case 2 -> {
                                // Kembali ke menu utama
                                laporanRunning = false;
                            }
                            default -> {
                                System.out.println("Pilihan tidak valid, coba lagi.");
                            }
                        }
                    }
                }

                // Keluar dari aplikasi
                case 4 -> {
                    System.out.println("Keluar dari aplikasi. Terima kasih!");
                    running = false;
                }

                // Pilihan tidak valid
                default -> {
                    System.out.println("Pilihan tidak valid, coba lagi.");
                }
            }
        }

        scanner.close();
    }
}
