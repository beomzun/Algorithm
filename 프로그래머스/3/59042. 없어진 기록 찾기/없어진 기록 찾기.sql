select o.animal_id,o.name
from animal_outs o
where o.animal_id not in (
    select i.animal_id from animal_ins i
)