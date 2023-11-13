/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cadastro.model.implementacao;

import cadastro.model.dao.view.viewMenu;
import static java.lang.System.out;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jotac
 */
public class implementacaoMenuTest {
    
    public implementacaoMenuTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of MenuPrincipal method, of class implementacaoMenu.
     */
    @Test
    public void testMenuPrincipal() {
        out.println("MenuPrincipal");
        viewMenu.MenuPrincipal();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testandoString method, of class implementacaoMenu.
     */
    @Test
    public void testTestandoString() {
        out.println("testandoString");
        String opcaoScolhida = "";
        String expResult = "";
        String result = viewMenu.testandoString(opcaoScolhida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
