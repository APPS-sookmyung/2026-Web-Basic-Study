public class Post {
    private int id;
    private String title;
    private String content;
    private String author;

    public Post(int id, String title, String content, String author) {
        // 각 멤버 변수에 입력받은 데이터 넣기
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getAuthor() { return author; }

    public void printSummary() {
        System.out.printf("[%d] %s | 작성자: %s\n", id, title, author);
    }
}