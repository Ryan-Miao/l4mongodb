Getting-Start
=============

1. [catalog](/readme.md "目录")



-------------------------------
##Database

check all the databases:    
```
> show dbs
 local  0.000GB
 mrf    0.000GB
 test   0.005GB
```

create database: for example create  mydb   
```
> use mydb
switched to db mydb
> show dbs
local  0.000GB
mrf    0.000GB
test   0.005GB
```
The database mydb has not been created, because the db is empty, 
You must create at lest one collection next.For example:    
```
>
> use mydb
switched to db mydb
> show dbs
local  0.000GB
mrf    0.000GB
test   0.005GB
>
> show collections
> db.user.insert({name:"Ryan"})
WriteResult({ "nInserted" : 1 })
> show dbs
local  0.000GB
mrf    0.000GB
mydb   0.000GB
test   0.005GB
```


check current database:    
```
> db
mydb
```

switch db:
```
> db
mydb
> use test
switched to db test
> db
test
```

drop database:    
```
> show dbs
local  0.000GB
mrf    0.000GB
mydb   0.000GB
test   0.005GB
> use mydb
switched to db mydb
> db.dropDatabase()
{ "dropped" : "mydb", "ok" : 1 }
> show dbs;
local  0.000GB
mrf    0.000GB
test   0.005GB
```


