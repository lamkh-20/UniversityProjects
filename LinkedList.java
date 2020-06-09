public class LinkedList<T> implements List<T> { 
private Node<T> head;
private Node<T> current; 
int length;


public LinkedList () {
head = current = null;
length=0; 

}


public boolean empty () {
if( head == null)
 return true;
 return false;
}


public boolean last () {


return current.next == null;

}


public boolean full () {
 return false;

}
public void findFirst () {
 current = head;
}


public void findNext () {
current = current.next;
}


public T retrieve () {
return current.data;
}


public void update (T val) { 
current.data = val;
}


public void insert (T val) { 
Node<T> tmp= null; ////////
if (head == null) {
current = head = new Node<T> (val);
} else {
tmp = current.next;
current.next = new Node<T> (val); 
current = current.next; 
current.next = tmp;

}
length++;
}

public void remove () {
if (current == head) {
head = head.next; } 
else {
Node<T> tmp = head;
while (tmp.next != current) {
tmp = tmp.next;
}
tmp.next = current.next;
}
if (current.next == null) {
current = head; } 
else {
current = current.next;
} length--;
}
 public int size() {
return length; }

public boolean exists(T e) {

/*Node<T>ptr=head; 
while(ptr!=null)
{ if(ptr.data.equals(e))
return true; 
ptr=ptr.next;
}
return false; }*/
Node<T> tmp=head;
boolean flag=false;
for(int i=0;i<this.size();i++){
if(tmp.data.equals(e))
flag=true;
tmp=tmp.next;

}
return flag;
}}