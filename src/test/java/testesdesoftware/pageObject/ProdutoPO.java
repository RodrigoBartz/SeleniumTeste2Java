package testesdesoftware.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Classe PageObject de Produto
 */
public class ProdutoPO extends BasePO{
	
	//botão "Criar"
	@FindBy(id="btn-adicionar")
	public WebElement buttonCriar;
	
	//campo de input de "Código"
	@FindBy(id="codigo")
	public WebElement inputCodigo;
	
	//campo de input de "Nome"
	@FindBy(id="nome")
	public WebElement inputNome;
	
	//campo de input de "Quantidade"
	@FindBy(id="quantidade")
	public WebElement inputQuantidade;
	
	//campo de input de "Valor"
	@FindBy(id="valor")
	public WebElement inputValor;
	
	//campo de input de "Data"
	@FindBy(id="data")
	public WebElement inputData;
	
	//botão "Salvar"
	@FindBy(id="btn-salvar")
	public WebElement buttonSalvar;
	
	@FindBy(css="div.modal-content>div.modal-body>div.alert>span")
	public WebElement spanObrigatorio;
	
	/**
	 * método para criar um produto após clicar em "Salvar"
	 * @param codigo
	 * @param nome
	 * @param quantidade
	 * @param valor
	 * @param data
	 */
	public void executarAcaoDeCriarProduto(String codigo,String nome,String quantidade,String valor,String data) {
		buttonCriar.click();
		buttonCriar.click();
		escrever(inputCodigo, codigo);
		escrever(inputNome, nome);
		escrever(inputQuantidade, quantidade);
		escrever(inputValor, valor);
		escrever(inputData, data);
		buttonSalvar.click();
	}
	
	/**
	 * método para escrever em algum campo de input
	 * @param input
	 * @param texto
	 */
	private void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto + Keys.TAB);
	}
	/**
	 * método para pegar mensagem do campo de span
	 * @return
	 */
	public String obterMensagem() {
		return this.spanObrigatorio.getText();
	}
	
	public ProdutoPO(WebDriver driver) {
		super(driver);
	}

}
