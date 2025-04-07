package assignment;

import java.util.Arrays;
import java.util.Scanner;

class Solution {

    // スライス条件に基づいて num_list を処理するメソッド
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];

        int[] result;

        switch (n) {
            case 1: // インデックス0からbまで
                result = Arrays.copyOfRange(num_list, 0, b + 1);
                break;
            case 2: // インデックスaから最後まで
                result = Arrays.copyOfRange(num_list, a, num_list.length);
                break;
            case 3: // インデックスaからbまで
                result = Arrays.copyOfRange(num_list, a, b + 1);
                break;
            case 4: // インデックスaからbまで、c間隔でスライス
                int size = (b - a) / c + 1;
                result = new int[size];
                int idx = 0;
                for (int i = a; i <= b; i += c) {
                    result[idx++] = num_list[i];
                }
                break;
            default:
                throw new IllegalArgumentException("エラー: スライス方法nは1～4の間である必要があります。");
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // ユーザーからの入力を受け取るための Scanner を作成
        Solution sol = new Solution(); // Solution クラスのインスタンスを生成

        // スライス方法nを入力
        System.out.print("nを入力してください (1〜4): ");
        int n = sc.nextInt();
        if (n < 1 || n > 4) {
            throw new IllegalArgumentException("エラー: nは1〜4のいずれかである必要があります。");
        }

        // slicerのa, b, cを入力
        int[] slicer = new int[3];
        System.out.print("slicerのa, b, cの値を入力してください (例: 1 5 2): ");
        for (int i = 0; i < 3; i++) {
            slicer[i] = sc.nextInt();
        }

        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];

        // num_listの入力を受け取り、文字列から整数配列へ変換
        System.out.print("num_listの値をスペースで区切って入力してください (例: 1 2 3 4 5): ");
        sc.nextLine(); // 改行のクリア
        String inputLine = sc.nextLine();
        String[] parts = inputLine.trim().split("\s+");

        if (parts.length < 5 || parts.length > 30) {
            throw new IllegalArgumentException("エラー: num_listの長さは5以上30以下でなければなりません。");
        }

        int[] num_list = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            int val = Integer.parseInt(parts[i]);
            if (val < 0 || val > 100) {
                throw new IllegalArgumentException("エラー: num_listの要素は0〜100の間でなければなりません。");
            }
            num_list[i] = val;
        }
        sc.close();

        // スライス条件の検証
        if (!(0 <= a && a <= b && b <= num_list.length - 1)) {
            throw new IllegalArgumentException("エラー: 0 ≤ a ≤ b ≤ num_list.length - 1 の条件を満たす必要があります。");
        }

        if (!(1 <= c && c <= 3)) {
            throw new IllegalArgumentException("エラー: cは1〜3の間でなければなりません。");
        }

        // スライス処理の実行
        int[] result = sol.solution(n, slicer, num_list);

        // 結果の出力
        String slicedMessage = switch (n) {
            case 1 -> String.format("%sの0番目から%d番目までをスライスした結果: %s",
                    Arrays.toString(num_list), b, Arrays.toString(result));
            case 2 -> String.format("%sの%d番目から最後までをスライスした結果: %s",
                    Arrays.toString(num_list), a, Arrays.toString(result));
            case 3 -> String.format("%sの%d番目から%d番目までをスライスした結果: %s",
                    Arrays.toString(num_list), a, b, Arrays.toString(result));
            default -> String.format("%sの%d番目から%d番目までを%d間隔でスライスした結果: %s",
                    Arrays.toString(num_list), a, b, c, Arrays.toString(result));
        };

        System.out.println(slicedMessage);
    }
}
