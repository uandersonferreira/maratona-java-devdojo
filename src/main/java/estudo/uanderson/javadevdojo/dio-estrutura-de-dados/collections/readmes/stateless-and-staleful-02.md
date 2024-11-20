**Autenticação Stateless e Stateful em Microserviços com Java 17, Spring Boot 3, JWT, PostgreSQL, Redis, Docker e Docker-compose: Um Guia Passo a Passo**

Olá! Eu sou Uanderson, um desenvolvedor Backend Java em formação, e hoje vou ajudar estudantes de programação a entender um tema essencial no mundo dos microserviços: os conceitos de autenticação *Stateless* e *Stateful*. Esses conceitos são fundamentais para garantir segurança e escalabilidade em sistemas modernos, especialmente quando usamos tecnologias como Java 17, Spring Boot 3, JWT, PostgreSQL, Redis, Docker, e Docker-compose. Vamos mergulhar fundo e esclarecer tudo isso com exemplos práticos!

### O Problema Que Vamos Resolver

Quando falamos de autenticação em microserviços, um dos maiores desafios é escolher entre uma abordagem *Stateless* ou *Stateful*. Qual é a mais adequada? Como cada uma delas afeta o desempenho, a segurança e a escalabilidade do sistema? É exatamente isso que vamos resolver hoje!

---

### **Autenticação Stateful: O Clássico Controle de Sessão**

Para entender o conceito de autenticação *Stateful*, imagine que você vai a uma biblioteca. Quando você entra, recebe um cartão de membro que precisa ser mostrado toda vez que quiser pegar um livro. A biblioteca lembra de você, mantém suas informações e sabe exatamente quantos livros você já pegou. Esse processo de "lembrar" quem você é representa a essência do *Stateful*.

No mundo dos microserviços, autenticação *Stateful* ocorre quando o servidor mantém as sessões dos usuários ativas em um armazenamento, geralmente um banco de dados como o **PostgreSQL** ou um cache como o **Redis**. Aqui, as sessões do usuário são salvas após o login, e a cada requisição, o sistema verifica o estado dessa sessão para autorizar a ação.

#### Como Funciona a Autenticação Stateful:
1. O usuário faz login no sistema.
2. O servidor cria uma sessão e salva no banco de dados ou cache (Redis, por exemplo).
3. A cada nova requisição, o cliente envia o identificador da sessão, e o servidor busca essa sessão para verificar a validade.
4. Se a sessão estiver válida, a requisição é autorizada.

#### Desvantagens:
- **Escalabilidade Limitada**: Manter sessões no servidor pode dificultar a escalabilidade, especialmente quando o sistema é distribuído em várias instâncias.
- **Gestão Complexa de Sessões**: Requer mais esforço para garantir consistência, especialmente em sistemas distribuídos.

### Exemplo Prático de Autenticação Stateful com Spring Boot e Redis

Vamos ver como implementar uma autenticação *Stateful* em uma aplicação Java com Spring Boot 3, Redis, PostgreSQL e Docker-compose.

#### Passo 1: Configurando Redis com Docker
No arquivo `docker-compose.yml`, configure o Redis:

```yaml
version: '3.8'
services:
  redis:
    image: "redis:alpine"
    ports:
      - "6379:6379"
```

#### Passo 2: Configuração do Spring Boot
No `application.properties`, configure o Redis como armazenamento de sessão:

```properties
spring.session.store-type=redis
spring.redis.host=localhost
spring.redis.port=6379
```

Com isso, as sessões dos usuários serão armazenadas no Redis, garantindo que o servidor possa manter o estado entre as requisições.

#### Passo 3: Implementando o Controlador de Login

```java
@PostMapping("/login")
public ResponseEntity<String> login(@RequestBody LoginRequest request) {
    // Autenticação do usuário
    String sessionId = generateSessionId();
    // Salva a sessão no Redis
    redisTemplate.opsForValue().set(sessionId, userData);
    return ResponseEntity.ok(sessionId);
}
```

---

### **Autenticação Stateless: Segurança Leve e Escalável**

Agora, pense na seguinte situação: você vai a um evento com um crachá que tem todas as suas informações. A cada lugar que você entra, o segurança só olha para o crachá e te deixa passar. Ele não precisa te conhecer ou lembrar quem você é; tudo o que ele precisa está no crachá. Esse é o conceito de *Stateless*.

Na autenticação *Stateless*, o servidor não mantém o estado do usuário entre as requisições. Em vez disso, todas as informações de autenticação e autorização são incluídas no próprio *token*, que geralmente é o **JWT (JSON Web Token)**. O servidor simplesmente valida o token a cada requisição, sem necessidade de buscar informações em um banco de dados ou cache.

#### Como Funciona a Autenticação Stateless:
1. O usuário faz login e recebe um **JWT**.
2. O JWT contém todas as informações necessárias (dados do usuário, permissões, etc.).
3. A cada nova requisição, o cliente envia o token no cabeçalho.
4. O servidor valida o token e autoriza a requisição.

#### Vantagens:
- **Escalabilidade Simples**: Não há necessidade de armazenar o estado no servidor, facilitando a escalabilidade horizontal.
- **Desempenho**: Reduz a necessidade de acessos a banco de dados ou cache, já que todas as informações estão no token.

#### Desvantagens:
- **Revogação Difícil**: Uma vez emitido, revogar o JWT pode ser complicado, já que ele não depende de um armazenamento central.
  
### Exemplo Prático de Autenticação Stateless com JWT e Spring Boot

#### Passo 1: Adicionando Dependências no `pom.xml`

```xml
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.9.1</version>
</dependency> 
```

#### Passo 2: Gerando o Token JWT

```java
public String generateToken(UserDetails userDetails) {
    return Jwts.builder()
            .setSubject(userDetails.getUsername())
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))  // 10 horas
            .signWith(SignatureAlgorithm.HS256, "secret_key")
            .compact();
}
```

#### Passo 3: Validando o Token em Cada Requisição

```java
public boolean validateToken(String token, UserDetails userDetails) {
    final String username = extractUsername(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
}
```

No caso de aplicações que precisam de alta escalabilidade e não querem lidar com o gerenciamento de sessões, o JWT é uma escolha excelente.

---

### Quando Escolher Autenticação *Stateful* ou *Stateless*?

- **Use Stateful** quando sua aplicação precisa de um controle rigoroso de sessões e o gerenciamento de estado é essencial, como em sistemas bancários ou de e-commerce.
  
- **Use Stateless** quando você precisar de escalabilidade, segurança e eficiência, como em APIs REST em arquiteturas de microserviços.

---

### Conclusão

A escolha entre autenticação *Stateless* e *Stateful* depende do contexto da sua aplicação e dos requisitos do sistema. Neste artigo, cobrimos os conceitos básicos e os passos para implementar cada abordagem usando Java 17, Spring Boot 3, JWT, PostgreSQL, Redis e Docker-compose. Agora, com essas informações em mãos, você está preparado para tomar decisões informadas e construir sistemas mais seguros e escaláveis!