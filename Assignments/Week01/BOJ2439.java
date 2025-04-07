package assignment;

import java.util.Scanner;

public class BOJ2439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // ユーザーからの入力を受け取るための Scanner オブジェクトを作成

        int n = sc.nextInt(); // 出力する行数をユーザーから入力として取得
        sc.close(); // Scanner を閉じてリソースを解放

        // 1 から n まで繰り返し、各行を出力
        for (int i = 1; i <= n; i++) {
            // 空白の出力（右寄せのため）
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // アスタリスクの出力
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }

            // 行末に改行を出力
            System.out.println();
        }
    }
}
