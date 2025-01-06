# java-pilot
Projeto de estudo.


## Como rodar o projeto?

### Requisitos:
    
    NetCat(https://www.ucartz.com/clients/knowledgebase/658/How-to-Install-and-Use-netcat-Command-on-Linux.html)

    RabbitMQ(https://medium.com/xp-inc/rabbitmq-com-docker-conhecendo-o-admin-cc81f3f6ac3b)

### Nescessario criar uma fila no rabbitMQ
- my_queue

### Criar um exchange
 - my_exchange

### Fazer o bind na fila com o exchange e um routing key
 - my_routing_key

### Para rodar o socket server, nescessario fazer uma requisicao http, pode ser pelo navegador mesmo.
 - http://localhost:8080/startServer

### Agora eh soh conectar ao socket via NetCat e enviar uma string.
### A mesma deve ir para o rabbitMQ.

### Formato necessario da mensagem: "POS;FOX23;001;-0;-0"

## Exemplo:

  >nc 0.0.0.0 8000

  POS;FOX23;001;-0;-0

### A mensagem no rabbitMQ deve aparecer assim:

"POS;FOX23;001;-0;-99BREAKPOSBREAK20250106 12:01:08"