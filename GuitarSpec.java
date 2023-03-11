public class GuitarSpec {

  private String model;
  private Type type;
  private Builder builder;
  private Wood backWood, topWood;

  public GuitarSpec(
    Builder builder,
    String model,
    Type type,
    Wood backWood,
    Wood topWood
  ) {
    this.builder = builder;
    this.model = model;
    this.type = type;
    this.backWood = backWood;
    this.topWood = topWood;
  }

  public Builder getBuilder() {
    return this.builder;
  }

  public String getModel() {
    return this.model;
  }

  public Type getType() {
    return this.type;
  }

  public Wood getBackWood() {
    return this.backWood;
  }

  public Wood getTopWood() {
    return this.topWood;
  }

  @Override
  public String toString() {
    return (
      this.getBuilder() +
      ", " +
      this.getModel() +
      ", " +
      this.getModel() +
      ", " +
      this.getBackWood() +
      ", " +
      this.getTopWood()
    );
  }
}
