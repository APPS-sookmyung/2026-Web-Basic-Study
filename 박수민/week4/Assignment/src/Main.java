import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        boolean running = true;

        while (running) {
            System.out.println("\n====== 게시판 프로그램 ======");
            System.out.println("1. 작성 | 2. 목록 | 3. 조회 | 4. 삭제 | 5. 종료");
            System.out.print("선택: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("제목: ");
                    String title = scanner.nextLine();
                    System.out.print("내용: ");
                    String content = scanner.nextLine();
                    System.out.print("작성자: ");
                    String author = scanner.nextLine();
                    board.addPost(title, content, author);
                    break;

                case 2:
                    board.showAllPosts();
                    break;

                case 3:
                    System.out.print("조회할 게시글 번호: ");
                    int viewId = scanner.nextInt();
                    board.viewPost(viewId);
                    break;

                case 4:
                    System.out.print("삭제할 게시글 번호: ");
                    int deleteId = scanner.nextInt();
                    board.deletePost(deleteId);
                    break;

                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                    break;

                default:
                    System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
            }
        }
        scanner.close();
    }
}