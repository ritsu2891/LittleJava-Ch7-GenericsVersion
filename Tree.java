abstract class Tree {
  abstract
    void accept(TreeVisitor ask);
}

class Bud extends Tree {
  void accept(TreeVisitor ask) {
    ask.forBud(); }
}

class Flat extends Tree {
  Fruit f;
  Tree t;
  Flat(Fruit _f, Tree _t) {
    f = _f;
    t = _t; }

  void accept(TreeVisitor ask) {
    ask.forFlat(f, t); }
}

class Split extends Tree {
  Tree l;
  Tree r;
  Split(Tree _l, Tree _r) {
    l = _l;
    r = _r; }

  void accept(TreeVisitor ask) {
    ask.forSplit(l, r); }
}

abstract class Fruit {}
class Peach extends Fruit {
  public boolean equals(Object o) {
    return (o instanceof Peach); }
  public String toString() {
    return "Peach";
  }
}
class Apple extends Fruit {
  public boolean equals(Object o) {
    return (o instanceof Apple); }
  public String toString() {
    return "Apple";
  }
}
class Pear extends Fruit {
  public boolean equals(Object o) {
    return (o instanceof Pear); }
  public String toString() {
    return "Pear";
  }
}
class Lemon extends Fruit {
  public boolean equals(Object o) {
    return (o instanceof Lemon); }
  public String toString() {
    return "Lemon";
  }
}
class Fig extends Fruit {
  public boolean equals(Object o) {
    return (o instanceof Fig); }
  public String toString() {
    return "Fig";
  }
} 