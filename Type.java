public enum Type {
  ACOUSTIC,
  ELETRIC,
  ANY;

  @Override
  public String toString() {
    switch (this) {
      case ACOUSTIC:
        return "acoustic";
      case ELETRIC:
        return "eletric";
      case ANY:
        return "any";
      default:
        return "invalid";
    }
  }
}
