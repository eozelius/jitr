# jitr
twitter clone JSON API  built in java 11 + Maven + Postgres.  This is a stand-alone JSON API, so no Frontend is included.

## Data Relationships.
This app is driven by 2 main classes: `User` and `Post`. There is a **One-to-Many** between a `User` and `Posts`.  This relationship is owned by `User`, each `Post` has a **user_id** column to dictate which `User` owns that particular post.

## Getting Started

### DB Setup
**Prerequisite** - Postgres is required to be installed, as well as a Postgres user named `jitr` with an existing `database` aptly named `jitr`.
```bash
# From root dir.

# Create Users Table
psql -d jitr --username jitr -f src/sql/01_create_users_table.sql

# Create Posts Table
psql -d jitr --username jitr -f src/sql/02_create_posts_table.sql

# Seed tables
psql -d jitr --username jitr -f src/sql/03_seed_users_and_posts.sql
```

### Running App
```bash
$ ./mvnw spring-boot:run
```

### Postman calls
Todo

## Todo
1. unit test application, not sure if these scenarios will be handled by testing cases themselves, or the controllers.
- User
  - create new user
  - update existing user
  - delete existing user
  - create a new post
- Post
  - update a post
  - delete a post
