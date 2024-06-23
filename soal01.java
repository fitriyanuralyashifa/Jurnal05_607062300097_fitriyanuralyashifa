import java.util.Stack;

public class soal01 {

    public static void main(String[] args) {
        // Ekspresi infix yang akan diubah menjadi postfix
        String infix = "(A+B)*C-(D-E)/(F+G)";
        // Mengubah ekspresi infix menjadi postfix
        String postfix = infixToPostfix(infix);
        // Menampilkan ekspresi infix dan hasil ekspresi postfix
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + postfix);
    }

    // Metode untuk mengubah ekspresi infix menjadi postfix
    public static String infixToPostfix(String expression) {
        // StringBuilder untuk menyimpan hasil ekspresi postfix
        StringBuilder result = new StringBuilder();
        // Stack untuk menyimpan operator selama proses konversi
        Stack<Character> stack = new Stack<>();
        // Loop untuk memproses setiap karakter dalam ekspresi infix
        for (char ch : expression.toCharArray()) {
            // Jika karakter adalah operand (huruf atau digit), tambahkan ke hasil
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } 
            // Jika karakter adalah tanda kurung buka, push ke stack
            else if (ch == '(') {
                stack.push(ch);
            } 
            // Jika karakter adalah tanda kurung tutup, pop dari stack sampai tanda kurung buka
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Menghapus tanda kurung buka dari stack
            } 
            // Jika karakter adalah operator
            else {
                // Pop dari stack dan tambahkan ke hasil sampai menemukan operator dengan precedence lebih rendah
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                // Push operator ke stack
                stack.push(ch);
            }
        }
        // Pop semua operator yang tersisa di stack dan tambahkan ke hasil
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        // Mengembalikan hasil ekspresi postfix
        return result.toString();
    }

    // Metode untuk menentukan precedence dari operator
    public static int precedence(char ch) {
        // Mengembalikan nilai precedence berdasarkan jenis operator
        switch (ch) {
            case '+':
            case '-':
                return 1; // Precedence terendah
            case '*':
            case '/':
                return 2; // Precedence menengah
            case '^':
                return 3; // Precedence tertinggi
        }
        return -1; // Default untuk karakter yang bukan operator
    }
}
```

**Penjelasan Langkah-langkah Program:**

1. **Import Libraries:**
   - `Stack` digunakan untuk menyimpan operator sementara selama proses konversi.

2. **Main Method:**
   - Inisialisasi ekspresi infix: `String infix = "(A+B)*C-(D-E)/(F+G)";`.
   - Panggil metode `infixToPostfix` untuk mengubah ekspresi infix menjadi postfix.
   - Cetak ekspresi infix dan hasil ekspresi postfix.

3. **Metode `infixToPostfix`:**
   - **Inisialisasi:** Membuat `StringBuilder` untuk menyimpan hasil postfix dan `Stack` untuk menyimpan operator.
   - **Loop:** Memproses setiap karakter dalam ekspresi infix.
     - **Operand:** Jika karakter adalah huruf atau digit, tambahkan ke hasil postfix.
     - **Tanda Kurung Buka:** Push karakter ke stack.
     - **Tanda Kurung Tutup:** Pop dari stack dan tambahkan ke hasil sampai menemukan tanda kurung buka.
     - **Operator:** Pop dari stack dan tambahkan ke hasil sampai menemukan operator dengan precedence lebih rendah, lalu push operator ke stack.
   - **Sisa Operator:** Pop semua operator yang tersisa di stack dan tambahkan ke hasil.

4. **Metode `precedence`:**
   - Menentukan nilai precedence berdasarkan jenis operator (`+`, `-`, `*`, `/`, `^`).

