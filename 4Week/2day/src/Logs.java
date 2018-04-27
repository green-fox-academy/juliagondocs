import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Logs {
    public static void main(String[] args) {
        // Read all data from 'log.txt'.
        // Each line represents a log message from a web server
        // Write a function that returns an array with the unique IP adresses.
        // Write a function that returns the GET / POST request ratio.
        Path path = Paths.get("log.txt");

        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("No such file or directory");
        }

        String[][] data = new String[lines.size()][7];
        String[] ip = new String[lines.size()];
        String[] getPost = new String[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            data[i] = lines.get(i).split(" ");
            ip[i] = data[i][8];
            getPost[i] = data[i][11];
        }
        System.out.println(IpAdresses(ip));
        System.out.println(getPostRatio(getPost));

    }

    public static List IpAdresses(String[] ip) {
        Arrays.sort(ip);
        ArrayList<String> uniqeNumber = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < ip.length; i++) {
            if (i < ip.length - 1) {
                if (!ip[i + 1].equals(ip[i])) {
                    //System.out.println(temp + " " + ip[i]);
                    uniqeNumber.add(temp, ip[i]);
                    temp += 1;
                }
            } else if (i == ip.length - 1) {
                if (!ip[i].equals(ip[i - 1])) {
                    //System.out.println(temp + " " + ip[i]);
                    uniqeNumber.add(temp, ip[i]);
                    temp += 1;
                }
            }
        }
        return uniqeNumber;
    }

    public static double getPostRatio(String[] getPost) {
        int countGet = 0;
        int countPost = 0;
        for (int i = 0; i < getPost.length; i++) {
            if (getPost[i].equals("POST")) {
                countPost += 1;
            }
            if (getPost[i].equals("GET")) {
                countGet += 1;
            }
        }
        System.out.println(countGet + " " + countPost);
        double ratio = (double) countGet / (double) countPost;
        return ratio;
    }
}

