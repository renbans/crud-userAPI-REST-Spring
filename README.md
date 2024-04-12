##  **Sistema completo de gerenciamento de Usuários com uma API REST, utilizando o framework Spring Boot.**



**Funcionalidades:**

- **Crie**, **leia**, **atualize** e **exclua** (**CRUD**) usuário com facilidade.
- Acesse e manipule dados de usuário através de requisições HTTP padronizadas.
- Integre facilmente com outras aplicações e sistemas.

**Recursos:**

- Implementação completa do **CRUD** para usuários:

  - **Crie** novas usuários com informações completas.
  - **Leia** e consulte usuário por ID.
  - **Atualize** informações de usuário existentes.
  - **Exclua** usuário do sistema de forma segura.

- Mapeamento de objetos para JSON:

  - Converta objetos Java em JSON para facilitar a comunicação com o cliente.

- Validação de dados:

  - Garante a qualidade dos dados com validações de entrada e formato.

  - Exibe mensagens de erro claras e informativas para o cliente.

    

--------------

**Para executar o projeto no terminal, digite o seguinte comando:**

```
mvn spring-boot:run 
```



**Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:**

```
http://localhost:8080/crud-user/
```



**Exemplos de JSON para testes da API crud-user:**

**1. Criar um novo Usuário:**

```
{
  "firstName": "Ana",
  "lastName": "Silva",
  "cpf": "12345678900",
  "birthDate": "01-01-2000",
  "phones": [
    {
      "type": "MOBILE",
      "number": "1199999-9999"
    },
    {
      "type": "HOME",
      "number": "1199999-9999"
    }
  ]
}
```



**2. Listar todos os Usuário:**

```
GET /crud-user/
```

Esta requisição retornará todos  os usuário.



**3. Consultar um Usuário por ID:**

A requisição será feita através da URL da API, incluindo o ID do usuário desejado. Por exemplo:

```
GET /crud-user/1
```

Esta requisição consultará o usuário com ID igual a 1.



**4. Atualizar um Usuário:**

```
{
    "id": 1,
    "firstName": "Maria",
    "lastName": "Lima",
    "cpf": "12345678900",
    "birthDate": "02-02-2010",
    "phones": [
        {
            "id": 1,
            "type": "HOME",
            "number": "2188888-88888"
        },
        {
            "id": 2,
            "type": "COMMERCIAL",
            "number": "2188888-8888"
        }
    ]
}
```

O campo `id` é obrigatório para identificar o usuário que será modificado.



**5. Excluir um Usuário:**

A requisição será feita através da URL da API, incluindo o ID do Usuário a ser excluído. Por exemplo:

```
DELETE /crud-user/1
```

Esta requisição excluirá o usuário com ID igual a 1.



----------------

**Tecnologias utilizadas:**

- Java 11 ou versões superiores.

- Maven 3.6.3 ou versões superiores.

- Intellj IDEA Community Edition.

- Controle de versão GIT.

- Postman

  

------------------------------

**Framework e dependências:**

- Lombok

- Spring Boot DevTools

- Spring Web

- Spring Data JPA

- Spring Boot Actuator

- H2 Database

- Map Struct

  

----------------------

**Abaixo, seguem links sobre o projeto :**

- [SDKMan! para gerenciamento e instalação do Java e Maven](https://sdkman.io/)
- [Referência do Intellij IDEA Community, para download](https://www.jetbrains.com/idea/download)
- [Site oficial do Spring](https://spring.io/)
- [Site oficial do Spring Initialzr, para setup do projeto](https://start.spring.io/)
- [Documentação oficial do Lombok](https://projectlombok.org/)
- [Documentação oficial do Map Struct](https://mapstruct.org/)
- [Referência para o padrão arquitetural REST](https://restfulapi.net/)
