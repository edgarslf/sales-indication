# sales-indication


DESAFIO:

 Considere que você trabalha numa empresa que trabalha com integração de dados. Uma dessas integrações é de sua responsabilidade. Um parceiro quer enviar
a você uma requisição sempre que um produto é vendido. Ao integrar com seu serviço, ele informa o CPF do cliente, o Código do Produto, quantidade, valor , cidade e UF do cliente. É possível também que seja consultado as 5 últimas compras de um dado cliente

Seu serviço deve conter dois endpoints:

1) receber a requisição de venda e devolver como resposta a seguinte informação: Dado a cidade do cliente da requisição, informar qual é o produto mais vendido naquela Cidade do Cliente. Esta informação será usada pelo integrador para uma oferta futura ao cliente que está comprando o produto inicial.

2) Receber a requisição de consulta de um cliente e informar as 5 últimas compras: CPF, nome, endereço, produtos comprados (com valores da compra) e forma de pagamento escolhida.



## stack:
- Java 8
- Spring-boot 2.7.5
- Spring-data-jpa
- Lombok
- H2 Database


### Pattern MVC



**Para Rodar, utilize:**
```
mvn spring-boot:run
