package banana.util.system;

public enum Path {

  HONE("/"), LOGIN("/login"), REGISTER("/register"), ACTIVE("/active"), RESET("/reset"), CHANGE_PASSWORD("/change_password");

  private String value;

  private Path(String value) {
    this.value = value;
  }

  public String get() {
    return this.value;
  }
}
