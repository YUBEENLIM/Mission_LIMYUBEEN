package com.ll;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
    public class App {
        public static void main(String[] args) {
            List<Quote> quotes = loadQuotesFromFile("quotes.txt");

            System.out.println("== 명언 앱 ==");
            Scanner scanner = new Scanner(System.in);

            int id = 0;
            if(!quotes.isEmpty()){
                Quote lastQuote = quotes.get(quotes.size()-1);
                id = lastQuote.getId();
            }

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
                    quote.setId(id);
                    quotes.add(quote);

                    saveQuotesToFile(quotes, "quotes.txt");
                } else if (cmd.equals("목록")) {
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("---------------------");
                    for (int i = quotes.size() - 1; i >= 0; i--) {
                        Quote quote = quotes.get(i);
                        System.out.printf("%d / %s / %s\n", quote.id, quote.authorName, quote.content);
                    }
                } else if (cmd.startsWith("삭제?id=")) {
                    String idStr = cmd.substring("삭제?id=".length());
                    int Deleteid = Integer.parseInt(idStr);
                    if (Deleteid >= 1 && Deleteid <= quotes.size()) {
                        quotes.remove(Deleteid - 1);
                        System.out.println(Deleteid + "번 명언이 삭제되었습니다.");
                    } else if (quotes.isEmpty()) {
                        System.out.println(Deleteid + "번 명언은 존재하지 않습니다.");
                    } else {
                        System.out.println(Deleteid + "번 명언은 존재하지 않습니다.");
                    }
                } else if (cmd.startsWith("수정?id=")) {
                    String idStr = cmd.substring("수정?id=".length());
                    int Updateid = Integer.parseInt(idStr);
                    if (Updateid >=1 && Updateid <= quotes.size()) {
                        Quote quoteToModify = quotes.get(Updateid - 1);
                        Scanner scanners = new Scanner(System.in);
                        System.out.println("명언(기존) : " + quoteToModify.getContent());
                        System.out.print("명언 : ");
                        String newContent = scanners.nextLine();
                        System.out.println("작가(기존) : " + quoteToModify.getAuthorName() );
                        System.out.print("작가 : ");
                        String newAuthorName = scanners.nextLine();
                        quoteToModify.setContent(newContent);
                        quoteToModify.setAuthorName(newAuthorName);
                        System.out.println(Updateid + "번 명언이 수정되었습니다.");
                    } else {
                        System.out.println((Updateid + "번 명언은 존재하지 않습니다."));
                    }
                } else if (cmd.equals("종료")) {
                    break;
                }
            }
            scanner.close();
        }


    private static List<Quote> loadQuotesFromFile(String filename) {
        List<Quote> quotes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("/");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String content = parts[1].trim();
                    String authorName = parts[2].trim();
                    Quote quote = new Quote(id, content, authorName);
                    quotes.add(quote);
                }
            }
        }catch(IOException e){
                e.printStackTrace();
            }
            return quotes;
        }



    private static void saveQuotesToFile(List<Quote> quotes, String filename) {
        try(PrintWriter writer = new PrintWriter(new FileWriter(filename))){
            for(Quote quote : quotes) {
                writer.printf("%d / %s / %s%n", quote.getId(), quote.getContent(), quote.getAuthorName());
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    }

