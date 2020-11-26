class Main {
  public static void main(String[] args) {
    System.out.println("// IsFlat TEST //");

    Tree t1 = new Flat(new Lemon(), new Flat(new Apple(), new Bud()));
    IsFlat v1 = new IsFlat();
    t1.accept(v1);
    System.out.println("[1] " + v1.resultStore.pop());

    Tree t2 = new Flat(new Lemon(), new Split(new Bud(), new Bud()));
    IsFlat v2 = new IsFlat();
    t2.accept(v2);
    System.out.println("[2] " + v2.resultStore.pop());


    System.out.println("\n// IsSplit TEST //");
    Tree t3 = new Split(new Split(new Bud(), new Bud()), new Split(new Bud(), new Bud()));
    IsSplit v3 = new IsSplit();
    t3.accept(v3);
    System.out.println("[3] " + v3.resultStore.pop());

    Tree t4 = new Split(new Split(new Bud(), new Bud()), new Split(new Flat(new Apple(), new Bud()), new Bud()));
    IsSplit v4 = new IsSplit();
    t4.accept(v4);
    System.out.println("[4] " + v4.resultStore.pop());


    System.out.println("\n// Occurs TEST //");
    Tree t56 = new Split(new Split(new Bud(), new Flat(new Lemon(), new Bud())), new Flat(new Lemon(), new Flat(new Apple(), new Flat(new Lemon(), new Bud()))));
    Occurs v5 = new Occurs(new Lemon());
    Occurs v6 = new Occurs(new Apple());
    t56.accept(v5);
    t56.accept(v6);
    System.out.println("[5/6] Lemon " + v5.resultStore.pop() + " Apple " + v6.resultStore.pop());

    System.out.println("\n// Subst TEST //");
    Tree t7 = new Split(new Split(new Bud(), new Flat(new Lemon(), new Bud())), new Flat(new Lemon(), new Flat(new Apple(), new Flat(new Lemon(), new Bud()))));
    TreePrinter prt = new TreePrinter();
    t7.accept(prt);
    Subst v7 = new Subst(new Apple(), new Lemon());
    t7.accept(v7);
    System.out.println("=====================");
    v7.resultStore.pop().accept(prt);
  }
}