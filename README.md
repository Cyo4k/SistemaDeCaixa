# Sistema De Caixa
Projeto desenvolvido para atividade final da disciplina de estrutura de dados.

Problemática: Lentidão no Sistema de Caixa de Supermercado

O ‘Time de Qualidade’ de um supermercado da Cidade de Fortaleza/CE aplicou um questionário de avaliação do Software de Gestão de Clientes com os funcionário-caixas de um supermercado, e por meio dos feedbacks coletados notou-se que há um grande número de reclamações em relação à lentidão na busca pelo cadastro do cliente.

“Os clientes que fazem parte do clube de desconto demoram bastante para se identificar antes de eu passar os produtos. Eu digito o CPF informado e demora cerca de 20 a 30 segundos para processar. Noto que quanto mais a empresa cresce, mais lento fica esse sistema!!! Sem contar os maus tratos dos clientes pela demora no atendimento.” - Informou a funcionária do Caixa.

Devido às queixas de lentidão relatadas pelos entrevistados, o Gerente decidiu contratar um Analista de Sistemas para realizar a atualização do sistema, de forma que este profissional, possa propor uma saída mais eficiente na busca pelos clientes por meio da chave de busca: CPF.



# Proposta para solucionar a problemática:

Sistema desenvolvido para o cadastro e consulta de usuários em um banco de dados. Implementado com uma estrutura de tabela hash, ele oferece escalabilidade superior na busca de informações, garantindo um tempo de resposta constante.

## Motivos para uso de hash:

### Benefícios:

O hash permite o acesso direto ao elementos, o que possibilita uma busca rapaida de clientes com o cpf, em vez de percorrer por toda a lista ou fila, podemos simplesmente calcular a posição do cpf no vetor e acesssar diretamente o registro corresponde utilizando funções de hash.
Devido o CPF ser uma chave unica é extramente compativel com a função possibilitando maior velocidade de indexar e recuperar o registro.

### Pontos negatívos:

Requer espaço adicionall para armazenar os índices.
Colisões: Embora o hash minimize colisões, elas ainda podem acontecer, para evitar que isso ocorra com frenquencia  é necessario o uso de técninas como encadeamento ou endereçamento aberto.




# Demonstração de interface:


#### Buscar cliente.
![image](https://github.com/Cyo4k/SistemaDeCaixa/assets/93006521/0a26370e-1872-4517-881b-f0d801e617cf)


#### Cadastrar cliente.
![image](https://github.com/Cyo4k/SistemaDeCaixa/assets/93006521/68af9550-b711-4924-8ebc-95fa86134e9f)



### Prévia do codigo fonte:

#### SistemaDeCaixa.java

![image](https://github.com/Cyo4k/SistemaDeCaixa/assets/93006521/fa16ffa5-889e-4920-ad29-fbb2794cb884)

