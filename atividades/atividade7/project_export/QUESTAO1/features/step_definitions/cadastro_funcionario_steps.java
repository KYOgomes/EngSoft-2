package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import com.github.brazilian_utils.BrazilianUtils;

import java.util.Map;

public class CadastroFuncionarioSteps {

    private boolean cadastroSucesso;
    private String erroMensagem;

    @Given("que eu sou um gerente")
    public void queEuSouUmGerente() {
        // Código para autenticar ou verificar que o usuário é um gerente.
    }

    @When("eu cadastro um novo funcionário com os seguintes dados:")
    public void euCadastroUmNovoFuncionarioComOsSeguintesDados(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> dadosFuncionario = dataTable.asMap(String.class, String.class);
        validarDadosFuncionario(dadosFuncionario);
    }

    @When("eu tento cadastrar um novo funcionário com CPF {string}")
    public void euTentoCadastrarUmNovoFuncionarioComCPF(String cpf) {
        validarCpf(cpf);
    }

    @When("eu tento cadastrar um novo funcionário com os seguintes dados:")
    public void euTentoCadastrarUmNovoFuncionarioComOsSeguintesDados(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> dadosFuncionario = dataTable.asMap(String.class, String.class);
        validarDadosFuncionario(dadosFuncionario);
    }

    @When("eu tento cadastrar um novo funcionário com endereço {string}")
    public void euTentoCadastrarUmNovoFuncionarioComEndereco(String endereco) {
        validarEndereco(endereco);
    }

    @When("eu tento cadastrar um novo funcionário com telefone {string}")
    public void euTentoCadastrarUmNovoFuncionarioComTelefone(String telefone) {
        validarTelefone(telefone);
    }

    @When("eu consulto o funcionário com CPF {string}")
    public void euConsultoOFuncionarioComCPF(String cpf) {
        // Código para consultar o funcionário.
    }

    @When("eu excluo o funcionário com CPF {string}")
    public void euExcluoOFuncionarioComCPF(String cpf) {
        // Código para excluir o funcionário.
    }

    @When("eu altero o cargo do funcionário com CPF {string} para {string}")
    public void euAlteroOCargoDoFuncionarioComCPFPara(String cpf, String novoCargo) {
        // Código para alterar o cargo do funcionário.
    }

    @Then("o cadastro deve ser bem-sucedido")
    public void oCadastroDeveSerBemSucedido() {
        Assert.assertTrue(cadastroSucesso);
    }

    @Then("o sistema deve exibir uma mensagem de erro {string}")
    public void oSistemaDeveExibirUmaMensagemDeErro(String mensagem) {
        Assert.assertEquals(mensagem, erroMensagem);
    }

    @Then("os dados do funcionário devem ser exibidos")
    public void osDadosDoFuncionarioDevemSerExibidos() {
        // Código para verificar a exibição dos dados do funcionário.
    }

    @Then("o funcionário deve ser removido do sistema")
    public void oFuncionarioDeveSerRemovidoDoSistema() {
        // Código para verificar a remoção do funcionário.
    }

    @Then("o cargo do funcionário deve ser atualizado no sistema")
    public void oCargoDoFuncionarioDeveSerAtualizadoNoSistema() {
        // Código para verificar a atualização do cargo do funcionário.
    }

    // Funções de validação

    private void validarDadosFuncionario(Map<String, String> dados) {
        if (dados.values().stream().
