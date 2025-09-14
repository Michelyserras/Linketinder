# Projeto Linketinder
#### **Desenvolvido por Michely Serras**


## Descrição
Este projeto é uma aplicação Groovy que simula uma plataforma de conexão entre candidatos e empresas, permitindo cadastro, visualização dos candidatos e empresas. O projeto utiliza o padrão MVC (Model-View-Controller) para organizar o código.

## **Entidades**
- **Pessoa**
- **PessoaFisica**
- **PessoaJuridica**

## **Funcionalidades**
- Cadastro de pessoas físicas e jurídicas.
- Listagem de perfis cadastrados de Pessoas Fisica e Juridicas.


## **Estrutura do Projeto**

```
Linketinder/
├── src/
│   ├── main/
│   │   ├── groovy/
│   │   │   └── org/
│   │   │       └── example/
│   │   │           ├── Controller/
│   │   │           │   ├── PessoaFisicaController.groovy
│   │   │           │   └── PessoaJuridicaController.groovy
│   │   │           ├── Model/
│   │   │           │   ├── Pessoa.groovy
│   │   │           │   ├── PessoaFisica.groovy
│   │   │           │   └── PessoaJuridica.groovy
│   │   │           ├── view/
│   │   │           │   ├── MainView.groovy
│   │   │           │   ├── PessoaFisicaView.groovy
│   │   │           │   └── PessoaJuridicaView.groovy
│   │   │           └── App.groovy
│   │   └── resources/
│   └── test/
│       └── groovy/
│       └── resources/
├── build.gradle
├── settings.gradle
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
└── README.md
```

## **Como Executar o Projeto**

**Pré-requisitos:**
- Java 8 ou superior
- Gradle instalado
- IntelliJ IDEA 

**Passos para execução:**
1. Clone o repositório:
   ```sh
   git clone https://github.com/Michelyserras/Linketinder.git
   cd linketinder
   ```
2. Abra o projeto no IntelliJ IDEA:
   - File → Open → Selecione a pasta do projeto
   - O IntelliJ detectará automaticamente o projeto Gradle
3. Execute via IntelliJ:
   - Navegue até `src/main/groovy/org/example/App.groovy`
   - Clique com botão direito → Run 'App'
4. Ou execute via linha de comando:
   ```sh
   gradle run
   ```
5. Ou compile e execute manualmente:
   ```sh
   gradle build
   gradle installDist
   ./build/install/Linketinder/bin/Linketinder
   ```


## Observações
- O projeto foi desenvolvido em Groovy, utilizando Gradle como ferramenta de build.


### Desenvolvido por Michely Serras



