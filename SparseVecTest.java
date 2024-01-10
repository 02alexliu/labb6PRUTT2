import static org.junit.Assert.*;
import org.junit.Test;

public class SparseVecTest {
    
    @Test
    public void testEmpty() {
        SparseVec<Integer> sparseVec = new glesVektor<>();

        // Testa size, maxIndex och minIndex
        assertEquals(0, sparseVec.size());
        assertEquals(-1, sparseVec.maxIndex());
        assertEquals(-1, sparseVec.minIndex());

        // Testa get()
        assertNull(sparseVec.get(0));

        // Testa toArray och sortedValues på den
        assertTrue(sparseVec.toArray().length == 0);
        assertTrue(sparseVec.sortedValues().isEmpty());

    } 

    @Test
    public void testIndex(){
        SparseVec<Integer> sparseVec = new glesVektor<>();

        // Testa lägg in värden och kolla size
        sparseVec.add(0, 5);
        assertEquals(1, sparseVec.size());
        sparseVec.add(4, 10);
        assertEquals(2, sparseVec.size());
        sparseVec.add(4, 9);        // Ska override värdet vid index 1.
        assertEquals(2, sparseVec.size());

        // Testa min/maxindex
        assertEquals(0, sparseVec.minIndex());
        assertEquals(4, sparseVec.maxIndex());

        // Testa ospesificerade positioner
        SparseVec<Integer> sparseVec2 = new glesVektor<>();

        // Testa lägg in värden och kolla size
        sparseVec2.add(100);
        assertEquals(1, sparseVec2.size());
        sparseVec2.add(200);
        assertEquals(2, sparseVec2.size());
        sparseVec2.add(300);
        assertEquals(3, sparseVec2.size());

        // Testa get()
        assertEquals(100, (int) sparseVec2.get(0));
        assertEquals(200, (int) sparseVec2.get(1));
        assertEquals(300, (int) sparseVec2.get(2));
        assertNull(sparseVec2.get(100));
    }

    @Test
    public void testRemove(){
        SparseVec<Integer> sparseVec = new glesVektor<>();
        // lägg till tre värden
        sparseVec.add(0, 10);
        sparseVec.add(5, 50);
        sparseVec.add(10, 50);
        assertEquals(3, sparseVec.size());

        // Använd removeAt och testa ny size och get()
        sparseVec.removeAt(0);
        assertEquals(2, sparseVec.size());
        assertNull(sparseVec.get(0));

        // Använd removeElem och testa ny size och get()
        sparseVec.removeElem(50);    // Ska ta bort 50 vid index 5.
        assertEquals(1, sparseVec.size());
        assertNull(sparseVec.get(5));
        assertEquals(50, (int) sparseVec.get(10));
    }
}
