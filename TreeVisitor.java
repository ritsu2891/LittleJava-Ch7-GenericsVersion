import java.util.Stack;

abstract class TreeVisitor<T> {
  Stack<T> resultStore;
  abstract void forBud();
  abstract void forFlat(Fruit f, Tree t);
  abstract void forSplit(Tree l, Tree r);
  TreeVisitor() {
    this.resultStore = new Stack<T>();
  }
}

class IsFlat extends TreeVisitor<Boolean> {
  public void forBud() {
    resultStore.push(true); }
  public void forFlat(Fruit f, Tree t) {
    t.accept(this); }
  public void forSplit(Tree l, Tree r) {
    resultStore.push(false); }
}

class IsSplit extends TreeVisitor<Boolean> {
  public void forBud() {
    resultStore.push(true); }
  public void forFlat(Fruit f, Tree t) {
    resultStore.push(false); }
  public void forSplit(Tree l, Tree r) {
    l.accept(this);
    if (resultStore.pop())
      r.accept(this);
    else
      resultStore.push(false); }
}

class Occurs extends TreeVisitor<Integer> {
  Fruit a;
  Occurs (Fruit _a) {
    a = _a; }

  public void forBud() {
    resultStore.push(0); }
  public void forFlat(Fruit f, Tree t) {
    if (f.equals(a)) {
      t.accept(this);
      resultStore.push(resultStore.pop() + 1);
    } else {
      t.accept(this); }}
  public void forSplit(Tree l, Tree r) {
    l.accept(this);
    r.accept(this);
    resultStore.push(resultStore.pop() + resultStore.pop()); }
}

class Subst extends TreeVisitor<Tree> {
  Fruit n;
  Fruit o;
  Subst(Fruit _n, Fruit _o) {
    n = _n;
    o = _o; }

  public void forBud() {
    resultStore.push(new Bud()); }
  public void forFlat(Fruit f, Tree t) {
    if (o.equals(f)) {
      t.accept(this);
      resultStore.push(new Flat(n, resultStore.pop()));
    } else {
      t.accept(this);
      resultStore.push(new Flat(f, resultStore.pop())); }}
  public void forSplit(Tree l, Tree r) {
    l.accept(this);
    Tree lTree = resultStore.pop();
    r.accept(this);
    Tree rTree = resultStore.pop();
    resultStore.push(new Split(lTree, rTree)); }
}

class TreePrinter extends TreeVisitor<Void> {
  int indent;
  TreePrinter() {
    indent = 0;
  }

  public void forBud() {
    printIndent();
    System.out.println("[BUD]"); }
  public void forFlat(Fruit f, Tree t) {
    printIndent();
    System.out.println("[FLAT] -- " + f);
    indent++;
    t.accept(this);
    indent--; }
  public void forSplit(Tree l, Tree r) {
    printIndent();
    System.out.println("[SPLIT]");
    indent++;
    l.accept(this);
    r.accept(this);
    indent--; }
  void printIndent() {
    for (int i = 0; i < indent; i++) {
      System.out.print("  ");
    }}
}