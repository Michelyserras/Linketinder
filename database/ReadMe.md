## Modelagem de dados Linketinder

#### Diagrama de Entidade e Relacionamento (DER)

![DER](Linketinder%20DER.png)

Para a realização desse diagrama foi utilizado o software [dbdiagram](https://dbdiagram.io/).

## Executar scripts com psql (usuário `postgres`)

Exemplos rápidos — execute a partir da raiz do projeto ou ajuste os caminhos para a pasta `database/`:

```bash
# criar banco (usuário postgres via sudo)
sudo -u postgres 
createdb linketinder_db
\q

# importar estrutura (Tables-Linketinder.sql)
sudo -u postgres psql -d linketinder_db -f Tables-Linketinder.sql

# importar dados de exemplo (Dados_bdLinketinder.sql)
sudo -u postgres psql -d linketinder_db -f database/Dados_bdLinketinder.sql
```




