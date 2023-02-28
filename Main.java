public class Main {

  public static void main(String[] args) {
    Inventory inventory = new Inventory();

    Guitar myGuitar01 = new Guitar(
      "1234SN_number_01",
      1200,
      "Gianini",
      "Viola modle",
      "acoustic",
      "oak",
      "arpen"
    );

    Guitar myGuitar02 = new Guitar(
      "1234SN_number_02",
      1400,
      "_builder",
      "Fender",
      "electric",
      "arpen",
      "oak"
    );

    Guitar myGuitar03 = new Guitar(
      "1234SN_number_03",
      3000,
      "_builder",
      "Fender",
      "electric",
      "arpen",
      "oak"
    );

    Guitar searchGuitar = new Guitar(
      null,
      0,
      "_builder",
      "fender",
      "electric",
      "arpen",
      "oak"
    );

    inventory.addGuitar(
      myGuitar01.getSerialNumber(),
      myGuitar01.getPrice(),
      myGuitar01.getBuilder(),
      myGuitar01.getModel(),
      myGuitar01.getType(),
      myGuitar01.getBackWood(),
      myGuitar01.getTopWood()
    );

    inventory.addGuitar(
      myGuitar02.getSerialNumber(),
      myGuitar02.getPrice(),
      myGuitar02.getBuilder(),
      myGuitar02.getModel(),
      myGuitar02.getType(),
      myGuitar02.getBackWood(),
      myGuitar02.getTopWood()
    );

    inventory.addGuitar(
      myGuitar03.getSerialNumber(),
      myGuitar03.getPrice(),
      myGuitar03.getBuilder(),
      myGuitar03.getModel(),
      myGuitar03.getType(),
      myGuitar03.getBackWood(),
      myGuitar03.getTopWood()
    );

    System.out.println("==== All guitars in inventory ====");
    System.out.println(inventory.getGuitars());

    System.out.println("==== Searching guitar ====");
    System.out.println(searchGuitar);

    System.out.println("==== Results of search ====");
    System.out.println(inventory.search(searchGuitar));
  }
}
