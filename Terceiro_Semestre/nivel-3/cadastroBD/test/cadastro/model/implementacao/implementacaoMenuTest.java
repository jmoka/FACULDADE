/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cadastro.model.implementacao;

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
        System.out.println("MenuPrincipal");
        implementacaoMenu.MenuPrincipal();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testandoString method, of class implementacaoMenu.
     */
    @Test
    public void testTestandoString() {
        System.out.println("testandoString");
        String opcaoScolhida = "";
        String expResult = "";
        String result = implementacaoMenu.testandoString(opcaoScolhida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}