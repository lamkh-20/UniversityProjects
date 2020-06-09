public class PQKImp<P extends Comparable<P>, T> implements PQK<P, T> 
{

   private PQNode<P,T> Head;
   private int length, No;
   
	public PQKImp(int k) {
		No=k;
      length=0;
      Head=null;
	}
   
   
	public int length(){
   return length;}
   

	public void enqueue(P pr, T e){
   PQNode<P,T> prev=Head;
   PQNode<P,T> temp=null;
   PQNode<P,T> NewOne = new PQNode<P,T>(pr, e);
  
   
		if((this.length == 0) || (pr.compareTo(Head.Priority)>0)) {
			NewOne.next = Head;
			Head = NewOne;
		}
		else {
			
			while((prev != null) && (pr.compareTo(prev.Priority) <= 0)) {
				temp = prev;
				prev = prev.next;
			}
			NewOne.next = prev;
			temp.next = NewOne;
		}
		length++;
	
 if(No<length){
 
  prev=Head;
   temp=null;
   while(prev.next != null){
   temp = prev;
	prev = prev.next;}
  temp.next = null; 
 length--;
 }
 
   }
   
  public Pair<P, T> serve(){
   //FIFO
   T data;
    P pri;
   if(Head!=null){
   data=Head.data;
   pri=Head.Priority;
   Head = Head.next;
      length--;}
   
   else{
   return null;}
   
   Pair<P, T> pai=new Pair<P, T>(pri,data);
   return pai; }
}
