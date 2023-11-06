package com.ll;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        while (true) {
            System.out.print("명령) ");
            String a = scanner.nextLine();
            if (a.equals("등록")) {
                System.out.print("명언 : ");
                String quote = scanner.nextLine();
                System.out.print("작가 : ");
                String authorName = scanner.nextLine();
                n++;
                System.out.println("명언 : " + quote);
                System.out.println("작가 : " + authorName);
                System.out.println(n + "번 명언이 등록되었습니다.");
            } else if (a.equals("종료")) {
                break;
            }
        }
        scanner.close();
    }
}
