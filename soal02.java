import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        // Membuat objek Queue menggunakan ArrayDeque untuk menyimpan daftar pekerjaan
        Queue<String> toDoList = new ArrayDeque<>();
        // Membuat objek Scanner untuk membaca input dari pengguna
        Scanner scanner = new Scanner(System.in);
        // Variabel untuk menyimpan pilihan menu dari pengguna
        int choice;

        // Loop untuk menampilkan menu dan memproses pilihan pengguna
        do {
            // Menampilkan menu
            System.out.println("1. Tambah Pekerjaan");
            System.out.println("2. Lihat Pekerjaan Pertama");
            System.out.println("3. Selesaikan Pekerjaan");
            System.out.println("4. Lihat Semua Pekerjaan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            // Membaca pilihan menu dari pengguna
            choice = scanner.nextInt();
            // Mengonsumsi newline yang tersisa setelah nextInt()
            scanner.nextLine();

            // Memproses pilihan pengguna menggunakan switch-case
            switch (choice) {
                case 1:
                    // Jika pilihan adalah 1, tambahkan pekerjaan baru ke dalam queue
                    System.out.print("Masukkan nama pekerjaan: ");
                    String pekerjaan = scanner.nextLine();
                    toDoList.add(pekerjaan);
                    break;
                case 2:
                    // Jika pilihan adalah 2, tampilkan pekerjaan pertama dalam queue
                    System.out.println("Pekerjaan pertama: " + (toDoList.peek() != null ? toDoList.peek() : "Tidak ada pekerjaan"));
                    break;
                case 3:
                    // Jika pilihan adalah 3, hapus pekerjaan pertama dari queue
                    System.out.println("Selesaikan pekerjaan: " + (toDoList.poll() != null ? "Pekerjaan selesai" : "Tidak ada pekerjaan"));
                    break;
                case 4:
                    // Jika pilihan adalah 4, tampilkan semua pekerjaan dalam queue
                    System.out.println("Daftar Pekerjaan:");
                    for (String p : toDoList) {
                        System.out.println(p);
                    }
                    break;
                case 5:
                    // Jika pilihan adalah 5, keluar dari program
                    System.out.println("Keluar");
                    break;
                default:
                    // Jika pilihan tidak valid, tampilkan pesan kesalahan
                    System.out.println("Pilihan tidak valid");
            }
        } while (choice != 5); // Loop terus berjalan hingga pilihan adalah 5 (keluar)

        // Menutup Scanner untuk menghindari kebocoran sumber daya
        scanner.close();
    }
}
```

**Penjelasan Langkah-langkah Program:**

1. **Import Libraries:**
   - `ArrayDeque` dan `Queue` digunakan untuk membuat queue.
   - `Scanner` digunakan untuk membaca input dari pengguna.

2. **Inisialisasi Objek:**
   - Membuat objek `Queue` bernama `toDoList` menggunakan `ArrayDeque`.
   - Membuat objek `Scanner` untuk membaca input dari pengguna.

3. **Menampilkan Menu:**
   - Program menampilkan menu untuk menambahkan, melihat, menyelesaikan, dan menampilkan pekerjaan, serta keluar dari program.

4. **Membaca Pilihan Pengguna:**
   - Program membaca pilihan pengguna menggunakan `scanner.nextInt()` dan mengonsumsi newline yang tersisa dengan `scanner.nextLine()`.

5. **Memproses Pilihan Pengguna:**
   - **Tambah Pekerjaan:** Menambahkan pekerjaan baru ke dalam queue menggunakan `toDoList.add(pekerjaan)`.
   - **Lihat Pekerjaan Pertama:** Menampilkan pekerjaan pertama dalam queue menggunakan `toDoList.peek()`.
   - **Selesaikan Pekerjaan:** Menghapus pekerjaan pertama dari queue menggunakan `toDoList.poll()`.
   - **Lihat Semua Pekerjaan:** Menampilkan semua pekerjaan dalam queue dengan iterasi menggunakan `for` loop.
   - **Keluar:** Menghentikan program.

6. **Penanganan Pilihan Tidak Valid:**
   - Jika pilihan pengguna tidak valid, program menampilkan pesan kesalahan.

7. **Penutupan Scanner:**
   - Setelah loop selesai, `scanner.close()` dipanggil untuk menutup `Scanner` dan menghindari kebocoran sumber daya.
