# Write your MySQL query statement below
    Select name from Employee
    where id In (Select managerId from Employee group by managerId
    having count(*)>=5);