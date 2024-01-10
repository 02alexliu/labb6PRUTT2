import java.security.spec.ECFieldF2m;
import java.util.*;

public class glesVektor <E extends Comparable<E>> implements SparseVec<E>{
    TreeMap<Integer, E> Ourmap = new TreeMap<Integer, E>();

    public void add(E elem){
        int index = 0;
        while(true){
            if(Ourmap.get(index) == null){
                Ourmap.put(index, elem);
                return;
            }
            index++;
        }
        

    };           // add at lowest index >= 0 and not already occupied                                              
    public int indexOf(E elem){
        for (Map.Entry<Integer, E> entry : Ourmap.entrySet()){
            if(elem == entry.getValue()){  
                return entry.getKey();
            }
        }
        return -1;
    };        // find first (lowest index) occurence of elem, return its index,                       
        
    // if not found, return -1   
    public Object[] toArray(){
        Object[] EArray = new Object[this.maxIndex()+1];
        for (int i=0;i<maxIndex()+1;i++){
            if(Ourmap.get(i) != null){  
                EArray[i] = Ourmap.get(i);
            }else{
                EArray[i] = null;
            }
        }
        return EArray;
    };         // return the SparseVector as a regular array with value null at unused indexes                                          
    
    public List<E> sortedValues(){
        List<E> valuesList = new ArrayList<>(Ourmap.values());
        Collections.sort(valuesList);
        return valuesList;
    };     // return a List of the values of the Vector in sorted order
   
    public String toString(){
        StringBuilder OurString = new StringBuilder();
        for (Map.Entry<Integer, E> entry : Ourmap.entrySet()){
            OurString.append(Integer.toString(entry.getKey()));
            OurString.append(" ");
            OurString.append(entry.getValue());
            OurString.append("\n");
        }
        String result = OurString.toString();
        return result;
    };          // one line per element with index and value, sorted by index                                                     
             
    
    public void add(int pos, E elem){
        if(pos<0)
            pos = 0;
        Ourmap.put(pos,elem);
    };  // add elem at pos, if pos is occupied replace with elem, if pos<0 use index = 0        
    
    public void removeAt(int pos){
        Ourmap.remove(pos);
    };     // if index pos is not used, nothing happens                                            
    
    public void removeElem(E elem){
        for (Map.Entry<Integer, E> entry : Ourmap.entrySet()){
            if(elem == entry.getValue()){  
                Ourmap.remove(entry.getKey());
                return;
            }
        }
    };    // remove first occurence (lowest index) of elem                                        
    public int size(){
        return Ourmap.size();
    }
    public int minIndex(){
        try{
            return Ourmap.firstKey();
        }catch (NoSuchElementException e){
            return -1;
        } // hej
        
    };             // lowest index in use, if vector is empty return -1                                    
    public int maxIndex(){
        try{
            return Ourmap.lastKey();
        }catch (NoSuchElementException e){
            return -1;
        }
        

    }           // highest index in use, if vector is empty return -1                                   
    
    public E get(int pos){              // return null if not available  
        return Ourmap.get(pos);
    }

    public static void main(String[] args) {
        SparseVec<Integer> sparseVec = new glesVektor<>();
        sparseVec.add(1, 10);
        sparseVec.add(5, 50);
        sparseVec.add(10, 100);
        sparseVec.add(15, 1);
        sparseVec.add(16, 160);

        System.out.println("toString()-test: ");
        System.out.println(sparseVec);
        
        System.out.println("toArray()-test: ");
        Object[] sparseVecArray = sparseVec.toArray();
        for(Object element : sparseVecArray){
            System.out.println(element);
        }

        System.out.println("sortedValues()-test: ");
        for (Integer output: sparseVec.sortedValues())
            System.out.println(Integer.toString(output));
        
        
    }
                                                                        
}
/*Tips: Följande metoder kan implementeras på en eller två rader vardera genom 
att direkt utnyttja funktionalitet i TreeMap eller kombinera andra metoder i SparseVec:
 size(), minIndex(), maxIndex(), removeAt(pos), get(pos), removeElem(elem), add(pos,elem)
 */