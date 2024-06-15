System clear; 
Create Database If Not Exists drive; 
Use drive; 

-- Dealing with tables 

Create table if not exists plans (
    id int not null auto_increment primary key, 
    name varchar(255) not null default "free", 
    storageQuota int not null default 1024, 
    price int not null default 0, 
    maxFileSize int not null default 100, 
    numUsers int not null default 1
); 

Create Table If Not Exists users (
    id Int not null Auto_Increment Primary Key, 
    name Varchar(255) Not Null Default "Unknown", 
    email Varchar(255) Not Null Unique, 
    password Varchar(255) Not Null,
    imageUrl Varchar(255) Not Null default "",
    joinedAt Timestamp Not Null Default Now(), 
    updatedAt Timestamp Not Null Default Now(), 
    lastSeen Timestamp Not Null Default Now(), 
    usedStorage Decimal(16, 2) Not Null Default 0, 
    planId Int Not Null Default 1, 
    foreign key(planId) references plans(id)
); 


Select "Schemas\n\n";

Describe plans; 
Describe users; 