# Write your MySQL query statement below









SELECT q.person_name from queue as q where (SELECT SUM(q1.weight) FROM Queue AS q1 where q1.turn <=q.turn)<=1000 order by (SELECT SUM(q1.weight) FROM Queue AS q1 where q1.turn <=q.turn) DESC LIMIT 1;