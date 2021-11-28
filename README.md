# Spring Boot MVC REST with MongoDB

1. [Spring Core Concepts](https://github.com/kumar2197/New-Learnings/blob/main/Spring-Core.md)
2. [Spring Boot REST](https://youtu.be/sdDDuQuX2cg)
3. [MongoDB with Java Spring Boot & Spring Framework](https://www.udemy.com/course/mongodb-with-spring-boot-spring-data-mongorepository-mlab-cloudfoundry/)

Endpoints For Postman App: [https://www.getpostman.com/collections/c40f5a82c5fb4c3f03dd](https://www.getpostman.com/collections/c40f5a82c5fb4c3f03dd) (Do : Import → Link)

Sample Create Student POST request body:

```json
{
	"name": "amit",
	"email": "amit@gmail.com",
	"department": {
		"departmentName": "Computer Science",
		"location": "BLR"
	},
	"subjects": [{
			"subjectName": "Data Structure",
			"marksObtained": "70.0"
		},
		{
			"subjectName": "Java",
			"marksObtained": "80.0"
		}
	]
}
```
