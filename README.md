# Mysql-Backup-Restore-JavaProgram
> Complete Java Application solution about backing up and restoring your MySQL database.

If you have used MySQL for a while, you have probably used mysqldump to backup your database. It provides a great command line utility to take backup and restore, so here is a simple Java program to backing up and restoring your MySQL database.

### To backup MySQL database(s), the following command can be used

```
mysqldump -h --port -u --password= --add-drop-database -B -r \
```

**In this java program we are use these parameters to create a backup.**
```
mysqldump               -> This .exe file located in your mysql installation directory bin folder. 
                           ex C:\..\\bin\\mysql\\mysql..\\bin\\mysqldump
-h                      -> Database host server name or server IP. ex:localhost or 127.20.15.241
--port                  -> Database port ex: 3306
-u                      -> Database username ex: root
--password=             -> If database has password you should provide it. If not leave it as a blank
--add-drop-database -B= -> Database name
-r                      -> Backup file save location
```


