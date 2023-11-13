import static org.junit.Assert.*;
import org.junit.Test;

public class ItemTest {

    @Test
    public void testIsEmprestavel() {
        Item livro = new Livro("Clean Code", "Robert C. Martin", 2008, 5);
        assertTrue(livro.isEmprestavel());
    }

    @Test
    public void testPodeSerEmprestado() {
        Item livro = new Livro("Clean Code", "Robert C. Martin", 2008, 5);
        assertTrue(livro.podeSerEmprestado());
    }

    @Test
    public void testEmprestarItem() {
        Item livro = new Livro("Clean Code", "Robert C. Martin", 2008, 5);
        int initialQntdDeVezesEmprestado = livro.getQntdDeVezesEmprestado();

        livro.emprestarItem();

        assertEquals(initialQntdDeVezesEmprestado + 1, livro.getQntdDeVezesEmprestado());
    }

    @Test
    public void testGetTipo() {
        Item livro = new Livro("Clean Code", "Robert C. Martin", 2008, 5);
        
        assertEquals(Item.ETipoItem.LIVRO, livro.getTipo());
    }

}
