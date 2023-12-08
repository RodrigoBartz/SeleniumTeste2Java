package testesdesoftware.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testesdesoftware.pageObject.ProdutoPO;


/**
 * Classe de testes para a tela de produtos
 */
public class ProdutoTest extends BaseTest{

	private static ProdutoPO produtoPage;
	
	/**
	 * Utilizando BeforeClass para preparar o teste 
	 */
	@BeforeClass
	public static void prepararTestesProduto() {
		produtoPage = new ProdutoPO(driver);
	}
	
	/**
	 * Teste que coloca itens nos campos e checa se botão salvar está funcionando
	 */
	@Test
	public void TC001_deveChecarBotaoSalvar() {
		produtoPage.executarAcaoDeCriarProduto("0", "Prato", "5", "10", "09082000");
		
		String logo = driver.findElement(By.className("navbar-brand")).getText();
		
		assertEquals(logo,"Controle de produtos");
	}
	
	/**
	 * Teste para checar se, ao não escrever em todos os campos, irá mostrar mensagem de span
	 */
	@Test
	public void TC002_deveChecarOSpanDeCamposObrigatorios() {
		produtoPage.executarAcaoDeCriarProduto("", "", "", "", "");
		
		String mensagem = produtoPage.obterMensagem();
		
		assertEquals(mensagem,"Todos os campos são obrigatórios para o cadastro!");
		
	}
}
