package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Quote> quotes = new ArrayList<>();
        System.out.println("== 명언 앱 ==");
        Scanner scanner = new Scanner(System.in);
        int id = 0;


        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();
            if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = scanner.nextLine();
                System.out.print("작가 : ");
                String authorName = scanner.nextLine();
                id++;
                System.out.println("명언 : " + content);
                System.out.println("작가 : " + authorName);
                System.out.println(id + "번 명언이 등록되었습니다.");
                Quote quote = new Quote(id, content, authorName);
                quotes.add(quote);
            }
                else if (cmd.equals("목록")) {


                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("---------------------");
                    for (int i = quotes.size() - 1; i >= 0; i--) {
                        Quote quote = quotes.get(i);
                        System.out.printf("%d / %s / %s\n", quote.id, quote.authorName, quote.content);
                    }
                }

                else if (cmd.startsWith("삭제?id=")){
                    String idStr = cmd.substring("삭제?id=".length());

                    int Deleteid = Integer.parseInt(idStr);
                    if(Deleteid >= 1 && Deleteid <= quotes.size()) {
                        quotes.remove(Deleteid - 1);
                        System.out.println(Deleteid + "번 명언이 삭제되었습니다.");
                    }




            }
                else if (cmd.equals("종료")) {
                    break;
                }
            }
            scanner.close();
        }
    }



