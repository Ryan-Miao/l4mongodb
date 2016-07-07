Insert
======

1. [catalog](/readme.md "目录")    

MongoDB insert option:    
```
> show dbs;
local  0.000GB
mrf    0.000GB
test   0.005GB
> use test
switched to db test
> show collections;
mycollection
restaurants
test
>
>
> db.mycollection.insert({
    title:"MongoDB Overview",
   description:'MongoDB is no sql database',
   by:'tutorials point',
   url:'http://www.tutorialspoint.com',
   tags:['mongodb','database','NoSQL'],
  likes:100
 })
WriteResult({ "nInserted" : 1 })
>
> db.mycollection.find()
{ "_id" : ObjectId("577e0dce99da0904659393c0"), "title" : "MongoDB Overview", "description" : "MongoDB is no sql databas
e", "by" : "tutorials point", "url" : "http://www.tutorialspoint.com", "tags" : [ "mongodb", "database", "NoSQL" ], "lik
es" : 100 }
> db.mycollection.find().pretty()
{
        "_id" : ObjectId("577e0dce99da0904659393c0"),
        "title" : "MongoDB Overview",
        "description" : "MongoDB is no sql database",
        "by" : "tutorials point",
        "url" : "http://www.tutorialspoint.com",
        "tags" : [
                "mongodb",
                "database",
                "NoSQL"
        ],
        "likes" : 100
}
>
```

----------------------------------------------------
Here `mycollections` is our collection name, as created in previous tutorial. If the
collection doesn't exist in the database, then MongoDB will create this collection 
adn then insert document into it.

In the inserted document if we don't specify the `_id` parameter, then MongoDB
assigns an unique ObjectId for this document.

`_id` is 12 bytes hexadecimal number unique for every document in a collection.
12 Bytes are dived as follows :   
```
_id: ObjectId(4 bytes timestamp, 3 bytes machine id, 2 bytes process id, 3 bytes incrementer)
```

To insert multiple documents in single query, you can pass an array of documents 
in insert() command.

**Example**
```
db.post.insert([
   {
      title: 'MongoDB Overview', 
      description: 'MongoDB is no sql database',
      by: 'tutorials point',
      url: 'http://www.tutorialspoint.com',
      tags: ['mongodb', 'database', 'NoSQL'],
      likes: 100
   },
   {
      title: 'NoSQL Database', 
      description: 'NoSQL database doesn\'t have tables',
      by: 'tutorials point',
      url: 'http://www.tutorialspoint.com',
      tags: ['mongodb', 'database', 'NoSQL'],
      likes: 20, 
      comments: [	
         {
            user:'user1',
            message: 'My first comment',
            dateCreated: new Date(2013,11,10,2,35),
            like: 0 
         }
      ]
   }
])
```

next:[find](/doc/find.md "find")  



































