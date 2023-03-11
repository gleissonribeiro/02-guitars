public class Main {

  public static void main(String[] args) {
    Inventory inventory = new Inventory();

    Guitar myGuitar01 = new Guitar(
      "1234SN_number_01",
      1200,
      Builder.FENDER,
      "Viola modle",
      Type.ELETRIC,
      Wood.ALDER,
      Wood.BRAZILIAN_ROSEWOOD
    );

    Guitar myGuitar02 = new Guitar(
      "1234SN_number_02",
      1400,
      Builder.GIBSON,
      "Black Olson",
      Type.ELETRIC,
      Wood.MAHOGANY,
      Wood.CEDAR
    );

    Guitar myGuitar03 = new Guitar(
      "1234SN_number_03",
      3000,
      Builder.OLSON,
      "Black Olson",
      Type.ACOUSTIC,
      Wood.SITKA,
      Wood.ALDER
    );

    Guitar myGuitar04 = new Guitar(
      "1234SN_number_04",
      5000,
      Builder.FENDER,
      "Black Olson",
      Type.ELETRIC,
      Wood.COCOBOLO,
      Wood.ALDER
    );

    inventory.addGuitar(myGuitar01);
    inventory.addGuitar(myGuitar02);
    inventory.addGuitar(myGuitar03);
    inventory.addGuitar(myGuitar04);

    GuitarSpec searchGuitarSpec = new GuitarSpec(
      null,
      null,
      null,
      null,
      Wood.ALDER
    );

    System.out.println("==== All guitars in inventory ====");
    System.out.println(inventory.getGuitars());

    System.out.println("==== Searching guitar spec ====");
    System.out.println(searchGuitarSpec);

    System.out.println("==== Results of search ====");
    System.out.println(inventory.search(searchGuitarSpec));
  }
}
