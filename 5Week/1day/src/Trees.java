import java.util.ArrayList;

public class Trees {
    public static void main(String[] args) {

        ArrayList<Object> trees = new ArrayList<Object>();
        String treeType = "oak";
        String leafColor = " brown";
        int treeAge = 12;
        String treeSex = "-";


        trees.add(treeType);
        trees.add(leafColor);
        trees.add(treeAge);
        trees.add(treeSex);
        System.out.println(trees);
    }
}
