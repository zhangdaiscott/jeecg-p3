insert into 
	jp_demo_activity
      ( id,name,begin_time,end_time,hdurl) 
values
      ('${act.id}',
       :act.name,
       :act.beginTime,
	   :act.endTime,
   	   :act.hdurl
      )