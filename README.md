# jitr
twitter clone JSON API built in java 11 + Maven + Postgres.

## DB Setup
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

## Running App
```bash
$ mvn spring-boot:init
```