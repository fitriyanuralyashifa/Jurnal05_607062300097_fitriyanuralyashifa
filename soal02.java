import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class soal02 {
    public static void main(String[] args) {
        Queue<String> toDoList = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Tambah Pekerjaan");
            System.out.println("2. Lihat Pekerjaan Pertama");
            System.out.println("3. Selesaikan Pekerjaan");
            System.out.println("4. Lihat Semua Pekerjaan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama pekerjaan: ");
                    String pekerjaan = scanner.nextLine();
                    toDoList.add(pekerjaan);
                    break;
                case 2:
                    System.out.println("Pekerjaan pertama: " + (toDoList.peek() != null ? toDoList.peek() : "Tidak ada pekerjaan"));
                    break;
                case 3:
                    System.out.println("Selesaikan pekerjaan: " + (toDoList.poll() != null ? "Pekerjaan selesai" : "Tidak ada pekerjaan"));
                    break;
                case 4:
                    System.out.println("Daftar Pekerjaan:");
                    for (String p : toDoList) {
                        System.out.println(p);
                    }
                    break;
                case 5:
                    System.out.println("Keluar");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (choice != 5);
        scanner.close();
    }
}
