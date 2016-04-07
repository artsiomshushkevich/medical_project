#you have to read it

1. create new file "hibernate.cfg.xml" in folder "resources"
2. copy info form file "hibernate-example.xml" into "hibernate.cfg.xml"
3. edit this file for your mashine(add db confing, delete instructions)

#create database
1. cd src/main/resources/database
2. mysql -u root -p < schema.sql

#for filling database
1. cd src/main/resources/database
2. mysql -u root -p < seeder.sql
