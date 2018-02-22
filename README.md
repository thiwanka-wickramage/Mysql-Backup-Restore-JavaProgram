# Mysql-Backup-Restore-JavaProgram
> Complete Java Application solution about backing up and restoring your MySQL database.

If you have used MySQL for a while, you have probably used mysqldump to backup your database. It provides a great command line utility to take backup and restore, so here is a simple Java program to backing up and restoring your MySQL database.

### To backup MySQL database(s), the following command can be used

```
mysqldump --user=username --password=password --opt DatabaseName > database.sql
```

In this java program we are using these commonds parameters to create a backup.

mysqldump -> This exe file located in the you mysql installation directory bin folder.
