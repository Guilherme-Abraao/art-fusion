![image](https://github.com/user-attachments/assets/9c0ea1f4-9aa4-47a1-a3ec-cdaf96922a16)

O projeto final completo encontra-se disponível no seguinte diretório: [/projeto-art-fusion](/https://github.com/software-concorrente-distribuido/art-attack/tree/main/projeto-art-fusion)

# 💻 Projeto - Art Fusion 

### Escopo

O ArtFusion é uma plataforma online de criação colaborativa de arte, projetada para artistas de todas as habilidades e estilos. Com o ArtFusion, os usuários podem criar, colaborar e compartilhar obras de arte digital em tempo real, conectando-se com outros artistas em todo o mundo. Com uma interface intuitiva e uma variedade de ferramentas de desenho e pintura, a plataforma permite que os usuários expressem sua criatividade de maneira flexível e dinâmica.

A plataforma ArtFusion oferecerá aos artistas a oportunidade de se conectar e colaborar com colegas de todo o mundo, ampliando suas perspectivas e inspirações. Ao explorar e colaborar em uma variedade de projetos de arte, os usuários podem encontrar inspiração constante e novas perspectivas criativas.

Principais Funcionalidades:
O foco inicial será na implementação das seguintes funcionalidades principais:
Criação colaborativa de obras de arte em tempo real.
Ferramentas de desenho e pintura intuitivas.
Recursos para compartilhamento de obras de arte.


# 🚀 Tecnologias 

Esse projeto foi desenvolvido com as seguintes tecnologias:

- Frontend: React 
- Backend: Spring Boot (Framework Java)
- Banco de Dados: PostgreSQL
- Middleware de Mensageria: RabbitMQ (essencial para distribuir as atualizações de arte para os usuários conectados sem sobrecarregar o sistema.)
- Controle de versão: Git e GitHub 

# Instalação 

## Guia de execução do backend:

### Pré-requisitos
- **Java 21**: Assegure-se de que a JDK 21 está instalada e configurada corretamente em seu sistema.
- Ter o Docker instalado.
- Tenha um postgres com um banco de dados chamado "art-attack" criado.

### Instalação do backend:

- Clonar o repositório do projeto usando Git:
```
git clone https://github.com/software-concorrente-distribuido/art-attack
```

- Navegar até o diretório `/projeto-art-fusion/backend` ou abrir o projeto em uma IDE de sua preferência.
  
- No diretório `/projeto-art-fusion/backend`, abra o terminal e use o Docker Compose para iniciar o RabbitMQ:
```
docker-compose up -d
```
- Editar o `application-dev.properties` e alterar as seguintes configurações:
```
spring.datasource.username=<seu_username_local> 
spring.datasource.password=<sua_senha_local>
```
	
- Sete o Active Profile do IntelliJ para "dev".

- Execute a aplicação.

## Guia de execução do frontend:

### Pré-requisitos
- **Node.js e npm**: Certifique-se de ter o Node.js e npm instalados. Instalar [Node.js](https://nodejs.org/pt/download/package-manager) e [npm](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm).

### Instalação
  
- Navegar até o diretório `/projeto-art-fusion/artfusion-front`
- Instalar as dependências:
```
npm install
```
  
- Iniciar o servidor de desenvolvimento
```
npm start
```
  
- O servidor estará disponível no endereço http://localhost:3000



# 👥 Equipe

| Nome              | Função     | Usuário Git                                                                    	|
|-------------------|------------|-------------------------------------------------------------------------------------------------------------------------------------------------------|
| Karlla Loane     	  | Gerente do projeto, Frontend/Backend Developer, Analista de requisitos e documentação       | [karllaloane](https://github.com/karllaloane)		 	 |
| Bruna Souza    	  | Analista de requisitos, documentação e UI/UX Designer  		 			| [brunadoesp](https://github.com/brunadoesp)	 	 	 |
| Guilherme Abraão 	  | Frontend Developer, Analista de requisitos e documentação   				| [Guilherme-Abraao](https://github.com/Guilherme-Abraao)  	 |
| João Gabriel Tavares    | Backend Developer, Analista de requisitos e documentação   		  			| [JoaoUFG](https://github.com/JoaoUFG)	  			 |
| Luiz Felipe	          | Backend Developer, Analista de requisitos e documentação   		  			| [uLuizFelipe](https://github.com/uLuizFelipe)	  			 |


