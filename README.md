# Exercício 2 - Integração Eclipse e PostgreSQL
repositorio : https://github.com/icei-pucminas/ti2cc.git
Este repositório contém a solução da tarefa **Exercício 2: Integração Eclipse e PostgreSQL**, proposta na disciplina de **Tecnologias para Internet II**.  
A atividade consiste em desenvolver um programa em **Java** no ambiente **Eclipse**, utilizando o **SGBD relacional PostgreSQL** para manipulação de dados.

---

## 📌 Problema Proposto

O aluno deve:

1. Criar uma tabela `X` no PostgreSQL.  
2. Criar uma classe `X` em Java.  
3. Implementar uma classe **DAO** para manipulação da classe `X`.  
4. Criar uma classe **Principal** contendo um menu com as opções:
   - Listar registros  
   - Inserir registro  
   - Excluir registro  
   - Atualizar registro  
   - Sair  

O programa deve realizar as operações **CRUD** (Create, Read, Update, Delete) no banco de dados.

---

## 🛠️ Estrutura da Solução

A solução foi organizada em pastas seguindo o padrão de projeto no Eclipse com **Maven**:

- `src/main/java/`  
  - **X.java** → Classe que representa a entidade da tabela no PostgreSQL.  
  - **XDAO.java** → Classe de acesso a dados (Data Access Object), responsável pela comunicação com o banco.  
  - **Principal.java** → Classe que contém o menu de interação com o usuário e chama os métodos da DAO.  

- `pom.xml` → Arquivo Maven que gerencia as dependências, incluindo o **driver JDBC do PostgreSQL**.  

---

## 💾 Banco de Dados

Exemplo de criação da tabela utilizada no PostgreSQL:

```sql
CREATE TABLE X (
    INSERT INTO usuario (codigo, login, senha, sexo) VALUES (3, 'maria', 'maria', 'F');
INSERT INTO usuario (codigo, login, senha, sexo) VALUES (4, 'luciana', 'luciana', 'F');
INSERT INTO usuario (codigo, login, senha, sexo) VALUES (5, 'juliana', 'juliana', 'F');
INSERT INTO usuario (codigo, login, senha, sexo) VALUES (6, 'paula', 'paula', 'F');
INSERT INTO usuario (codigo, login, senha, sexo) VALUES (7, 'carol', 'carol', 'F');
INSERT INTO usuario (codigo, login, senha, sexo) VALUES (8, 'joao', 'joao', 'M');
INSERT INTO usuario (codigo, login, senha, sexo) VALUES (9, 'pedro', 'pedro', 'M');
INSERT INTO usuario (codigo, login, senha, sexo) VALUES (10, 'paulo', 'paulo', 'M');
