# 📚 Literalura

Aplicação **Java + Spring Boot** desenvolvida para buscar livros da API pública **Gutendex (Project Gutenberg)**, armazená-los em um banco de dados **PostgreSQL** e disponibilizar consultas e estatísticas através de um **menu interativo no terminal**.

O projeto demonstra conceitos importantes de desenvolvimento backend como:

- Consumo de API REST
- Persistência de dados com **Spring Data JPA**
- Modelagem de entidades e relacionamentos
- Consultas derivadas (Derived Queries)
- Manipulação de dados com **Streams**
- Estrutura de projeto seguindo boas práticas de backend

---

# 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- API Gutendex
- Jackson (JSON parsing)

---

# 🧠 Funcionalidades

O sistema possui um menu interativo no terminal com as seguintes funcionalidades:

1. Buscar livro pelo título (consome a API Gutendex)  
2. Listar livros registrados no banco  
3. Listar autores registrados  
4. Buscar autores vivos em determinado ano  
5. Listar livros por idioma  
6. Exibir estatísticas de livros por idioma  

Regras implementadas:

✔ O sistema verifica se o livro já existe no banco antes de salvar  
✔ O mesmo livro não pode ser salvo duas vezes  
✔ O autor é persistido automaticamente ao salvar um livro  
✔ Existe relacionamento entre Livro e Autor  

---

# 🗄️ Banco de Dados

O projeto utiliza **PostgreSQL** para armazenamento dos dados.

## Entidades principais

### Autor

- id  
- nome  
- anoNascimento  
- anoFalecimento  

### Livro

- id  
- titulo  
- idioma  
- downloads  
- autor_id  

## Relacionamento

Autor (1) ---- (N) Livro

# ⚙️ Configuração do Projeto

## 1️⃣ Clonar o repositório

```bash
git clone https://github.com/seuusuario/literalura.git
cd literalura
```


---

## 2️⃣ Criar banco de dados

No PostgreSQL execute:


```sql
CREATE DATABASE literalura;
```


---

## 3️⃣ Configurar credenciais

 O arquivo de exemplo está em:

```markdown
src/main/resources/application-example.properties
```

 Copie ele para:

```markdown
src/main/resources/application.properties
```

Depois configure seu usuário e senha do PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```


---

# ▶️ Executar o Projeto

Via Maven:

```bash
mvn spring-boot:run
```
Ou execute diretamente a classe principal:

#### LiteraluraApplication.java

---

# 🌐 API Utilizada

Este projeto consome a API pública:

**Gutendex**

https://gutendex.com/

Exemplo de requisição:

https://gutendex.com/books/?search=frankenstein

---

# 🎯 Objetivo do Projeto

Este projeto foi desenvolvido com foco em praticar conceitos essenciais do desenvolvimento backend em Java, incluindo:

- Consumo de APIs REST
- Persistência de dados
- Modelagem relacional
- Boas práticas com Spring Boot
- Organização de projeto

---

# 👨‍💻 Autor

Desenvolvido por **Diogo**

Estudante de **Sistemas de Informação**

GitHub:
https://github.com/diogodb12

---

# 📌 Possíveis Melhorias Futuras

- Interface web com Spring MVC
- API REST para acesso externo
- Testes automatizados (JUnit)
- Containerização com Docker
- Deploy em nuvem

---

# ⭐ Observação

Este projeto foi desenvolvido como parte de estudos em **Java Backend e Spring Boot**, com foco em aprendizado e evolução para oportunidades de **estágio em desenvolvimento**.
