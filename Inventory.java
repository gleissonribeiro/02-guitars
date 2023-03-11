import java.util.ArrayList;

public class Inventory {

  private ArrayList<Guitar> guitars = new ArrayList<>();

  public Inventory() {}

  public Inventory(ArrayList<Guitar> guitars) {
    this.guitars = guitars;
  }

  public ArrayList<Guitar> getGuitars() {
    return this.guitars;
  }

  public void addGuitar(Guitar guitar) {
    guitars.add(guitar);
  }

  public Guitar getGuitar(String serialNumber) {
    for (Guitar guitar : this.guitars) {
      if (guitar.getSerialNumber() == serialNumber) return guitar;
    }
    return null;
  }

  public ArrayList<Guitar> search(GuitarSpec searchSpec) {
    ArrayList<Guitar> matchingGuitars = new ArrayList<Guitar>();

    for (Guitar guitar : guitars) {
      GuitarSpec guitarSpec = guitar.getSpec();
      if (!builderIsSatisfied(guitarSpec, searchSpec)) continue;

      if (!modelIsSatisfied(guitarSpec, searchSpec)) continue;

      if (!typeIsSatisfied(guitarSpec, searchSpec)) continue;

      if (!backWoodIsSatisfied(guitarSpec, searchSpec)) continue;

      if (!topWoodIsSatisfied(guitarSpec, searchSpec)) continue;

      matchingGuitars.add(guitar);
    }
    return matchingGuitars;
  }

  private boolean builderIsSatisfied(
    GuitarSpec guitarSpec,
    GuitarSpec searchSpec
  ) {
    return (
      !builderIsSpecific(searchSpec) || buildersMatch(guitarSpec, searchSpec)
    );
  }

  private boolean builderIsSpecific(GuitarSpec searchSpec) {
    Builder builder = searchSpec.getBuilder();
    return builder != Builder.ANY && builder != null;
  }

  private boolean buildersMatch(GuitarSpec guitarSpec, GuitarSpec searchSpec) {
    return guitarSpec.getBuilder() == searchSpec.getBuilder();
  }

  private boolean modelIsSatisfied(
    GuitarSpec guitarSpec,
    GuitarSpec searchSpec
  ) {
    return !modelIsSpecific(searchSpec) || modelsMatch(guitarSpec, searchSpec);
  }

  private boolean modelIsSpecific(GuitarSpec searchSpec) {
    String guitarModel = searchSpec.getModel();
    return (guitarModel != null && !guitarModel.equals(""));
  }

  private boolean modelsMatch(GuitarSpec guitarSpec, GuitarSpec searchSpec) {
    String guitarSpecModel = guitarSpec.getModel().toLowerCase();
    String searchSpecModel = searchSpec.getModel().toLowerCase();
    return guitarSpecModel.equals(searchSpecModel);
  }

  private boolean typeIsSatisfied(
    GuitarSpec guitarSpec,
    GuitarSpec searchSpec
  ) {
    return !typeIsSpecific(searchSpec) || typesMatch(guitarSpec, searchSpec);
  }

  private boolean typeIsSpecific(GuitarSpec searchSpec) {
    Type type = searchSpec.getType();
    return type != Type.ANY && type != null;
  }

  private boolean typesMatch(GuitarSpec guitarSpec, GuitarSpec searchSpec) {
    return guitarSpec.getType() == searchSpec.getType();
  }

  private boolean backWoodIsSatisfied(
    GuitarSpec guitarSpec,
    GuitarSpec searchSpec
  ) {
    return (
      !backWoodIsSpecific(searchSpec) || backWoodsMatch(guitarSpec, searchSpec)
    );
  }

  private boolean backWoodIsSpecific(GuitarSpec searchSpec) {
    Wood backWood = searchSpec.getBackWood();
    return backWood != Wood.ANY && backWood != null;
  }

  private boolean backWoodsMatch(GuitarSpec guitarSpec, GuitarSpec searchSpec) {
    return guitarSpec.getBackWood() == searchSpec.getBackWood();
  }

  private boolean topWoodIsSatisfied(
    GuitarSpec guitarSpec,
    GuitarSpec searchSpec
  ) {
    return (
      !topWoodIsSpecific(searchSpec) || topWoodsMatch(guitarSpec, searchSpec)
    );
  }

  private boolean topWoodIsSpecific(GuitarSpec searchSpec) {
    Wood topWood = searchSpec.getTopWood();
    return topWood != Wood.ANY && topWood != null;
  }

  private boolean topWoodsMatch(GuitarSpec guitarSpec, GuitarSpec searchSpec) {
    return guitarSpec.getTopWood() == searchSpec.getTopWood();
  }

  @Override
  public String toString() {
    return "Inventory [guitars=" + guitars + "]";
  }
}
