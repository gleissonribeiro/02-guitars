public class Guitar {

  private String serialNumber, model;
  private double price;
  private Type type;
  private Builder builder;
  private Wood backWood, topWood;

  public Guitar(
    String serialNumber,
    double price,
    Builder builder,
    String model,
    Type type,
    Wood backWood,
    Wood topWood
  ) {
    this.serialNumber = serialNumber;
    this.price = price;
    this.builder = builder;
    this.model = model;
    this.type = type;
    this.backWood = backWood;
    this.topWood = topWood;
  }

  public String getSerialNumber() {
    return this.serialNumber;
  }

  public double getPrice() {
    return this.price;
  }

  public void setPrice(double newPrice) {
    this.price = newPrice;
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
      this.getSerialNumber() +
      ", " +
      this.getPrice() +
      ", " +
      this.getBuilder() +
      ", " +
      this.getModel() +
      ", " +
      this.getType() +
      ", " +
      this.getBackWood() +
      ", " +
      this.getTopWood() +
      "\n"
    );
  }
}
