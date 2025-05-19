# Santander Dev Week 2023

Java RESTful API created for Santander Deb Week

## Class Diagram

```mermaid

classDiagram
  class User {
    -String name
    -Account account
    -Feature[] features
    -Card card
    -News[] news
  }

  class Account {
    -String number
    -String agency
    -Float balance
    -Float limit
  }

  class Card {
    -String number
    -Float limit
  }

  class Feature {
    -String icon
    -String description
  }

  class News {
    -String icon
    -String description
  }

  User "1" *-- "1" Account
  User "1" *-- Card
  User "1" *-- "*" Feature
  User "1" *-- "*" News


```
