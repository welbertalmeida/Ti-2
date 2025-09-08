

# 🚀 Projetos Ti 2 — Exercícios

Este repositório contém **três exercícios** em Java desenvolvidos em ti 2:
## 📘 Exercício 1 — CPostgreSQL (Eclipse)

---
Somar dois numero no eclipse

## 📘 Exercício 2 — CRUD Java + PostgreSQL (Eclipse)

Projeto simples de CRUD em Java usando JDBC e PostgreSQL.

### Estrutura

* **DAO2.java** → Classe para manipulação da tabela `x`.
* **X.java** → Modelo da tabela `x`.
* **Principal2.java** → Classe principal com menu CRUD.
* **DAO.java** → Base de conexão com o banco.

### Requisitos

* Java 8+
* PostgreSQL 14+
* Eclipse IDE (ou qualquer IDE Java)

### Passos para rodar

1. Criar a tabela `x` no PostgreSQL.
2. Configurar as credenciais do banco em `DAO.java`.
3. No Eclipse, rodar a classe `Principal2`.

---

## 📗 Exercício 3 — CRUD Produto com Spark + PostgreSQL (Java + Maven)

Projeto de CRUD Web (Produto) usando **Spark Framework**, **Maven** e **PostgreSQL**.
Inclui **formulário HTML** e API JSON.

### 🧰 Tecnologias

* Java 17+
* Maven 3.8+
* PostgreSQL 14+
* Spark Framework
* Gson
* (Opcional) FreeMarker para templates

### Estrutura sugerida

```
/src/main/java/br/com/seuprojeto/
│   ├─ App.java            # Classe main com rotas Spark
│   ├─ dao/ProdutoDAO.java # Acesso ao banco
│   ├─ model/Produto.java  # Entidade Produto
│   └─ service/ProdutoService.java (opcional)
```

### Banco de Dados

```sql
CREATE DATABASE loja;
CREATE USER loja_user WITH ENCRYPTED PASSWORD 'loja_pass';
GRANT ALL PRIVILEGES ON DATABASE loja TO loja_user;

CREATE TABLE IF NOT EXISTS produto (
  id          SERIAL PRIMARY KEY,
  nome        VARCHAR(120) NOT NULL,
  descricao   TEXT,
  preco       NUMERIC(10,2) NOT NULL DEFAULT 0,
  quantidade  INTEGER NOT NULL DEFAULT 0,
  created_at  TIMESTAMP NOT NULL DEFAULT NOW()
);
```

### Configuração

Arquivo `src/main/resources/application.properties`:

```properties
DB_HOST=localhost
DB_PORT=5432
DB_NAME=loja
DB_USER=loja_user
DB_PASS=loja_pass
APP_PORT=4567
```

### Dependências principais (`pom.xml`)

```xml
<dependencies>
  <dependency>
    <groupId>com.sparkjava</groupId>
    <artifactId>spark-core</artifactId>
    <version>2.9.4</version>
  </dependency>
  <dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.11.0</version>
  </dependency>
  <dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.3</version>
  </dependency>
</dependencies>
```

### Rotas principais

| Método | Rota                   | Descrição                   |
| ------ | ---------------------- | --------------------------- |
| GET    | `/produtos`            | Listar produtos (HTML/JSON) |
| GET    | `/produtos/novo`       | Formulário de criação       |
| POST   | `/produtos`            | Criar produto               |
| GET    | `/produtos/:id`        | Detalhar produto            |
| POST   | `/produtos/:id`        | Atualizar produto           |
| POST   | `/produtos/:id/delete` | Excluir produto             |

### Como executar

```bash
mvn clean package
java -jar target/seu-projeto-1.0-SNAPSHOT-shaded.jar
```

Acesse [http://localhost:4567](http://localhost:4567)

---

## ✅ Entrega
