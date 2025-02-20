select o.animal_id, o.animal_type, o.name from animal_outs o left join animal_ins i on o.animal_id=i.animal_id
where (i.sex_upon_intake ="intact male" and o.sex_upon_outcome="neutered male") 
    or (i.sex_upon_intake ="intact female" and o.sex_upon_outcome="spayed female")