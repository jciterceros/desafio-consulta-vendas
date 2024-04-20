# desafio-consulta-vendas

DESAFIO: Consulta vendas

Você deverá forkar o projeto abaixo e implementar as consultas como se pede a seguir.

### Projeto:

Trata-se de um sistema de vendas (Sale) e vendedores (Seller). Cada venda está para um vendedor, e um
vendedor pode ter várias vendas.

| Sale             | Sales * ------------- 1 seller | Seller        |
|------------------|--------------------------------|---------------|
| id: Long         |                                | id: Long      |
| visited: Integer |                                | name: String  |
| deals: Integer   |                                | email: String |
| amount: Double   |                                | phone: String |
| date: Date       |                                |               |

### Consultas:

<b>GET /sales/summary</b></br>
Deverá retornar o sumário de vendas por vendedor dos últimos 12 meses.

<b>GET /sales/summary?minDate=2022-01-01&maxDate=2022-06-30</b></br>
Deverá retornar o sumário de vendas por vendedor do período informado.

    ```json
    [
        {
            "sellerName": "Anakin",
            "total": 110571.0
        },
        {
            "sellerName": "Logan",
            "total": 83587.0
        },
        {
            "sellerName": "Loki Odinson",
            "total": 150597.0
        },
        {
            "sellerName": "Padme",
            "total": 135902.0
        },
        {
            "sellerName": "Thor Odinson",
            "total": 144896.0
        }
    ]
    ```

<b>GET /sales/report</b></br>
Deverá retornar o relatório de vendas dos últimos 12 meses.

<b>GET /sales/report?minDate=2022-05-01&maxDate=2022-05-31&name=odinson</b></br>
Deverá retornar o relatório de vendas do período/vendedor informados:

    ```
    {
        "content": [
            {
                "id": 9,
                "date": "2022-05-22",
                "amount": 19476.0,
                "sellerName": "Loki Odinson"
            },
            {
                "id": 10,
                "date": "2022-05-18",
                "amount": 20530.0,
                "sellerName": "Thor Odinson"
            },
            {
                "id": 12,
                "date": "2022-05-06",
                "amount": 21753.0,
                "sellerName": "Loki Odinson"
            }
        ],
        ...
    }
    ```

### Critérios de correção:
Mínimo para aprovação: 4 de 4
- Sumário de vendas por vendedor passando argumentos minDate e maxDate deve retornar os dados previstos no enunciado <b>(eliminatório)</b>
- Sumário de vendas por vendedor sem passar argumentos deve retornar os dados dos últimos 12 meses <b>(eliminatório)</b>
- Relatório de vendas sem passar argumentos deve retornar vendas dos últimos 12 meses <b>(eliminatório)</b>
- Relatório de vendas passando argumentos minDate e maxDate deve retornar os dados previstos no enunciado <b>(eliminatório)</b>

### Competências avaliadas:
- Realização de casos de uso
- Criação de endpoints de API Rest com parâmetros de consulta opcionais
- Implementação de consultas em banco de dados relacional com Spring Data JPA