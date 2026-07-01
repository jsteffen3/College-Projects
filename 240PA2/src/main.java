
public class main {
  public static void main(String[] args) {
    LinkedIntSet test = new LinkedIntSet();
    test.add(6);
    test.add(5);
    test.add(7);
    test.remove(6);
    System.out.println(test.toString());
  }
}
