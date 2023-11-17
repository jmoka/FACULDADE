#obs: Optei em fazer o projeto utilizando o tomcat
##> não consegui fazer o ping , em nenhum dos banco de dados.
##> Instalei o GlassFish, porém ele não faz o pig. vi varios videos mas não consegui , e para não deixar de fazer , fiz com tomcat
##> utilizei o banco de dados Mysql

## No estudo podemos ter 2 abordagnem para criar o caminho no servlet (referenciar a classe)
### A primeira usando o arquivo web.xml - com o caminho /suariosServlet

	<servlet>
        	<servlet-name>UsuariosServlet</servlet-name>
        	<servlet-class>top.jota.servlets.UsuariosServlet</servlet-class>
    	</servlet>

    	<servlet-mapping>
       		<servlet-name>UsuariosServlet</servlet-name>
              	<url-pattern>/UsuariosServlet</url-pattern>
         	<url-pattern>/us</url-pattern>
        	<url-pattern>*.top</url-pattern>
        </servlet-mapping> 

### A segunda foi usando a anotation @WebServelet() - encima da classe servlet passando o caminha para ser acessada

	@WebServlet("/sa")
	public class UsuariosServlet1 extends HttpServlet {...}

## Importante
### Pode ser usado varios caminhos para uma mesma Servlet
	
	- Dessa Forma
	

		 <servlet-mapping>
        		 <servlet-name>UsuariosServlet</servlet-name>
        
       			 <url-pattern>/UsuariosServlet</url-pattern>
         		 <url-pattern>/us</url-pattern>
       			 <url-pattern>*.top</url-pattern>

    		</servlet-mapping> 

	- Ou Dessa - Usando urlPatterns={}
		@WebServlet(urlPatterns = {"/sa", "/no", "*.tf"})
		public class UsuariosServlet1 extends HttpServlet {...}

## Baixe e Instale o Mysql e o MySQLWorkbench .
### Rode o Script

	
	CREATE SCHEMA `loja1` ;

	use loja;

	CREATE TABLE produtos (
  	id_produto INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  	id_user INTEGER UNSIGNED NOT NULL,
  	nome VARCHAR(255) NOT NULL,
  	quantidade INTEGER UNSIGNED NULL,
  	preco_venda DECIMAL NULL,
  	data_compra DATE NOT NULL,
  	PRIMARY KEY(id_produto),
  	INDEX Table_Produtos_FKIndex1(id_user)
	);

	CREATE TABLE usuarios (
  	id_user INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  	nome VARCHAR(255) NOT NULL,
  	senha VARCHAR(255) NULL,
  	PRIMARY KEY(id_user)
	);


# Possui dois projeto.
## Ao realizar a chamada do jsp através das servlet com tomcat consegui normalmente com a versão 10.
## Ao utilizar nos jsp o jslt na versão 10 do tomcat não funcionou, por isso a opção de continuar o projeto com a versão 9 do tomcat


