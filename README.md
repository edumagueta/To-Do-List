# Gerenciador de Tarefas

## Descrição

O **Gerenciador de Tarefas Inteligente** é uma aplicação desenvolvida para ajudar usuários a gerenciar e organizar suas tarefas diárias.
A aplicação permite o cadastro, atualização, listagem e filtragem de tarefas, além de fornecer notificações automáticas para lembrar os usuários de prazos próximos.
Com isso, a ferramenta busca otimizar a produtividade, mantendo o controle das tarefas de maneira eficiente e prática.

---

## Funcionalidades

### 1. Cadastro de Tarefas

Ao iniciar a aplicação, o usuário pode cadastrar novas tarefas fornecendo:
- **Título:** Nome da tarefa.
- **Descrição:** Detalhes sobre a tarefa.
- **Data Limite (prazo):** Prazo final para conclusão da tarefa.
- **Status:** Status inicial da tarefa (Pendente, Em andamento, Concluída).

A tarefa não será cadastrada se a data limite for no passado ou se o título for muito curto.

### 2. Atualização de Status

O usuário pode atualizar o status de uma tarefa existente, mudando de "Pendente" para "Em andamento" ou para "Concluída". Se o status for alterado para "Concluída", a tarefa não gerará mais lembretes de prazo.

### 3. Notificações de Prazo

A aplicação verifica as tarefas com prazo para o dia seguinte e envia um lembrete no console para o usuário. A notificação é exibida apenas para tarefas que não possuem o status "Concluída".

### 4. Filtragem e Listagem de Tarefas

O usuário pode listar todas as tarefas cadastradas e filtrá-las por **status** (Pendente, Em andamento, Concluída). Também é possível ordenar as tarefas por **data limite**.