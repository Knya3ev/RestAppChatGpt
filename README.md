# RestAppChatGpt
---
   
Конечные точки
----
  - `localhost:8080`
    
    |Path                          | Request Parameters | Example                                                                       | Description                 |
    |------------------------------|--------------------|-------------------------------------------------------------------------------|-----------------------------|
    | /model/all                   | null               |null                                                                           | получение всех моделей      |
    | /model/{model}               | model: String      | "text-davinci-003"                                                            |получение определенной модели|
    | -                            | -                  | -                                                                             | -                           |
    |/completion/send_message      | Request body: json | [example](https://platform.openai.com/docs/api-reference/completions/create)  |быстрое сообщение            |
    |/completion/chat/send_message | Request body: json | [example](https://platform.openai.com/docs/api-reference/chat/create)         |сообщения через чат          |
    |/completion/edit_text         | Request body: json | [example](https://platform.openai.com/docs/api-reference/edits/create)        |редактирование текста        |
    | -                            | -                  | -                                                                             | -                           |
    |/image/geniration             | Request body: json | [example](https://platform.openai.com/docs/api-reference/images/create)       |генерация изоброжения        |
    |/images/edit                  | Form Data          | [example](https://platform.openai.com/docs/api-reference/images/create-edit)  |редактирование изоброжение   |
    
## Chat GPT Docs
---
* [Models](https://platform.openai.com/docs/models/models)
   * [List Models](https://platform.openai.com/docs/api-reference/models/list)
   * [Retrieve model](https://platform.openai.com/docs/api-reference/models/retrieve)
* [Completion](https://platform.openai.com/docs/guides/chat/chat-completions-beta)
   * [Create completion](https://platform.openai.com/docs/guides/chat/chat-completions-beta)
   * [Creation chat completion](https://platform.openai.com/docs/api-reference/chat/create)
   * [Creation edit](https://platform.openai.com/docs/api-reference/chat/create)
* [Images](https://platform.openai.com/docs/guides/images/image-generation-beta)
   * [Creation image](https://platform.openai.com/docs/api-reference/images/create)
   * [Creation edit image](https://platform.openai.com/docs/api-reference/images/create-edit)
    
    
## Backend
----
* JDK 17

* Spring framework
  * Boot
  * Data
  
* Gradle

* Feign

### Тестирование

* JUnit
* Mockito
