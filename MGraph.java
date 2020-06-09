public class MGraph<K extends Comparable<K>> implements Graph<K> {
	public Map<K, List<K>> adj; // Do not change this
	public MGraph() {
	 adj=new BSTMap<K,List<K>>();
	}
	public boolean addNode(K i){
   List<K> NewList=new LinkedList<K>();
   return adj.insert(i,NewList);
        }

	public boolean isNode(K i){   
    Pair<Boolean,List<K>> pai =adj.retrieve(i);
   return pai.first;
   }
	public boolean addEdge(K i, K j){
   Pair<Boolean,List<K>> pai =adj.retrieve(i);
   if (pai.first==false)
   return false;
   if (this.isNode(j)==false)
   return false;
   //exsits
    Pair<Boolean,List<K>> paii =adj.retrieve(i);
    Pair<Boolean,List<K>> paij =adj.retrieve(j);
  if(paii.second.exists(j))
  return false;
   if(paij.second.exists(i))
  return false;
 paii.second.insert(j);
 paij.second.insert(i);
 return true;
   }
   
	public boolean isEdge(K i, K j){
    Pair<Boolean,List<K>> paii =adj.retrieve(i);
    Pair<Boolean,List<K>> paij =adj.retrieve(j);
  if(paii.second.exists(j))
   if(paij.second.exists(i))
  return true;
  return false;
   }

	public List<K> neighb(K i){
   return adj.retrieve(i).second;
   }

	public int deg(K i){
   int count=0;
    if(!isNode(i))
    return -1;
   return adj.retrieve(i).second.size();
   }

	public List<K> getNodes(){
    return adj.getKeys();
   }


   }


