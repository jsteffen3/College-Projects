import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BSTTest {


  private Integer[] numbers;
  private Integer[] ordered;


  @BeforeEach
  void setUp() throws Exception {
    numbers = new Integer[] {4, 5, 2, 8, 9, 1, 3};
    ordered = Arrays.copyOf(numbers, numbers.length);
    Arrays.sort(ordered);
  }

  @Test
  public void testMinElement() {
    BST<Integer> bst = new BST<>();

    for (int i = 0; i < numbers.length; i++) {
      Integer[] subset = Arrays.copyOf(numbers, i + 1);
      Arrays.sort(subset);
      bst.insert(numbers[i]);
      assertEquals(subset[0], bst.minElement());
    }
  }

  @Test
  public void testMaxElement() {
    BST<Integer> bst = new BST<>();
    for (int i = 0; i < numbers.length; i++) {
      Integer[] subset = Arrays.copyOf(numbers, i + 1);
      Arrays.sort(subset);
      bst.insert(numbers[i]);
      assertEquals(subset[i], bst.maxElement());
    }
  }

  @Test
  public void testRecursiveSize() {
    BST<Integer> bst = new BST<>();
    for (int num : numbers) {
      assertEquals(bst.size(), bst.recursiveSize());
      bst.insert(num);
    }
  }

  @Test
  public void testMakeOrderedList() {

    BST<Integer> bst = new BST<>();
    for (int num : numbers) {
      bst.insert(num);
    }
    
    LList<Integer> list = bst.makeOrderedList();

    assertEquals(numbers.length, list.length());

    for (int i = 0; i < numbers.length; i++) {
      list.moveToPos(i);
      assertEquals(ordered[i], list.getValue());
    }
  }
  
  
  @Test
  public  void testIsBSTSizeZero() {

    BST<Integer> bst = new BST<>();
    assertTrue(bst.isValidBST());
  }

  @Test
  public  void testIsBSTGoodBST() {

    BST<Integer> bstOK = new BST<>();
    bstOK.root = new BSTNode<>(10);
    bstOK.root.setLeft(new BSTNode<>(7));
    bstOK.root.setRight(new BSTNode<>(15));
    bstOK.root.left().setLeft(new BSTNode<>(2));
    bstOK.root.left().setRight(new BSTNode<>(8));
    bstOK.root.right().setLeft(new BSTNode<>(14));
    assertTrue(bstOK.isValidBST());
  }

  @Test
  public  void testIsBSTEasyBroken() {
    BST<Integer> bstEasyBroken = new BST<>();
    bstEasyBroken.root = new BSTNode<>(10);
    bstEasyBroken.root.setLeft(new BSTNode<>(7));
    bstEasyBroken.root.setRight(new BSTNode<>(3));
    assertFalse(bstEasyBroken.isValidBST());
  }

  @Test
  public  void testIsBSTSneakyBroken() {
    BST<Integer> bstSneakyBroken = new BST<>();
    bstSneakyBroken.root = new BSTNode<>(10);
    bstSneakyBroken.root.setLeft(new BSTNode<>(7));
    bstSneakyBroken.root.setRight(new BSTNode<>(15));
    bstSneakyBroken.root.left().setLeft(new BSTNode<>(2));
    bstSneakyBroken.root.left().setRight(new BSTNode<>(11));
    bstSneakyBroken.root.right().setLeft(new BSTNode<>(14));
    assertFalse(bstSneakyBroken.isValidBST());

  }


}