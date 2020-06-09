class PQNode<P extends Comparable<P>, T>{
public T data;
public P Priority;
public PQNode<P,T> next;


public PQNode(P Pr,T e){
data=e;
Priority=Pr;
next=null;
}
}
