import static org.junit.Assert.*;
import org.junit.Test;

public class SparseVecTest2 {
    
    @Test
    public void testEmpty() {
        SparseVec<Integer> sparseVec = new glesVektor2<>();

        // Testa OURsize, maxIndex och minIndex
        assertEquals(0, sparseVec.OURsize());
        assertEquals(-1, sparseVec.maxIndex());
        assertEquals(-1, sparseVec.minIndex());

        // Testa OURget()
        assertNull(sparseVec.OURget(0));

        // Testa toArray och sortedValues på den
        assertTrue(sparseVec.toArray().length == 0);
        assertTrue(sparseVec.sortedValues().isEmpty());

    } 

    @Test
    public void testIndex(){
        SparseVec<Integer> sparseVec = new glesVektor2<>();

        // Testa lägg in värden och kolla OURsize
        sparseVec.add(0, 5);
        assertEquals(1, sparseVec.OURsize());
        sparseVec.add(4, 10);
        assertEquals(2, sparseVec.OURsize());
        sparseVec.add(4, 9);        // Ska override värdet vid index 1.
        assertEquals(2, sparseVec.OURsize());

        // Testa min/maxindex
        assertEquals(0, sparseVec.minIndex());
        assertEquals(4, sparseVec.maxIndex());

        // Testa ospesificerade positioner
        SparseVec<Integer> sparseVec2 = new glesVektor2<>();

        // Testa lägg in värden och kolla OURsize
        sparseVec2.add(100);
        assertEquals(1, sparseVec2.OURsize());
        sparseVec2.add(200);
        assertEquals(2, sparseVec2.OURsize());
        sparseVec2.add(300);
        assertEquals(3, sparseVec2.OURsize());

        // Testa OURget()
        assertEquals(100, (int) sparseVec2.OURget(0));
        assertEquals(200, (int) sparseVec2.OURget(1));
        assertEquals(300, (int) sparseVec2.OURget(2));
        assertNull(sparseVec2.OURget(100));
    }

    @Test
    public void testRemove(){
        SparseVec<Integer> sparseVec = new glesVektor2<>();
        // lägg till tre värden
        sparseVec.add(0, 10);
        sparseVec.add(5, 50);
        sparseVec.add(10, 50);
        assertEquals(3, sparseVec.OURsize());

        // Använd removeAt och testa ny OURsize och OURget()
        sparseVec.removeAt(0);
        assertEquals(2, sparseVec.OURsize());
        assertNull(sparseVec.OURget(0));

        // Använd removeElem och testa ny OURsize och OURget()
        sparseVec.removeElem(50);    // Ska ta bort 50 vid index 5.
        assertEquals(1, sparseVec.OURsize());
        assertNull(sparseVec.OURget(5));
        assertEquals(50, (int) sparseVec.OURget(10));
    }
}
