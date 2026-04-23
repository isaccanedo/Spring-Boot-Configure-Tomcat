# How to Configure Spring Boot Tomcat

# 1. Visão Geral
O Spring Boot Web inclue um servidor web embutido pré-configurado por padrão. Em algumas situações, porém, gostaríamos de modificar a configuração padrão para atender aos requisitos personalizados.

Neste tutorial, veremos alguns casos de uso comuns para configurar o servidor integrado Tomcat por meio do arquivo application.properties.

# 2. Configurações comuns do Tomcat incorporado

### 2.1. Endereço e porta do servidor
A configuração mais comum que podemos desejar alterar é o número da porta:

```
server.port=80
```

Se não fornecermos o parâmetro server.port, ele será definido como 8080 por padrão.

Em alguns casos, podemos desejar definir um endereço de rede ao qual o servidor deve se vincular. Em outras palavras, definimos um endereço IP onde nosso servidor irá escutar:

```
server.address=my_custom_ip
```

Por padrão, o valor é definido como 0.0.0.0, o que permite a conexão por meio de todos os endereços IPv4. Definir outro valor, por exemplo, localhost - 127.0.0.1 - tornará o servidor mais seletivo.

### 2.2. Manipulação de erros
Por padrão, Spring Boot fornece uma página da web de erro padrão. Esta página é chamada de Whitelabel. Está habilitado por padrão, mas se não quisermos exibir nenhuma informação de erro, podemos desabilitá-lo:

```
server.error.whitelabel.enabled=false
```

O caminho padrão para um Whitelabel é /error. Podemos personalizá-lo definindo o parâmetro server.error.path:

```
server.error.path=/user-error
```

Também podemos definir propriedades que determinarão quais informações sobre o erro serão apresentadas. Por exemplo, podemos incluir a mensagem de erro e o rastreamento de pilha:

```
server.error.include-exception=true
server.error.include-stacktrace=always
```

### 2.3. Conexões de servidor
Ao executar em um contêiner de poucos recursos, podemos diminuir a carga da CPU e da memória. Uma maneira de fazer isso é limitar o número de solicitações simultâneas que podem ser tratadas por nosso aplicativo. Por outro lado, podemos aumentar esse valor para usar mais recursos disponíveis para obter melhor desempenho.

No Spring Boot, podemos definir a quantidade máxima de threads de trabalho do Tomcat:

```
server.tomcat.threads.max=200
```

Ao configurar um servidor da web, também pode ser útil definir o tempo limite de conexão do servidor. Isso representa a quantidade máxima de tempo que o servidor aguardará até que o cliente faça sua solicitação após a conexão, antes que a conexão seja encerrada:

```
server.connection-timeout=5s
```

Também podemos definir o tamanho máximo de um cabeçalho de solicitação:

```
server.max-http-header-size=8KB
```

O tamanho máximo do corpo de uma solicitação:

```
server.tomcat.max-swallow-size=2MB
```

Ou um tamanho máximo de toda a solicitação de postagem:

```
server.tomcat.max-http-post-size=2MB
```

### 2.4. SSL
Para ativar o suporte SSL em nosso aplicativo Spring Boot, precisamos definir a propriedade server.ssl.enabled como true e definir um protocolo SSL:

```
server.ssl.enabled=true
server.ssl.protocol=TLS
```

Devemos também configurar a senha, o tipo e o caminho para o armazenamento de chaves que contém o certificado:

```
server.ssl.key-store-password=my_password
server.ssl.key-store-type=keystore_type
server.ssl.key-store=keystore-path
```

E também devemos definir o alias que identifica nossa chave no armazenamento de chaves:

```
server.ssl.key-alias=tomcat
```

### 2.5. Logs de acesso do servidor Tomcat
Os logs de acesso do Tomcat são muito úteis ao tentar medir a contagem de acessos à página, a atividade da sessão do usuário e assim por diante.

Para ativar os registros de acesso, basta definir:

```
server.tomcat.accesslog.enabled=true
```

Devemos também configurar outros parâmetros, como nome do diretório, prefixo, sufixo e formato de data anexado aos arquivos de log:

```
server.tomcat.accesslog.directory=logs
server.tomcat.accesslog.file-date-format=yyyy-MM-dd
server.tomcat.accesslog.prefix=access_log
server.tomcat.accesslog.suffix=.log
```

# 3. Conclusão
Neste tutorial, aprendemos algumas configurações comuns de servidor integrado Tomcat. Para ver mais configurações possíveis, visite a página oficial de documentos de propriedades do aplicativo Spring Boot.

#

Hope that helps. Cheers!<br>
Isac Canedo 😉
