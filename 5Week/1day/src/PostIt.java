public class PostIt {
    public static void main(String[] args) {
        PostItType postIt1 = new PostItType("Orange", "Idea1", "blue");
        PostItType postIt2 = new PostItType("pink", "Awsome", "black");
        PostItType postIt3 = new PostItType("yellow", "Superb", "green");
        System.out.println(postIt1.text);
        System.out.println(postIt2.text);
        System.out.println(postIt3.text);
    }
}

class PostItType {
    String backgroundColor;
    String text;
    String textColor;

    public PostItType(String background, String text, String textColor) {
        this.backgroundColor = background;
        this.text = text;
        this.textColor = textColor;
    }
}
