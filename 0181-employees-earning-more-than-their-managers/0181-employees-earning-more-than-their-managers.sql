# Write your MySQL query statement below
SELECT e.name AS Employee
From Employee e
JOIN Employee m
ON e.managerId=m.id
WHERE e.salary>m.salary;