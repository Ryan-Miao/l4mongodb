l4mongoDB
=========

0. [overview](/readme.md)    
1.  [getting-start](/doc/database.md "database")    
2.  [collection](/doc/collection.md "collection")    
 

------------------------------------------

##Overview

MongoDB is a cross-platform, document oriented database that provides, high performance, high availability,
and easy scalability. MongoDB works on concept of collection and document.

### Database
Database is a physical container for collections. Each database gets its own set
of files on the file system. A single MongoDB server typically has multiple databases.

###Collection
Collection is a group of MongoDB documents. It is the equivalent of an RDBMS table.
A collection exists within a single database. Collections do not enforce a schema.
Documents with a collection can have different fields. Typically, all documents 
in a collection are of similar or related purpose.

###Document
A document is a set of key-value pairs. Documents have dynamic schema.
Dynamic schema means that documents in the same collection do not need to 
have the same set of fields or structure, and common fields in a collection's
documents may hold different types of data.

Below given table shows the relationship of RDBMS terminology with MongoDB

|  RDBMS  |  MongoDB  |
|---| --- |
| Database | Database |
| Table | Collection |
| Tuple/Row | Document |
| column | Field |
| Table Join | Embedded Documents |
| Table Join | Primary Key(Default key \_id provided by mongodb itself) |

### Sample document
Below given example shows the document structure of a blog site which is simply 
a comma separated key value pair.

```
{
   _id: ObjectId(7df78ad8902c)
   title: 'MongoDB Overview', 
   description: 'MongoDB is no sql database',
   by: 'tutorials point',
   url: 'http://www.tutorialspoint.com',
   tags: ['mongodb', 'database', 'NoSQL'],
   likes: 100, 
   comments: [	
      {
         user:'user1',
         message: 'My first comment',
         dateCreated: new Date(2011,1,20,2,15),
         like: 0 
      },
      {
         user:'user2',
         message: 'My second comments',
         dateCreated: new Date(2011,1,25,7,45),
         like: 5
      }
   ]
}
```

--------------------------------------------
      

 





























