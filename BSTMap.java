public class BSTMap<K extends Comparable<K>, T> implements Map<K, T> {
   public BSTNode<K, T> root; // Do not change this
   private int length;
   
   public BSTMap() {
      root=null;  
      length=0;    
   }
   
   public int size(){
      return length;
   }
      
   public boolean full(){
      return false;
     
   }

   public void clear(){
      root=null;}
   
   public boolean update(K k, T e){
      BSTNode<K, T> tmp=root;
      boolean flag=false;
      while(tmp !=null){
         if(k.compareTo(tmp.key) == 0){
            tmp.data=e;
            flag=true;
            break;}
         if(k.compareTo(tmp.key) > 0)
            tmp=tmp.right;
         else
            tmp=tmp.left;
      }
      
      return flag; }
   
   public Pair<Boolean,T> retrieve(K k){
      BSTNode<K, T> tmp=root;
      boolean flag=false;
      while(tmp !=null){
         if(k.compareTo(tmp.key) == 0){
            flag=true;
            break;}
         if(k.compareTo(tmp.key) > 0)
            tmp=tmp.right;
         else
            tmp=tmp.left;
      }
      Pair<Boolean,T> pai;
      if(flag)
         pai=new Pair<Boolean, T>(flag,tmp.data);
      else
         pai=new Pair<Boolean, T>(flag,null);
   
      return pai;}
//mustafa
 /*  public boolean insert(K k, T e) {
BSTNode<K,T>newNode=new BSTNode<K,T>(k,e); 
if(root==null)
{
root=newNode; 
         length ++;
 return true;
}
BSTNode<K,T>q=null;
 BSTNode<K,T>ptr=root;
  while(ptr!=null)
{

q=ptr;
 if(ptr.key.compareTo(k)==0){
return false; }
else if(k.compareTo(ptr.key)>0) 
ptr=ptr.right;
else
ptr=ptr.left; }
if(k.compareTo(q.key)>0) 
q.right=newNode;
else 
q.left=newNode;
         length ++;
return true;
}   */
/////////////////////////////2
   public boolean insert(K k, T e){
      BSTNode<K, T> NewOne= new BSTNode<K, T>(k,e);
      if (root == null){
         root=NewOne;
         length ++;
         return true;}
   
      
      BSTNode<K, T> tmp=root;
      while(tmp !=null){
      
         if(k.compareTo(tmp.key) == 0)
            return false;
      
         if(k.compareTo(tmp.key) > 0){
            if(tmp.right==null)
               break;
            tmp=tmp.right;}
         else{
            if(tmp.left==null)
               break;
            tmp=tmp.left;}
      }
            
      if(k.compareTo(tmp.key) > 0)
         tmp.right=NewOne;
      else 
         tmp.left=NewOne;
      length ++;
      return true;
   }

  /* public boolean remove(K k){
      BSTNode<K, T> tmp=root;
      BSTNode<K, T> tmp1=null;
      K k1=k;
      while(tmp!=null){    
      
         if(k.compareTo(tmp.key) == 0){
            if(tmp.left == null && tmp.right == null){
               if(k.compareTo(tmp1.key) > 0)
                  tmp1.right=null;
               else
                  tmp.left=null;
             }//leaf
            if(tmp.left == null && tmp.right != null || tmp.left != null && tmp.right == null){
               if(tmp.right !=null){
                  
                  if(tmp.left == null && tmp.right != null)
                     tmp1.right=tmp.right;
                  else
                     tmp1.right=tmp.left;
               }
               else{
                 
                  if(tmp.left == null && tmp.right != null)
                     tmp1.left=tmp.right;
                  else
                     tmp1.left=tmp.left;}
               }//one child
         
            if ((tmp.left != null) && (tmp.right != null)) {
               BSTNode<K,T> min = tmp.right;
               tmp1 = tmp;
               while (min.left != null) {
                  tmp1 = min;
                  min = min.left;
               }
               tmp.key = min.key;
               tmp.data = min.data;
               k1 = min.key;
               tmp = min;
                }//two children
           
         
            if (tmp1 == null) { // No parent for p, root must change
               root = tmp;
            } else {
               if (k1.compareTo(tmp1.key)==-1) {
                  tmp1.left = tmp;
               } else {
                  tmp1.right = tmp;
               }
            }
             length--;
            return true;  
            } 
         tmp1=tmp;
         if(k.compareTo(tmp.key) > 0)
            tmp=tmp.right;
         else
            tmp=tmp.left;
      
      }
        
      return false;
   }*/
         
        /////////////////////////////
   public boolean remove(K k){
      BSTNode<K, T> tmp=root;
      BSTNode<K, T> q=null;
      K k1=k;
      while (tmp != null) {
         if (k1.compareTo(tmp.key)==-1) {
            q =tmp;
            tmp = tmp.left;
         } else if (k1.compareTo(tmp.key)==1) {
            q = tmp;
            tmp= tmp.right;
         } 
         
         else { 
         
            if (tmp.left != null) {
               if (tmp.right != null) {
                  BSTNode<K,T> min = tmp.right;
                  q = tmp;
                  while (min.left != null) {
                     q = min;
                     min = min.left;
                  }
                  tmp.key = min.key;
                  tmp.data = min.data;
                  k1 = min.key;
                  tmp = min;
               }}
             
             
            if (tmp.left != null) { 
               tmp = tmp.left;
            } else { 
               tmp = tmp.right;
            }
         
            if (q == null) { 
               root = tmp;
            } else {
               if (k1.compareTo(q.key)==-1) {
                  q.left = tmp;
               } else {
                  q.right = tmp;
               }
            }
            length--;
            return true;
         }
      }
      return false; 
   }


        ////////////////////////////
    
   
   
   public List<K> getKeys(){
      List<K> listOfKeys=new LinkedList<K>();
      getKeys(listOfKeys,root);
      
      
      return listOfKeys;
   }

   private void getKeys(List<K>listOfKeys,BSTNode<K,T>rootCopy) {
      if(rootCopy==null) 
         return;
      getKeys(listOfKeys, rootCopy.left);
      listOfKeys.insert(rootCopy.key);
      getKeys(listOfKeys, rootCopy.right); }
     
       
      
}




