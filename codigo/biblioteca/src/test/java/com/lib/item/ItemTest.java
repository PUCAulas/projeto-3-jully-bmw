import static org.junit.Assert.*;
import org.junit.Test;

public class ItemTest {

    @Test
    public void testIsEmprestavel() {
        // Create a test instance of the Item class (you might need to adjust this based on your actual implementation)
        Item livro = new Livro("Clean Code", "Robert C. Martin", 2008, 5);
        
        assertTrue(livro.isEmprestavel());
    }

    @Test
    public void testPodeSerEmprestado() {
        // Create a test instance of the Item class (you might need to adjust this based on your actual implementation)
        Item livro = new Livro("Clean Code", "Robert C. Martin", 2008, 5);

        assertTrue(livro.podeSerEmprestado());
    }

    @Test
    public void testEmprestarItem() {
        // Create a test instance of the Item class (you might need to adjust this based on your actual implementation)
        Item livro = new Livro("Clean Code", "Robert C. Martin", 2008, 5);
        int initialQntdDeVezesEmprestado = livro.getQntdDeVezesEmprestado();

        livro.emprestarItem();

        assertEquals(initialQntdDeVezesEmprestado + 1, livro.getQntdDeVezesEmprestado());
    }

    @Test
    public void testGetTipo() {
        // Create a test instance of the Item class (you might need to adjust this based on your actual implementation)
        Item livro = new Livro("Clean Code", "Robert C. Martin", 2008, 5);
        
        assertEquals(Item.ETipoItem.LIVRO, livro.getTipo());
    }

    // Add more test cases for other methods as needed
}
