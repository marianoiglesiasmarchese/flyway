# flyway
Simple mysql migration example using flyway

# Links of interest

* [flyway for spring boot](https://flywaydb.org/documentation/plugins/springboot)
* [flyway for maven](https://flywaydb.org/documentation/maven/)
* [flyway migrations](https://flywaydb.org/documentation/migrations)
* [flyway configuration parameters](https://flywaydb.org/documentation/commandline/migrate)
* [spring migration properties](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html#data-migration-properties)


## Migrations naming convention
`<Prefix><Version>__<Description>.sql`

### Where:

* `<Prefix>` – Default prefix is V, which may be configured in the above configuration file using the flyway.sqlMigrationPrefix property.
* `<Version>` – Migration version number. Major and minor versions may be separated by an underscore. The migration version should always start with 1.
* `<Description>` – Textual description of the migration. The description needs to be separated from the version numbers with a double underscore.
Example: V1_1_0__my_first_migration.sql

## Flyway commands

Flyway supports the following basic commands to manage database migrations.

* **Info**: Prints current status/version of a database schema. It prints which migrations are pending, which migrations have been applied, what is the status of applied migrations and when they were applied.
* **Migrate**: Migrates a database schema to the current version. It scans the classpath for available migrations and applies pending migrations.
* **Baseline**: Baselines an existing database, excluding all migrations, including baselineVersion. Baseline helps to start with Flyway in an existing database. Newer migrations can then be applied normally.
* **Validate**: Validates current database schema against available migrations.
* **Repair**: Repairs metadata table.
* **Clean**: Drops all objects in a configured schema. All database objects are dropped. Of course, you should never use clean on any production database.

## Using it

```shell script
mvn clean -Dflyway.configFiles=flyway.properties flyway:info -X
```
