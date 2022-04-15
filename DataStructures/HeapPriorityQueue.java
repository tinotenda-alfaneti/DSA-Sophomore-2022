package DataStructures;
import java.util.ArrayList;

//index n-1 to index 0, and then invoke downheap to reposition it.
/** An implementation of a priority queue using an array-based heap. */
public class HeapPriorityQueue<V> {
  
  private static class Entry<V> {
    private Integer key;
    private V value;

    public Entry(Integer key, V value) {
      this.key = key;
      this.value = value;
    }

    //Getter Methods
    public Integer getKey() {return key;}
    public V getValue() {return value;}

    // Setter methods
    public void setKey(Integer key) {
      this.key = key;
    }
    public void setValue(V value) {
      this.value = value;
    }

    public String toString() {
      return "" + value;
    }
  }

 /** primary collection of priority queue entries */
   protected ArrayList<Entry<V>> heap = new ArrayList<>( );
   /** Creates an empty priority queue based on the natural ordering of its keys. */
   public HeapPriorityQueue( ) {};
   

  /** Creates an empty priority queue using the given comparator to order keys. */
  protected int parent(int j) { return (j-1) / 2; } // truncating division

  protected int left(int j) { return 2*j + 1; } 

  protected int right(int j) { return 2*j + 2; } 

  protected boolean hasLeft(int j) { return left(j) < heap.size( );} 

  protected boolean hasRight(int j) { return right(j) < heap.size( ); } 

     /** Exchanges the entries at indices i and j of the array list. */
  protected void swap(int i, int j) { 
    Entry<V> temp = heap.get(i);
    heap.set(i, heap.get(j));
    heap.set(j, temp);
  }
   /** Moves the entry at index j higher, if necessary, to restore the heap property. */
  protected void upheap(int j) { 
    while (j > 0) { // continue until reaching root (or break statement)
      int p = parent(j);
      if (compare(heap.get(j), heap.get(p)) >= 0) break; // heap property verified
        swap(j, p);
    j = p;
    }
  }

  /** Moves the entry at index j lower, if necessary, to restore the heap property. */
  protected void downheap(int j) { 
    while (hasLeft(j)) { // continue to bottom (or break statement)
      
      int leftIndex = left(j);
      int smallChildIndex = leftIndex; // although right may be smaller

      if (hasRight(j)) { 
        int rightIndex = right(j);
      if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
        smallChildIndex = rightIndex; // right child is smaller
      } 
      if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0) break; // heap property has been restored
        swap(j, smallChildIndex);
        j = smallChildIndex; // continue at position of the child
    }
   }
   /** Inserts a key-value pair and returns the entry created. */
  public Entry<V> insert(Integer key, V value) throws IllegalArgumentException {
    Entry<V> newest = new Entry<>(key, value);
    checkKey(newest); // auxiliary key-checking method (could throw exception)
    
    heap.add(newest); // add to the end of the list
    upheap(heap.size( ) - 1); // upheap newly added entry
    return newest;
   }

  /** Removes and returns an entry with minimal key (if any). */
  public Entry<V> removeMin() { 
    if (heap.isEmpty( )) return null;
    Entry<V> answer = heap.get(0);
    swap(0, heap.size( ) - 1); // put minimum item at the end
    heap.remove(heap.size( ) - 1); // and remove it from the list;
    downheap(0); // then fix new root
    return answer;
  }
  
  
  /** Method for comparing two entries according to key */
  protected int compare(Entry<V> a, Entry<V> b) { 
    return a.getKey().compareTo(b.getKey( ));
  }

  /** Determines whether a key is valid. */
  protected boolean checkKey(Entry<V> c) throws IllegalArgumentException { 
    try { 
      return (compare(c,c) == 0); // see if key can be compared to itself
    } catch (ClassCastException e) { 
      throw new IllegalArgumentException("Incompatible key");
    } 
   
  }
   
}