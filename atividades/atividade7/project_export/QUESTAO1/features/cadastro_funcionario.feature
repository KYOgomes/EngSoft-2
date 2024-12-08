Feature: Gerenciamento de Funcionários
  Como gerente
  Eu quero cadastrar, consultar, excluir e alterar funcionários
  Para gerenciar o RH da empresa

  Scenario: Cadastro de novo funcionário
    Given que eu sou um gerente
    When eu cadastro um novo funcionário com os seguintes dados:
      | nome           | cpf          | cargo  | endereco                       | telefone         |
      | João da Silva  | 123.456.789-09 | Analista | Rua Exemplo, Belo Horizonte  | (31) 98765-4321 |
    Then o cadastro deve ser bem-sucedido

  Scenario: Cadastro de funcionário com CPF inválido
    Given que eu sou um gerente
    When eu tento cadastrar um novo funcionário com CPF "123.456.789-00"
    Then o sistema deve exibir uma mensagem de erro "CPF inválido"

  Scenario: Cadastro de funcionário com campos em branco
    Given que eu sou um gerente
    When eu tento cadastrar um novo funcionário com os seguintes dados:
      | nome  | cpf         | cargo  | endereco  | telefone  |
      |       | 123.456.789-09 | Analista |            |           |
    Then o sistema deve exibir uma mensagem de erro "Nenhum campo pode ficar em branco"

  Scenario: Cadastro de funcionário com endereço fora de Belo Horizonte
    Given que eu sou um gerente
    When eu tento cadastrar um novo funcionário com endereço "Rua Exemplo, São Paulo"
    Then o sistema deve exibir uma mensagem de erro "Endereço deve ser em Belo Horizonte"

  Scenario: Cadastro de funcionário com telefone fora do DDD 31
    Given que eu sou um gerente
    When eu tento cadastrar um novo funcionário com telefone "(11) 98765-4321"
    Then o sistema deve exibir uma mensagem de erro "DDD do telefone deve ser 31"

  Scenario: Consulta de funcionário
    Given que eu sou um gerente
    When eu consulto o funcionário com CPF "123.456.789-09"
    Then os dados do funcionário devem ser exibidos

  Scenario: Exclusão de funcionário
    Given que eu sou um gerente
    When eu excluo o funcionário com CPF "123.456.789-09"
    Then o funcionário deve ser removido do sistema

  Scenario: Alteração de dados de funcionário
    Given que eu sou um gerente
    When eu altero o cargo do funcionário com CPF "123.456.789-09" para "Gerente"
    Then o cargo do funcionário deve ser atualizado no sistema
