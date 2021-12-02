# API - Sua Conta Basa
1. Banco de Dados H2 - Local;
2. Relação OneToOne;
3. Porta padrão: 8080; 
4. Classes responses estão sendo utilizadas corretamente;
5. Em buscar por nome e cpf, caso a pessoa cadastrada não tenha uma conta, é exibido apenas as informações pessoais como nome e cpf. Caso tenha uma conta, é exibido as informações completas com a conta.

## Requisição POST
#### Exemplo de url com criação de contas - Antigo
```bash

curl -X POST "http://localhost:8080/api/v1/contas/cadastro/9?agencia=7&dataVigencia=2025%2F10%2F02&saldo=500&senha=adm123&status=ATIVA&tipoConta=PJ" -H  "accept: */*" -d ""

```
### Cadastro de conta atual, necessita do parâmetro idPessoa
```JSON
{
  "agencia": 59,
  "senha": "copaverde",
  "tipoConta": "POUPANÇA"
}
```

### No cadastro de Pessoas, é utilizado um corpo em JSON

```JSON
{
  "idFiscal": 123456789,
  "nome": "Fulano",
  "dataNascimento": "1981-02-25T14:11:34.262Z",
  "tipoPessoa": "FISICA"
}
```

## Requisição PATCH
É usado apenas um parâmetro informando o número da conta e o corpo recebendo um valor Double informando o valor de saque ou depósito.

```bash
curl -X PATCH "http://localhost:8080/api/v1/contas/saque/9" -H  "accept: */*" -H  "Content-Type: application/json" -d "200"

```

## Requisição DELETE

É utilizado apenas um parâmetro informando o número da conta ou idPessoa a serem excluídos

```bash
curl -X DELETE "http://localhost:8080/api/v1/contas/desativacao/9" -H  "accept: */*"

```

## Requisição GET
É utilizado parâmetros simples de busca como 'nome','cpf','idConta','Agencia'

```bash

curl -X GET "http://localhost:8080/api/v1/pessoas/cpf-cnpj/789456321" -H  "accept: */*"
```

```JSON
{
  "idPessoa": 11,
  "idFiscal": 789456321,
  "nome": "Beltrano",
  "dataNascimento": "1998-10-01",
  "agencia": 98,
  "status": "DESATIVADO",
  "dataVigencia": "2021-11-07",
  "tipoConta": "PJ"
}
```