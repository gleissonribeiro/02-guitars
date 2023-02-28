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
    String builder,
    String model,
    String type,
    String backWood,
    String topWood
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

  // Serach a guitar in the invertory
  public ArrayList<Guitar> search(Guitar searchGuitar) {
    ArrayList<Guitar> matchingGuitars = new ArrayList<Guitar>();

    for (Guitar guitar : this.guitars) {
      // Builder
      String searchGuitarBuilder = searchGuitar.getBuilder();
      if (
        searchGuitarBuilder != null &&
        !searchGuitarBuilder.equals("") &&
        !searchGuitarBuilder.equals(guitar.getBuilder())
      ) continue;

      // Model
      String searchGuitarModel = searchGuitar.getModel().toLowerCase();
      if (
        searchGuitarModel != null &&
        !searchGuitarModel.equals("") &&
        !searchGuitarModel.equals(guitar.getModel().toLowerCase())
      ) continue;

      // Type
      String searchGuitarType = searchGuitar.getType();
      if (
        searchGuitarType != null &&
        !searchGuitarType.equals("") &&
        !searchGuitarType.equals(guitar.getType())
      ) continue;

      // BackWood
      String searchGuitarBackWood = searchGuitar.getBackWood();
      if (
        searchGuitarBackWood != null &&
        !searchGuitarBackWood.equals("") &&
        !searchGuitarBackWood.equals(guitar.getBackWood())
      ) continue;

      // TopWood
      String searchGuitarTopWood = searchGuitar.getTopWood();
      if (
        searchGuitarTopWood != null &&
        !searchGuitarTopWood.equals("") &&
        !searchGuitarTopWood.equals(guitar.getTopWood())
      ) continue;

      matchingGuitars.add(guitar);
    }
    return matchingGuitars;
  }
}
