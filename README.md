# Fullstack Integration Lab

Laboratório experimental para compreender, na prática,
a integração entre diferentes componentes de uma aplicação
full-stack.

## Objective

Understand how the following technologies interact:

- React
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- HTTP/REST
- Docker

## Architecture

React
  ↓
HTTP/JSON
  ↓
Spring Boot
  ↓
Spring MVC
  ↓
Service
  ↓
Spring Data JPA
  ↓
Hibernate
  ↓
JDBC
  ↓
PostgreSQL

## Experiments

- [ ] HTTP
- [ ] REST API
- [ ] PostgreSQL connection
- [ ] JPA
- [ ] Hibernate
- [ ] CRUD
- [ ] DTO
- [ ] Validation
- [ ] Error handling
- [ ] React integration
- [ ] CORS
- [ ] Docker

## Project Structure

```text
fullstack-integration-lab/
│
├── backend/
│
├── frontend/
│
├── experiments/
│   ├── 01-http/
│   ├── 02-rest/
│   ├── 03-database/
│   ├── 04-orm/
│   ├── 05-crud/
│   ├── 06-dto/
│   ├── 07-validation/
│   ├── 08-errors/
│   ├── 09-react/
│   ├── 10-cors/
│   └── 11-docker/
│
├── docs/
│   ├── architecture.md
│   ├── request-flow.md
│   ├── database.md
│   ├── http.md
│   └── technologies.md
│
└── README.md

