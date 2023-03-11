public class Guitar {

  private String serialNumber;
  private double price;
  private GuitarSpec spec;

  public Guitar(
    String serialNumber,
    double price,
    Builder builder,
    String model,
    Type type,
    Wood backWood,
    Wood topWood
  ) {
    this.spec = new GuitarSpec(builder, model, type, backWood, topWood);
    this.serialNumber = serialNumber;
    this.price = price;
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

  public GuitarSpec getSpec() {
    return this.spec;
  }

  public String toString() {
    return (
      this.getSerialNumber() +
      ", " +
      this.getPrice() +
      ", " +
      this.getSpec().toString() +
      "\n"
    );
  }
}
