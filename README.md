# CAPM: Company Attendance and Preference Management

The aim of the project is to control the number of employees who are going to be attending the office on any given day. 
Employees should be able to punch in their future attendance preference into the system so that the company can exercise 
control over limiting the overall population in the office on a given day. 
This management should happen smoothly taking into account the conflict resolution of preferences within a team and 
inter teams as well.

##### Set up instructions:
- Download the project and set up any IDE like IntelliJ
- Set up the mysql data base as per the schema given in the links section
- To run the application, set the configuration one time as below

> Run -> Edit configurations -> click on + button on the left-hand side -> Select Application-> 
> Give name like CAPM application, click apply and OK

In the VM options bar enter: ```-Dspring.profiles.active=local```

##### Important Links and documents
- Specification link: https://docs.google.com/document/d/1wIU316BLzo8iBPr1KTzI5kMiKyyP2QXEQK5AfWCy5cM/edit?usp=sharing
- Schema: [schema.sql](https://github.com/deepakjayaprakash/CAPM/blob/master/src/main/resources/schema.sql)
- API doc, sample request/response: 
 



