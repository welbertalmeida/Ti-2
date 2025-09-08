#Projeto sclipse somar dois numeros em java
### Requisitos:
- Java 8 ou superior
- Eclipse IDE
- 
# Exercicio02 - CRUD Java PostgreSQL

Este projeto contém a implementação de um CRUD em Java usando PostgreSQL.  
O projeto possui:

- **DAO2.java**: Classe para manipulação da tabela `x`.
- **X.java**: Modelo da tabela `x`.
- **Principal2.java**: Classe principal com menu CRUD.
- Conexão com banco PostgreSQL usando DAO base.


## Como usar

1. Configure o banco PostgreSQL e crie a tabela `x`.  
2. Ajuste as credenciais no DAO.java.  
3. Compile e rode usando Maven:

```bash
mvn clean compile exec:java


### Exercício 3 — Integração Spark (Java + Maven + PostgreSQL)

Este repositório contém um **CRUD de Produto** implementado em **Java** usando **Spark Framework**, **Maven** e **PostgreSQL**, com **formulário HTML** para leitura e envio dos dados, conforme o enunciado do Exercício 3.

---

## 📌 Objetivo

Criar um backend Web em Java (Spark) com operações CRUD e um **formulário HTML** para cadastrar/editar produtos, similar aos exemplos WS03/WS04 do material da disciplina.

---

## 🧰 Stack e Requisitos

* **Java 17+** (ou versão indicada pelo professor)
* **Apache Maven 3.8+**
* **PostgreSQL 14+**
* **Spark Java** (microframework web)
* **Gson** (serialização JSON)
* **JDBC Driver PostgreSQL**
* (Opcional) **FreeMarker** ou HTML simples com templates próprios

---

## 🗂️ Estrutura sugerida do projeto

```
/ (raiz)
├─ src/
│  ├─ main/
│  │  ├─ java/
│  │  │  └─ br/com/seuprojeto/
│  │  │     ├─ App.java              # classe main com rotas Spark
│  │  │     ├─ dao/
│  │  │     │  └─ ProdutoDAO.java    # acesso ao banco
│  │  │     ├─ model/
│  │  │     │  └─ Produto.java       # entidade
│  │  │     └─ service/
│  │  │        └─ ProdutoService.java# regras de negócio (opcional)
│  │  ├─ resources/
│  │  │  ├─ templates/               # páginas HTML (lista, form, etc.)
│  │  │  └─ application.properties   # config do BD (ou .env)
│  │  └─ webapp/ (opcional)
│  └─ test/ (opcional)
├─ pom.xml
└─ README.md

```

---

## 🗃️ Banco de Dados

Crie o banco e a tabela `produto` no PostgreSQL.

### 1) Criar DB e usuário (exemplo)

```sql
CREATE DATABASE loja;
CREATE USER loja_user WITH ENCRYPTED PASSWORD 'loja_pass';
GRANT ALL PRIVILEGES ON DATABASE loja TO loja_user;
```

### 2) Criar tabela

```sql
CREATE TABLE IF NOT EXISTS produto (
  id          SERIAL PRIMARY KEY,
  nome        VARCHAR(120) NOT NULL,
  descricao   TEXT,
  preco       NUMERIC(10,2) NOT NULL DEFAULT 0,
  quantidade  INTEGER NOT NULL DEFAULT 0,
  created_at  TIMESTAMP NOT NULL DEFAULT NOW()
);
```

> Ajuste nomes/colunas conforme seu modelo do Exercício 2, se necessário.

---

## ⚙️ Configuração de ambiente

Configure as credenciais do PostgreSQL em `src/main/resources/application.properties` (ou use variáveis de ambiente):

```properties
DB_HOST=localhost
DB_PORT=5432
DB_NAME=loja
DB_USER=loja_user
DB_PASS=loja_pass
APP_PORT=4567
```

O `ProdutoDAO` deve ler estas propriedades para abrir a conexão JDBC.

---

## 📦 Dependências (pom.xml – exemplo)

Inclua as dependências principais:

```xml
<dependencies>
  <!-- Spark Framework -->
  <dependency>
    <groupId>com.sparkjava</groupId>
    <artifactId>spark-core</artifactId>
    <version>2.9.4</version>
  </dependency>

  <!-- Gson -->
  <dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.11.0</version>
  </dependency>

  <!-- PostgreSQL JDBC Driver -->
  <dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.3</version>
  </dependency>

  <!-- (Opcional) Template engine, caso utilize -->
  <dependency>
    <groupId>org.freemarker</groupId>
    <artifactId>freemarker</artifactId>
    <version>2.3.32</version>
  </dependency>
</dependencies>

<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <version>3.11.0</version>
      <configuration>
        <source>17</source>
        <target>17</target>
      </configuration>
    </plugin>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-shade-plugin</artifactId>
      <version>3.5.0</version>
      <executions>
        <execution>
          <phase>package</phase>
          <goals><goal>shade</goal></goals>
          <configuration>
            <createDependencyReducedPom>false</createDependencyReducedPom>
            <transformers>
              <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                <mainClass>br.com.seuprojeto.App</mainClass>
              </transformer>
            </transformers>
          </configuration>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
```

---

## 🌐 Rotas/Endpoints (exemplo)

| Método | Rota                   | Ação                                 |
| -----: | ---------------------- | ------------------------------------ |
|    GET | `/`                    | Home (redir. para lista de produtos) |
|    GET | `/produtos`            | Listar produtos (HTML)               |
|    GET | `/produtos/novo`       | Formulário de criação                |
|   POST | `/produtos`            | Criar produto (via formulário)       |
|    GET | `/produtos/:id`        | Detalhar produto (HTML/JSON)         |
|    GET | `/produtos/:id/editar` | Formulário de edição                 |
|   POST | `/produtos/:id`        | Atualizar produto (ou PUT via JSON)  |
|   POST | `/produtos/:id/delete` | Excluir produto (ou DELETE)          |

> Você pode expor também uma API JSON (ex.: `/api/produtos`) para testes com `curl`/Postman.

---

## 📝 Formulário HTML (exemplo mínimo)

Arquivo: `src/main/resources/templates/form_produto.html`

```html
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Novo Produto</title>
</head>
<body>
  <h1>Novo Produto</h1>
  <form action="/produtos" method="post">
    <label>Nome: <input type="text" name="nome" required></label><br>
    <label>Preço: <input type="number" step="0.01" name="preco" required></label><br>
    <label>Quantidade: <input type="number" name="quantidade" required></label><br>
    <label>Descrição:<br><textarea name="descricao"></textarea></label><br>
    <button type="submit">Salvar</button>
  </form>
</body>
</html>
```

---

## ▶️ Como executar

1. **Configurar o banco**: criar DB/tabela e ajustar `application.properties`.
2. **Build**:

   ```bash
   mvn clean package
   ```
3. **Rodar (jar empacotado)**:

   ```bash
   java -jar target/seu-projeto-1.0-SNAPSHOT-shaded.jar
   ```
4. **Acessar**: `http://localhost:4567`

> Em **Eclipse**: Importar *Existing Maven Project* ➜ Executar `App.main()`.

---

## 🔎 Testes rápidos (API JSON opcional)

```bash
# criar
curl -X POST http://localhost:4567/api/produtos \
  -H "Content-Type: application/json" \
  -d '{"nome":"Teclado","preco":120.90,"quantidade":5,"descricao":"Mecânico"}'

# listar
curl http://localhost:4567/api/produtos

# obter por id
curl http://localhost:4567/api/produtos/1

# atualizar
curl -X PUT http://localhost:4567/api/produtos/1 \
  -H "Content-Type: application/json" \
  -d '{"nome":"Teclado RGB","preco":149.90,"quantidade":7,"descricao":"ABNT2"}'

# deletar
curl -X DELETE http://localhost:4567/api/produtos/1
```

---

## ✅ Entrega

* **Envie o link do repositório GitHub** com o código-fonte completo.
* Inclua **instruções de execução** (este README) e **artefatos** relevantes (diagramas, SQL, etc.).
* Informe a **nota da sua autoavaliação** nos comentários da entrega.

---

## 📎 Dicas e boas práticas

* Separe **camadas**: *model* → *dao* → *service* → *web* (rotas).
* Trate erros e **valide dados** do formulário.
* Use `try-with-resources` no JDBC.
* Parametrize SQL (PreparedStatement) para evitar **SQL Injection**.
* Logue consultas/exceções para facilitar a correção.

---





