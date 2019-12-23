  


---

#1 - Passo - Flyway


	Criar um schema no mysql
	
> schema = db-eicon  
> usuario = root  
> password = root  

 	Na 1 execução os parametros abaixo devem estar descomentados no application.properties.  
 	As flags abaixo vão permitir que se crie as tabelas e carregue os seus dados.  

>	spring.flyway.enabled=true  
>	spring.flyway.baseline-on-migrate=true  

---

#2 - OpenApi 3.0


> 
	http://localhost:8080/swagger-ui.html    
>

#3 - Exemplos  

Filtro dinamico por JPQL **http://localhost:8080/pedido/filtroPorJPQL**

**POST** para a url [](http://localhost:8080/pedido/filtroPorJPQL "Efetua a busca pelo filtro")  




### EX. 1 - Retorna todos os pedidos pela data do pedido

>
	{  
	 	"dataDoPedido": "01/12/2019"  
	}  
>

### EX. 2 - Retorna todos os pedidos que corresponderem extamente a todos os campos descritos

> 

    {
        "id": 1,
        "idCliente": 1,
        "dataDoPedido": "01/12/2019",
        "valorTotalDoPedido": 10.01,
        "listaPedidoItens": [
            {
                "quantidade": 2,
                "valorTotalItensDoPedido": 20.02,
                "produto": {
                    "descricao": "Produto A",
                    "valorProduto": 10.01
                }
            }
        ]
    }

> 

### EX. 3 - Retorna todos os pedidos que possuem a palavra "Produto"
    {
        "listaPedidoItens": [
            {
                "produto": {
                    "descricao": "Produto"
                }
            }
        ]
    }
>


>

		
