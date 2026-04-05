Quando tu poe @RabbitListener(queues = "died-pet-queue") src/main/java/com/bugpetconsumer/project/rabbitmq/DiedPetListener.java num método, o Spring AMQP precisa de alguém que, na prática:

1. Abra uma conexão com o RabbitMQ
2. Fique num loop escutando mensagens da fila
3. Pegue a mensagem bruta (bytes)
4. Desserialize ela (JSON → DTO)
5. Invoque o teu método
6. Faça o ack/nack (confirma pro Rabbit que processou, ou devolve)
7. Trate erros, retries, concorrência, etc.

Esse "alguém" é o MessageListenerContainer. Cada @RabbitListener vira um container desses rodando em background