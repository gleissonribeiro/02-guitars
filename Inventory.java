import java.util.ArrayList;

public class Inventory {

  private ArrayList<Guitar> guitars;

  public Inventory() {
    this.guitars = new ArrayList<Guitar>();
  }

  public ArrayList<Guitar> getGuitars() {
    return this.guitars;
  }

  // Add guitar to inventory
  public void addGuitar(
    String serialNumber,
    double price,
    Builder builder,
    String model,
    Type type,
    Wood backWood,
    Wood topWood
  ) {
    // Create guitar
    Guitar guitar = new Guitar(
      serialNumber,
      price,
      builder,
      model,
      type,
      backWood,
      topWood
    );

    // Add guitar to inventory
    this.guitars.add(guitar);
  }

  // Get guitar from serial number
  public Guitar getGuitar(String serialNumber) {
    for (Guitar guitar : this.guitars) {
      if (guitar.getSerialNumber() == serialNumber) return guitar;
    }
    return null;
  }

  // Search a guitar in the invertory
  public ArrayList<Guitar> search(Guitar searchGuitar) {
    ArrayList<Guitar> matchingGuitars = new ArrayList<Guitar>();

    for (Guitar guitar : this.guitars) {
      // Builder
      if (!builderIsSatisfied(guitar, searchGuitar)) continue;

      // Model
      if (!modelIsSatisfied(guitar, searchGuitar)) continue;

      // Type
      if (!typeIsSatisfied(guitar, searchGuitar)) continue;

      // BackWood
      if (!backWoodIsSatisfied(guitar, searchGuitar)) continue;

      // TopWood
      if (!topWoodIsSatisfied(guitar, searchGuitar)) continue;

      matchingGuitars.add(guitar);
    }
    return matchingGuitars;
  }

  private boolean builderIsSatisfied(Guitar guitar, Guitar searchGuitar) {
    return (
      !builderIsSpecific(searchGuitar) || buildersMatch(guitar, searchGuitar)
    );
  }

  private boolean builderIsSpecific(Guitar guitar) {
    Builder builder = guitar.getBuilder();
    return builder != Builder.ANY && builder != null;
  }

  private boolean buildersMatch(Guitar guitar, Guitar searchGuitar) {
    return guitar.getBuilder() == searchGuitar.getBuilder();
  }

  private boolean modelIsSatisfied(Guitar guitar, Guitar searchGuitar) {
    return !modelIsSpecific(searchGuitar) || modelsMatch(guitar, searchGuitar);
  }

  private boolean modelIsSpecific(Guitar guitar) {
    String guitarModel = guitar.getModel();
    return (guitarModel != null && !guitarModel.equals(""));
  }

  private boolean modelsMatch(Guitar guitar, Guitar searchGuitar) {
    String guitarModel = guitar.getModel().toLowerCase();
    String searchGuitarModel = searchGuitar.getModel().toLowerCase();
    return guitarModel.equals(searchGuitarModel);
  }

  private boolean typeIsSatisfied(Guitar guitar, Guitar searchGuitar) {
    return !typeIsSpecific(searchGuitar) || typesMatch(guitar, searchGuitar);
  }

  private boolean typeIsSpecific(Guitar guitar) {
    Type type = guitar.getType();
    return type != Type.ANY && type != null;
  }

  private boolean typesMatch(Guitar guitar, Guitar searchGuitar) {
    return guitar.getType() == searchGuitar.getType();
  }

  private boolean backWoodIsSatisfied(Guitar guitar, Guitar searchGuitar) {
    return (
      !backWoodIsSpecific(searchGuitar) || backWoodsMatch(guitar, searchGuitar)
    );
  }

  private boolean backWoodIsSpecific(Guitar guitar) {
    Wood backWood = guitar.getBackWood();
    return backWood != Wood.ANY && backWood != null;
  }

  private boolean backWoodsMatch(Guitar guitar, Guitar searchGuitar) {
    return guitar.getBackWood() == searchGuitar.getBackWood();
  }

  private boolean topWoodIsSatisfied(Guitar guitar, Guitar searchGuitar) {
    return (
      !topWoodIsSpecific(searchGuitar) || topWoodsMatch(guitar, searchGuitar)
    );
  }

  private boolean topWoodIsSpecific(Guitar guitar) {
    Wood topWood = guitar.getBackWood();
    return topWood != Wood.ANY && topWood != null;
  }

  private boolean topWoodsMatch(Guitar guitar, Guitar searchGuitar) {
    return guitar.getTopWood() == searchGuitar.getTopWood();
  }
}
