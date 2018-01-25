SELECT id FROM cms_menu AS cm 
where LENGTH(cm.id) = :localCodeLength
and cm.id like CONCAT(:parentCode ,'%')
order by cm.id desc 
limit 1