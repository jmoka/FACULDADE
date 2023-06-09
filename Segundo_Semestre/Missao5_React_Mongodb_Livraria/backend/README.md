# BACKEND SISTEMA CRUD NODE.JS E MONGODB
## REQUSITOS

### 1 - INSTALATÇÃO 

### REPOSITÓRIODOS PROGRAMAS (TecEdu4All)
    https://drive.google.com/drive/folders/17GyJ638BBF6nV_dI_9ociqwVDJPjWSqz

    - Insomnia.setup.6.3.2.exe
    - mongodb-win32-x86_64-2008plus-ssl-4.0.5-signed.msi
    - node-v12.18.3-x64.msi
    - robo3t-1.2.1-windows-x86_64-3e50a65.exe
    - VSCodeUserSetup-x64-1.30.1.exe


### Intalar NPM
    Em uma pasta vazia rode o seguinte comando
        npm init 
        ou
        npm init -y ( instalação rápida sem preguntas)
    
    Será feito diversas perguntas :
    - package name: (backend) -  coloque o nome de seu projeto ( não pode conter letras maiusculas no nome)
    -version: (1.0.0)
    - description: ( pode colocar uma descrição se quiser não é obrigado é so apertar enter ) 
    - entry point: (index.js) -  gerenciador padão de todo o projeto
    - test command:
    - git repository:
    - keywords:
    - author:
    - license: (ISC)
About to write to C:\Users\jotac\Documents\JOTA_GIT_ARQUIVOS\n2m5\backend\package.json:

{
  "name": "banckend_mongodb",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "author": "",
  "license": "ISC"
}


Is this OK? (yes)  - y


foi criado o arquivo ()package.jason

==========================
### INSTALAÇÃO DAS DEPENDENCIAS
#### cors
    npm install cors
#### express
    npm install express
#### mongoose
    npm instal mongoose
    npm instal mongoose-paginate
#### require-dir
    npm install require-dir
#### nodemon
    npm install -D nodemon
#### Podemos instalar atodos em uma so linha
    npm install express nodemon mongoose cors mongoose-paginate require-dir


#### Arquivo packege.json
    {
  "name": "banckend_mongodb",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "author": "",
  "license": "ISC",
  "dependencies": {
    "cors": "^2.8.5",
    "express": "^4.18.2",
    "mongoose": "^7.2.2",
    "mongoose-paginate": "^5.0.3",
    "require-dir": "^1.2.0"
  },
  "devDependencies": {
    "nodemon": "^2.0.22"
  }
}

#### Obs Instalar as dependencias de outra forma
    Copie e cole o o codigo acima no arquivo packege.json , após copiar e colar rode o comando:

    npm install 
    npm install -D nodemon

    Isso fá instalar todas as dependencias listada no arquivo packege.json

