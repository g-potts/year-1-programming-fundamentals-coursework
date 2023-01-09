package coursework_question3;

public class Seller extends User {

  public Seller(String fullname) {
    super(fullname);
  }

  @Override
  public String toString() {
    return getName() + " " + getFullName().split(" ")[1].charAt(0) + ". ()";
  }

}
