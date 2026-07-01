/*
 * OpenDSA Project Distributed under the MIT License
 * 
 * Copyright (c) 2011-2019 - Ville Karavirta and Cliff Shaffer
 */

class AQueue<E> implements Queue<E> {

  // Keep this non-private for testing purposes!
  E queueArray[]; // Array holding queue elements
  
  private static final int defaultSize = 10;
  private int front; // Index of front element
  private int size; // Number of elements stored.

  // Constructors
  @SuppressWarnings("unchecked") // Generic array allocation
  AQueue(int capacity) {
    queueArray = (E[]) new Object[capacity];
    front = 0;
    size = 0;
  }
  

  AQueue() {
    queueArray = (E[]) new Object[defaultSize];
    front = 0;
    size = 0;
  }

  // Reinitialize
  public void clear() {
    queueArray = (E[]) new Object[defaultSize];
    front = 0;
    size = 0;
  }

  // Put "it" in queue
  public boolean enqueue(E it) {
    if (size == queueArray.length) {
      E[] hold = (E[]) new Object[queueArray.length * 2];
      int counter = front;
      for (int i = 0; i < size; i++) {
        hold[i] = queueArray[counter % queueArray.length];
        counter++;
      }
      front = 0;
      queueArray = hold;
    }
    queueArray[size % queueArray.length] = it;
    size++;
    return true;
  }

  // Remove and return front value
  public E dequeue() {
   if (size == 0) {
     return null;
   }
   size--;
   E hold = queueArray[front];
   queueArray[front] = null;
   front = front + 1 % queueArray.length;
   return hold;
  }

  // Return front value
  public E frontValue() {
    return queueArray[front];
  }

  // Return queue size
  public int length() {
    return size;
  }
  
  //Check if the queue is empty
  public boolean isEmpty() {
    return size == 0;
  }
}
