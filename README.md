# API - Sua Conta Basa
1. Banco de Dados H2 - Local
2. Relação OneToOne
3. Porta padrão: 8080 

## Requisição POST
Exemplo de url com criação de contas
```bash

curl -X POST "http://localhost:8080/api/v1/contas/cadastro/9?agencia=7&dataVigencia=2025%2F10%2F02&saldo=500&senha=adm123&status=ATIVA&tipoConta=PJ" -H  "accept: */*" -d ""

```
No cadastro de Pessoas, é utilizado um corpo em JSON

```JSON
{
	  "idFiscal": 12345678,
	  "nome": "André Matos",
	  "dataNascimento": "1984-08-14T13:42:56.151Z",
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