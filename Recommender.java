
import java.io.File;
import java.util.Scanner;
@SuppressWarnings("unchecked")

public class Recommender {

	// Return the top k recommended friends for user i using the popular nodes method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
   public static <K extends Comparable<K>> PQK<Double, K> recommendPop(Graph<K> g, K i, int k) {
      if(g.isNode(i)){
         PQK<Double, K> newPQ= new PQKImp<Double, K>(k);
         List<K> newList = g.getNodes(); 
         if(newList.empty() || newList==null )
            return null;
         newList.findFirst();
         for(int j=0;j<newList.size();j++){
            if(newList.retrieve().compareTo(i)!=0){
               if(!g.isEdge(i,newList.retrieve())){
                  newPQ.enqueue(new Double(g.deg(newList.retrieve())),newList.retrieve());}}
            newList.findNext();
         }
         return newPQ;
      }
      return null;
   }

	// Return the top k recommended friends for user i using common neighbors method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
   public static <K extends Comparable<K>> PQK<Double, K> recommendCN(Graph<K> g, K i, int k) {
      if(g.isNode(i)){
         PQK<Double, K> newPQ= new PQKImp<Double, K>(k);
         int Comn=0;
         List<K> newList = g.getNodes(); 
         if(newList.empty() || newList==null)
            return null;
         newList.findFirst();
         List<K> nebors1=g.neighb(i);
         List<K> nebors2 =new LinkedList();
         for(int j=0;j<newList.size();j++){
            if(newList.retrieve().compareTo(i)!=0){
               if(!g.isEdge(i,newList.retrieve())){
                  nebors2 = g.neighb(newList.retrieve());
               //No Of Common
                /*  if(nebors1.empty() && nebors2.empty() && nebors1==null && nebors2==null )
                     Comn= 0;
                  else{
                     nebors1.findFirst();
                     for(j=0;j<nebors1.size();j++){
                        if(nebors2.exists(nebors1.retrieve()))
                           Comn++;
                        nebors1.findNext();}}
               //*/
               Comn = CommonNep(nebors2, nebors1); 
                  newPQ.enqueue(new Double(Comn),newList.retrieve());}}
            newList.findNext();}
         return newPQ; 
      }
      return null;
   }
   
 
	// Read graph from file. The file is a text file where each line contains an edge. The end and start of the edge are separated by space(s) or tabs.
   public static Graph<Integer> read(String fileName) {
   
      try {
         Graph<Integer> g = new MGraph<Integer>();
         Scanner scanner = new Scanner(new File(fileName));
         while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            g.addNode(i);
            int j = scanner.nextInt();
            g.addNode(j);
            g.addEdge(i, j);
         }
         scanner.close();
         return g;
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }
   
     public static<K extends Comparable> int CommonNep(List<K>nebors2,List<K>nebors1) {
      int count=0;
     if(nebors1.empty()) 
         return 0;
     if(nebors2.empty()) 
         return 0;
     if(nebors1==null) 
         return 0;
     if(nebors2==null) 
         return 0;
       nebors1.findFirst();
                     for(int j=0;j<nebors1.size();j++){
                     nebors2.findFirst();
                      for(int e=0;e<nebors2.size();e++){
                        if(nebors2.retrieve().equals(nebors1.retrieve()))
                           count++;
                           nebors2.findNext(); }
                        nebors1.findNext();
      
      }
      return count; }

}
