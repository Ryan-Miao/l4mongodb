find()
======

### The find() Method
To query data from MongoDB collection, you need to user MongoDB's `find()` method.

####Syntax
Basic syntax of find() method id as follows:
```
db.collection_name.find()
```
`find()`method will display all the documents in a non structured way.

####The pretty() Method
To display the results in a formatted way, you can use `pretty()` method.
```
db.collection_name.find().pretty()
```

####Example
```
> show collections
mycollection
post
restaurants
test
> db.post.find().pretty()
{
        "_id" : ObjectId("577e11fd502847799b05f062"),
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
{
        "_id" : ObjectId("577e11fd502847799b05f063"),
        "title" : "NoSQL Database",
        "description" : "NoSQL database doesn't have tables",
        "by" : "tutorials point",
        "url" : "http://www.tutorialspoint.com",
        "tags" : [
                "mongodb",
                "database",
                "NoSQL"
        ],
        "likes" : 20,
        "comments" : [
                {
                        "user" : "user1",
                        "message" : "My first comment",
                        "dateCreated" : ISODate("2013-12-10T10:35:00Z"),
                        "like" : 0
                }
        ]
}
>
```



    
    
###RDBMS Where Clause Equivalents in MongoDB
To query the document on the basis of some codition, you can use following
options:

| Options  | Syntax | Example | RDBMS Equivalent |
|-------| ----- | -----  |-------------- |
|  Equal |{\<key\>:\<value\>}|db.mycol.find({'by':'abc'}).pretty()|where by='abc'|
| Less Than | {\<key\>:{$lt:\<value\>}}|db.mycol.find({'likes':{$lt:50}}).pretty()|where likes < 50|
| Less Than Equals | {\<key\>:{$lte:\<value\>}}|db.mycol.find({'likes':{$lte:50}}).pretty()|where likes <= 50|
| Greater Than  | {\<key\>:{$gt:\<value\>}}|db.mycol.find({'likes':{$gt:50}}).pretty()|where likes > 50|
| Greater Than Equals | {\<key\>:{$gte:\<value\>}}|db.mycol.find({'likes':{$gte:50}}).pretty()|where likes >= 50|
| Not Equals | {\<key\>:{$ne:\<value\>}}|db.mycol.find({'likes':{$ne:50}}).pretty()|where likes != 50|

**Example**
```
> db.mycol.find().pretty()
{
        "_id" : ObjectId("577e19c5502847799b05f064"),
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
{
        "_id" : ObjectId("577e19c5502847799b05f065"),
        "title" : "NoSQL Database",
        "description" : "NoSQL database doesn't have tables",
        "by" : "tutorials point",
        "url" : "http://www.tutorialspoint.com",
        "tags" : [
                "mongodb",
                "database",
                "NoSQL"
        ],
        "likes" : 20,
        "comments" : [
                {
                        "user" : "user1",
                        "message" : "My first comment",
                        "dateCreated" : ISODate("2013-12-10T10:35:00Z"),
                        "like" : 0
                }
        ]
}
>
> db.mycol.find({'likes':{$gt:50}}).pretty()
{
        "_id" : ObjectId("577e19c5502847799b05f064"),
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
> db.mycol.find({'likes':{$lt:50}}).pretty()
{
        "_id" : ObjectId("577e19c5502847799b05f065"),
        "title" : "NoSQL Database",
        "description" : "NoSQL database doesn't have tables",
        "by" : "tutorials point",
        "url" : "http://www.tutorialspoint.com",
        "tags" : [
                "mongodb",
                "database",
                "NoSQL"
        ],
        "likes" : 20,
        "comments" : [
                {
                        "user" : "user1",
                        "message" : "My first comment",
                        "dateCreated" : ISODate("2013-12-10T10:35:00Z"),
                        "like" : 0
                }
        ]
}
```



### AND in MongoDB
Syntax
In the `find()` method if you pass multiple keys by separating them by '`,`' then
MongoDB treats it` AND` condition. Basic syntax of `AND` is shown below:
```
db.mycol.find({ keys:value, key2:value2 }).pretty()
```

####Example:
Below given example will show all the tutorials written by and
whose title is 'MongoDB OVerview':
```
> db.mycol.find({"by":"tutorials point","title":"MongoDB Overview"}).pretty()
{
        "_id" : ObjectId("577e19c5502847799b05f064"),
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
```

For the above given example equivalent where clause will be
 ` where by='tutorials point' AND title = 'MongoDB Overview' `. 
 You can pass any number of key, value pairs in find clause.
 
     
     
###OR in MongoDB
####Syntax
To query documents based on the OR condition, you need to use `$or` keyword. 
Basic syntax of **OR** is shown below −

```
>db.mycol.find(
   {
      $or: [
         {key1: value1}, {key2:value2}
      ]
   }
).pretty()
```


**Example**
```
> db.mycol.find(
{
        $or:[
            {"title":"MongoDB Overview"},{"likes":20}
        ]
}).pretty()

{
        "_id" : ObjectId("577e19c5502847799b05f064"),
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
{
        "_id" : ObjectId("577e19c5502847799b05f065"),
        "title" : "NoSQL Database",
        "description" : "NoSQL database doesn't have tables",
        "by" : "tutorials point",
        "url" : "http://www.tutorialspoint.com",
        "tags" : [
                "mongodb",
                "database",
                "NoSQL"
        ],
        "likes" : 20,
        "comments" : [
                {
                        "user" : "user1",
                        "message" : "My first comment",
                        "dateCreated" : ISODate("2013-12-10T10:35:00Z"),
                        "like" : 0
                }
        ]
}
```



###Using AND and  OR together
 
 
 ####Example
 Below given example will show the documents that have likes greater than 10
 and whose title is either 'MongoDB Overview' or by is 'tutorials point': 
Equals:`where likes>10 AND (by = 'tutorials point' OR title = 'MongoDB Overview')` 
```
> db.mycol.find({
                        "likes": {$gt:10}, 
                        $or: [
                            {"by": "tutorials point"}, {"title": "MongoDB Overview"}
                        ]
}).pretty()
{
        "_id" : ObjectId("577e19c5502847799b05f064"),
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
{
        "_id" : ObjectId("577e19c5502847799b05f065"),
        "title" : "NoSQL Database",
        "description" : "NoSQL database doesn't have tables",
        "by" : "tutorials point",
        "url" : "http://www.tutorialspoint.com",
        "tags" : [
                "mongodb",
                "database",
                "NoSQL"
        ],
        "likes" : 20,
        "comments" : [
                {
                        "user" : "user1",
                        "message" : "My first comment",
                        "dateCreated" : ISODate("2013-12-10T10:35:00Z"),
                        "like" : 0
                }
        ]
}
```


next:http://www.tutorialspoint.com/mongodb/mongodb_update_document.htm











