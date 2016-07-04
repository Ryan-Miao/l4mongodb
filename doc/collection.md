collection
==========

1. [catalog](/readme.md "目录")

----------------------------------

### create collection


when you insert data, if the collection not exists, it will be created automatically:     
```
> show collections
restaurants
test
> db.mycollection.insert({name:"test"})
WriteResult({ "nInserted" : 1 })
> show collections
mycollection
restaurants
test
```
      
 Of course, there is other way to create a specify collection:     
     
     
    
#### Syntax

Basic syntax of createCollection() command is as follows:   
```
db.createCollection(name, options)
```
In the command, `name` is the name of collection created, `Options` is a document
and used to specify configuration of collection.    

`Options` parameter is optional, so you need to specify only name of the collection.
Following is the list of options you can use:

| Filed  | Type  | Description |
|---| ---| ---|
|   capped | Boolean | (Optional) If true, enables a capped collection. Capped collection is  a collection fixed size collection that automatically overwrites its oldest entries  when it reaches its maximum size. **If you sepecify true, you need specify size parameter too** |
| autoIndexID | Boolean | (Optional) If true, automatically create index  on  \_id filed. Default value is false |
|size | number|(Optional) Specify a maximum size in bytes for a capped collection.  **If capped is true, then you need specify this filed also** |
|max|number| (Optional) Specifies the maximum number of documents allowed in the capped collection. |     

while inserting the document , MongoDB first checks size filed of capped collection, then it checks max filed.
    
    
   

#### Example

```
> db.mycollection.drop()
true
> show collections
restaurants
test
>
>
> db.createCollection("mycollection")
{ "ok" : 1 }
> show collections
mycollection
restaurants
test
>
> db.createCollection("mycol",{capped:true,autoIndexID:true,size:6142800, max:10000})
{ "ok" : 1 }
> show collections
mycol
mycollection
restaurants
test
>
```



    
###drop()
```
> use test
switched to db test
> show collections
mycol
mycollection
restaurants
test
> db.mycol.drop()
true
> show collections
mycollection
restaurants
test
```












next : http://www.tutorialspoint.com/mongodb/mongodb_drop_collection.htm


