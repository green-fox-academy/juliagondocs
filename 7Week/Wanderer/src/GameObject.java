public class GameObject {


    String filePath;

    public GameObject() {
    }

    public GameObject(String filePath) {
        this.filePath = filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void moveLeft() { setFilePath("img/hero-left.png"); }

    public void moveRight() {
        setFilePath("img/hero-right.png");
    }

    public void moveDown() {
        setFilePath("img/hero-down.png");
    }

    public void moveUp() {
        setFilePath("img/hero-up.png");
    }

    public void setKey() {  Skeleton.hasKey = true; }


}
