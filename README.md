# Projeto criado com [Spring Boot](https://start.spring.io/).

## Cadastrar Planetas

**POST** http://localhost:8080/planetas

```
{
    "nome": "Tatooine",
    "clima": "arid",
    "terreno": "desert"
}
```

## Listar Planetas

**GET** http://localhost:8080/planetas
```
[
    {
        "id": 1,
        "clima": "tenso",
        "terreno": "escorregadio",
        "nome": "Pronto"
    },
    {
        "id": 2,
        "clima": "arid",
        "terreno": "desert",
        "nome": "Tatooine"
    }
]
```
