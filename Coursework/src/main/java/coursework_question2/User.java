package coursework_question2;

public class User {

  private String fullname;

  public User(String fullname) {
    if (fullname.matches("[A-Z][a-z]* [A-Z][a-z]*")) {
      this.fullname = fullname;
    } else {
      throw new IllegalArgumentException("name invalid");
    }
  }

  public String getName() {
    return (fullname.split(" ")[0]);
  }

  @Override
  public String toString() {
    return fullname;
  }
}
