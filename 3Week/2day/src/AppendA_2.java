public class AppendA_2 {
    public static void main(String[] args) {
        // - Create an array variable named `nimals`
        //   with the following content: `["kuty", "macsk", "cic"]`
        // - Add all elements an `"a"` at the end
        String[] animals = {"kuty", "macsk", "cic"};
        for (int i = 0; i < animals.length; i++) {
            animals[i] = animals[i] + "a";
        }
        for (String element : animals) {
            System.out.println(element);
        }
    }
}
